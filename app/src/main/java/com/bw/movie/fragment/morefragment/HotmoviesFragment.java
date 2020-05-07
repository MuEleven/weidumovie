package com.bw.movie.fragment.morefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.moreadapter.HotmoviesAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.RmBean;
import com.bw.movie.bean.ZzsyBean;
import com.bw.movie.mvp.HomeContract;
import com.bw.movie.mvp.HomePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HotmoviesFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        presenter.getDataRm(1,10);
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
        return R.layout.being_layout;
    }

    @Override
    public void onSuccess(BannerBean bannerBean) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onSuccessjj(JjsyBean jjsyBean) {

    }

    @Override
    public void onErrorjj(String msg) {

    }

    @Override
    public void onSuccesszz(ZzsyBean zzsyBean) {

    }

    @Override
    public void onErrorzz(String msg) {

    }

    @Override
    public void onSuccessrm(RmBean rmBean) {

        List<RmBean.ResultBean> result = rmBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        HotmoviesAdapter hotmoviesAdapter = new HotmoviesAdapter(result, getActivity());
        recyclerView.setAdapter(hotmoviesAdapter);
    }

    @Override
    public void onErrorrm(String msg) {

    }


}
