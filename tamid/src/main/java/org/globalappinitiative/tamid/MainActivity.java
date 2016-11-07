package org.globalappinitiative.tamid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PostCardFragment cardFragment = new PostCardFragment();
        PostCardFragment testFragment2 = new PostCardFragment();
        fragmentTransaction.add(R.id.llCardLocation, cardFragment);
        fragmentTransaction.add(R.id.llCardLocation, testFragment2);
        fragmentTransaction.commit();

    }
}
