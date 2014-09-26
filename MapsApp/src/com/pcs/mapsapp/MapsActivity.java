package com.pcs.mapsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends Activity{

	private GoogleMap mMaps;

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps_layout);

		mMaps = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

		if(mMaps == null){

			Toast.makeText(getBaseContext(), 
					getResources().getString(R.string.map_not_found), 
					Toast.LENGTH_LONG).show();	
		}

		mMaps.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		mMaps.setMyLocationEnabled(true);

		mMaps.getUiSettings().setZoomGesturesEnabled(true);

		mMaps.getUiSettings().setCompassEnabled(true);

		mMaps.getUiSettings().setMyLocationButtonEnabled(true);

		mMaps.getUiSettings().setRotateGesturesEnabled(true);


		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
		Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		double longitude = 10;location.getLongitude();
		double latitude = 10;location.getLatitude();

		for(int i=0;i<=30;i=i+10){

			MarkerOptions mMarker = new MarkerOptions();

			mMarker.position(new LatLng(latitude+10, longitude+10));
			mMarker.title(getResources().getString(R.string.default_title));

			if(i == 0){
				mMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

			}
			if(i == 10){
				mMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

			}
			if(i == 20){
				mMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

			}
			if(i == 30){
				mMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

			}

			if(i == 30){
				CameraPosition mCamera = 
						new CameraPosition.Builder().
						target(new LatLng(latitude, longitude)).
						zoom(15).build();

				mMaps.animateCamera(CameraUpdateFactory
						.newCameraPosition(mCamera));

			}
		}

	}	


}
