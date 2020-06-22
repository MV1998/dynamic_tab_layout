package com.example.dynamictablayout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;

public class FragmentDynamic extends Fragment {
    private static final String TAG = FragmentDynamic.class.getSimpleName();

    private View view;
    int val;
    TextView c;
    static FragmentDynamic fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.RESUMED);

        view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        return view;
    }

    public static FragmentDynamic addfrag(int val) {
        fragment = new FragmentDynamic();
        Bundle args = new Bundle();
        args.putInt("someInt", val);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        val = getArguments().getInt("someInt", 0);
        c = view.findViewById(R.id.textView);
        c.setText("Fragment - " + (val + 1));
        Log.d(TAG, "fragment: " + (val + 1));
    }
}