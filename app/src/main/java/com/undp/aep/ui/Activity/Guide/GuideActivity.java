package com.undp.aep.ui.Activity.Guide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.undp.aep.Adapter.NewsAdapter;
import com.undp.aep.Adapter.ViewPagerAdapter;
import com.undp.aep.Adapter.ViewPagerAdapter2;
import com.undp.aep.Data.Database.NewsDatabase;
import com.undp.aep.Data.Network.APIClient;
import com.undp.aep.Model.News;
import com.undp.aep.R;
import com.undp.aep.ui.Fragment.ArticleFragment;
import com.undp.aep.ui.Fragment.ContinueFragment;
import com.undp.aep.ui.Fragment.DatabaseFragment;
import com.undp.aep.ui.Fragment.EmploymentSkillsFragment;
import com.undp.aep.ui.Fragment.NewsFragment;
import com.undp.aep.ui.Fragment.TashbeekFragment;

import java.util.ArrayList;
import java.util.List;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuideActivity extends AppCompatActivity {
    FrameLayout container;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;
    TextView txtView;
    int[] tabs={R.drawable.home,R.drawable.letter,
            R.drawable.tashbeek,R.drawable.database,R.drawable.arrows,R.drawable.skills};
    public int position;
    private FragmentStateAdapter pagerAdapter;
    public static NewsDatabase newsDatabase=null;
    public static ArrayList<News> all_news= new ArrayList<News>();
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);
        newsDatabase= new NewsDatabase(this,"YEP",null,1);

        load_data();
        getSharedPreferences("myapp", MODE_PRIVATE).edit().putInt("first", 1).commit();
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);
        txtView=findViewById(R.id.txtView);
        ///set color for action bar
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#008FFF"));
        actionBar.setBackgroundDrawable(colorDrawable);
        //  viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        //pagerAdapter = new ViewPagerAdapter(this);
        pagerAdapter =new ViewPagerAdapter2(this);
        viewPager.setAdapter(pagerAdapter);
        /*new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(tabs[position])
        ).attach();
        */
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setIcon(tabs[position])
        ).attach();
        setupTextView(0);
        //setupTabIcons();
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#008FFF"), PorterDuff.Mode.SRC_IN);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position=tab.getPosition();
                setupTextView(position);
                tab.getIcon().setColorFilter(Color.parseColor("#008FFF"), PorterDuff.Mode.SRC_IN);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#787878"), PorterDuff.Mode.SRC_IN);
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
       // position=tabLayout.getSelectedTabPosition();
    }

    public void load_data() {

       /* if (internet_available())
            load_from_retrofit();
        else*/
            load_from_database();
    }
    public void load_from_database() {
        //ArrayList<News> all_news= load_from_db();
        all_news=load_from_db();
        //display_on_list(all_news);
    }
    public ArrayList<News> load_from_db() {
        Cursor cursor = newsDatabase.getAll();
        ArrayList<News> temp = new ArrayList<>();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            for (int i=0;i<cursor.getCount();i++)
            {
                News c = new News();
                c.ID=cursor.getInt(cursor.getColumnIndex("ID"));
                c.Type=cursor.getInt(cursor.getColumnIndex("Type"));
                c.Title=cursor.getString(cursor.getColumnIndex("Title"));
                c.Description=cursor.getString(cursor.getColumnIndex("Description"));
                c.Date=cursor.getString(cursor.getColumnIndex("Date"));
                c.Image=cursor.getString(cursor.getColumnIndex("Image"));
                temp.add(c);
                cursor.moveToNext();
            }
        }
        return temp;
    }
    public void load_from_retrofit() {
        APIClient.get().get_News().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response!=null)
                {
                    if (response.isSuccessful())
                    {
                        //List<News> all_News = response.body();
                        all_news= (ArrayList<News>) response.body();
                        save_to_database(all_news);
                        //display_on_list((ArrayList<News>) all_News);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                load_from_database();
            }
        });
    }
 /*   private void display_on_list(ArrayList<News> all_news) {
        NewsAdapter adapter = new NewsAdapter(this, R.layout.item_product,all_news);
        lst_data.setAdapter(adapter);
    }*/
    public void save_to_database(List<News> all_news) {
        newsDatabase.Delete();
        for(int i=0;i<all_news.size();i++)
        {
            News c = all_news.get(i);
            newsDatabase.Insert(c.ID,c.Title,c.Description,c.Type,c.Date,c.Image);
        }
        newsDatabase.close();
    }
    public boolean internet_available() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void setupTextView(int position) {
        switch (position){
            case 0:
                txtView.setText("الأحدث");break;
                case 1:
                txtView.setText("مقالات إرشادية");break;
                case 2:
                txtView.setText("تشبيك");break;
                case 3:
                txtView.setText("قاعدة البيانات");break;
                case 4:
                txtView.setText("متابعة");break;
                case 5:
                txtView.setText("مهارات التوظيف");break;
        }
    }
    //String[] tabs = {"الاحدث", "مقالات ارشادية", "تشبيك", "قاعدة بيانات","متابعة","مهارات نوظيف"};
    /*private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabs[0]);
        tabLayout.getTabAt(1).setIcon(tabs[1]);
        tabLayout.getTabAt(2).setIcon(tabs[2]);
        tabLayout.getTabAt(3).setIcon(tabs[3]);
        tabLayout.getTabAt(4).setIcon(tabs[4]);
        tabLayout.getTabAt(5).setIcon(tabs[5]);
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) GuideActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
          searchView = (SearchView) searchItem.getActionView();}
        if (searchView != null) {

            searchView.setSearchableInfo(searchManager.getSearchableInfo(GuideActivity.this.getComponentName()));
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                filter(query,position);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filter(newText,position);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void filter(String newText,int p ) {
        switch (p)
        {
            case 0:
                NewsFragment.filterData = new ArrayList<>();
                for (int i = 0; i < NewsFragment.all_data.size(); i++) {
                    if (NewsFragment.all_data.get(i).Title.contains(newText)) {
                        NewsFragment.filterData.add(NewsFragment.all_data.get(i));
                        continue;
                    }
                    if (NewsFragment.all_data.get(i).Description.contains(newText)) {
                        NewsFragment.filterData.add(NewsFragment.all_data.get(i));
                        continue;
                    }
                }
                NewsFragment.newsAdapter.setList(NewsFragment.filterData);
                break;
            case 1:
                ArticleFragment.filterData = new ArrayList<>();
                for (int i = 0; i < ArticleFragment.all_data.size(); i++) {
                    if (ArticleFragment.all_data.get(i).Title.contains(newText)) {
                        ArticleFragment.filterData.add(ArticleFragment.all_data.get(i));
                        continue;
                    }
                    if (ArticleFragment.all_data.get(i).Description.contains(newText)) {
                        ArticleFragment.filterData.add(ArticleFragment.all_data.get(i));
                        continue;
                    }
                }
                ArticleFragment.articleAdapter.setList(ArticleFragment.filterData);
                break;
            case 2:
                TashbeekFragment.filterData = new ArrayList<>();
                for (int i = 0; i < TashbeekFragment.all_data.size(); i++) {
                    if (TashbeekFragment.all_data.get(i).Title.contains(newText)) {
                        TashbeekFragment.filterData.add(TashbeekFragment.all_data.get(i));
                        continue;
                    }
                    if (TashbeekFragment.all_data.get(i).Description.contains(newText)) {
                        TashbeekFragment.filterData.add(TashbeekFragment.all_data.get(i));
                        continue;
                    }
                }
                TashbeekFragment.tashbeekAdapter.setList(TashbeekFragment.filterData);
                break;
            case 3:
                DatabaseFragment.filterData = new ArrayList<>();
                for (int i = 0; i < DatabaseFragment.all_data.size(); i++) {
                    if (DatabaseFragment.all_data.get(i).Title.contains(newText)) {
                        DatabaseFragment.filterData.add(DatabaseFragment.all_data.get(i));
                        continue;
                    }
                    if (DatabaseFragment.all_data.get(i).Description.contains(newText)) {
                        DatabaseFragment.filterData.add(DatabaseFragment.all_data.get(i));
                        continue;
                    }
                }
                DatabaseFragment.databaseAdapter.setList(DatabaseFragment.filterData);
                break;
            case 4:
                ContinueFragment.filterData = new ArrayList<>();
                for (int i = 0; i < ContinueFragment.all_data.size(); i++) {
                    if (ContinueFragment.all_data.get(i).Title.contains(newText)) {
                        ContinueFragment.filterData.add(ContinueFragment.all_data.get(i));
                        continue;
                    }
                    if (ContinueFragment.all_data.get(i).Description.contains(newText)) {
                        ContinueFragment.filterData.add(ContinueFragment.all_data.get(i));
                        continue;
                    }
                }
                ContinueFragment.continueAdapter.setList(ContinueFragment.filterData);
                break;
            case 5:
                EmploymentSkillsFragment.filterData = new ArrayList<>();
                for (int i = 0; i < EmploymentSkillsFragment.all_data.size(); i++) {
                    if (EmploymentSkillsFragment.all_data.get(i).Title.contains(newText)) {
                        EmploymentSkillsFragment.filterData.add(EmploymentSkillsFragment.all_data.get(i));
                        continue;
                    }
                    if (EmploymentSkillsFragment.all_data.get(i).Description.contains(newText)) {
                        EmploymentSkillsFragment.filterData.add(EmploymentSkillsFragment.all_data.get(i));
                        continue;
                    }
                }
                EmploymentSkillsFragment.employmentSkillsAdapter.setList(EmploymentSkillsFragment.filterData);
                break;
        }
    }
}