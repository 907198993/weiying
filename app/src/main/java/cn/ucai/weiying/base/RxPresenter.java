package cn.ucai.weiying.base;

/**
 * Created by Administrator on 2016/11/9.
 */

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */
public class RxPresenter<T> implements BasePresenter<T> {
    protected T mView;
    protected CompositeSubscription compositeSubscription;

    protected void unSubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
     this.mView = null;
        unSubscribe();
    }
}
