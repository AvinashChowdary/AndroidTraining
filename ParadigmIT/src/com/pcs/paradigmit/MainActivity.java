package com.pcs.paradigmit;

import java.util.ArrayList;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.pcs.adapters.CustomAdapter;
import com.pcs.model.Companies;

/**
 * Main Activity to add two fragments
 * left fragment and right fragment
 * @author Avinash
 *
 */
public class MainActivity extends FragmentActivity {

	private static ArrayList<Companies> companiesList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	/*	getSupportFragmentManager().beginTransaction()
		.add(R.id.left_fragment, new LeftFragment(MainActivity.this)).commit();


		getSupportFragmentManager().beginTransaction()
		.add(R.id.right_fragment, new RightFragment()).commit();*/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A left fragment containing a simple list view.
	 * list of companies
	 * on selecting moves to right fragment
	 * sends position of item selected to right fragment's constructor
	 */
	public static class LeftFragment extends Fragment {

		

		public LeftFragment() {
		
		}
		

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_left, container,
					false);
			ListView listView = (ListView) rootView.findViewById(R.id.listview);
			
			companiesList = new ArrayList<Companies>();
			
			Companies company = new Companies();
			company.setName(getResources().getString(R.string.pcs));
			companiesList.add(company);
			
			company = new Companies();
			company.setName(getResources().getString(R.string.p_it));
			companiesList.add(company);
			
			company = new Companies();
			company.setName(getResources().getString(R.string.ecentric));
			companiesList.add(company);
			
			company = new Companies();
			company.setName(getResources().getString(R.string.egramit));
			companiesList.add(company);
			
			CustomAdapter adapter = new CustomAdapter(getActivity(), companiesList);
			listView.setAdapter(adapter);
			
			
			
			
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					RightFragment rightFragment = new RightFragment(position);
					getFragmentManager().beginTransaction().add(R.id.right_fragment, rightFragment).commit();

				}


			});
			return rootView;
		}
	}

	/**
	 * A Right fragment containing a simple image view.
	 * takes position of item selected as parameter from left fragment
	 * displays the relevant image accordingly 
	 */
	public static class RightFragment extends Fragment {
		private int position;

		public RightFragment(int position) {
			this.position = position;
			
		}

		public RightFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_right, container,
					false);

			ImageView imageView = (ImageView) rootView.findViewById(R.id.image);
			
			
			switch(position){
			case 0:
				imageView.setBackgroundResource(R.drawable.blank);
				imageView.setBackgroundResource(R.drawable.pcs);
				break;
			case 1:
				imageView.setBackgroundResource(R.drawable.blank);
				imageView.setBackgroundResource(R.drawable.paradigm_infotech);
				break;
			case 2:
				imageView.setBackgroundResource(R.drawable.blank);
				imageView.setBackgroundResource(R.drawable.ecentric);
				break;
			case 3:
				imageView.setBackgroundResource(R.drawable.blank);
				imageView.setBackgroundResource(R.drawable.egramit);
				break;
			}
			return rootView;
		}
	}
}

