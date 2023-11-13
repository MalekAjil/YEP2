package com.undp.aep.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


 import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.undp.aep.Adapter.Learn.NewsAdapter;
import com.undp.aep.Model.News;
import com.undp.aep.R;

public class MyAccountFragment extends Fragment {

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
        View v= inflater.inflate(R.layout.fragment_my_account, container, false);




        all_data.add(new News(1, "الخبرالأول " , "الخبر الاول توصيف " , 4 , "20-12-2021" ,"https://via.placeholder.com/728x200.png?text=hi3"));

        all_data.add(new News(2, "الخبر الثاني " , "الخبر الاول توصيف " , 4 , "20-12-1990" ,"https://via.placeholder.com/728x200.png?text=hi3"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));
        all_data.add(new News(3, "الخبر الثالث " , "الخبر الاول توصيف " , 4 , "20-12-2000" ,"https://via.placeholder.com/728x200.png"));


        RecyclerView lst_data2 = v.findViewById(R.id.lst_data);
        adapter = new NewsAdapter(getContext(),all_data);
        lst_data2.setLayoutManager(new GridLayoutManager(getContext(), 1));

        lst_data2.setAdapter(adapter);

        return v;
    }
}