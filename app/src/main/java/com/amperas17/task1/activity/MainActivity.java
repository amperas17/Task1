package com.amperas17.task1.activity;

import android.annotation.TargetApi;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amperas17.task1.R;
import com.amperas17.task1.adapter.DividerItemDecoration;
import com.amperas17.task1.adapter.ImageAdapter;

import java.util.ArrayList; //[Commen] Unused imports

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int ITEM_SPACE = 5;
    ArrayList<Integer> mImages; //[Comment] Visibility modifiers

    RecyclerView mRecyclerView; //[Comment] Visibility modifiers
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

        //It works, but too many times if you scroll recycler, so I leave it to show this way
        //But I add this onClick function to images in Adapter.
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(MainActivity.this, "RecyclerView", Toast.LENGTH_SHORT).show(); //[Comment] Commented code
                return false;
            }
        });
        getSupportActionBar().setTitle("CE-1257218"); //[Comment] Hardcode

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#55789E"))); //[Comment] Hardcode

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#45688E")); //[Comment] Hardcode
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
            Toast.makeText(this,"TextView",Toast.LENGTH_SHORT).show(); //[Comment] Hardcode
        } else if (v instanceof LinearLayout){
            Toast.makeText(this,"LinearLayout",Toast.LENGTH_SHORT).show(); //[Comment] Hardcode
        } else if (v instanceof View){
            Toast.makeText(this,"View",Toast.LENGTH_SHORT).show(); //[Comment] Hardcode
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
