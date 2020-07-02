package com.akameko.testforprovercast.mainrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akameko.testforprovercast.R;
import com.akameko.testforprovercast.repository.pojos.Item;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Item> requestSites;

    //private ViewGroup parent; //для предоставления локальных ресурсов в onBingViewHolder


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView siteTitle;
        public TextView siteLink;
        public TextView siteDesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            siteTitle = itemView.findViewById(R.id.text_view_site_title);
            siteLink = itemView.findViewById(R.id.text_view_site_link);
            siteDesc = itemView.findViewById(R.id.text_view_site_desc);

        }
    }

    public MainAdapter(List<Item> requestSites) {
        this.requestSites = requestSites;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this.parent = parent;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.siteTitle.setText(requestSites.get(position).getTitle());
        holder.siteLink.setText(requestSites.get(position).getDisplayLink());
        holder.siteDesc.setText(requestSites.get(position).getSnippet());
    }

    @Override
    public int getItemCount() {
        return requestSites.size();
    }
}
