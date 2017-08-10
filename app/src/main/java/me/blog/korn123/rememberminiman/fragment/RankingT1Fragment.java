package me.blog.korn123.rememberminiman.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by CHO HANJOONG on 2017-08-09.
 */

public class RankingT1Fragment extends RankingListFragment {

    public RankingT1Fragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // only stage1 ranking
        return databaseReference.child("ranking").child("stage1").orderByChild("recordTime");
    }
}
