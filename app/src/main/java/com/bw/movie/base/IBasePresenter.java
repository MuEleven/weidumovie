package com.bw.movie.base;

public abstract class IBasePresenter<view> {
    public view iBaseView;
    public IBasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void acthView(view iBaseView){
        this.iBaseView = iBaseView;
    }

    public void dchView(){
       /* if (iBaseView != null) {
            iBaseView = null;*/
        //}
    }

}
