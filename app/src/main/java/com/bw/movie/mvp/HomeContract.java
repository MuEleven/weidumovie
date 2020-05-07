package com.bw.movie.mvp;

import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.RmBean;
import com.bw.movie.bean.ZzsyBean;

public interface HomeContract {
    interface IHomeView{
        void onSuccess(BannerBean bannerBean);
        void onError(String msg);

        void onSuccessjj(JjsyBean jjsyBean);
        void onErrorjj(String msg);

        void onSuccesszz(ZzsyBean zzsyBean);
        void onErrorzz(String msg);


        void onSuccessrm(RmBean rmBean);
        void onErrorrm(String msg);
    }

    interface IHomeModel{
        //轮播图
        void getDataBanner(MyBannerCallBack myBannerCallBack);
        interface MyBannerCallBack{
            void onSuccess(BannerBean bannerBean);
            void onError(String msg);
        }
        //即将上映
        void getDataJjsy(int page, int count, MyJjsyrCallBack myJjsyrCallBack);
        interface MyJjsyrCallBack{
            void onSuccessjj(JjsyBean jjsyBean);
            void onErrorjj(String msg);
        }
        //正在上映
        void getDataZzsy(int page, int count, MyZzsyCallBack myZzsyCallBack);
        interface MyZzsyCallBack{
            void onSuccesszz(ZzsyBean zzsyBean);
            void onErrorzz(String msg);
        }
        //热门
        void getDataRm(int page, int count, MyRmCallBack myRmCallBack);
        interface MyRmCallBack{
            void onSuccessrm(RmBean rmBean);
            void onErrorrm(String msg);
        }
    }

    interface IHomePresenter{
        void getDataBanner();
        void getDataJjsy(int page, int count);
        void getDataZzsy(int page, int count);
        void getDataRm(int page, int count);

    }
}
