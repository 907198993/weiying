package cn.ucai.weiying.base;

/**
 * Created by Administrator on 2016/11/9.
 */
public interface BasePresenter<T> {

    void attachView(T view);
    void detachView();
}
