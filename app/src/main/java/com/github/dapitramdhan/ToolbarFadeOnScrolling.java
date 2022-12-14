package com.github.dapitramdhan;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.WindowManager;

import androidx.core.widget.NestedScrollView;

public class ToolbarFadeOnScrolling extends NestedScrollView {

	private boolean mIsOverScrollEnabled = true;

	
	

	public void setOverScrollEnabled(boolean enabled) {
		mIsOverScrollEnabled = enabled;
	}

	public boolean isOverScrollEnabled() {
		return mIsOverScrollEnabled;
	}

	@Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY,
			int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
		return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,
				mIsOverScrollEnabled ? maxOverScrollX : 0, mIsOverScrollEnabled ? maxOverScrollY : 0, isTouchEvent);
	}

	public interface OnScrollChangedListener {
		void onScrollChanged(NestedScrollView who, int l, int t, int oldl, int oldt);
	}

	private OnScrollChangedListener mOnScrollChangedListener;

	public ToolbarFadeOnScrolling(Context context) {
		super(context);
	}

	public ToolbarFadeOnScrolling(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ToolbarFadeOnScrolling(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (mOnScrollChangedListener != null) {
			mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
		}
	}

	public void setOnScrollChangedListener(OnScrollChangedListener listener) {
		mOnScrollChangedListener = listener;
	}

}