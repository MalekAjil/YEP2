package com.undp.aep.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.undp.aep.Adapter.NewsAdapter;
import com.undp.aep.Adapter.SliderAdapter;
import com.undp.aep.Model.News;
import com.undp.aep.R;
import com.undp.aep.ui.Activity.Guide.GuideActivity;

import java.util.ArrayList;


public class NewsFragment extends Fragment {
    public static ArrayList<News> all_data= new ArrayList<News>();
    public static ArrayList<News> filterData= new ArrayList<News>();
    public static NewsAdapter newsAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        ArrayList<String> list_of_image = new ArrayList<>();
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi1");
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi2");
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi3");
        //all_data.add(new News(2, "الخبر الثاني " , "الخبر  توصيف " , 1 , "20-12-1990" ,"https://via.placeholder.com/728x200.png?text=hi3"));
        //all_data.add(new News(3, "الخبر الثالث " , "الخبر  توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        RecyclerView lst_data = v.findViewById(R.id.lst_data);
        //newsAdapter = new NewsAdapter(getContext(),all_data);
        newsAdapter = new NewsAdapter(getContext(), GuideActivity.all_news);
        lst_data.setLayoutManager(new GridLayoutManager(getContext(), 1));
        lst_data.setAdapter(newsAdapter);
        SliderView sliderView = v.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new SliderAdapter(getContext() , list_of_image));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();
        return v;
    }
}