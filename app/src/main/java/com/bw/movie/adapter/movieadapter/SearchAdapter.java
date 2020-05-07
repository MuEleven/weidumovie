package com.bw.movie.adapter.movieadapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: jiezhuoyi20191227
 * @Package: bw.com.movie.adapter.movieadapter
 * @ClassName: SearchAdapter
 * @Description: java类作用描述
 * @Author: 解卓逸
 * @UpdateUser: 更新者：
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.myHolder> {

   /* List<ZzsyBean> list = new ArrayList<>();


    public void addll(List<ZzsyBean> data) {
        if (data != null) {
            list.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        list.clear();
    }*/

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_item_layout, viewGroup, false);
        return new myHolder(view);*/
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder myHolder, final int i) {
      /*  myHolder.movieSousuoItemImg.setImageURI(list.get(i).imageUrl);
        myHolder.movieSousuoItemName.setText(list.get(i).name);
        myHolder.movieSousuoItemDaoyan.setText("导演：" + list.get(i).director);
        myHolder.movieSousuoItemZhuyan.setText("主演：" + list.get(i).starring);
        myHolder.movieSousuoItemSoce.setText(list.get(i).score + "分");
        myHolder.movieSousuoItemGoupiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApp.sContext, "购票", Toast.LENGTH_SHORT).show();
            }
        });

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTopItemListener.onClick(list.get(i).movieId);
            }
        });*/

    }

    @Override
    public int getItemCount() {
     /*   if (list != null) {
            return list.size();
        }*/
        return 0;
    }

    public class myHolder extends RecyclerView.ViewHolder {

       /* @BindView(R.id.movie_sousuo_item_name)
        TextView movieSousuoItemName;
        @BindView(R.id.movie_sousuo_item_daoyan)
        TextView movieSousuoItemDaoyan;
        @BindView(R.id.movie_sousuo_item_zhuyan)
        TextView movieSousuoItemZhuyan;
        @BindView(R.id.movie_sousuo_item_soce)
        TextView movieSousuoItemSoce;
        @BindView(R.id.movie_sousuo_item_goupiao)
        Button movieSousuoItemGoupiao;
        @BindView(R.id.movie_sousuo_item_img)
        SimpleDraweeView movieSousuoItemImg;*/
        public myHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }


    //初始化接口
    public ZzsyAdapter.OnClickTopItemListener onClickTopItemListener;

    public void setOnClickTopItemListener(ZzsyAdapter.OnClickTopItemListener onClickTopItemListener) {
        this.onClickTopItemListener = onClickTopItemListener;
    }

    public interface OnClickTopItemListener {
        void onClick(int movieId);
    }
}
