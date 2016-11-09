package cn.ucai.weiying.presenter.contract;

import java.util.List;

import cn.ucai.weiying.base.BasePresenter;
import cn.ucai.weiying.base.BaseView;

/**
 * Created by Administrator on 2016/11/9.
 */
public interface WelcomeContract {

    interface View extends BaseView<Presenter> {
        boolean isActive();

        void showContent(List<String> list);

        void jumpToMain();
    }


    interface Presenter extends BasePresenter {
        void getWelcomeData();
    }
}
