package com.undp.aep.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.undp.aep.Model.City;
import com.undp.aep.Model.Form;
import com.undp.aep.Model.Training;
import com.undp.aep.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class City_Adapter extends ArrayAdapter<City> {

    private Context mContext;
    public ArrayList<City> all_data;

    public City_Adapter(@NonNull Context context,  int textViewResourceId,
                        ArrayList<City> CityList) {
        super(context, textViewResourceId, CityList);
        mContext = context;
        this.all_data = CityList;
    }

    private class ViewHolder {
        TextView txtCenter;
        ImageView imgCenter;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.center_item, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.i(TAG, "City_Adapter: " + position);

        final City t = City.getData().get(position);

        holder.txtCenter = (TextView) convertView.findViewById(R.id.txtCenter);
        holder.imgCenter = (ImageView) convertView.findViewById(R.id.imgCenter);
        holder.txtCenter.setText(t.Name);
        holder.imgCenter.setImageResource(t.Img);

        return convertView;

    }




}
