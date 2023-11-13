package com.undp.aep.ui.Activity.Guide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
 import com.undp.aep.Model.News;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailsActivity extends AppCompatActivity {

    public TextView txt_date;
    public TextView txt_title;
    public TextView txt_description;
    public ImageView image_news;


    public static News item=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_date = findViewById(R.id.txt_date);
        txt_title = findViewById(R.id.txt_title);
        txt_description = findViewById(R.id.txt_description);
        image_news = findViewById(R.id.image_news);

        //change actionBar color
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#008FFF"));
        actionBar.setBackgroundDrawable(colorDrawable);

        setTitle(item.Title);
        txt_date.setText(item.Date);
        txt_description.setText(item.Description);
        txt_title.setText(item.Title);
        Picasso.get().load(item.Image).into(image_news);

        ExtendedFloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//startActivity(new Intent(DetailsActivity.this,Data_Input_1.class));
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}