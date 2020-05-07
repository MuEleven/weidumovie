package com.bw.movie.mvp.tunjian;

import com.bw.movie.app.Api;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.tools.OkHttpUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TunJianModel implements ITunjianContract.ITunJianModel {
    @Override
    public void getData(int page, int count, MyTJCallBack myTJCallBack) {
        Api api = OkHttpUtils.getOkHttpUtils().api();
        Observable<RecommendBean> recommendCinemas = api.findRecommendCinemas(page, count);
        recommendCinemas.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecommendBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        myTJCallBack.onSuccess(recommendBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myTJCallBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
