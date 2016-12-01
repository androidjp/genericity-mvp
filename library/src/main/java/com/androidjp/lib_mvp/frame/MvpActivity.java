package com.androidjp.lib_mvp.frame;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidjp.lib_mvp.base.BaseView;

/**
 * Created by androidjp on 16-8-9.
 */
public abstract class MvpActivity <P extends MvpPresenter> extends LogFragmentActivity implements MvpView{
    public P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMvp();
    }

    private void initMvp() {
        Log.d("MvpActivity","initMap()");
        Mvp.getInstance().registerView(this.getClass(),this);
        Log.d("initMap()", Mvp.getGenericType(this,0).getName());
        mPresenter = (P)  Mvp.getInstance().getPresenter(Mvp.getGenericType(this,0));
        mPresenter.initPresenter(getBaseView());
    }

    /**
     *
     * @return 确定关联的View
     */
    protected abstract BaseView getBaseView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Mvp.getInstance().unRegister(this.getClass());
        mPresenter.destory();///让View 和Presenter 解绑
    }
}
