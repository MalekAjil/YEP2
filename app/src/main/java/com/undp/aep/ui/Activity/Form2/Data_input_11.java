package com.undp.aep.ui.Activity.Form2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

 import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Adapter.StrengthAdapter;
import com.undp.aep.Adapter.WeaknessAdapter;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_input_11 extends AppCompatActivity {
    ListView lst_strength;
    ListView lst_weakness;
    ExtendedFloatingActionButton fab_adds;
    ExtendedFloatingActionButton fab_addw;
    ExtendedFloatingActionButton fab_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input_11);
        lst_strength = findViewById(R.id.lst_strength);
        lst_weakness = findViewById(R.id.lst_weakness);
        fab_adds = findViewById(R.id.fab_adds);
        fab_addw = findViewById(R.id.fab_addw);
        fab_next = findViewById(R.id.fab_next);
        fab_adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                show_s_dialog(new ArrayList<String>());
            }
        });
        fab_addw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                show_w_dialog(new ArrayList<String>());
            }
        });






     fab_next.setOnClickListener(new View.OnClickListener() {
   @Override
          public void onClick(View v) {
              NextPage();
         }
       });






    }

    private void NextPage() {
        try {
            Intent intent = new Intent(this, FinalForm.class);
            startActivity(intent);
        }catch (Exception ex) {
        }

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    private void show_w_dialog(ArrayList<String> strings) {
        Dialog w = new Dialog(this);
        w.setContentView(R.layout.dialog_weakness);
        TextInputEditText txt_weakness = w.findViewById(R.id.txt_weakness);
        Button bt_ok = w.findViewById(R.id.bt_ok);
        Window window = w.getWindow(); //to control the size of the dialog
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Form.getInstance(false).allWeakness.add(txt_weakness.getText().toString());
                w.dismiss();
                Display_w_data();
            }
        });
        w.show();

    }

    private void Display_w_data() {
        WeaknessAdapter adapter = new WeaknessAdapter(this,R.layout.weakness_adapter,Form.getInstance(false).allWeakness);
        lst_weakness.setAdapter(adapter);
        lst_weakness.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                show_w_dialog((ArrayList<String>) parent.getItemAtPosition(position));
                return false;
            }
        });
    }

    private void show_s_dialog(ArrayList<String> strings) {
        Dialog s = new Dialog(this);
        s.setContentView(R.layout.dialog_strength);
        TextInputEditText  txt_strength = s.findViewById(R.id.txt_strength);
        Button bt_ok = s.findViewById(R.id.bt_ok);
        Window window = s.getWindow(); //to control the size of the dialog
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Form.getInstance(false).allStrength.add(txt_strength.getText().toString());
                s.dismiss();
                Display_s_data();
            }
        });
        s.show();

    }

    private void Display_s_data() {
        StrengthAdapter adapter = new StrengthAdapter(this,R.layout.strength_adapter,Form.getInstance(false).allStrength);
        lst_strength.setAdapter(adapter);

        lst_strength.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                show_s_dialog((ArrayList<String>) parent.getItemAtPosition(position));
                return false;
            }
        });
    }
}