package com.amperas17.task1.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amperas17.task1.R;
import com.amperas17.task1.adapter.DividerItemDecoration;
import com.amperas17.task1.adapter.ImageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int ITEM_SPACE = 5;
    private ArrayList<Integer> mImages;

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeList();

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view_images);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new ImageAdapter(this, mImages));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(ITEM_SPACE));

        getSupportActionBar().setTitle(R.string.title_string);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.violet)));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
        }

    }

    private void makeList(){
        mImages = new ArrayList<>();
        mImages.add(R.drawable.image1);
        mImages.add(R.drawable.image2);
        mImages.add(R.drawable.image1);
        mImages.add(R.drawable.image2);
    }


    @Override
    public void onClick(View v) {
        if (v instanceof TextView){
            Toast.makeText(this, R.string.text_view_name_string,Toast.LENGTH_SHORT).show(); //[Comment] v.getClass().getSimpleName();
        } else if (v instanceof LinearLayout){
            Toast.makeText(this, R.string.linear_layout_name_string,Toast.LENGTH_SHORT).show();
        } else if (v instanceof View){
            Toast.makeText(this, R.string.view_name_string,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
