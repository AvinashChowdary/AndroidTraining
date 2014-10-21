package com.pcs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcs.slidingmenus.R;
/**
 * Fragment to show messages when messages is selected in sliding menu
 */
public class MessagesFragment  extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//inflating an returning view	
		View view = inflater.inflate(R.layout.fragment_messages, null);
		return view;
	}

}