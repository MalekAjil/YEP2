package com.undp.aep.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

 import com.google.android.material.textview.MaterialTextView;
import com.undp.aep.Model.Jobs;
import com.undp.aep.R;

import java.util.ArrayList;

public class StrengthAdapter extends ArrayAdapter<String> {
    public StrengthAdapter(@NonNull Context context, int resource , ArrayList<String> all_data) {
        super(context, resource,all_data);
        this.mContext = context;
        this.all_data = all_data;

    }
    private Context mContext;
    public ArrayList<String> all_data;

    private class ViewHolder{
        MaterialTextView strength;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            LayoutInflater vi= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.strength_adapter,null);
            holder = new ViewHolder();
            convertView.setTag(holder);}

        else{ holder = (ViewHolder) convertView.getTag();}
        final String c = all_data.get(position);
        holder.strength = (MaterialTextView) convertView.findViewById(R.id.strength);
        holder.strength.setText(c);

        return convertView;
    }
    }

