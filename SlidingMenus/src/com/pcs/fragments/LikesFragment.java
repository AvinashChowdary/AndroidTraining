package com.pcs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcs.slidingmenus.R;
/**
 * Fragment to show likes when likes is selected in sliding menu
 */
public class LikesFragment  extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//inflating an returning view	
		View view = inflater.inflate(R.layout.fragment_likes, null);
		return view;
	}

}
