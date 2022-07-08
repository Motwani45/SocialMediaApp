package com.example.socialmediaapp.fragments;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialmediaapp.R;
import com.example.socialmediaapp.adapters.NotificationAdapter;
import com.example.socialmediaapp.databinding.FragmentShowNotificationBinding;
import com.example.socialmediaapp.models.NotificationModel;

import java.util.ArrayList;


public class ShowNotificationFragment extends Fragment {
    ArrayList<NotificationModel> list;
    FragmentShowNotificationBinding binding;

    public ShowNotificationFragment() {
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
        binding=FragmentShowNotificationBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        setNotificationRecyclerView();
        return view;
    }

    private void setNotificationRecyclerView() {
        list=new ArrayList<>();
        list.add(new NotificationModel(R.drawable.placeholderprofilerohit,"<b>JAI</b> invited You invited You invited You invited You","Just Now"));
        list.add(new NotificationModel(R.drawable.placeholderbackgroundrohit,"<b>JAI</b> invited You invited You invited You invited You","Just Now"));
        list.add(new NotificationModel(R.drawable.placeholderprofilerohit,"<b>JAI</b> invited You invited You invited You invited You","Just Now"));
        list.add(new NotificationModel(R.drawable.placeholderprofilerohit,"<b>JAI</b> invited You invited You invited You invited You","Just Now"));
        list.add(new NotificationModel(R.drawable.placeholderprofilerohit," <b>JAI</b> invited You invited You invited You invited You","Just Now"));
        NotificationAdapter adapter=new NotificationAdapter(getContext(),list);
        binding.notificationrecyclerview.setAdapter(adapter);
        binding.notificationrecyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        DividerItemDecoration itemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getContext().getResources().getDrawable(R.drawable.recyclerviewitemdecoration));
        binding.notificationrecyclerview.addItemDecoration(itemDecoration);
    }
}