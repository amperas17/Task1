package com.amperas17.task1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.amperas17.task1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Works with images in recycler view.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<Integer> mImages; //[Comment] Use abstraction instead of realization
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView)itemView.findViewById(R.id.iv_list_item_image); //[Comment] Unnecessary "this"
        }
    }

    public ImageAdapter(Context context,ArrayList<Integer> images){
        mContext = context;
        mImages = images;
    }


    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        ViewHolder imageViewHolder = new ViewHolder(view);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mImages.get(position))
                .resizeDimen(R.dimen.image_size, R.dimen.image_size)
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.recycler_view_name_string,Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return mImages.size();
    }

}
