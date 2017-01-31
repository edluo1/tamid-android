package org.globalappinitiative.tamid;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISP_LEN = 1000;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Initiate login

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the MainActivity. */

                mAuth = FirebaseAuth.getInstance();
                mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        if (firebaseAuth.getCurrentUser() != null) {
                            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                            SplashActivity.this.startActivity(mainIntent);
                            SplashActivity.this.finish();
                            //changeToNextFragment();
                        } else {
                            Toast.makeText(getApplicationContext(), "You are not currently logged in.", Toast.LENGTH_SHORT).show();
                            //changeToLogin();
                            Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                            SplashActivity.this.startActivity(mainIntent);
                            SplashActivity.this.finish();
                        }
                    }
                });

            }
        }, SPLASH_DISP_LEN);
    }
}
