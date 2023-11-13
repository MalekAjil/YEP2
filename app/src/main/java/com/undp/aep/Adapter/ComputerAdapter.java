package com.undp.aep.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

 import com.google.android.material.textview.MaterialTextView;
import com.undp.aep.Model.Computer;
import com.undp.aep.R;

import java.util.ArrayList;

public class ComputerAdapter extends ArrayAdapter<Computer> {


    public ComputerAdapter(@NonNull Context context, int resource , ArrayList<Computer> all_programs) {
        super(context, resource,all_programs);
        this.mContext = context;
        this.all_programs = all_programs;

    }
    private Context mContext;
    public ArrayList<Computer> all_programs;

    public static class ViewHolder{
        MaterialTextView txt_program;
        MaterialTextView txt_percent;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            LayoutInflater vi= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = vi.inflate(R.layout.computer_adapter,null);
        holder = new ViewHolder();
        convertView.setTag(holder);}

        else{ holder = (ViewHolder) convertView.getTag();}
        final Computer c = all_programs.get(position);
        holder.txt_program = (MaterialTextView) convertView.findViewById(R.id.txt_program);
        holder.txt_percent = (MaterialTextView) convertView.findViewById(R.id.txt_percent);
        holder.txt_program.setText(c.program);
        holder.txt_percent.setText(c.percent+" %");
        return convertView;
    }
    }

