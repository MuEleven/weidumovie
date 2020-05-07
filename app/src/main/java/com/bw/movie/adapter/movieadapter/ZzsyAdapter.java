package com.bw.movie.adapter.movieadapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.app.MyApp;
import com.bw.movie.bean.ZzsyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZzsyAdapter extends RecyclerView.Adapter<ZzsyAdapter.ViewHolder> {
    private List<ZzsyBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public ZzsyAdapter(List<ZzsyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zzsy_item_layout, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZzsyBean.ResultBean resultBean = list.get(i);
        String imageUrl = resultBean.getImageUrl();
        double score = resultBean.getScore();
        String name = resultBean.getName();
        int movieId = resultBean.getMovieId();
        viewHolder.simpleDraweeView.setImageURI(imageUrl);
        viewHolder.score.setText(score + "分");
        viewHolder.name.setText(name);
        viewHolder.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApp.sContext, "购票", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(MyApp.sContext, LoginActivity.class);
            }
        });
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickZzsyItemListener.onClick(movieId);
            }
        });
    }

    @Override
    public int getItemCount() {
            return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpleDraweeView)
        SimpleDraweeView simpleDraweeView;
        @BindView(R.id.score)
        TextView score;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.but)
        Button but;
        @BindView(R.id.relativeLayout)
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public onClickZzsyItemListener onClickZzsyItemListener;

    public void setOnClickCenterItemListener(onClickZzsyItemListener onClickZzsyItemListener) {
        this.onClickZzsyItemListener = onClickZzsyItemListener;
    }

    public interface onClickZzsyItemListener {
        void onClick(int movieId);
    }

    public interface OnClickTopItemListener{
        void onClick(int movieId);
    }

}
