package com.undp.aep.ui.Activity.Form1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.undp.aep.Adapter.City_Adapter;
import com.undp.aep.Model.City;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class Data_Input_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__input_1);
        ListView lst_data = findViewById(R.id.lst_data);
        City_Adapter adapter = new City_Adapter(this, android.R.layout.simple_list_item_1, City.getData());
        lst_data.setAdapter(adapter);
        lst_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Form.getInstance(false).Governorate = ((City) parent.getItemAtPosition(position)).Name;
                goToNextPage();
            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    private void goToNextPage() {
        try {
            startActivity(new Intent(this, Data_Input_2.class));
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

/*
// Array of strings storing country names
    String[] cities = new String[] {
            "Aleppo",
            "Damascus",
            "Hamah",
            "Homs",
            "Latakia",
            "Tartous",
            "Deir Azzor",
            "Hasakah"
            };

            // Array of integers points to images stored in /res/drawable-ldpi/
            int[] flags = new int[]{
            R.drawable.aleppo3,
            R.drawable.damascus3,
            R.drawable.hama3,
            R.drawable.homs3,
            R.drawable.latakia3,
            R.drawable.tartous3,
            R.drawable.deir_azzor,
            R.drawable.hasakah3
            };

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__input_1);

        ListView lst_data = findViewById(R.id.lst_data);

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<cities.length;i++){
        HashMap<String, String> hm = new HashMap<String,String>();
        hm.put("txt", cities[i]);
        hm.put("img", Integer.toString(flags[i]) );
        aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "img","txt" };

        // Ids of views in listview_layout
        int[] to = { R.id.imgCenter,R.id.txtCenter};

        // Instantiating an adapter to store each items
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.center_item, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.lst_data);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
*/