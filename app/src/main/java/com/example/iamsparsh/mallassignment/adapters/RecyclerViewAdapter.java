package com.example.iamsparsh.mallassignment.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iamsparsh.mallassignment.R;
import com.example.iamsparsh.mallassignment.models.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iamsparsh on 4/7/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private List<Restaurant> restaurantList = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(List<Restaurant> restaurantList, Context context) {
        this.restaurantList = restaurantList;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.name.setText(restaurantList.get(position).getName());

        Picasso.with(context).load("http://stage.phonethics.in/inorbitapp/"+restaurantList.get(position).getImage_url())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;

        public CustomViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.mall_name);
        }
    }
}
