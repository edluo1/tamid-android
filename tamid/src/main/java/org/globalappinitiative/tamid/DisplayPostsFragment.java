package org.globalappinitiative.tamid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisplayPostsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DisplayPostsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public DisplayPostsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_posts, container, false);
    }

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mPosts = mDatabase.child("posts");
    private FirebaseAuth user;
    private String userEmail;

    private ArrayList<Post> allPosts;

    @Override
    public void onStart() {
        super.onStart();

        allPosts = new ArrayList<>();

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        PostInputFragment toPost = new PostInputFragment(); // Instantiate post input
        fragmentTransaction.add(R.id.content_area, toPost); // Add post input area
        /*
        for (Post p: allPosts) {
            PostCardFragment cardFragment = new PostCardFragment(p);
            fragmentTransaction.add(R.id.content_area, cardFragment);
        }
        */
        fragmentTransaction.commit();

        // Query posts sorted in reverse chronological order
        Query postsQuery = mPosts.orderByChild("postTime").limitToLast(10);
        postsQuery.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try {
                    Post p = dataSnapshot.getValue(Post.class);
                    allPosts.add(p);
                    FragmentManager fragmentManager = getChildFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    PostCardFragment cardFragment = new PostCardFragment(p);
                    fragmentTransaction.add(R.id.content_area, cardFragment);
                    fragmentTransaction.commit();

                } catch (DatabaseException er) {
                    Log.e("db",er.getMessage());
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try {
                    /*
                    Post p = dataSnapshot.getValue(Post.class);
                    allPosts.add(p);
                    FragmentManager fragmentManager = getChildFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    PostCardFragment cardFragment = new PostCardFragment(p);
                    fragmentTransaction.add(R.id.content_area, cardFragment);
                    fragmentTransaction.commit();
                    */
                } catch (DatabaseException er) {
                    Log.e("db",er.getMessage());
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Read failed");
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
