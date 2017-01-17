package org.globalappinitiative.tamid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateProfileActivity extends AppCompatActivity {
    // this possibly might work better as a fragment switched in rather than a separate activity but it'll do for now
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mProfile;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        // Get user's profile from Firebase
        user = FirebaseAuth.getInstance().getCurrentUser();
        mProfile = mDatabase.child("users").child(user.getUid());

    }

    /* TODO: Ask if user should press Save to save changes

     */

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
