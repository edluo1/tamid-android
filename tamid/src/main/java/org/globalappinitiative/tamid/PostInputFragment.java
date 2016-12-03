package org.globalappinitiative.tamid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PostInputFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PostInputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostInputFragment extends Fragment {
    private TextView tvPostContent;

    private OnFragmentInteractionListener mListener;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    public PostInputFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PostInputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PostInputFragment newInstance() {
        PostInputFragment fragment = new PostInputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_post_layout, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button bPost = (Button) getView().findViewById(R.id.bPost);
        Button bCamera = (Button) getView().findViewById(R.id.bCamera);
        tvPostContent = (EditText) getView().findViewById(R.id.etPostContent);

        bPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = mDatabase.child("posts").push().getKey();
                String postContent = tvPostContent.getText().toString();
                if (!postContent.isEmpty()) { // only post if there's nothing written
                    Post p = new Post(tvPostContent.getText().toString(), "", 0);
                    Map<String, Object> postValues = p.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/posts/"+key, postValues);
                    // TODO: store username
                    // childUpdates.put("/user-posts/" + userId + "/" + key, postValues);
                    mDatabase.updateChildren(childUpdates);
                }
            }
        });

        bCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
