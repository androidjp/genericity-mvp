package com.androidjp.lib_mvp.frame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * 生命周期Log日志打印 Fragment
 * Created by androidjp on 16-7-25.
 */
public class LogFragment extends Fragment {

    private  boolean IS_LOG = true;
    private  boolean IS_TOAST = false;

    protected String tag(){
        return this.getClass().getName();
    }

    ///-------------------------------------------------


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onLog("onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLog("onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onLog("onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onLog("onViewCreated()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onLog("onActivityCreated()");
    }



    @Override
    public void onStart() {
        super.onStart();
        onLog("onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        onLog("onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        onLog("onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        onLog("onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onLog("onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onLog("onDestroy()");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onLog("onActivityResult()");
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        onLog("startActivityForResult()");
    }

    //------------------------------------------------------

    protected void onLog(String logMsg){
        if (IS_LOG){
            Log.d(tag(),logMsg);
        }
        if (IS_TOAST){
            Toast.makeText(getActivity(), tag()+": "+logMsg, Toast.LENGTH_SHORT).show();
        }
    }


    public void showLog(boolean isLog){
        this.IS_LOG = isLog;
    }

    public void showToast(boolean isToast){
        this.IS_TOAST = isToast;
    }

}
