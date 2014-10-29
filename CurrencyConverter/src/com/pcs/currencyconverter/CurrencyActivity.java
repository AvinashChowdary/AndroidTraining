package com.pcs.currencyconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrencyActivity extends Activity {

	private EditText fromCurrency, toCurrency, value;
	private Button goBtn, convertBtn;
	private TextView finalValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.currency_layout);

		fromCurrency = (EditText) findViewById(R.id.source_currency);
		toCurrency = (EditText) findViewById(R.id.target_currency);
		convertBtn = (Button) findViewById(R.id.secondBtn);
		goBtn = (Button) findViewById(R.id.convert);
		value = (EditText) findViewById(R.id.edt);
		finalValue = (TextView) findViewById(R.id.final_value);

		goBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (fromCurrency != null && toCurrency != null) {

					value.setVisibility(View.VISIBLE);
					finalValue.setVisibility(View.VISIBLE);
					goBtn.setVisibility(View.INVISIBLE);
					convertBtn.setVisibility(View.VISIBLE);
				}
				convertBtn.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						String finalsol = value.getText().toString();

						finalValue.setText(finalsol);

					}
				});

			}
		});

	}

}
