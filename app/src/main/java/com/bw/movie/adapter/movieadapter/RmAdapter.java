package com.bw.movie.adapter.movieadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.RmBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RmAdapter extends RecyclerView.Adapter<RmAdapter.ViewHolder> {
   private List<RmBean.ResultBean> list = new ArrayList<>();
   private Context context;

    public RmAdapter(List<RmBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zzsy_item_layout, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RmBean.ResultBean resultBean = list.get(i);
        String imageUrl = resultBean.getImageUrl();
        String name = resultBean.getName();
        double score = resultBean.getScore();
        int movieId = resultBean.getMovieId();

        viewHolder.simpleDraweeView.setImageURI(imageUrl);
        viewHolder.name.setText(name);
        viewHolder.score.setText(score + "分");
        viewHolder.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "购买", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRmItemListener.onClick(movieId);
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
    public onClickRmItemListener onClickRmItemListener;

    public void setOnClickCenterItemListener(onClickRmItemListener onClickRmItemListener) {
        this.onClickRmItemListener = onClickRmItemListener;
    }

    public interface onClickRmItemListener {
        void onClick(int movieId);
    }
}
