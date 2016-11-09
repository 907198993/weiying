package cn.ucai.weiying.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.google.common.base.Preconditions;

import java.util.List;

import butterknife.BindView;
import cn.ucai.weiying.R;
import cn.ucai.weiying.base.RootView;
import cn.ucai.weiying.component.ImageLoader;
import cn.ucai.weiying.presenter.contract.WelcomeContract;
import cn.ucai.weiying.utils.EventUtil;
import cn.ucai.weiying.utils.StringUtils;

/**
 * Created by Administrator on 2016/11/9.
 */
public class WelcomeView extends RootView<WelcomeContract.Presenter> implements WelcomeContract.View {


    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;

    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showContent(List<String> list) {
     if(list!=null){
         int randomNumber = StringUtils.getRandomNumber(0, list.size() - 1);
         ImageLoader.load(mContext,list.get(randomNumber),ivWelcomeBg);
         ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
     }
    }

    @Override
    public void jumpToMain() {

    }

    @Override
    public void serPresenter(WelcomeContract.Presenter presenter) {
       mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext,msg);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_welcome_view, this);


    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }
}
