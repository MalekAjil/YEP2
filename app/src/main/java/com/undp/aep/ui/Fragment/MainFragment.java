package com.undp.aep.ui.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


 import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.undp.aep.Adapter.Learn.NewsAdapter;
import com.undp.aep.Adapter.Learn.SliderAdapter;
import com.undp.aep.Model.News;
import com.undp.aep.R;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {

   public static ArrayList<News> all_data= new ArrayList<News>();

    public static    ArrayList<News> filterdata= new ArrayList<News>();
    public static NewsAdapter adapter ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View  v= inflater.inflate(R.layout.fragment_main, container, false);

     //   loadRetrofit();


        ArrayList<String> list_of_image = new ArrayList<>();
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi1");
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi2");
        list_of_image.add("https://via.placeholder.com/728x200.png?text=hi3");




        all_data.add(new News(1, "الخبر الأول " , "الخبر الاول توصيف " , 1 , "20-12-2021" ,"https://via.placeholder.com/728x200.png?text=hi3"));

        all_data.add(new News(2, "الخبر الثاني " , "الخبر الاول توصيف " , 1 , "20-12-1990" ,"https://via.placeholder.com/728x200.png?text=hi3"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 1 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));


        RecyclerView lst_data = v.findViewById(R.id.lst_data);
         adapter = new NewsAdapter(getContext(),all_data);
        lst_data.setLayoutManager(new GridLayoutManager(getContext(), 1));

        lst_data.setAdapter(adapter);
        SliderView sliderView = v.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new SliderAdapter(getContext() ,  list_of_image));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

        return v;

    }
 /*   private void loadRetrofit() {
        APIClient.get().GET_DATANEWS().enqueue(new Callback<DataNews>() {
            @Override
            public void onResponse(Call<DataNews> call, Response<DataNews> response) {
                ArrayAdapter<News> adapter =new ArrayAdapter<>(MainFragment.this,
                        android.R.layout.simple_list_item_1,response.body().Description);
                lst_data.setAdapter(adapter);
                Log.i("tag", "onResponse: "+ response.isSuccessful());
                Log.i("tag", "onResponse: "+ response.body().Description.toString());
            }

            @Override
            public void onFailure(Call<DataNews> call, Throwable t) {
                Log.i("tag", "onFailure: "+ t.getMessage());
            }
        });
    }*/

}

