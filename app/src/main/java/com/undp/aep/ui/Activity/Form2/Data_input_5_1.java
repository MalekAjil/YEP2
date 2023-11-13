package com.undp.aep.ui.Activity.Form2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;

 import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_input_5_1 extends AppCompatActivity {
    TextInputEditText txt_skill1;
    TextInputEditText txt_skill2;
    SwitchMaterial sw_skill3;
    MaterialTextView txt_license1;
    MaterialTextView txt_license2;
    ExtendedFloatingActionButton fab_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input_5_1);
        txt_skill1 = findViewById(R.id.txt_skill1);
        txt_skill2 = findViewById(R.id.txt_skill2);
        sw_skill3 = findViewById(R.id.sw_skill3);
        fab_next = findViewById(R.id.fab_next);
        txt_license1 = findViewById(R.id.txt_license1);
        txt_license2 = findViewById(R.id.txt_license2);
        Dialog d;
        Form.getInstance(false).skill1= String.valueOf(txt_skill1.getText());
        Form.getInstance(false).skill2= String.valueOf(txt_skill2.getText());


        d= new Dialog(this);
        d.setContentView(R.layout.lisence_dialog);
        TextInputEditText txt_kind = d.findViewById(R.id.txt_kind);
        TextInputEditText txt_category = d.findViewById(R.id.txt_category);
        Button bt_ok = d.findViewById(R.id.bt_ok);
        Window window = d.getWindow(); //to control the size of the dialog
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Form.getInstance(false).licenseKind = txt_kind.getText().toString();
                Form.getInstance(false).licenseCategory = txt_category.getText().toString();
                Form.getInstance(false).drivingLicense=1;
                txt_license1.setText("نوع الشهادة: " +txt_kind.getText().toString());
                txt_license2.setText("فئة الشهادة: " +txt_category.getText().toString());
                txt_license1.setVisibility(View.VISIBLE);
                txt_license2.setVisibility(View.VISIBLE);
                d.dismiss();
            }
        });
        sw_skill3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw_skill3.isChecked()==true)
                    d.show();
            }});

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
    public void NextPage() {
        try {
            Intent intent = new Intent(this, Data_input_6.class);
            startActivity(intent);
        }catch (Exception ex) {
        }
    }
}


