package cn.ucai.weiying.base;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import cn.ucai.weiying.R;
import cn.ucai.weiying.utils.PreUtils;
import cn.ucai.weiying.widget.theme.Theme;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Administrator on 2016/11/8.
 */
public class BaseActivity extends SupportActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setTranslucentStatus(true);
        onPreCreate();
    }

    private void onPreCreate() {
        Theme theme = PreUtils.getCurrentTheme(this);
        switch (theme){
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
