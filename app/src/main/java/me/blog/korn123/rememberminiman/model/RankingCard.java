package me.blog.korn123.rememberminiman.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHO HANJOONG on 2017-08-09.
 */

public class RankingCard {

    public int rankingNo;
    public String userName;
    public float recordTime;

    public RankingCard() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public RankingCard(int rankingNo, String userName, float recordTime) {
        this.rankingNo = rankingNo;
        this.userName = userName;
        this.recordTime = recordTime;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userName", userName);
        result.put("recordTime", recordTime);
        return result;
    }
}
