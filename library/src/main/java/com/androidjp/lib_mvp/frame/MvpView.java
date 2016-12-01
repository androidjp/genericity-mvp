package com.androidjp.lib_mvp.frame;

/**
 * 与BaseView不同，
 * MvpView表示的是Activity和Fragment等大组件，必须只能单例出现
 * TODO：这里，关于Activity的我同意，但是，关于Fragment，我觉得，如果要我在一个ViewPager的容器中放5个Fragment，我会选择用一个Fragment来进行重用，而不是5个不同的Fragment类
 * Created by androidjp on 16-8-9.
 */
public interface MvpView {
}
