package com.androidjp.lib_mvp.frame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 封装了基本的Activity间Intent的传递
 * Created by androidjp on 16-7-4.
 */
public class BaseFragmentActivity extends AppCompatActivity{

    private CancelledCallback mCanceledCallback;
    private OkCallback mOkCallback;

    private Intent preIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent()!=null){
            preIntent = getIntent();
        }
    }



    /**
     * 返回时，如果有返回参数，则调用
     * @param resCode 返回码
     * @param intent 返回的Intent
     */
    public void backWithIntent(int resCode, Intent intent){
        setResult(resCode,intent);
        onBackPressed();
    }

    /**
     * 接收返回的数据
     * @param requestCode 请求码
     * @param resultCode  返回码
     * @param data   传递回来的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode){
            case RESULT_CANCELED:
                if (mCanceledCallback!=null){
                    mCanceledCallback.onResultCanceled();
                }
                break;

            case RESULT_OK:
                if (mOkCallback!=null){
                    mOkCallback.onResultOk();
                }
                break;
        }

    }

    /**
     * 返回为 Canceled
     */
    public interface CancelledCallback{
        public void onResultCanceled();
    }
    /**
     * 返回为Ok
     */
    public interface OkCallback{
        public void onResultOk();
    }

    //=---------------------------------------------------------------------------------


    public void setCanceledCallback(CancelledCallback mCanceledCallback) {
        this.mCanceledCallback = mCanceledCallback;
    }


    public void setOkCallback(OkCallback mOkCallback) {
        this.mOkCallback = mOkCallback;
    }


    public Intent getPreIntent() {
        return preIntent;
    }
}
