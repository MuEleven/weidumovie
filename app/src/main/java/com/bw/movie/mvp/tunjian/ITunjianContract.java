package com.bw.movie.mvp.tunjian;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.RecommendBean;

public interface ITunjianContract {
    interface ITunJianView extends IBaseView{
        void onSuccess(RecommendBean recommendBean);
        void onError(String msg);
    }

    interface ITunJianModel{
        void getData(int page, int count, MyTJCallBack myTJCallBack);
        interface MyTJCallBack{
            void onSuccess(RecommendBean recommendBean);
            void onError(String msg);
        }
    }

    interface ITunJianPresenter{
        void getData(int page, int count);
    }
}
