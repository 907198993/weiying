package cn.ucai.weiying.base;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import butterknife.Unbinder;
import cn.ucai.weiying.R;
import cn.ucai.weiying.utils.KL;
import cn.ucai.weiying.utils.PreUtils;
import cn.ucai.weiying.widget.theme.Theme;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Administrator on 2016/11/8.
 */
public class BaseActivity<T extends BasePresenter> extends SupportActivity {
    protected Unbinder unbinder;
    protected  T mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KL.d(this.getClass(), this.getClass().getName() + "-------oncreate");
        init();
    }

    private void init() {
        setTranslucentStatus(true);
        onPreCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        KL.d(this.getClass(), this.getClass().getName() + "------>onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        KL.d(this.getClass(), this.getClass().getName() + "------>onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        KL.d(this.getClass(), this.getClass().getName() + "------>onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        KL.d(this.getClass(), this.getClass().getName() + "------>onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        KL.d(this.getClass(), this.getClass().getName() + "------>onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KL.d(this.getClass(), this.getClass().getName() + "------>onDestroy");
        if (unbinder != null) {
            unbinder.unbind();
        }

    }

    private void onPreCreate() {
        Theme theme = PreUtils.getCurrentTheme(this);
        switch (theme) {
            case Blue:
                setTheme(R.style.BlueTheme);
                break;
        }
    }

    /**
     * 设置沉浸式
     *
     * @param on
     */
    public void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }

    }


}
