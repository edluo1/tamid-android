package org.globalappinitiative.tamid;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edward on 11/17/2016.
 */

public class Post {
    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String description;
    public String userID;
    public String imageUrl;
    public int likes;
    public Long postTime;

    public Post() { // constructor with no arguments because reasons
        description = "";
        imageUrl = "";
        likes = 0;
        userID = "";
        postTime = new Long(0);
    }

    public Post(String desc, String user) {
        description = desc;
        imageUrl = "";
        likes = 0;
        userID = user;
        postTime = new Date().getTime();
    }

    public Post(String desc, String url, String user) {
        description = desc;
        imageUrl = url;
        userID = user;
        likes = 0;
        postTime = new Date().getTime();
    }
    public Post(String description, String imageUrl, String userID, int likes, long postTime) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.userID = userID;
        this.likes = likes;
        this.postTime = postTime;
    }

    public void like() {
        // deal with integer overflow
        if (likes+1 > likes) likes++;
    }

    public void unlike() {
        if (likes > 0) likes--;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("description", description);
        result.put("userID", userID);
        result.put("imageUrl", imageUrl);
        result.put("likes", likes);
        result.put("postTime", postTime);
        return result;
    }
}
