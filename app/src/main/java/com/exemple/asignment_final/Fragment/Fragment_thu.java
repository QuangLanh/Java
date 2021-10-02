package com.exemple.asignment_final.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.exemple.asignment_final.R;
import com.exemple.asignment_final.Adapter.TabAdapter;
import com.exemple.asignment_final.TabFragment.Tab_Chi;
import com.exemple.asignment_final.TabFragment.Tab_Thu;
import com.google.android.material.tabs.TabLayout;

public class Fragment_thu extends Fragment {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thu, container , false);

        viewPager = view.findViewById(R.id.viewPage);
        tabLayout = view.findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new Tab_Thu(),"Khoản thu");
        adapter.addFragment(new Tab_Chi(),"Khoản chi");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
