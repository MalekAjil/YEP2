package com.undp.aep.ui.Activity.Form1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_Input_5 extends AppCompatActivity {

    Form form=null;

    ArrayList<String> data1;
    ArrayList<String> data2;

    TextView txtHeader;

    TextInputEditText txtHowKnow,txtPhoneNum,txtMobileNum,txtWhatsAppNum,
            txtFacebookAccount,txtEmail;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    MaterialAutoCompleteTextView txtMilitary, txtResidence;

    Spinner  spnrResidence, spnrMilitary;

    ExtendedFloatingActionButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__input_5);

            form=Form.getInstance(false);

            data1 = new ArrayList<>();
            data2 = new ArrayList<>();

        spnrResidence = findViewById(R.id.spnrResidence);
            spnrMilitary = findViewById(R.id.spnrMilitary);
        txtMilitary = findViewById(R.id.txtMilitary);
        txtResidence = findViewById(R.id.txtResidence);

        txtResidence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    spnrResidence.performClick();
                }
            });

        txtMilitary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    spnrMilitary.performClick();
                }
            });

        spnrResidence.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 //   txtMartyrsFamily.setText(parent.getAdapter().getItem(position).toString());
                    txtResidence.setText(parent.getAdapter().getItem(position).toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            spnrMilitary.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    txtMilitary.setText(parent.getAdapter().getItem(position).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            txtHowKnow = findViewById(R.id.txtHowKnow);
            txtPhoneNum = findViewById(R.id.txtPhoneNum);
            txtMobileNum = findViewById(R.id.txtMobile);
            txtWhatsAppNum = findViewById(R.id.txtWhatsApp);
            txtFacebookAccount = findViewById(R.id.txtFacebook);
            txtEmail = findViewById(R.id.txtEmail);

            load_data();
            //txtNameEN.setText(person.getGovernorate());

            ArrayAdapter<String> adapter1, adapter2;
            adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data1);
            adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data2);
        spnrResidence.setAdapter(adapter1);
            spnrMilitary.setAdapter(adapter2);

            btnNext = findViewById(R.id.btnNext);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { goToNextPage(); }
            });

    }

    private void load_data(){
        data1.add("مهجّر");
        data1.add("مقيم");
        data1.add("عائد");

        data2.add("مؤجل");
        data2.add("مسرّح");
        data2.add("وحيد دائم");
        data2.add("وحيد مؤقت");
        data2.add("معفى");
/*
        switch(person.getGovernorate()){
            case "حلب":txtPhoneNum.;
            break;
            case "دمشق":;
                break;
            case "حماة":;
                break;
            case "اللاذقية":;
                break;
            case "طرطوس":;
                break;
            case "دير الزور":;
                break;
            case "الحسكة":;
                break;
        }
*/
    }

    private void goToNextPage() {
        //if(check()) {
        try {
            Intent intent = new Intent(this, Data_Input_6.class);
            //Toast.makeText(this, person.getGovernorate(), Toast.LENGTH_LONG).show();
            startActivity(intent);
        }catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        //}
    }

    private boolean check() {
        int checked = 0;
        if (txtHowKnow.getText().length() > 1) {
            form.HowKnowYEP=txtHowKnow.getText().toString();
            //checked++;
        }
        //else
          //  txtHowKnow.setError("الرجاء ملء هذا الحقل");

        if (txtPhoneNum.getText().length() > 5) {
            form.Phone=txtPhoneNum.getText().toString();
            //checked++;
        }
        //else
          //  txtHowKnow.setError("الرجاء ملء هذا الحقل");

        if (txtMobileNum.getText().length() > 7) {
            form.Mobile=txtHowKnow.getText().toString();
            checked++;
        } else
            txtHowKnow.setError("الرجاء ملء هذا الحقل");

        if (txtWhatsAppNum.getText().length() > 7) {
            form.WhatsApp =txtWhatsAppNum.getText().toString();
            //checked++;
        }
        //else
          //  txtHowKnow.setError("الرجاء ملء هذا الحقل");

        if (txtFacebookAccount.getText().length() > 3) {
            form.Facebook=txtFacebookAccount.getText().toString();
            //checked++;
        }
        //else
          //  txtHowKnow.setError("الرجاء ملء هذا الحقل");

        if (txtEmail.getText().length() > 7) {
            form.Email=txtEmail.getText().toString();
            //checked++;
        }
        //else
          //  txtHowKnow.setError("الرجاء ملء هذا الحقل");

        if(checked>0)
            return true;
        return false;
    }

}