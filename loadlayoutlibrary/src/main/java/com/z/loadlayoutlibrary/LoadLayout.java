package com.z.loadlayoutlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import org.xmlpull.v1.XmlPullParserException;


/**
 * Created by bruce on 8/19/15.
 */
public class LoadLayout extends FrameLayout {

    private int emptyViewId, errorViewId, loadingViewId, contentViewId;
    private View emptyView, errorView, loadingView, contentView;

    public LoadLayout(Context context) {
        this(context, null);
    }

    public LoadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public LoadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LoadLayout, 0, 0);
        emptyViewId = a.getResourceId(R.styleable.LoadLayout_emptyView, -1);
        errorViewId = a.getResourceId(R.styleable.LoadLayout_errorView, -1);
        loadingViewId = a.getResourceId(R.styleable.LoadLayout_loadingView, -1);
        contentViewId = a.getResourceId(R.styleable.LoadLayout_contentView, -1);
        a.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (emptyViewId != -1)
            emptyView = findViewById(emptyViewId);
        if (errorViewId != -1)
            errorView = findViewById(errorViewId);
        if (loadingViewId != -1)
            loadingView = findViewById(loadingViewId);
        if (contentViewId != -1) {
            contentView = findViewById(contentViewId);
            try {
                throw new XmlPullParserException("don't have a contentView");
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        updateViewVisibility(contentView);
    }

    public void showEmpty() {
        if (emptyView != null)
            updateViewVisibility(emptyView);
        Log.d("我的", "空界面");
    }

    public void showError() {
        if (errorView != null)
            updateViewVisibility(errorView);
        Log.d("我的", "错误界面");
    }

    public void showLoading() {
        if (loadingView != null)
            updateViewVisibility(loadingView);
        Log.d("我的", "显示加载中");
    }

    public void showContent() {
        if (contentView != null)
            updateViewVisibility(contentView);
        Log.d("我的", "主界面");
    }

    private void updateViewVisibility(View view) {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (child.getId() == view.getId()) {
                Log.d("我的" + i, view.getId() + ":显示" + child.getId());
                view.setVisibility(VISIBLE);
            } else {
                Log.d("我的" + i, view.getId() + ":隐藏" + child.getId());
                child.setVisibility(GONE);
            }
        }
    }
}
