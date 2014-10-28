package com.pcs.frameanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
/**
 * This class has an Imageview and a button
 * On clicking starts the animation
 * @author pcs-05
 *
 */
public class MainActivity extends Activity {

	private AnimationDrawable gifAnimation;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//ImageView to display the frame animation
		imageView = (ImageView) findViewById(R.id.image_view);
		imageView.setBackgroundResource(R.anim.gif_anim);
		
		//Adding Default background to animation frame
		gifAnimation = (AnimationDrawable) imageView.getBackground();
	}

	//This method is called on clicking the ok button
	public void start(View view) {
		//Starting the Animation
		gifAnimation.start();

	}

}
