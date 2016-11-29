package org.globalappinitiative.tamid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by edLuo1 on 11/7/2016.
 */

public class PostCardFragment extends Fragment {

    private Post p;

    public PostCardFragment() {

    }

    public PostCardFragment(Post p) {
        // empty for fragment
        this.p = p;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.post_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tvDesc = (TextView) getView().findViewById(R.id.tvDescription);
        TextView tvLikes = (TextView) getView().findViewById(R.id.tvLikesCount);

        tvDesc.setText(p.description);
        tvLikes.setText(p.likes);
    }
}
