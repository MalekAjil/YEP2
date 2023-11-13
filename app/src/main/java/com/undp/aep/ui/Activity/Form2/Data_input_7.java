package com.undp.aep.ui.Activity.Form2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_input_7 extends AppCompatActivity {
    TextInputEditText txt_goal;
    TextInputEditText txt_expect;
    ExtendedFloatingActionButton fab_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input_7_1);
        txt_goal = findViewById(R.id.txt_goal);
        txt_expect = findViewById(R.id.txt_expect);
        fab_next = findViewById(R.id.fab_next);
        Form.getInstance(false).myGoal = txt_goal.getText().toString();
        Form.getInstance(false).myExpectations = txt_expect.getText().toString();

        fab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NextPage();
            }
        });

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    private void NextPage() {
        try {
            Intent intent = new Intent(this, Data_input_8.class);
            startActivity(intent);
        }catch (Exception ex) {
        }
    }
}