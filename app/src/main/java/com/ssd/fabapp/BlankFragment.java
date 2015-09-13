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
public class BlankFragment extends Fragment {

    private int mData;

    public BlankFragment() {
        // Required empty public constructor
    }

    private static final String DATA_KEY = "data_key";
    public static BlankFragment getNewInstance(int data) {
        Bundle args = new Bundle();
        args.putInt(DATA_KEY, data);

        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setArguments(args);

        return blankFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        FloatingActionButton fabButton = (FloatingActionButton)view.findViewById(R.id.fabButton);

        Bundle bundle = getArguments();
        if(bundle != null) {
            mData = bundle.getInt(DATA_KEY, 0);
        }

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You clicked the FAB button: " + mData, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }


}
