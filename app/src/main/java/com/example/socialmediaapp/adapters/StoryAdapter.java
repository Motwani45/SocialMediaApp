package com.example.socialmediaapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.R;
import com.example.socialmediaapp.models.StoryModel;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    Context context;
    ArrayList<StoryModel> list;
    public StoryAdapter(Context context, ArrayList<StoryModel> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.storylayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.storyType.setImageResource(list.get(position).getStoryType());
        holder.profile.setImageResource(list.get(position).getProfile());
        holder.story.setImageResource(list.get(position).getStory());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView story,storyType,profile;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            story=itemView.findViewById(R.id.storyimageview);
            storyType=itemView.findViewById(R.id.live);
            profile=itemView.findViewById(R.id.profileimage);
            name=itemView.findViewById(R.id.name);

        }
    }
}
