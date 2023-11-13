package com.undp.aep.ui.Activity.Form2;

import androidx.annotation.NonNull;
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
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.slider.Slider;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_input_5 extends AppCompatActivity {
    Slider sld_en;
    Slider sld_lan2;
    TextInputEditText txt_lan2;

    ExtendedFloatingActionButton fab_next;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input_5_0);
        sld_en = findViewById(R.id.sld_en);
        sld_lan2 = findViewById(R.id.sld_lan2);
        txt_lan2 = findViewById(R.id.txt_lan2);
        fab_next = findViewById(R.id.fab_next);

        sld_en.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                float english = sld_en.getValue();
                Form.getInstance(false).englishLevel = (int)english;
            }
        });
        Form.getInstance(false).otherLanguage = String.valueOf(txt_lan2.getText());
        sld_lan2.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                Form.getInstance(false).otherLanguageLevel= (int) sld_lan2.getValue();
            }
        });


        fab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NextPage();
            }
        });



    }

    public void NextPage() {
        try {
            Intent intent = new Intent(this, Data_input_5_1.class);
            startActivity(intent);
        }catch (Exception ex) {
        }
    }
}