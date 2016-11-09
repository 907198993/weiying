package cn.ucai.weiying.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/11/9.
 */
public abstract class  RootView<T extends BasePresenter> extends LinearLayout {
    protected  boolean mActive;
    protected  Context mContext;
    protected T mPresenter;
    protected Unbinder unbinder;


    public RootView(Context context) {
        super(context);
        init();
    }

    public RootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected  void init(){
        mContext=getContext();
        getLayout();
        unbinder = ButterKnife.bind(this);
        mActive=true;
        initView();
        initEvent();

    };

    protected abstract void getLayout();

    protected abstract void initView();

    protected abstract void initEvent();

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(mPresenter!= null){
            mPresenter.attachView(this);
        }
        mActive=true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
        mActive=false;
        unbinder.unbind();
        mContext=null;
    }
}
