package me.blog.korn123.rememberminiman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.blog.korn123.commons.utils.CommonUtils;
import me.blog.korn123.commons.utils.FontUtils;
import me.blog.korn123.rememberminiman.R;
import me.blog.korn123.rememberminiman.model.User;

public class SignInActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "SignInActivity";
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @BindView(R.id.fieldEmail) EditText mFieldEmail;
    @BindView(R.id.fieldPassword) EditText mFieldPassword;
    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.singIn) TextView mSingIn;
    @BindView(R.id.singUp) TextView mSingUp;
    @BindView(R.id.guideMessage1) TextView mGuideMessage1;
    @BindView(R.id.guideMessage2) TextView mGuideMessage2;
    @BindView(R.id.guideMessage3) TextView mGuideMessage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        FontUtils.setTypeface(this, getAssets(), mFieldEmail);
        FontUtils.setTypeface(this, getAssets(), mFieldPassword);
        FontUtils.setTypeface(this, getAssets(), mTitle);
        FontUtils.setTypeface(this, getAssets(), mSingIn);
        FontUtils.setTypeface(this, getAssets(), mSingUp);
        FontUtils.setTypeface(this, getAssets(), mGuideMessage1);
        FontUtils.setTypeface(this, getAssets(), mGuideMessage2);
        FontUtils.setTypeface(this, getAssets(), mGuideMessage3);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Check auth on Activity start
        if (mAuth.getCurrentUser() != null) {
            onAuthSuccess(mAuth.getCurrentUser());
        }
    }

    private void signIn() {
        Log.d(TAG, "signIn");
        if (!validateForm()) {
            return;
        }

        showProgressDialog();
        String email = mFieldEmail.getText().toString();
        String password = mFieldPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signIn:onComplete:" + task.isSuccessful());
                        hideProgressDialog();

                        if (task.isSuccessful()) {
                            onAuthSuccess(task.getResult().getUser());
                        } else {
                            Toast.makeText(SignInActivity.this, "Sign In Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signUp() {
        Log.d(TAG, "signUp");
        if (!validateForm()) {
            return;
        }

        showProgressDialog();
        String email = mFieldEmail.getText().toString();
        String password = mFieldPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUser:onComplete:" + task.isSuccessful());
                        hideProgressDialog();

                        if (task.isSuccessful()) {
                            onAuthSuccess(task.getResult().getUser());
                        } else {
                            Toast.makeText(SignInActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void onAuthSuccess(FirebaseUser user) {
        String username = CommonUtils.usernameFromEmail(user.getEmail());

        // Write new user
        writeNewUser(user.getUid(), username, user.getEmail());

        // Go to MainActivity
        startActivity(new Intent(SignInActivity.this, RankingActivity.class));
        finish();
    }

    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(mFieldEmail.getText().toString())) {
            mFieldEmail.setError("Required");
            result = false;
        } else {
            mFieldEmail.setError(null);
        }

        if (TextUtils.isEmpty(mFieldPassword.getText().toString())) {
            mFieldPassword.setError("Required");
            result = false;
        } else {
            mFieldPassword.setError(null);
        }

        return result;
    }

    // [START basic_write]
    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);

        mDatabase.child("users").child(userId).setValue(user);
    }
    // [END basic_write]

    @OnClick({R.id.singIn, R.id.singUp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.singIn:
                signIn();
                break;
            case R.id.singUp:
                signUp();
                break;
        }
    }

}
