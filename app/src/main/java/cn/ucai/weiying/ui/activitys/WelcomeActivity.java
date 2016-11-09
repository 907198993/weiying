package cn.ucai.weiying.ui.activitys;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.weiying.R;
import cn.ucai.weiying.base.BaseActivity;
import cn.ucai.weiying.presenter.WelcomePresenter;
import cn.ucai.weiying.ui.view.WelcomeView;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.welcome_view)
    WelcomeView welcomeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        unbinder = ButterKnife.bind(this);
        mPresenter = new WelcomePresenter(welcomeView);
    }
}