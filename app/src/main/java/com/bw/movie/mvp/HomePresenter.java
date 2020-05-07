package com.bw.movie.mvp;

import com.bw.movie.base.IBasePresenter;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.RmBean;
import com.bw.movie.bean.ZzsyBean;

public class HomePresenter extends IBasePresenter<HomeContract.IHomeView> implements HomeContract.IHomePresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getDataBanner() {
        homeModel.getDataBanner(new HomeContract.IHomeModel.MyBannerCallBack() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                iBaseView.onSuccess(bannerBean);
            }

            @Override
            public void onError(String msg) {
                iBaseView.onError(msg);
            }
        });
    }

    @Override
    public void getDataJjsy(int page, int count) {
        homeModel.getDataJjsy(page, count, new HomeContract.IHomeModel.MyJjsyrCallBack() {
            @Override
            public void onSuccessjj(JjsyBean jjsyBean) {
                iBaseView.onSuccessjj(jjsyBean);
            }

            @Override
            public void onErrorjj(String msg) {
                iBaseView.onErrorjj(msg);
            }
        });
    }

    @Override
    public void getDataZzsy(int page, int count) {
        homeModel.getDataZzsy(page, count, new HomeContract.IHomeModel.MyZzsyCallBack() {
            @Override
            public void onSuccesszz(ZzsyBean zzsyBean) {
                iBaseView.onSuccesszz(zzsyBean);
            }

            @Override
            public void onErrorzz(String msg) {
                iBaseView.onErrorzz(msg);
            }
        });
    }

    @Override
    public void getDataRm(int page, int count) {
            homeModel.getDataRm(page, count, new HomeContract.IHomeModel.MyRmCallBack() {
                @Override
                public void onSuccessrm(RmBean rmBean) {
                    iBaseView.onSuccessrm(rmBean);
                }

                @Override
                public void onErrorrm(String msg) {
                    iBaseView.onErrorrm(msg);
                }
            });
    }
}
