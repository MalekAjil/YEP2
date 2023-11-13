package com.undp.aep.ui.Activity.Learn;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.undp.aep.Model.News;
import com.undp.aep.R;


public class DetailsActivity extends AppCompatActivity {

    public TextView txt_date;
    public TextView txt_title;
    public TextView txt_description;
    public ImageView image_news;


    public static News item=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        txt_date = findViewById(R.id.txt_date);
        txt_title = findViewById(R.id.txt_title);
        txt_description = findViewById(R.id.txt_description);
        image_news = findViewById(R.id.image_news);
        setTitle(item.Title);


        txt_date.setText(item.Date);
        txt_description.setText(item.Description)
        ;
        txt_title.setText(item.Title);
        Picasso.get().load(item.Image).into(image_news);

   Button fab = findViewById(R.id.fab);
        fab.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

