package com.undp.aep.ui.Activity.Learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;


 import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.undp.aep.Adapter.Learn.ViewPagerAdapter;
import com.undp.aep.R;
import com.undp.aep.ui.Fragment.CourseFragment;
import com.undp.aep.ui.Fragment.MainFragment;
import com.undp.aep.ui.Fragment.MyAccountFragment;
import com.undp.aep.ui.Fragment.NotificationFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity2 extends AppCompatActivity {
    FrameLayout container;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;
    RecyclerView lst_data;
    public int position;
    private FragmentStateAdapter pagerAdapter;

    //for font
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        getSharedPreferences("myapp", MODE_PRIVATE).edit().putInt("first", 1).commit();
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);

        lst_data = findViewById(R.id.lst_data);
        //   viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        pagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setIcon(tabs[position])
        ).attach();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                int tabIconColor = ContextCompat.getColor(HomeActivity2.this, R.color.colorblue1);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(HomeActivity2.this, R.color.lightblack);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
     //   create_database();
       // load_data();

    }
    //String[] tabs = {"الأحدث", "تعليم مستمر", "تدريب مهني", "ريادة اعمال"};
    private int[] tabs = {
            R.drawable.home2,
            R.drawable.presentation3,
            R.drawable.practice1,
            R.drawable.practice2
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu
    ) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_home, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) HomeActivity2.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(HomeActivity2.this.getComponentName()));
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 0)
                    filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    private void filter(String newText) {

        switch (position) {
            case 0:
                MainFragment.filterdata = new ArrayList<>();
                for (int i = 0; i < MainFragment.all_data.size(); i++) {
                    if (MainFragment.all_data.get(i).Title.contains(newText)) {
                        MainFragment.filterdata.add(MainFragment.all_data.get(i));
                        continue;
                    }

                    if (MainFragment.all_data.get(i).Description.contains(newText)) {
                        MainFragment.filterdata.add(MainFragment.all_data.get(i));
                        continue;
                    }

                }
                MainFragment.adapter.setList(MainFragment.filterdata);

                break;
            case 1:
                CourseFragment.filterdata = new ArrayList<>();
                for (int i = 0; i < CourseFragment.all_data.size(); i++) {
                    if (CourseFragment.all_data.get(i).Title.contains(newText)) {
                        CourseFragment.filterdata.add(CourseFragment.all_data.get(i));
                        continue;
                    }

                    if (CourseFragment.all_data.get(i).Description.contains(newText)) {
                        CourseFragment.filterdata.add(CourseFragment.all_data.get(i));
                        continue;
                    }
                }

                CourseFragment.adapter.setList(CourseFragment.filterdata);
                break;
            case 2:
                NotificationFragment.filterdata = new ArrayList<>();
                for (int i = 0; i < NotificationFragment.all_data.size(); i++) {
                    if (NotificationFragment.all_data.get(i).Title.contains(newText)) {
                        NotificationFragment.filterdata.add(NotificationFragment.all_data.get(i));
                        continue;
                    }

                    if (NotificationFragment.all_data.get(i).Description.contains(newText)) {
                        NotificationFragment.filterdata.add(NotificationFragment.all_data.get(i));
                        continue;
                    }
                }

                NotificationFragment.adapter.setList(NotificationFragment.filterdata);
                break;
            case 3:
                MyAccountFragment.filterdata = new ArrayList<>();
                for (int i = 0; i < MyAccountFragment.all_data.size(); i++) {
                    if (MyAccountFragment.all_data.get(i).Title.contains(newText)) {
                        MyAccountFragment.filterdata.add(MyAccountFragment.all_data.get(i));
                        continue;
                    }

                    if (MyAccountFragment.all_data.get(i).Description.contains(newText)) {
                        MyAccountFragment.filterdata.add(MyAccountFragment.all_data.get(i));
                        continue;
                    }
                }
                MyAccountFragment.adapter.setList(MyAccountFragment.filterdata);
                break;
        }

    }
/*

    private void create_database() {
        SQLiteDatabase db = openOrCreateDatabase("db" , MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE if not exists [Product] (\n" +
                "  [ID] INT, \n" +
                "  [Title] [NVARCHAR(300)], \n" +
                "  [Description] [NVARCHAR(3000)], \n" +
                "  [Type] INT, \n" +
                "  [Date] [NVARCHAR(3000)], \n" +
                "  [Image] [NVARCHAR(50)], \n" +
                "\n");
        db.close();
    }


    private void load_data() {
        if (internet_available())
            load_from_retrofit();
        else
            load_from_database();
    }
    private void load_from_database() {

        ArrayList<DataNews> all_Data= load_from_db();

        display_on_list(all_Data);
    }
    private ArrayList<DataNews> load_from_db() {
        SQLiteDatabase db = openOrCreateDatabase("db",MODE_PRIVATE,null);
        Cursor cursor = db.rawQuery("select * from DataNews ;" , null);
        ArrayList<DataNews> temp = new ArrayList<>();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            for (int i=0;i<cursor.getCount();i++)
            {
               DataNews c = new DataNews();

                c.Id=cursor.getInt(cursor.getColumnIndex("ID"));
                c.Title=cursor.getString(cursor.getColumnIndex("Title"));
                c.Description=cursor.getString(cursor.getColumnIndex("Description"));
                c.Type=cursor.getInt(cursor.getColumnIndex("Type"));
                c.Date=cursor.getString(cursor.getColumnIndex("Date"));
                c.Image=cursor.getString(cursor.getColumnIndex("Image"));
                temp.add(c);
                cursor.moveToNext();
            }
        }
        return temp;
    }
    private void load_from_retrofit() {
        APIClient.get().get_DataNews("4").enqueue(new Callback<List<DataNews>>() {
            @Override
            public void onResponse(Call<List<DataNews>> call, Response<List<DataNews>> response) {
                if (response!=null)
                {
                    if (response.isSuccessful())
                    {
                        List<DataNews> all_Data = response.body();
                        Log.i("tag", "onResponse: "+all_Data.size());
                        save_to_database(all_Data);
                        display_on_list((ArrayList<DataNews>) all_Data);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<DataNews>> call, Throwable t) {
                Log.i("tag", "onFailure: "+t.getMessage());
                load_from_database();
            }
        });
    }
    private void display_on_list(ArrayList<DataNews> all_Data) {
        Log.i("tag", "display_on_list: "+all_Data.size());
        DataAdapter adapter = new DataAdapter(this, R.layout.item_course,all_Data);
        lst_data.setAdapter(adapter);

    }
    private void save_to_database(List<DataNews> all_Data) {
        SQLiteDatabase db = openOrCreateDatabase("db",MODE_PRIVATE,null);
        db.execSQL("delete from DataNews;");
        for(int i=0;i<all_Datat.size();i++)
        {
            DataNews c = all_Data.get(i);
            String query=String.format("insert into Product(Id,Title,Description,Type,Date,Image)\n" +
                    " values (%d,'%s','%s','%d','%s','%s',"+c.Id+,c.Title,c.Description,c.Type,c.Date,c.Image,);

            db.execSQL(query);
            Log.i("tag", "save_to_database: "+query);
        }

        db.close();
    }

    private boolean internet_available() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }*/

}



