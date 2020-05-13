package com.bw.movie.fragment;

import android.content.Intent;
import android.widget.ImageView;

import com.bw.movie.LoginActivity;
import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.IBasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFragment extends BaseFragment {

    @BindView(R.id.my_image)
    ImageView myImage;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initview() {

    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.myfragment_layout;
    }

    @OnClick(R.id.my_image)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);

    }
}
