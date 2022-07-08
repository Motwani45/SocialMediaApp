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
import com.example.socialmediaapp.models.DashBoardModel;

import java.util.ArrayList;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.ViewHolder> {
    Context context;
    ArrayList<DashBoardModel> list;
    public DashBoardAdapter(Context context, ArrayList<DashBoardModel> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dashboardlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DashBoardModel model=list.get(position);
        holder.profile.setImageResource(model.getProfile());
        holder.image.setImageResource(model.getImage());
        holder.save.setImageResource(model.getSave());
        holder.likes.setText(model.getLikes());
        holder.about.setText(model.getAbout());
        holder.name.setText(model.getName());
        holder.comments.setText(model.getComments());
        holder.shares.setText(model.getShares());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile,image,save;
        TextView name,about,likes,comments,shares;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile=itemView.findViewById(R.id.profileimagedashboard);
            image=itemView.findViewById(R.id.imageviewdashboard);
            save=itemView.findViewById(R.id.save);
            name=itemView.findViewById(R.id.namedashboard);
            about=itemView.findViewById(R.id.aboutdashboard);
            likes=itemView.findViewById(R.id.likes);
            comments=itemView.findViewById(R.id.comments);
            shares=itemView.findViewById(R.id.shares);


        }
    }
}
