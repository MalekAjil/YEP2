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
import android.widget.Button;
import android.widget.ListView;

 import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Adapter.JobsAdapter;
import com.undp.aep.Model.Form;
import com.undp.aep.Model.Jobs;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Data_input_9 extends AppCompatActivity {
    ListView lst_jobs;
    ExtendedFloatingActionButton fab_next;
    ExtendedFloatingActionButton fab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input_9);
        lst_jobs = findViewById(R.id.lst_jobs);
        fab_next = findViewById(R.id.fab_next);
        fab_add = findViewById(R.id.fab_add);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_job_d(new Jobs());
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
            Intent intent = new Intent(this, Data_input_10.class);
            startActivity(intent);
        }catch (Exception ex) {
        }
    }


    private void show_job_d(Jobs j) {
        Dialog d = new Dialog(this);
        d.setContentView(R.layout.dialog_jobs);
        TextInputEditText txt_jobName = d.findViewById(R.id.txt_jobName);
        TextInputEditText txt_companyName = d.findViewById(R.id.txt_companyName);
        TextInputEditText txt_jobPeriodFrom = d.findViewById(R.id.txt_jobPeriodFrom);
        TextInputEditText txt_jobPeriodTo = d.findViewById(R.id.txt_jobPeriodTo);
        TextInputEditText txt_leaveReasons = d.findViewById(R.id.txt_leaveReasons);
        Button bt_ok = d.findViewById(R.id.bt_ok);
        Window window = d.getWindow(); //to control the size of the dialog
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jobs j = new Jobs();
                j.jobName = txt_jobName.getText().toString();
                j.companyName = txt_companyName.getText().toString();
                j.jobPeriodFrom = txt_jobPeriodFrom.getText().toString();
                j.jobPeriodTo = txt_jobPeriodTo.getText().toString();
                j.leaveReasons = txt_leaveReasons.getText().toString();
                Form.getInstance(false).previousJobs.add(j);
                d.dismiss();
                Display_jobs();


            }
        });
        d.show();

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    private void Display_jobs() {
        JobsAdapter adapter = new JobsAdapter(this,R.layout.jobs_adapter,Form.getInstance(false).previousJobs);
        lst_jobs.setAdapter(adapter);
        lst_jobs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                show_job_d((Jobs) parent.getItemAtPosition(position));
                return false;
            }
        });
    }
}