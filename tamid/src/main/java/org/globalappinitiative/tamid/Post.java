package org.globalappinitiative.tamid;

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
    //public String userName;
    public String imageUrl;
    public int likes;

    public Post() {

    }
    public Post(String desc) {
        description = desc;
        imageUrl = "";
        likes = 0;
    }

    public Post(String desc, String url) {
        description = desc;
        imageUrl = url;
        likes = 0;
    }
    public Post(String description, String imageUrl, int likes) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.likes = likes;
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
        result.put("imageUrl", imageUrl);
        result.put("likes", likes);
        return result;
    }
}
