package com.example.socialmediaapp.adapters;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.socialmediaapp.fragments.NotificationFragment;
import com.example.socialmediaapp.fragments.RequestFragment;
import com.example.socialmediaapp.fragments.ShowNotificationFragment;

public class ViewpagerAdapter extends FragmentStateAdapter {
    private static final int NUM_FRAGMENTS=2;

    public ViewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewpagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewpagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return new ShowNotificationFragment();
        }
        else{
            return new RequestFragment();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_FRAGMENTS;
    }
}
