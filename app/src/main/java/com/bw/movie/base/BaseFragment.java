package com.bw.movie.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<p extends IBasePresenter> extends Fragment {
    public p presenter;
    public boolean isVisibleHint = false;
    private boolean isLoadData;

    private boolean isInitView;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(initLayout(), container, false);
        unbinder = ButterKnife.bind(this, inflate);

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.acthView(this);
        }
        initview();

        isInitView = true;
        initListener();
        if (getUserVisibleHint()) {
            initData();
            isLoadData = true;
        }
    }


    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initview();

    protected abstract p initPresenter();

    protected abstract int initLayout();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !isLoadData && isInitView) {
            isLoadData = true;
            initData();
        } else {
            isLoadData = false;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dchView();
        }
        unbinder.unbind();
    }
}
