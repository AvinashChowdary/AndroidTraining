package com.southmp3.fragment;

import com.southmp3.R;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeFragment extends Fragment {

	private EditText searchEdt;

	private Button searchBtn;

	private TextView teluguTxt;

	private TextView searchTxt;

	private TextView shareTxt;

	private TextView rateTxt;

	private TextView contactTxt;

	private TextView dummyTxt;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.home_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		searchEdt = (EditText) view.findViewById(R.id.search_txt);
		searchBtn = (Button) view.findViewById(R.id.search_btn);
		teluguTxt = (TextView) view.findViewById(R.id.telugu_songs);
		searchTxt = (TextView) view.findViewById(R.id.search_song);
		shareTxt = (TextView) view.findViewById(R.id.share_app);
		rateTxt = (TextView) view.findViewById(R.id.rate_app);
		contactTxt = (TextView) view.findViewById(R.id.contact_us);
		dummyTxt = (TextView) view.findViewById(R.id.dummy);

	}
}
