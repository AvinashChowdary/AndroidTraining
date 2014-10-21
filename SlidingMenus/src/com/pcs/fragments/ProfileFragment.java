package com.pcs.fragments;


import com.pcs.slidingmenus.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Fragment to show profile when profile is selected in sliding menu
 */
public class ProfileFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//inflating an returning view
		View view = inflater.inflate(R.layout.fragment_profile, null);
		return view;
	}

}
