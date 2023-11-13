package com.undp.aep.ui.Activity.Form2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

 import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_input_10 extends AppCompatActivity {
    SwitchMaterial sw_privateBusiness;
    SwitchMaterial sw_profession;
    TextInputEditText txt_yes;
    TextInputEditText txt_no;
    TextInputEditText txt_do;
    TextInputEditText txt_dont;
    ExtendedFloatingActionButton fab_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input_10);
        sw_privateBusiness = findViewById(R.id.sw_privateBusiness);
        sw_profession = findViewById(R.id.sw_profession);
        txt_yes = findViewById(R.id.txt_yes);
        txt_no = findViewById(R.id.txt_no);
        txt_do = findViewById(R.id.txt_do);
        txt_dont = findViewById(R.id.txt_dont);
        fab_next = findViewById(R.id.fab_next);

       sw_privateBusiness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    txt_yes.setEnabled(true);
                    txt_no.setEnabled(false);
                    Form.getInstance(false).achievements = txt_yes.getText().toString();
                    Form.getInstance(false).privateBusiness =1;
                }
                else {
                    txt_yes.setEnabled(false);
                    txt_no.setEnabled(true);
                    Form.getInstance(false).whyNot = txt_no.getText().toString();
                    Form.getInstance(false).privateBusiness =0;
                }

        }
       });


        sw_profession.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    txt_do.setEnabled(true);
                    txt_dont.setEnabled(false);
                    Form.getInstance(false).professionDetails = txt_do.getText().toString();
                    Form.getInstance(false).profession =1;
                }
                else {
                    txt_do.setEnabled(false);
                    txt_dont.setEnabled(true);
                    Form.getInstance(false).whyProfession = txt_no.getText().toString();
                    Form.getInstance(false).profession =0;
                }

            }
        });

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
            Intent intent = new Intent(this, Data_input_11.class);
            startActivity(intent);
        }catch (Exception ex) {
        }
    }
    }
