package com.undp.aep.ui.Activity.Form2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

 import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.undp.aep.Model.Form;
import com.undp.aep.R;
import com.undp.aep.ui.Activity.Start.MainActivity;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class FinalForm extends AppCompatActivity {
    TextView txt_final;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    ExtendedFloatingActionButton fab_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_form);
        txt_final = findViewById(R.id.txt_final);
        fab_submit = findViewById(R.id.fab_submit);

        fab_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalForm.this, MainActivity.class));
            }
        });
       /* txt_final.setText(Html.fromHtml("<p>" + Form.getInstance(false).Governorate+ "</p>" + "<br>"
        +"<p>" + Form.getInstance(false).ArabicName+ "</p>" + "<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).EnglishName+ "</p>"+ "<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>"+ "b" + Form.getInstance(false).NationalID+"</b>" +"</p>"+ "<br>"
        +"<p>" + Form.getInstance(false).EntityID+ "</p>"+ "<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).BirthDate+ "</p>"+ "<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).Constraint+ "</p>"+ "<br>"
        +"<p>" + Form.getInstance(false).Gender+ "</p>"+ "<br>"
        +"<p>" + Form.getInstance(false).Married+ "</p>"+ "<br>"
        +"<p>" + Form.getInstance(false).disability+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).FatherName+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).FatherWork+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).FatherAge+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).MotherName+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).MotherWork+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).MotherAge+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).Martyrs_families+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).Residence+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).MilitaryService+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).HowKnowYEP+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).Phone+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).Mobile+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).Whatsapp+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).Facebook+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).City+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).Region+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).Town+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).Address+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).Certificate+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).AcademicSpecialization+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).LastCertificateDate+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).StudyYear+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).AllCourses+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).englishLevel+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).otherLanguage+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).otherLanguageLevel+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).skill1+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).skill2+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).drivingLicense+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).licenseKind+ "</p>"+"<nbsp>" + "<nbsp>"+ "<nbsp>"+"<nbsp>"
        +"<p>" + Form.getInstance(false).licenseCategory+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).icdl+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).allComputers+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).myExpectations+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).applyReason+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).previousJobs+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).freeTime+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).privateBusiness+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).achievements+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).whyNot+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).profession+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).professionDetails+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).whyProfession+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).allStrength+ "</p>"+"<br>"
        +"<p>" + Form.getInstance(false).allWeakness+ "</p>"+"<br>"
        ));*/

    }
}