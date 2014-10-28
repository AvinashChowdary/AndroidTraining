package com.example.expandinganimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView red, green, blue;
	private Animation zoom, slideUp, slideDown, zoomDown, zoomUp;
	private static final int RED = 1, GREEN = 2, BLUE = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		red = (ImageView) findViewById(R.id.red);
		green = (ImageView) findViewById(R.id.green);
		blue = (ImageView) findViewById(R.id.blue);

		red.setOnClickListener(this);
		green.setOnClickListener(this);
		blue.setOnClickListener(this);

		zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
		slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
		slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
		zoomDown = AnimationUtils.loadAnimation(this, R.anim.zoom_down);
		zoomUp = AnimationUtils.loadAnimation(this, R.anim.zoom_up);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.red:
			clicked(RED);
			break;
		case R.id.green:
			clicked(GREEN);
			break;
		case R.id.blue:
			clicked(BLUE);
			break;

		default:
			break;
		}
	}

	private void clicked(int color) {

		LinearLayout.LayoutParams layoutParams = new LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);

		if (color == RED) {
			red.startAnimation(zoomDown);
			blue.startAnimation(slideDown);
			green.startAnimation(slideDown);
		} else if (color == GREEN) {
			green.startAnimation(zoom);
			blue.startAnimation(slideDown);
			red.startAnimation(slideUp);
		} else {
			blue.startAnimation(zoomUp);
			red.startAnimation(slideUp);
			green.startAnimation(slideUp);
		}
	}

}
