package com.undp.aep.ui.Activity.Form2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CursorAdapter;
import android.widget.ResourceCursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

 import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Model.ApplyReason;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_input_8 extends AppCompatActivity {
    ExtendedFloatingActionButton fab_next;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    MaterialAutoCompleteTextView auto_items;
    TextInputEditText txt_free;
 //   TextView txt_view;
    String[] lstItems = {"البحث عن وظيفة قطاع عام", "البحث عن وظيفة قطاع خاص","تعلم مهنة","الرغبة بافتتاح مشروع صغير","تطوير نفسي","غير محدد بشيء"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input_8);
        fab_next= findViewById(R.id.fab_next);
        auto_items= findViewById(R.id.dropdown_menu);
        txt_free = findViewById(R.id.txt_free);
       // txt_view = findViewById(R.id.txt_view);
      //  ArrayList<String> items = new ArrayList<>();
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,lstItems);
        auto_items.setAdapter(adapter);

        auto_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Form.getInstance(false).applyReason = position;
            }
        });
        Form.getInstance(false).freeTime = txt_free.getText().toString();
        fab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NextPage();
            }
        });


    }

    private void NextPage() {
        try {
            Intent intent = new Intent(this, Data_input_9.class);
            startActivity(intent);
        }catch (Exception ex) {
        }
    }
}