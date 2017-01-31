package org.globalappinitiative.tamid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        TextView tvUserName = (TextView) getView().findViewById(R.id.tvUserName);
        TextView tvDesc = (TextView) getView().findViewById(R.id.tvDescription);
        TextView tvLikes = (TextView) getView().findViewById(R.id.tvLikesCount);
        TextView tvPostDate = (TextView) getView().findViewById(R.id.tvPostDate);
        ImageView ivImage = (ImageView) getView().findViewById(R.id.ivImagePost);
        if (p.imageUrl == null || p.imageUrl.isEmpty()) {
            ivImage.setImageDrawable(null);
        } else { // use Picasso to load the image
            Picasso.with(getActivity()).load(p.imageUrl).into(ivImage);
        }
        if (p.userID == null || p.userID.isEmpty()) {
            tvUserName.setText("Anonymous");
        } else {
            tvUserName.setText(p.userID);
        }
        tvDesc.setText(p.description);
        tvLikes.setText(Integer.toString(p.likes));
        if (p.postTime != null) {
            Date postDate = new Date(p.postTime);
            Format dateForm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tvPostDate.setText(dateForm.format(postDate));
        }
    }
}
