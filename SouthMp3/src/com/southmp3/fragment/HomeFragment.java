package com.southmp3.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.southmp3.R;

public class HomeFragment extends Fragment {

	private Button teluguBtn;

	private Button searchBtn;

	private Button shareBtn;

	private Button rateBtn;

	private Button contactBtn;

	private Button dummyBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.home_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		teluguBtn = (Button) view.findViewById(R.id.telugu_songs);
		searchBtn = (Button) view.findViewById(R.id.search_song);
		shareBtn = (Button) view.findViewById(R.id.share_app);
		rateBtn = (Button) view.findViewById(R.id.rate_app);
		contactBtn = (Button) view.findViewById(R.id.contact_us);
		dummyBtn = (Button) view.findViewById(R.id.dummy);

	}
}
