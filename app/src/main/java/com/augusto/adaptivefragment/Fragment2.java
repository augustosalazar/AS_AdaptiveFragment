package com.augusto.adaptivefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    final static String ARG_POSITION = "position";
    private TextView mTextView;
    int mCurrentPosition = -1;
    private String TAG = "AdaptiveFragmentLog";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_fragment2, container, false);

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");
        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.

        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateView(args.getInt("number"));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateView(mCurrentPosition);
        }
    }

    public void updateView(int position) {
        Log.d(TAG, "updateView " + position);
        mTextView = (TextView) getActivity().findViewById(R.id.textViewF2);
        mTextView.setText(position+"");
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

}
