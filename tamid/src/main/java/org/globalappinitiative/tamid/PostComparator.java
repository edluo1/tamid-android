package org.globalappinitiative.tamid;

import java.util.Comparator;

public class PostComparator implements Comparator<Post> {

    @Override
    public int compare(Post post, Post t1) {
        return post.postTime.compareTo(t1.postTime);
    }
}
