package com.androidjp.lib_mvp.frame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidjp.lib_mvp.base.BaseView;

/**
 * Fragment 基类（支持 presenter 泛型）
 * Created by androidjp on 16-8-9.
 */
public abstract class MvpFragment <P extends MvpPresenter> extends LogFragment implements MvpView{
    public P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initMvp(0);

        onLog("onCreateView()");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void initMvp(int index) {
        Mvp.getInstance().registerView(this.getClass(),this);
        mPresenter = (P) Mvp.getInstance().getPresenter(Mvp.getGenericType(this, index));
        mPresenter.initPresenter(getBaseView());
    }

    protected abstract BaseView getBaseView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Mvp.getInstance().unRegister(this.getClass());//view引用销毁
        mPresenter.destory();//presenter与view解绑，但是自己不销毁，被Mvp持有引用
    }
}
