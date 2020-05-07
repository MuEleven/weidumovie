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
import com.bw.movie.bean.JjsyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JjsyAdapter extends RecyclerView.Adapter<JjsyAdapter.ViewHolder> {
    private List<JjsyBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public JjsyAdapter(List<JjsyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.jjsy_item_layout, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        JjsyBean.ResultBean resultBean = list.get(i);
        String imageUrl = resultBean.getImageUrl();
        String name = resultBean.getName();
        long releaseTime = resultBean.getReleaseTime();
        int wantSeeNum = resultBean.getWantSeeNum();
        int movieId = resultBean.getMovieId();

        viewHolder.image.setImageURI(imageUrl);
        viewHolder.name.setText(name);
        Date date = new Date(releaseTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");//月
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd");//日
        viewHolder.data.setText(simpleDateFormat.format(date) + "月" + simpleDateFormat1.format(date) + "日上映");
        viewHolder.xiangkan.setText(wantSeeNum + "想看");
        viewHolder.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "预约", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickJjsyItemListener.onClick(movieId);
            }
        });
    }

    @Override
    public int getItemCount() {
            return list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.data)
        TextView data;
        @BindView(R.id.xiangkan)
        TextView xiangkan;
        @BindView(R.id.but)
        Button but;
        @BindView(R.id.image)
        SimpleDraweeView image;
        @BindView(R.id.relativeLayout)
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public onClickJjsyItemListener onClickJjsyItemListener;

    public void setOnClickCenterItemListener(onClickJjsyItemListener onClickJjsyItemListener) {
        this.onClickJjsyItemListener = onClickJjsyItemListener;
    }

    public interface onClickJjsyItemListener {
        void onClick(int movieId);
    }
}
