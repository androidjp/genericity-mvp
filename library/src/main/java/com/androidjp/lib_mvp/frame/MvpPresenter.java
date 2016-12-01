package com.androidjp.lib_mvp.frame;

import android.content.Context;

import com.androidjp.lib_mvp.base.BaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * presenter基类，旨在关联起 view 和 model 两层
 * Created by androidjp on 16-8-9.
 */
public class MvpPresenter <M extends MvpModel ,V extends BaseView>{
    public Context mContext;///上下文
    public Reference<V> mViewRef;///关联的view
    public M mModel;

    /**
     * 初始化对应view的presenter
     * @param view 对应的view
     */
    public void initPresenter(V view){
        mModel = (M) Mvp.getInstance().getModel(Mvp.getGenericType(this, 0));
        mViewRef = new WeakReference<V>(view);//软引用
        mContext = Mvp.getInstance().getApplictionContext();
    }

    public V getIView(){
        return mViewRef.get();//获取view的软引用
    }

    public void destory(){
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
