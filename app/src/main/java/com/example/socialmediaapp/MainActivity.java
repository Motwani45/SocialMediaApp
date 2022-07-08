package com.example.socialmediaapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.socialmediaapp.databinding.ActivityMainBinding;
import com.example.socialmediaapp.fragments.AddPostFragment;
import com.example.socialmediaapp.fragments.HomeFragment;
import com.example.socialmediaapp.fragments.NotificationFragment;
import com.example.socialmediaapp.fragments.ProfileFragment;
import com.example.socialmediaapp.fragments.SearchFragment;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStackImmediate();
            String name = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
            switch (name) {
                case "home":
                    binding.bottomnavigationbar.selectTabAt(0, false);
                    break;
                case "notification":
                    binding.bottomnavigationbar.selectTabAt(1, false);
                    break;
                case "addpost":
                    binding.bottomnavigationbar.selectTabAt(2, false);
                    break;
                case "search":
                    binding.bottomnavigationbar.selectTabAt(3, false);
                    break;
                case "profile":
                    binding.bottomnavigationbar.selectTabAt(4, false);
                    break;

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setSupportActionBar(binding.toolbar);
        MainActivity.this.setTitle("My Profile");
        binding.toolbar.setVisibility(View.GONE);
//        binding.bottomnavigationbar.selectTabAt(0,false);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        setContentView(binding.getRoot());
        setFramentTransactions();
        Toast.makeText(this, String.valueOf(getSupportFragmentManager().getBackStackEntryCount()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuitemstoolbar, menu);
        return true;
    }

    private void setFramentTransactions() {
        binding.bottomnavigationbar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NonNull AnimatedBottomBar.Tab tab1) {
//                Toast.makeText(MainActivity.this, "LAST TAB INDEX AND NAME:"+i+","+tab.getTitle()+"\n"+"CURRENT TAB INDEX AND NAME:"+i1+","+tab1.getTitle(), Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (i1) {
                    case 0:
                        binding.toolbar.setVisibility(View.GONE);
                        transaction.replace(R.id.container, new HomeFragment());
                        getSupportFragmentManager().popBackStack(getSupportFragmentManager().getBackStackEntryAt(0).getName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                    case 1:
                        binding.toolbar.setVisibility(View.GONE);
                        transaction.replace(R.id.container, new NotificationFragment()).addToBackStack("notification");
                        break;
                    case 2:
                        binding.toolbar.setVisibility(View.GONE);
                        transaction.replace(R.id.container, new AddPostFragment()).addToBackStack("addpost");
                        break;
                    case 3:
                        binding.toolbar.setVisibility(View.GONE);
                        transaction.replace(R.id.container, new SearchFragment()).addToBackStack("search");
                        break;
                    case 4:
                        transaction.replace(R.id.container, new ProfileFragment()).addToBackStack("profile");
                        binding.toolbar.setVisibility(View.VISIBLE);

                        break;
                }
                transaction.commit();

            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {

            }
        });
    }
}