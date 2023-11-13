package com.undp.aep.ui.Activity.Start;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.undp.aep.R;
import com.undp.aep.ui.Activity.Form1.Data_Input_1;
import com.undp.aep.ui.Activity.Guide.GuideActivity;
import com.undp.aep.ui.Activity.Learn.HomeActivity2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    BottomNavigationView o;
    int width, height, width_S, height_S, width_t, height_t;
    int Radius,RadiusT;
    Animation anim1, anim2, anim3, anim4, anim5, rotation, rotation2,animTv1;
    TextView tv1, tv2, tv3, tv4, tv5;
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
        RadiusT = width;
        width_S = width/3;
        height_S = height/3;
        width_t = width;
        height_t = width/2;


    }

    void find_o(){
        o = findViewById(R.id.nav_home);
        o = findViewById(R.id.nav_learning);
        o = findViewById(R.id.nav_traingin);
        o = findViewById(R.id.nav_sup);
        o = findViewById(R.id.nav_bus);
        o = findViewById(R.id.nav_job);
        IB = findViewById(R.id.IB);
        btn1 = findViewById(R.id.BTs1);
        btn2 = findViewById(R.id.BTs2);
        btn3 = findViewById(R.id.BTs3);
        btn4 = findViewById(R.id.BTs4);
        btn5 = findViewById(R.id.BTs5);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv1.getLayoutParams().width = width_t;
        tv1.getLayoutParams().height = height_t;

        tv2.getLayoutParams().width = width_t;
        tv2.getLayoutParams().height = height_t;

        tv3.getLayoutParams().width = width_t;
        tv3.getLayoutParams().height = height_t;

        tv4.getLayoutParams().width = width_t;
        tv4.getLayoutParams().height = height_t;

        tv5.getLayoutParams().width = width_t;
        tv5.getLayoutParams().height = height_t;
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
    void Anim (){
        anim1 = AnimationUtils.loadAnimation(this, R.anim.tran1);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.tran2);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.tran3);
        anim4 = AnimationUtils.loadAnimation(this, R.anim.tran4);
        anim5 = AnimationUtils.loadAnimation(this, R.anim.tran5);
        animTv1 = AnimationUtils.loadAnimation(this, R.anim.fade);

        rotation = AnimationUtils.loadAnimation(this, R.anim.rotation);
        rotation2 = AnimationUtils.loadAnimation(this, R.anim.rotation2);
        IB.setAnimation(rotation2);
        btn1.setAnimation(anim1);
        btn2.setAnimation(anim2);
        btn3.setAnimation(anim3);
        btn4.setAnimation(anim4);
        btn5.setAnimation(anim5);
        tv1.setAnimation(animTv1);
        tv2.setAnimation(animTv1);
        tv3.setAnimation(animTv1);
        tv4.setAnimation(animTv1);
        tv5.setAnimation(animTv1);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_traingin:
                startActivity(new Intent(MainActivity.this, GuideActivity.class));

                break;
            case R.id.nav_learning:
                startActivity(new Intent(MainActivity.this, HomeActivity2.class));
                break;
            case R.id.nav_sup:
                startActivity(new Intent(MainActivity.this, MainActivity1.class));

                break;
            case R.id.nav_bus:
                startActivity(new Intent(MainActivity.this, MainActivity2.class));

                break;
            case R.id.nav_job:
                startActivity(new Intent(MainActivity.this, MainActivity3.class));

                break;

        }
        return true;
    }
    ActionBarDrawerToggle mDrawerToggle;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
      Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Get DrawerLayout ref from layout
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        // Initialize ActionBarDrawerToggle, which will control toggle of hamburger.
        // You set the values of R.string.open and R.string.close accordingly.
        // Also, you can implement drawer toggle listener if you want.
         mDrawerToggle  = new ActionBarDrawerToggle (this, drawerLayout, mToolbar, R.string.open, R.string.close);
        // Setting the actionbarToggle to drawer layout
        drawerLayout.addDrawerListener(mDrawerToggle);
        // Calling sync state is necessary to show your hamburger icon...
        // or so I hear. Doesn't hurt including it even if you find it works
        // without it on your test device(s)
        mDrawerToggle.syncState();

        mToolbar.setTitle(getString(R.string.app_name));

         NavigationView navigationView = findViewById(R.id.nav_view);
         navigationView.setNavigationItemSelectedListener(this);


         findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this, Data_Input_1.class));
             }
         });


        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean firstRun = settings.getBoolean("firstRun", true);
        if (firstRun) {
            startActivity(new Intent(MainActivity.this, secondActivity.class));
        }
        getScreenWidth();
        find_o();
        Anim();



        ConstraintLayout cl = findViewById(R.id.circle_constraint); // No need if you have already done.
        ConstraintSet c = new ConstraintSet(); // Make new ConstraintSet.
        c.clone(cl); // Cloning from our ConstraintLayout or else our ConstraintSet won't get affect on ConstraintLayout.
        c.constrainCircle(R.id.BTs1, R.id.IB, Radius, 36); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.BTs2, R.id.IB, Radius, 108); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.BTs3, R.id.IB, Radius, 180); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.BTs4, R.id.IB, Radius, 252); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.BTs5, R.id.IB, Radius, 324); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.tv1, R.id.IB, RadiusT, 36); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.tv2, R.id.IB, RadiusT, 108); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.tv3, R.id.IB, RadiusT, 180); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.tv4, R.id.IB, RadiusT, 252); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.
        c.constrainCircle(R.id.tv5, R.id.IB, RadiusT, 324); // Applying our circle constraint, use anything replacing 40 for radius & 45 for any angle.

        c.applyTo(cl); // Apply back our ConstraintSet on ConstraintLayout.
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.clearAnimation();
                btn1.setAnimation(rotation);

                startActivity(new Intent(MainActivity.this, GuideActivity.class));
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GuideActivity.class));

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.clearAnimation();
                btn2.setAnimation(rotation);
                startActivity(new Intent(MainActivity.this, MainActivity1.class));

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity1.class));

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3.clearAnimation();
                btn3.setAnimation(rotation);
                startActivity(new Intent(MainActivity.this,MainActivity2.class));

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn4.clearAnimation();
                btn4.setAnimation(rotation);
                startActivity(new Intent(MainActivity.this,MainActivity3.class));

            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity3.class));

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5.clearAnimation();
                btn5.setAnimation(rotation);
                startActivity(new Intent(MainActivity.this, HomeActivity2.class));

            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity2.class));
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}