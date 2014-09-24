package com.pcs.facebookparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.example.facebookparsing.R;
import com.pcs.adapters.ColleaguesAdapter;
import com.pcs.model.Colleagues;


/**
 * This Activity has the layout with a button
 * on clicking it parses the given url and displays the data below
 * @author Avinash
 */
public class MainActivity extends Activity {



	private static ProgressDialog  progressDialog ;
	private static final int DIALOG = 9;
	private ListView listView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		//Finding views of those declared in layout xml 
		listView = (ListView) findViewById(R.id.list);
		Button downloadBtn = (Button) findViewById(R.id.download_btn);
		downloadBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				//Moving to Async on clicking downloadBtn
				new Downloader(MainActivity.this,listView).execute();
			}
		});

	}


	public Dialog onCreateDialog(int id){

		switch (id) {

		//creating a progress dialog using on create dialog

		case DIALOG:
			progressDialog = new ProgressDialog(this);
			progressDialog.setTitle(R.string.title);
			progressDialog.setProgress(1);
			progressDialog.setMax(100);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressDialog.setCancelable(true);
			progressDialog.show();
			return progressDialog;

		default:
			return null;
		}

	}

	public class Downloader extends AsyncTask<Void, Integer, String>{

		private Context mContext;
		private StringBuilder stringBuilder;
		private ColleaguesAdapter colleaguesAdapter;
		private ListView listView;
		private ArrayList<Colleagues> colleaguesList;

		//constructor in order to use the context of activity 

		public Downloader(Context context,ListView listView){
			mContext = context;
			this.listView = listView;
		}

		@Override
		protected void onPreExecute() {

			super.onPreExecute();

			//using deprecated method showDialog to create a new progress Dialog
			showDialog(DIALOG);
		}


		@Override
		protected String doInBackground(Void... params) {

			String line=null;

			try {

				//Giving url as parameter to url 

				URL url = new URL("http://192.168.4.25/source");
				URLConnection connection= url.openConnection();

				connection.connect();

				InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

				BufferedReader bufferReader = new BufferedReader(inputStreamReader);

				stringBuilder = new StringBuilder();

				while ((line = bufferReader.readLine()) != null) {

					//Updating progress for the Progress Dialog
					//Moves to onProgressUpdate when called
					publishProgress(70);
					stringBuilder.append(line);

				}


			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			//Returning string value
			if(stringBuilder!=null){
			return stringBuilder.toString();
			}

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);

			//Updating the progress of the progressDialog
			progressDialog.setProgress(values[0]);
		}

		@Override
		protected void onPostExecute(String result) {

			super.onPostExecute(result);
			dismissDialog(DIALOG);

			try {

				colleaguesList = new ArrayList<Colleagues>();

				colleaguesAdapter = 
						new ColleaguesAdapter(mContext, colleaguesList);

				//Creating JSON Object
				JSONObject rootObj = new JSONObject(result);

				//Creating JSON Array
				JSONArray jsonArray = rootObj.optJSONArray("colleagues");

				//Getting length of jsonArray
				int len = jsonArray.length();

				//Obtaining Values from JSON Object based on key
				for (int i = 0; i < len; i++) {

					Colleagues colleague = new Colleagues();

					JSONObject jsonObj = jsonArray.getJSONObject(i);

					if(jsonObj.has("name")){
						colleague.setName("Name : "+jsonObj.getString("name"));
					}
					if(jsonObj.has("gender")){
						colleague.setGender("Gender : "+jsonObj.getString("gender"));
					}
					if(jsonObj.has("id")){
						colleague.setId("ID : "+jsonObj.getString("id"));
					}
					if(jsonObj.has("locale")){
						colleague.setLocale("Locale : "+jsonObj.getString("locale"));
					}

					colleaguesList.add(colleague);
					
					
					//Adapter used to set the list to listview
					listView.setAdapter(colleaguesAdapter);


				}		

			} catch (JSONException e) {
				e.printStackTrace();
			}

		}



	}

}
