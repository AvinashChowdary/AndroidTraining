package com.pcs.spriteanimation;

import com.pcs.spritesheetanimation.R;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	public boolean go;;
	public SpriteView spriteView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		spriteView = (SpriteView) findViewById(R.id.spriteView);
		//starting sprite
		spriteView.startAnimation();

	}

}
