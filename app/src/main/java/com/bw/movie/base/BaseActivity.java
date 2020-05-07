package com.bw.movie.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<p extends IBasePresenter> extends AppCompatActivity implements IBaseView{
    public p presenter;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(initLayout());
        ButterKnife.bind(this);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.acthView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract p initPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dchView();
        }

    }
}
