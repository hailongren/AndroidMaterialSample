package com.bearapp.material;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FavoriteFragment extends Fragment {

    private static final String TAG = "FavoriteFragment";


    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate>>>>>>>>");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView>>>>>>>>");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated>>>>>>>>");
        setSupportActionBar(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart>>>>>>>>");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop>>>>>>>>");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume>>>>>>>>");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause>>>>>>>>");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint>>>>>>>>" + isVisibleToUser);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView>>>>>>>>");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged>>>>>>>>" + hidden);
        if (!hidden) {
            setSupportActionBar(getView());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy>>>>>>>>");
    }

    /**
     * Set toolbar as ActionBar
     *
     * @param view
     */
    public void setSupportActionBar(View view) {
        MainActivity activity = (MainActivity) getActivity();
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (activity.CURRENT_FRAGMENT().equals(MainActivity.FAVORITE_FRAGMENT_TAG)) {
            Log.d(TAG, "setSupportActionBar>>>>>>>>");
            activity.setSupportActionBar(toolbar);
            activity.setupToolBar("Favorite");
        }
    }

}
