package com.github.dapitramdhan;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity {

	Toolbar toolbar;
	AppBarLayout mAppbar;
	private Drawable mActionBarBackgroundDrawable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mActionBarBackgroundDrawable = getResources().getDrawable(R.drawable.warna_utama);
		toolbar.setBackgroundDrawable(mActionBarBackgroundDrawable);
		mActionBarBackgroundDrawable.setAlpha(0);
		((ToolbarFadeOnScrolling) view.findViewById(R.id.scroll_view)).setOnScrollChangedListener(mOnScrollChangedListener);

	}

	// github dapitramdhan Toolbar Fade
	private ToolbarFadeOnScrolling.OnScrollChangedListener mOnScrollChangedListener = new ToolbarFadeOnScrolling.OnScrollChangedListener() {
		public void onScrollChanged(NestedScrollView who, int l, int t, int oldl, int oldt) {
			final int headerHeight = toolbar.getHeight();
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
			final int newAlpha = (int) (ratio * 255);
			mActionBarBackgroundDrawable.setAlpha(newAlpha);
	

		}
	};
}
