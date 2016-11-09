package cn.ucai.weiying.base;

/**
 * Created by Administrator on 2016/11/9.
 */
public interface BaseView<T>{

    void serPresenter(T presenter);
    void showError(String msg);
}
