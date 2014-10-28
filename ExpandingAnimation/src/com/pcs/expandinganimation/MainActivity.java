package com.pcs.expandinganimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/**
 * This application has Animating the images on selecting an image other images
 * slide away from the screen Selected image zooms out On clicking the zoomed
 * image it comes back to original position
 * 
 * @author pcs-05
 * 
 */
public class MainActivity extends Activity implements OnClickListener {

	private ImageView red, green, blue;
	private Animation zoomMiddle, slideUp, slideDown, zoomDown, zoomUp;
	private Animation zoomOut;
	private static final int RED = 1, GREEN = 2, BLUE = 3;
	//Flag value to maintain the flow first to non zoomed image
	//then to zoomed image
	private boolean flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		red = (ImageView) findViewById(R.id.red);
		green = (ImageView) findViewById(R.id.green);
		blue = (ImageView) findViewById(R.id.blue);

		// Adding listeners
		red.setOnClickListener(this);
		green.setOnClickListener(this);
		blue.setOnClickListener(this);

		// Adding animations
		zoomMiddle = AnimationUtils.loadAnimation(this, R.anim.zoom_middle);
		slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
		slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
		zoomDown = AnimationUtils.loadAnimation(this, R.anim.zoom_down);
		zoomUp = AnimationUtils.loadAnimation(this, R.anim.zoom_up);

		zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);

	}

	// Selecting different items based on id
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

		layoutParams.setMargins(10, 10, 10, 10);

		// To zoom out when clicked on a zoomed image
		if (flag) {
			red.startAnimation(zoomOut);
			green.startAnimation(zoomOut);
			blue.startAnimation(zoomOut);
			flag = false;
		} else {
			if (color == RED) {
				// Zoom the selected image
				red.startAnimation(zoomDown);
				// Slide away the others
				blue.startAnimation(slideDown);
				green.startAnimation(slideDown);

			} else if (color == GREEN) {

				// Zoom the selected image
				green.startAnimation(zoomMiddle);
				// Slide away the others
				blue.startAnimation(slideDown);
				red.startAnimation(slideUp);

			} else {

				// Zoom the selected image
				blue.startAnimation(zoomUp);
				// Slide away the others
				red.startAnimation(slideUp);
				green.startAnimation(slideUp);

			}
			//Making it true to enter the Zoomed image click event
			flag = true;

		}

	}

}
