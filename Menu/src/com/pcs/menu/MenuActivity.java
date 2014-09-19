package com.pcs.menu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuActivity extends Activity{

	private ImageView first_image; 
	private ImageView fourth_image;
	private ImageView third_image;
	private ImageView second_image;
	private ImageView sixth_image;
	private ImageView fifth_image;
	private Button shareBtn;

	private enum  list{view,edit,delete,setas,details};


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);

		shareBtn = (Button) findViewById(R.id.share);

		first_image = (ImageView) findViewById(R.id.image1);
		second_image = (ImageView) findViewById(R.id.image2);
		third_image = (ImageView) findViewById(R.id.image3);
		fourth_image = (ImageView) findViewById(R.id.image4);
		fifth_image = (ImageView) findViewById(R.id.image5);
		sixth_image = (ImageView) findViewById(R.id.image6);

		registerForContextMenu(first_image);
		registerForContextMenu(second_image);
		registerForContextMenu(third_image);
		registerForContextMenu(fourth_image);
		registerForContextMenu(fifth_image);
		registerForContextMenu(sixth_image);	

		shareBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);

				startActivity(Intent.createChooser(sharingIntent, "Share via"));

			}
		});


	}


	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		int id = item.getOrder();


		switch(id){

		case 0:
			Toast.makeText(MenuActivity.this, 
					getResources().getString(R.string.view_toast), 
					Toast.LENGTH_LONG).show();
			break;
		case 1: 
			Toast.makeText(MenuActivity.this, 
					getResources().getString(R.string.edit_toast), 
					Toast.LENGTH_LONG).show();
			break;
		case 2:
			Toast.makeText(MenuActivity.this, 
					getResources().getString(R.string.delete_toast), 
					Toast.LENGTH_LONG).show();
			break;
		case 3:
			Toast.makeText(MenuActivity.this, 
					getResources().getString(R.string.setas_toast), 
					Toast.LENGTH_LONG).show();
			break;
		case 4:
			Toast.makeText(MenuActivity.this, 
					getResources().getString(R.string.details_toast), 
					Toast.LENGTH_LONG).show();
			break;
		}

		return super.onContextItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String title =  item.getTitle().toString();
		Toast.makeText(MenuActivity.this, title, Toast.LENGTH_LONG).show();

		
		return super.onOptionsItemSelected(item);
	}
}
