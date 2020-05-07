package com.bw.movie.mvp;

import com.bw.movie.app.Api;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.RmBean;
import com.bw.movie.bean.ZzsyBean;
import com.bw.movie.tools.OkHttpUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements HomeContract.IHomeModel {
    @Override
    public void getDataBanner(MyBannerCallBack myBannerCallBack) {
        Api api = OkHttpUtils.getOkHttpUtils().api();
        Observable<BannerBean> banner = api.banner();
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        myBannerCallBack.onSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myBannerCallBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataJjsy(int page, int count, MyJjsyrCallBack myJjsyrCallBack) {
        Api api = OkHttpUtils.getOkHttpUtils().api();
        Observable<JjsyBean> comingSoonMovieList = api.findComingSoonMovieList(page, count);
        comingSoonMovieList.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<JjsyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JjsyBean jjsyBean) {
                            myJjsyrCallBack.onSuccessjj(jjsyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            myJjsyrCallBack.onErrorjj(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataZzsy(int page, int count, MyZzsyCallBack myZzsyCallBack) {
        Api api = OkHttpUtils.getOkHttpUtils().api();
        Observable<ZzsyBean> releaseMovieList = api.findReleaseMovieList(page, count);
        releaseMovieList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZzsyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZzsyBean zzsyBean) {
                            myZzsyCallBack.onSuccesszz(zzsyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            myZzsyCallBack.onErrorzz(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataRm(int page, int count, MyRmCallBack myRmCallBack) {
        Api api = OkHttpUtils.getOkHttpUtils().api();
        Observable<RmBean> hotMovieList = api.findHotMovieList(page, count);
        hotMovieList.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RmBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RmBean rmBean) {
                        myRmCallBack.onSuccessrm(rmBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myRmCallBack.onErrorrm(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
