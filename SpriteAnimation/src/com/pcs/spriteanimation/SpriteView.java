package com.pcs.spriteanimation;

import com.pcs.spritesheetanimation.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class SpriteView extends View {

	public SpriteView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	public Context context;
	public int frameWidth;
	public int frameHeight;
	
	//Obtaining sprite from drawable
	Bitmap spriteSheet = BitmapFactory.decodeResource(getResources(),
			R.drawable.sprite_anim);
	//new Rectangles
	Rect source = new Rect();
	Rect destination = new Rect();

	public int x, y;
	public boolean go;
	public SpriteThread spriteThread;

	private void init() {

		//Making width and height based on the
		//Number of images in the sprite sheet
		frameWidth = spriteSheet.getWidth() / 5;
		frameHeight = spriteSheet.getHeight() / 2;
		destination.left = destination.top = 0;
		destination.right = frameWidth;
		destination.bottom = frameHeight;
	}

	//Starting animation
	public void startAnimation() {
		go = true;
		//Running on a thread
		spriteThread = new SpriteThread();
		spriteThread.start();

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//Adding a single frame of a sprite image to canvas
		canvas.drawBitmap(spriteSheet, source, destination, null);
	}

	public class SpriteThread extends Thread {

		public int screenWidth, screenHeight;

		int speed = 5;

		@Override
		public void run() {
			screenWidth = getWidth();
			screenHeight = getHeight();

			//Looping all the images
			while (go) {
				for (int rows = 0; rows < 4; rows++) {
					for (int columns = 0; columns < 1; columns++) {
						source.left = columns * frameWidth;
						source.top = rows * frameHeight;
						source.right = source.left + frameWidth;
						source.bottom = source.top + frameHeight;

						destination.left = x;
						destination.top = 0;
						destination.right = destination.left + frameWidth;
						destination.bottom = destination.top + frameHeight;
						postInvalidate();
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}