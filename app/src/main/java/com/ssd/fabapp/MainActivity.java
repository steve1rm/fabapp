package com.ssd.fabapp;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /* This is where we will add our fragment
           If savedInstanceState is null then this the first time MainActivity has been created
           so we add the fragment.
           And time after that savedInstanceState won't be null so no need to add the fragment again */
        if(savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            /* First parameter is the id of the layout we want to add this fragment into
               Second parameter we get a new instance of the fragment has pass in some data
               Third parameter is good practice to add this, the string tag and for referencing fragments (headless fragments) */
            fragmentTransaction.add(R.id.fragment_container, FabFragment.getNewInstance(1234), "FabFragment");
            /* final step commit the fragment thus displaying it in our UI */
            fragmentTransaction.commit();
        }
    }
}
