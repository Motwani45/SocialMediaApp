package com.example.socialmediaapp.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.socialmediaapp.R;
import com.example.socialmediaapp.adapters.ViewpagerAdapter;
import com.example.socialmediaapp.databinding.FragmentNotificationBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class NotificationFragment extends Fragment {
    FragmentNotificationBinding binding;


    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentNotificationBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        setViewpager();
        setShowNotificationFragment();
        setRequestsFragment();
        return view;
    }

    private void setRequestsFragment() {

    }

    private void setShowNotificationFragment() {

    }

    private void setViewpager() {
        ViewpagerAdapter adapter=new ViewpagerAdapter(NotificationFragment.this);
        binding.viewpager.setAdapter(adapter);
//        binding.tablayout.setBackgroundColor(getResources().getColor(R.color.red));
        binding.tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.black));
        new TabLayoutMediator(binding.tablayout, binding.viewpager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==0){
                    tab.setText("NOTIFICATION");
                }
                else{
                    tab.setText("REQUESTS");
                }
            }
        }).attach();
    }
}