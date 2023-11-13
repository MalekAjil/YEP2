package com.undp.aep.Adapter;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

 import com.google.android.material.textview.MaterialTextView;
import com.undp.aep.Model.Computer;
import com.undp.aep.Model.Jobs;
import com.undp.aep.R;

import java.util.ArrayList;
import java.util.Date;

public class JobsAdapter extends ArrayAdapter<Jobs> {
    public JobsAdapter(@NonNull Context context, int resource , ArrayList<Jobs> all_data) {

        super(context, resource,all_data);
        this.mContext = context;
        this.all_data = all_data;

    }
    private Context mContext;
    public ArrayList<Jobs> all_data;

    private class ViewHolder{
        MaterialTextView jobName;
        MaterialTextView companyName;
        MaterialTextView jobPeriodFrom;
        MaterialTextView jobPeriodTo;
        MaterialTextView leaveReasons;


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            LayoutInflater vi= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.jobs_adapter,null);
            holder = new ViewHolder();
            convertView.setTag(holder);}

        else{ holder = (ViewHolder) convertView.getTag();}
        final Jobs c = all_data.get(position);
        holder.jobName = (MaterialTextView) convertView.findViewById(R.id.jobName);
        holder.companyName = (MaterialTextView) convertView.findViewById(R.id.companyName);
        holder.jobPeriodFrom = (MaterialTextView) convertView.findViewById(R.id.jobPeriodFrom);
        holder.jobPeriodTo = (MaterialTextView) convertView.findViewById(R.id.jobPeriodTo);
        holder.leaveReasons = (MaterialTextView) convertView.findViewById(R.id.leaveReasons);

        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");

        holder.jobName.setText(c.jobName);
        holder.companyName.setText(c.companyName);
        holder.leaveReasons.setText(c.leaveReasons);
        try {
            Date d=dateFormat.parse(c.jobPeriodFrom);
            Date d1=dateFormat.parse(c.jobPeriodTo);
            holder.jobPeriodFrom.setText(d+"");
            holder.jobPeriodTo.setText(d1+"");

        }
        catch(Exception e) {

        }


        return convertView;
    }
}

