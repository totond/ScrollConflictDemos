package com.yanzhikai.scrollconflictdemos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SBFragment extends Fragment {
    private ArrayList<Fragment> fragments;
    private ViewPager myViewPager;
    private View btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sub, null);
        myViewPager = root.findViewById(R.id.vp);
        btn = root.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragments = new ArrayList<>();
                fragments.add(new WidgetFragment());
                fragments.add(new WidgetFragment());
                SubFragment.MyFragmentAdapter adapter = new SubFragment.MyFragmentAdapter(fragments, getChildFragmentManager());
                myViewPager.setAdapter(adapter);
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
