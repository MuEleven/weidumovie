package com.bw.movie.adapter.cinemaadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {

    private List<RecommendBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public RecommendAdapter(List<RecommendBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recommend_item_layout, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RecommendBean.ResultBean resultBean = list.get(i);
        String logo = resultBean.getLogo();
        String name = resultBean.getName();
        String address = resultBean.getAddress();

        viewHolder.image.setImageURI(logo);
        viewHolder.name.setText(name);
        viewHolder.address.setText(address);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        SimpleDraweeView image;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.address)
        TextView address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this.itemView);
        }
    }
}
