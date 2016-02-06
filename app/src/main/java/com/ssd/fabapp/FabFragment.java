package com.ssd.fabapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class FabFragment extends Fragment {

    /* Some data that we want to pass into the fragment example only */
    private int mData;

    public FabFragment() {
        // Required empty public constructor
    }

    /* key that maps to our data when setting and retrieving */
    private static final String DATA_KEY = "data_key";

    /* Factory method for returning a new instance of our fragment,
       sets the data into a bundle and sets it as an argument for the fragment.
       NEVER use a overloaded constructor for doing this, as an overloaded constructor
       will not be called when the fragment has to re-create itself.
       This is the ONLY way you can pass data safely to fragments */
    public static FabFragment getNewInstance(int data) {
        final Bundle args = new Bundle();
        args.putInt(DATA_KEY, data);

        FabFragment blankFragment = new FabFragment();
        /* Sets the argument to be retrieved in the CreateView later */
        blankFragment.setArguments(args);

        return blankFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        final FloatingActionButton fabButton = (FloatingActionButton)view.findViewById(R.id.fabButton);

        /* Here we are getting the contents from the bundle after doing some sanity checks */
        Bundle bundle = getArguments();
        if(bundle != null) {
            /* If there is no value, set the default 0 value for the data */
            mData = bundle.getInt(DATA_KEY, 0);
        }

        /* The FAB will display the contents of our data in a toast message */
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You clicked the FAB button: " + mData, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
