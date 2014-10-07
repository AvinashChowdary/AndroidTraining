package com.example.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

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
import android.widget.EditText;
import android.widget.ListView;

import com.pcs.adapters.WeatherAdapter;
import com.pcs.model.WeatherModel;

public class CityActivity extends Activity{

	private ListView listView;
	private EditText cityEdt;
	private static final int DIALOG = 109;
	private ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
		//obtaining views
		cityEdt = (EditText)findViewById(R.id.cityEdt);
		Button getWeatherBtn = (Button) findViewById(R.id.weatherBtn);
		listView = (ListView) findViewById(R.id.final_listview);
		//verifying if the value of city is null
		if(cityEdt.getText().toString()!=null){
			getWeatherBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					//calling the asynctask
					new Weather(CityActivity.this, listView).execute();
				}
			});
		}
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

	public class Weather extends AsyncTask<Void, Integer, String>{

		private Context mContext;
		private StringBuilder stringBuilder;
		private WeatherAdapter weatherAdapter;
		private ListView listView;
		private ArrayList<WeatherModel> weatherList;

		//constructor in order to use the context of activity 

		public Weather(Context context,ListView listView){
			mContext = context;
			this.listView = listView;
		}

		@Override
		protected void onPreExecute() {

			super.onPreExecute();

			//invoking dialog
			showDialog(DIALOG);
		}


		@Override
		protected String doInBackground(Void... params) {

			String line=null;

			try {


				//setting url
				URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+cityEdt.getText().toString()+"&mode=json");
				URLConnection connection= url.openConnection();
				//opening connection
				connection.connect();
				//getting inpust stream and readers
				InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

				BufferedReader bufferReader = new BufferedReader(inputStreamReader);

				stringBuilder = new StringBuilder();

				while ((line = bufferReader.readLine()) != null) {

					//updating the progress in progress bar
					publishProgress(70);
					stringBuilder.append(line);

				}


			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


			if(stringBuilder!=null){
				//returing as result to on post execute
				return stringBuilder.toString();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);

			//updating progress bar
			progressDialog.setProgress(values[0]);
		}

		@Override
		protected void onPostExecute(String result) {

			super.onPostExecute(result);
			dismissDialog(DIALOG);

			try {

				weatherList = new ArrayList<WeatherModel>();
				WeatherModel weatherObj = new WeatherModel();
				//obtaining root object
				JSONObject rootObj = new JSONObject(result);


				//verifying if there is an attribute name
				if(rootObj.has("name")){
					weatherObj.setCity(getResources().getString(R.string.city_string)+" "+rootObj.getString("name"));
				}
				//moving to json object main
				JSONObject obj = rootObj.getJSONObject("main");

				//obtaining values if there are relevant attributes
				if(obj.has("temp")){
					weatherObj.setTemp(getResources().getString(R.string.temp_string)+" "+obj.getString("temp"));
				}
				if(obj.has("humidity")){
					weatherObj.setHumidity(getResources().getString(R.string.humidity_string)+" "+obj.getString("humidity"));
				}
				if(obj.has("temp_min")){
					weatherObj.setMinTemp(getResources().getString(R.string.min_string)+" "+obj.getString("temp_min"));
				}
				if(obj.has("temp_max")){
					weatherObj.setMaxTemp(getResources().getString(R.string.max_string)+" "+obj.getString("temp_max"));
				}



				//adding weather object to list
				weatherList.add(weatherObj);
				//adding list to adapter
				weatherAdapter = 
						new WeatherAdapter(mContext, weatherList);
				//adding adapter to listview
				listView.setAdapter(weatherAdapter);




			} catch (JSONException e) {
				e.printStackTrace();
			}

		}



	}



}
