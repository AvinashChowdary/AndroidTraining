package com.pcs.animations;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * This class has several animations implemented using the animations written in
 * anim folder located under res
 * 
 * @author pcs-05
 * 
 */
public class AnimationActivity extends Activity implements AnimationListener {

	private TextView text;
	private ToggleButton fadeToggleBtn, zoomToggleBtn;
	private Button rotateBtn, slideBtn, flipBtn;
	private Animation fadeIn, fadeOut, zoomIn, zoomOut, rotate, slide,
			flipBack, flipFront;
	private boolean flag = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);

		// Finding view from the layout
		text = (TextView) findViewById(R.id.text);
		fadeToggleBtn = (ToggleButton) findViewById(R.id.fade_btn);
		zoomToggleBtn = (ToggleButton) findViewById(R.id.zoom_btn);
		rotateBtn = (Button) findViewById(R.id.rotate_btn);
		slideBtn = (Button) findViewById(R.id.slide_btn);
		flipBtn = (Button) findViewById(R.id.flip_btn);

		// loading animations using the xml files
		// present in res/anim folder
		fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

		zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
		zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);

		rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

		slide = AnimationUtils.loadAnimation(this, R.anim.slide);

		flipBack = AnimationUtils.loadAnimation(this, R.anim.flip_back);
		flipFront = AnimationUtils.loadAnimation(this, R.anim.flip_front);

		flipBack.setAnimationListener(this);
		flipFront.setAnimationListener(this);

		// Using invisible to completely fade out the view
		fadeToggleBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (fadeToggleBtn.isChecked() == true) {
					// Starting the animation
					text.startAnimation(fadeOut);
					text.setVisibility(View.INVISIBLE);
				} else {
					// Starting the animation
					text.startAnimation(fadeIn);
					text.setVisibility(View.VISIBLE);
				}

			}
		});

		zoomToggleBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (zoomToggleBtn.isChecked() == true) {
					// Starting the animation
					text.startAnimation(zoomOut);

				} else {
					// Starting the animation
					text.startAnimation(zoomIn);

				}

			}
		});

		rotateBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Starting the animation
				text.startAnimation(rotate);
			}
		});

		slideBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Starting the animation
				text.startAnimation(slide);
			}
		});

		flipBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Making it true to make the next animation run for once
				flag = true;
				// Starting the animation
				text.startAnimation(flipBack);
			}
		});
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// using flag to make sure that the animation
		// repeats only once
		if (flag) {
			// Starting the animation
			text.startAnimation(flipFront);
			// making flag false to restrict the animation to run only once
			flag = false;
		}

	}

	@Override
	public void onAnimationRepeat(Animation animation) {
	}

}
