package com.undp.aep.ui.Activity.Start;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class secondActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    FloatingActionButton floatingActionButton;

    int width, height;
    int width_S, height_S;

    int Radius;
    //    Balloon balloon1, balloon2, balloon3, balloon4, balloon5;
    Animation anim1, anim2, anim3, anim4, anim5, rotation;
    ImageView btn1, btn2, btn3, btn4, btn5;
    ImageButton IB;
    public void getScreenWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        if(Resources.getSystem().getDisplayMetrics().widthPixels<Resources.getSystem().getDisplayMetrics().heightPixels)
            width = Resources.getSystem().getDisplayMetrics().widthPixels / 3;
        else
            width =  Resources.getSystem().getDisplayMetrics().heightPixels / 3;
        height = width;
        Radius = (int) (width/1.5);
        width_S = width/3;
        height_S = height/3;
    }
    void find_o(){
        IB = findViewById(R.id.IB);
        btn1 = findViewById(R.id.BTs1);
        btn2 = findViewById(R.id.BTs2);
        btn3 = findViewById(R.id.BTs3);
        btn4 = findViewById(R.id.BTs4);
        btn5 = findViewById(R.id.BTs5);

        IB.getLayoutParams().width = width;
        IB.getLayoutParams().height = width;
        btn1.getLayoutParams().width = width_S;
        btn1.getLayoutParams().height = width_S;
        btn2.getLayoutParams().width = width_S;
        btn2.getLayoutParams().height = width_S;
        btn3.getLayoutParams().width = width_S;
        btn3.getLayoutParams().height = width_S;
        btn4.getLayoutParams().width = width_S;
        btn4.getLayoutParams().height = width_S;
        btn5.getLayoutParams().width = width_S;
        btn5.getLayoutParams().height = width_S;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getScreenWidth();
        find_o();
        ConstraintLayout cl = findViewById(R.id.circle_constraint_T); // No need if you have already done.
        ConstraintSet c = new ConstraintSet(); // Make new ConstraintSet.
        c.clone(cl); // Cloning from our ConstraintLayout or else our ConstraintSet won't get affect on ConstraintLayout.
        c.constrainCircle(R.id.BTs1, R.id.IB, Radius, 36); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.BTs2, R.id.IB, Radius, 108); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.BTs3, R.id.IB, Radius, 180); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.BTs4, R.id.IB, Radius, 252); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.BTs5, R.id.IB, Radius, 324); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.

        c.applyTo(cl); // Apply back our ConstraintSet on ConstraintLayout.



        floatingActionButton = findViewById(R.id.floatingBtn);

        new TapTargetSequence(this)
                .targets(
                        TapTarget.forView(btn1,"التوجيه المهني"," الإرشاد المهني ،مهارات قابلية التوظيف ،والتواصل مع أرباب العمل")
                                .outerCircleColor(R.color.cyan3)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(15)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(btn2,"فرص العمل","فرص توظيف الشباب، وتحسين وصولهم إلى الفرص المتاحة")
                                .outerCircleColor(R.color.lcyan3)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(15)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(btn3,"خدمات","خدمات التشبيك بين أصحاب الفعاليات الاقتصادية")
                                .outerCircleColor(R.color.green3)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(15)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(btn4,"ريادة الأعمال","تقديم الوعي الريادي واحتياجات المشاريع")
                                .outerCircleColor(R.color.red)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(15)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(btn5,"التعليم المستمر","يُساهم التعليم المستمرّ بتطوير الأفراد  على المستوى الشخصيّ و المهنيّ")
                                .outerCircleColor(R.color.yellow3)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(15)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                TapTarget.forView(floatingActionButton,"ابدأ","الى الواجهة الرئيسية")
                        .outerCircleColor(R.color.cyan3)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(20)
                        .titleTextColor(R.color.white)
                        .descriptionTextSize(15)
                        .descriptionTextColor(R.color.black)
                        .textColor(R.color.black)
                        .textTypeface(Typeface.SANS_SERIF)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(false)
                        .tintTarget(true)
                        .transparentTarget(true)
                        .targetRadius(60)).listener(new TapTargetSequence.Listener(){
            @Override
            public void onSequenceFinish() {
                SharedPreferences settings = getSharedPreferences("prefs", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("firstRun", false);
                editor.apply();
                startActivity(new Intent(secondActivity.this, MainActivity.class));
                secondActivity.this.finish();
            }

            @Override
            public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {


            }

            @Override
            public void onSequenceCanceled(TapTarget lastTarget) {

            }
        }).start();

    }
}