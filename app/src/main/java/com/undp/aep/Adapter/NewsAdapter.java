package com.undp.aep.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
 import com.undp.aep.Model.News;
import com.undp.aep.R;
import com.undp.aep.ui.Activity.Guide.DetailsActivity;

import java.util.ArrayList;
import java.util.List;



public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final Context mCtx;
    public NewsAdapter(Context context,
                       List<News> List) {
        //super();
        this.mCtx = context;
        this.ListData = List;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
      //  holder.name.setText(POList.get(position).ID+" - "+POList.get(position).ID);
        holder.txt_date.setText( ListData.get(position).Date);
        holder.txt_description.setText(ListData.get(position).Description.substring(0,100) +" ...");
        holder.txt_title.setText(ListData.get(position).Title);
        Picasso.get().load(ListData.get(position).Image).into(holder.image_news);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.item=ListData.get(position);
                mCtx.startActivity(new Intent(mCtx,DetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListData.size();
    }
    public void setList(ArrayList<News> filterData) {
    ListData=filterData;
    notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_date;
        public TextView txt_title;
        public TextView txt_description;
        public ImageView image_news;
         public ViewHolder(View view) {
            super(view);
             txt_date = itemView.findViewById(R.id.txt_date);
             txt_title = itemView.findViewById(R.id.txt_title);
             txt_description = itemView.findViewById(R.id.txt_description);
             image_news = itemView.findViewById(R.id.image_news);
        }
    }
    public List<News> ListData;
}
