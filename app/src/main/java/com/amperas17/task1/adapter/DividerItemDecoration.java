package com.amperas17.task1.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Adds the spaces between images in recyclerView.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration{
    private int mSpace;

    public DividerItemDecoration(int space){
        mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = mSpace;
        outRect.bottom = mSpace;

        if (parent.getChildAdapterPosition(view)!=0){
            outRect.left = mSpace;
        }
        if (parent.getChildAdapterPosition(view)!=parent.getChildCount()){
            outRect.right = mSpace;
        }
    }
}
