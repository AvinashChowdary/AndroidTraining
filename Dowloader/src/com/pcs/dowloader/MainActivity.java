package com.pcs.dowloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {


	private static TextView idTxt;
	private static TextView aboutTxt;
	private static TextView categoryTxt;
	private static TextView checkinsTxt;
	private static ProgressDialog  progressDialog ;
	private static final int DIALOG = 9;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		idTxt = (TextView) findViewById(R.id.id_display);
		aboutTxt = (TextView) findViewById(R.id.about_display);
		checkinsTxt = (TextView) findViewById(R.id.checkins_display);
		categoryTxt = (TextView) findViewById(R.id.category_display);


		Button downloadBtn = (Button) findViewById(R.id.download_btn);
		downloadBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Downloader().execute();
			}
		});

	}


	public Dialog onCreateDialog(int id){
		
		switch (id) {
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
		private StringBuilder stringBuilder=null;
		

		public Downloader(Context context){
			mContext = context;
		}

		public Downloader() {
		}

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			showDialog(DIALOG);
		}


		@Override
		protected String doInBackground(Void... params) {

			String line=null;

			try {

				URL url = new URL("https://graph.facebook.com/19292868552");
				URLConnection connection= url.openConnection();

				connection.connect();

				InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

				BufferedReader bufferReader = new BufferedReader(inputStreamReader);

				stringBuilder = new StringBuilder();

				while ((line = bufferReader.readLine()) != null) {

					
					publishProgress(70);
					stringBuilder.append(line);

				}


			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return stringBuilder.toString();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			progressDialog.setProgress(values[0]);
		}

		@Override
		protected void onPostExecute(String result) {
						
			super.onPostExecute(result);
			dismissDialog(DIALOG);

			try {

				JSONObject jsonObj = new JSONObject(result);

				if(jsonObj.has("id")){

					String id = jsonObj.getString("id");
					idTxt.setText("ID : "+id+"\n");
				}
				if(jsonObj.has("about")){

					String about = jsonObj.getString("about");
					aboutTxt.setText("About : "+about+"\n");
				}
				if(jsonObj.has("category")){

					String category = jsonObj.getString("category");
					categoryTxt.setText("Category : "+category+"\n");
				}
				if(jsonObj.has("checkins")){

					String checkins = jsonObj.getString("checkins");
					checkinsTxt.setText("Checkins : "+checkins+"\n");
				}

				

			} catch (JSONException e) {
				e.printStackTrace();
			}

		}



	}

}

