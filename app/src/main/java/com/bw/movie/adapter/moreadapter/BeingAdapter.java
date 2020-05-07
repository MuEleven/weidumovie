package com.bw.movie.adapter.moreadapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.ZzsyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeingAdapter extends RecyclerView.Adapter<BeingAdapter.ViewHolder> {
    private List<ZzsyBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public BeingAdapter(List<ZzsyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bring_item_layout, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZzsyBean.ResultBean resultBean = list.get(i);
        String imageUrl = resultBean.getImageUrl();
        double score = resultBean.getScore();
        String name = resultBean.getName();
        String director = resultBean.getDirector();
        String starring = resultBean.getStarring();

        viewHolder.showingSimple.setImageURI(imageUrl);
        viewHolder.showingScore.setText(score + "分");
        viewHolder.showingName.setText(name);
        viewHolder.showingDirector.setText(director);
        viewHolder.showingStarring.setText(starring);
        viewHolder.showingBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "购票", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(MyApp.sContext, LoginActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.showing_simple)
        SimpleDraweeView showingSimple;
        @BindView(R.id.showing_name)
        TextView showingName;
        @BindView(R.id.showing_director)
        TextView showingDirector;
        @BindView(R.id.showing_score)
        TextView showingScore;
        @BindView(R.id.showing_starring)
        TextView showingStarring;
        @BindView(R.id.showing_but)
        Button showingBut;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
