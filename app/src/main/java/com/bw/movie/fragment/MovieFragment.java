package com.bw.movie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.MoreActivity;
import com.bw.movie.MovieDetailsActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.movieadapter.JjsyAdapter;
import com.bw.movie.adapter.movieadapter.RmAdapter;
import com.bw.movie.adapter.movieadapter.ZzsyAdapter;
import com.bw.movie.app.MyApp;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.RmBean;
import com.bw.movie.bean.ZzsyBean;
import com.bw.movie.mvp.HomeContract;
import com.bw.movie.mvp.HomePresenter;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MovieFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {

    @BindView(R.id.movie_dingwei)
    ImageView movieDingwei;
    @BindView(R.id.movie_chengshi)
    TextView movieChengshi;
    @BindView(R.id.movie_sousuo)
    ImageView movieSousuo;

    @BindView(R.id.movie_zxryImg)
    ImageView movieZxryImg;
    @BindView(R.id.text_one)
    TextView textOne;
    @BindView(R.id.movie_recy1)
    RecyclerView movieRecy1;
    @BindView(R.id.movie_jjsyImg)
    ImageView movieJjsyImg;
    @BindView(R.id.text_two)
    TextView textTwo;
    @BindView(R.id.movie_recy2)
    RecyclerView movieRecy2;
    @BindView(R.id.movie_rmdyImg)
    ImageView movieRmdyImg;
    @BindView(R.id.text_Three)
    TextView textThree;
    /*  @BindView(R.id.movie_image)
      SimpleDraweeView movieImage;*/
    /*@BindView(R.id.movie_hotname)
    TextView movieHotname;*/
   /* @BindView(R.id.movie_hotpingfen)
    TextView movieHotpingfen;*/
 /*   @BindView(R.id.movie_hotgoupiao)
    Button movieHotgoupiao;*/
    @BindView(R.id.movie_recy3)
    RecyclerView movieRecy3;

    @BindView(R.id.movie_text)
    TextView movieText;
    @BindView(R.id.movie_xbanner)
    XBanner movieXbanner;


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        presenter.getDataBanner();
        presenter.getDataJjsy(1, 5);
        presenter.getDataRm(1, 5);
        presenter.getDataZzsy(1, 5);
    }

    @Override
    protected void initview() {

    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.moviefragment_layout;
    }

    //轮播图
    @Override
    public void onSuccess(BannerBean bannerBean) {
        movieXbanner.setData(bannerBean.getResult(), null);
        movieXbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(MyApp.sContext).load(bannerBean.getResult().get(position).getImageUrl()).into((ImageView) view);
                movieText.setText(bannerBean.getResult().get(position).getRank()+"/"+5);
            }
        });
        movieXbanner.setPageTransformer(Transformer.Cube);
        movieXbanner.setPointsIsVisible(false);
        movieXbanner.setPageChangeDuration(1000);
    }

    @Override
    public void onError(String msg) {

    }

    //即将上映
    @Override
    public void onSuccessjj(JjsyBean jjsyBean) {
        List<JjsyBean.ResultBean> result = jjsyBean.getResult();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        movieRecy1.setLayoutManager(linearLayoutManager);

        JjsyAdapter jjsyAdapter = new JjsyAdapter(result, getContext());
        movieRecy1.setAdapter(jjsyAdapter);
        jjsyAdapter.setOnClickCenterItemListener(new JjsyAdapter.onClickJjsyItemListener() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getContext(), MovieDetailsActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onErrorjj(String msg) {

    }

    //正在上映
    @Override
    public void onSuccesszz(ZzsyBean zzsyBean) {
        List<ZzsyBean.ResultBean> result = zzsyBean.getResult();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        movieRecy2.setLayoutManager(linearLayoutManager);

        ZzsyAdapter zzsyAdapter = new ZzsyAdapter(result, getContext());
        movieRecy2.setAdapter(zzsyAdapter);

        zzsyAdapter.setOnClickCenterItemListener(new ZzsyAdapter.onClickZzsyItemListener() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getContext(), MovieDetailsActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onErrorzz(String msg) {

    }

    //热门电影
    @Override
    public void onSuccessrm(RmBean rmBean) {
        List<RmBean.ResultBean> result = rmBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        movieRecy3.setLayoutManager(linearLayoutManager);

        RmAdapter rmAdapter = new RmAdapter(result, getContext());
        movieRecy3.setAdapter(rmAdapter);

        rmAdapter.setOnClickCenterItemListener(new RmAdapter.onClickRmItemListener() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getContext(), MovieDetailsActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onErrorrm(String msg) {

    }

    @OnClick({R.id.movie_dingwei, R.id.movie_sousuo, R.id.text_one, R.id.text_two, R.id.text_Three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.movie_dingwei:

                break;
            case R.id.movie_sousuo:
                break;
            case R.id.text_one:
                Intent intent = new Intent(getContext(), MoreActivity.class);
                startActivity(intent);
                break;
            case R.id.text_two:
                Intent intent01 = new Intent(getContext(), MoreActivity.class);
                startActivity(intent01);
                break;
            case R.id.text_Three:
                Intent intent02 = new Intent(getContext(), MoreActivity.class);
                startActivity(intent02);
                break;

        }
    }

}
