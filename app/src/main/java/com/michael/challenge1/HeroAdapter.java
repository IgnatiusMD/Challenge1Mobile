package com.michael.challenge1;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    ArrayList<HeroModel> heroModelArrayList;
    Context context;

    public HeroAdapter(Context context, ArrayList<HeroModel> heroModelArrayList){
        this.context = context;
        this.heroModelArrayList = heroModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.item_heroes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.ViewHolder holder, int position) {
        HeroModel heroModel = heroModelArrayList.get(position);
        holder.tvHero_Name.setText(heroModel.getHeroName());
        holder.ivImage.setImageResource(heroModel.getImage());
        holder.tvHeroSource.setText(heroModel.getSource());
    }

    @Override
    public int getItemCount() {
        return heroModelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImage;
        TextView tvHero_Name;
        TextView tvHeroSource;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvHero_Name = itemView.findViewById(R.id.tv_hero_name);
            tvHeroSource = itemView.findViewById(R.id.tv_heroSource);
        }
    }

}
