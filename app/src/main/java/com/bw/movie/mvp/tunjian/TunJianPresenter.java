package com.bw.movie.mvp.tunjian;

import com.bw.movie.base.IBasePresenter;
import com.bw.movie.bean.RecommendBean;

public class TunJianPresenter extends IBasePresenter<ITunjianContract.ITunJianView> implements ITunjianContract.ITunJianPresenter {

    private TunJianModel tunJianModel;

    @Override
    protected void initModel() {
        tunJianModel = new TunJianModel();
    }

    @Override
    public void getData(int page, int count) {
        tunJianModel.getData(page, count, new ITunjianContract.ITunJianModel.MyTJCallBack() {
            @Override
            public void onSuccess(RecommendBean recommendBean) {
                iBaseView.onSuccess(recommendBean);
            }

            @Override
            public void onError(String msg) {
                iBaseView.onError(msg);
            }
        });
    }
}
