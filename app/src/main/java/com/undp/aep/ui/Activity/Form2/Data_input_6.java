package com.undp.aep.ui.Activity.Form2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

 import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Adapter.ComputerAdapter;
import com.undp.aep.Adapter.MinMaxFilter;
import com.undp.aep.Model.Computer;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_input_6 extends AppCompatActivity {
    SwitchMaterial sw_icdl;
    ExtendedFloatingActionButton fab_next;
    ExtendedFloatingActionButton fab_add;
    ListView lst_programs;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input_6_1);
        Form.getInstance(false).allComputers.clear();
        Form.getInstance(false).allComputers.add(new Computer("Word", 0));
        Form.getInstance(false).allComputers.add(new Computer("Powerpoint", 0));
        Form.getInstance(false).allComputers.add(new Computer("Excel", 0));
        Form.getInstance(false).allComputers.add(new Computer("E-mail", 0));
        Form.getInstance(false).allComputers.add(new Computer("Access", 0));
       // Computer c = new Computer("",0);
        sw_icdl = findViewById(R.id.sw_icdl);
        lst_programs = findViewById(R.id.lst_programs);
        fab_next = findViewById(R.id.fab_next);
        fab_add = findViewById(R.id.fab_add);
        fab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextPage();
            }
        });



        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_dialog(new Computer(), true);
            }
        });


        Display_data();
        if (sw_icdl.isChecked())
            Form.getInstance(false).icdl = 1;


    }

    private void NextPage() {
        try {
            Intent intent = new Intent(this, Data_input_7.class);
            startActivity(intent);
        }catch (Exception ex) {
        }
    }



    private void show_dialog(Computer c, boolean editable) {
        Dialog d = new Dialog(this);
        d.setContentView(R.layout.dialog_computer);
        TextInputEditText txt_name = d.findViewById(R.id.txt_name);
        TextInputEditText txt_percent =d.findViewById(R.id.txt_percent);
        txt_percent.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "100" )}) ;
        Button bt_add = d.findViewById(R.id.bt_add);
        txt_name.setText(c.program);
        txt_name.setEnabled(editable);
        txt_percent.setText(c.percent+"");
        Window window = d.getWindow(); //to control the size of the dialog
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.program = txt_name.getText().toString();
                c.percent = Integer.valueOf(txt_percent.getText().toString());
                if (!Form.getInstance(false).allComputers.contains(c))
                    Form.getInstance(false).allComputers.add(c);
                d.dismiss();
                Display_data();
            }


        });
        d.show();

    }

    private void Display_data() {
        ComputerAdapter adapter = new ComputerAdapter(this, R.layout.computer_adapter, Form.getInstance(false).allComputers);
        lst_programs.setAdapter(adapter);
        lst_programs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                show_dialog((Computer) adapterView.getItemAtPosition(position), (position > 4));
            }
        });
    }





}








