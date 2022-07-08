package com.example.socialmediaapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.socialmediaapp.R;
import com.example.socialmediaapp.adapters.DashBoardAdapter;
import com.example.socialmediaapp.adapters.StoryAdapter;
import com.example.socialmediaapp.databinding.FragmentHomeBinding;
import com.example.socialmediaapp.models.DashBoardModel;
import com.example.socialmediaapp.models.StoryModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    ArrayList<StoryModel> storyModelArrayList;
    ArrayList<DashBoardModel> dashboardModelArrayList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        View view = binding.getRoot();
        setStoryRecyclerView();
        setDashBoardRecyclerView();
        return view;
    }

    private void setDashBoardRecyclerView() {
        dashboardModelArrayList=new ArrayList<>();
        dashboardModelArrayList.add(new DashBoardModel(R.drawable.ic_profile_icon_svg_gvqn3q,R.drawable.placeholderstory,R.drawable.ic_baseline_bookmark_border_24,"JAI","ESE HI ","257","257","257"));
        dashboardModelArrayList.add(new DashBoardModel(R.drawable.ic_profile_icon_svg_gvqn3q,R.drawable.placeholderstory,R.drawable.ic_baseline_bookmark_border_24,"JAI","ESE HI ","257","257","257"));
        dashboardModelArrayList.add(new DashBoardModel(R.drawable.ic_profile_icon_svg_gvqn3q,R.drawable.placeholderstory,R.drawable.ic_baseline_bookmark_border_24,"JAI","ESE HI ","257","257","257"));
        dashboardModelArrayList.add(new DashBoardModel(R.drawable.ic_profile_icon_svg_gvqn3q,R.drawable.placeholderstory,R.drawable.ic_baseline_bookmark_border_24,"JAI","ESE HI ","257","257","257"));
        DashBoardAdapter adapter=new DashBoardAdapter(getContext(),dashboardModelArrayList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        binding.dashboardrecyclerview.setLayoutManager(layoutManager);
        binding.dashboardrecyclerview.setNestedScrollingEnabled(false);
        binding.dashboardrecyclerview.setAdapter(adapter);

    }

    private void setStoryRecyclerView() {
        storyModelArrayList = new ArrayList<>();
        storyModelArrayList.add(new StoryModel(R.drawable.placeholderstory, R.drawable.live, R.drawable.ic_profile_icon_svg_gvqn3q, "JAI"));
        storyModelArrayList.add(new StoryModel(R.drawable.placeholderstory, R.drawable.live, R.drawable.ic_profile_icon_svg_gvqn3q, "JAI"));
        storyModelArrayList.add(new StoryModel(R.drawable.placeholderstory, R.drawable.live, R.drawable.ic_profile_icon_svg_gvqn3q, "JAI"));
        storyModelArrayList.add(new StoryModel(R.drawable.placeholderstory, R.drawable.live, R.drawable.ic_profile_icon_svg_gvqn3q, "JAI"));
        StoryAdapter adapter = new StoryAdapter(getContext(), storyModelArrayList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.storyrecyclerview.setLayoutManager(manager);
        binding.storyrecyclerview.setNestedScrollingEnabled(false);
        binding.storyrecyclerview.setAdapter(adapter);

    }
}