package com.pcs.imagerotator;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class RotateActivity extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.rotateimage);


		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

			
			Toast.makeText(RotateActivity.this, "Landscape Mode" , Toast.LENGTH_LONG).show();
		}

		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

			
			Toast.makeText(RotateActivity.this, "Portrait Mode" , Toast.LENGTH_LONG).show();
		}



	}

}
