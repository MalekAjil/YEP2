package com.undp.aep.Adapter;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.undp.aep.ui.Activity.Guide.GuideActivity;
 import com.undp.aep.ui.Fragment.ArticleFragment;
import com.undp.aep.ui.Fragment.ContinueFragment;
import com.undp.aep.ui.Fragment.DatabaseFragment;
import com.undp.aep.ui.Fragment.EmploymentSkillsFragment;
import com.undp.aep.ui.Fragment.NewsFragment;
import com.undp.aep.ui.Fragment.TashbeekFragment;


public class ViewPagerAdapter2 extends FragmentStateAdapter {
    Context context;
    public ViewPagerAdapter2(GuideActivity act) {
        super(act);
        this.context = act;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new NewsFragment();
        }
        else if (position == 1)
        {
            fragment = new ArticleFragment();
        }
        else if (position == 2)
        {
            fragment = new TashbeekFragment();
        }
        else if (position == 3)
        {
            fragment = new DatabaseFragment();
        }else if (position == 4)
        {
            fragment = new ContinueFragment();
        }else if (position == 5)
        {
            fragment = new EmploymentSkillsFragment();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
