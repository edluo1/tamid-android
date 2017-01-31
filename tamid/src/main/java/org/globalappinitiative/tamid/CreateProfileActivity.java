package org.globalappinitiative.tamid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateProfileActivity extends AppCompatActivity {
    // this possibly might work better as a fragment switched in rather than a separate activity but it'll do for now
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mProfile;
    private FirebaseUser user;
    private UserProfile p;
    private EditText etUserName;
    private EditText etFullName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        // Get user's profile from Firebase
        user = FirebaseAuth.getInstance().getCurrentUser();
        mProfile = mDatabase.child("users").child(user.getUid());

        setupInfo();


    }

    private void setupInfo() {
        etUserName = (EditText) findViewById(R.id.etUserName);
        etFullName = (EditText) findViewById(R.id.etFullName);
        etPhone = (EditText) findViewById(R.id.etPhoneNumber);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etLocation = (EditText) findViewById(R.id.etLocation);

        DatabaseReference fullName = mProfile.child("fullname");
        mProfile.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                p = dataSnapshot.getValue(UserProfile.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /* TODO: Ask if user should press Save to save changes

     */

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
