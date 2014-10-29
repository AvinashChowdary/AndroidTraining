package com.pcs.currencyconverter.test;

import com.pcs.currencyconverter.CurrencyActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrencyConverterTestActivity extends
		ActivityInstrumentationTestCase2<CurrencyActivity> {

	private CurrencyActivity activity;
	private EditText fromEdt, toEdt, valueEdt;
	private Button setBtn, okBtn;
	private TextView toTxt;
	private static final String USD = "usd", INR = "inr", VALUE = "10";

	public CurrencyConverterTestActivity() {
		super(CurrencyActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		super.setUp();

		activity = getActivity();
		// Ensure a valid Activity has been returned
		assertNotNull(activity);
		// Find views
		fromEdt = (EditText) activity
				.findViewById(com.pcs.currencyconverter.R.id.source_currency);
		toEdt = (EditText) activity
				.findViewById(com.pcs.currencyconverter.R.id.target_currency);
		setBtn = (Button) activity
				.findViewById(com.pcs.currencyconverter.R.id.convert);
		okBtn = (Button) activity
				.findViewById(com.pcs.currencyconverter.R.id.secondBtn);
		valueEdt = (EditText) activity
				.findViewById(com.pcs.currencyconverter.R.id.edt);
		toTxt = (TextView) activity
				.findViewById(com.pcs.currencyconverter.R.id.final_value);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void test000_Preconditions() {

		// Asserts to find if the obtained object is null
		assertNotNull("Failed getting activity context", getActivity());
		assertNotNull("Can't find a view... Has layout changed?", fromEdt);
		assertNotNull("Can't find a view... Has layout changed?", toEdt);
		assertNotNull("Can't find a view... Has layout changed?", setBtn);
		assertNotNull("Can't find a view... Has layout changed?", okBtn);
		assertNotNull("Can't find a view... Has layout changed?", valueEdt);
		assertNotNull("Can't find a view... Has layout changed?", toTxt);

	}

	public void test001_currency() {

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, fromEdt);
		getInstrumentation().sendStringSync(USD);

		TouchUtils.tapView(this, toEdt);
		getInstrumentation().sendStringSync(INR);

		// Clicking the Button
		TouchUtils.clickView(this, setBtn);

		// Assetring the objects to be not null
		assertNotNull(fromEdt);
		assertNotNull(toEdt);

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, valueEdt);
		getInstrumentation().sendStringSync(VALUE);

		// Clicking the Button
		TouchUtils.clickView(this, okBtn);

		// Assetring the objects to be not null
		assertNotNull(okBtn);

		// Verifyinf if the expected and actual value are equal or not
		assertEquals(toTxt.getText().toString(), VALUE);
	}

	public void test003_to_null() {

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, fromEdt);
		getInstrumentation().sendStringSync(USD);

		TouchUtils.tapView(this, toEdt);
		getInstrumentation().sendStringSync("");

		// Clicking the Button
		TouchUtils.clickView(this, setBtn);

		// Assetring the objects to be not null
		assertNotNull(fromEdt);
		assertNotNull(toEdt);

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, valueEdt);
		getInstrumentation().sendStringSync(VALUE);

		// Clicking the Button
		TouchUtils.clickView(this, okBtn);

		// Assetring the objects to be not null
		assertNotNull(okBtn);

		// Verifyinf if the expected and actual value are equal or not
		assertEquals(toTxt.getText().toString(), VALUE);
	}

	public void test002_from_null() {

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, fromEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, toEdt);
		getInstrumentation().sendStringSync(INR);

		// Clicking the Button
		TouchUtils.clickView(this, setBtn);

		// Assetring the objects to be not null
		assertNotNull(fromEdt);
		assertNotNull(toEdt);

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, valueEdt);
		getInstrumentation().sendStringSync(VALUE);

		// Clicking the Button
		TouchUtils.clickView(this, okBtn);

		// Assetring the objects to be not null
		assertNotNull(okBtn);

		// Verifyinf if the expected and actual value are equal or not
		assertEquals(toTxt.getText().toString(), VALUE);
	}

	public void test004_both_null() {

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, fromEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, toEdt);
		getInstrumentation().sendStringSync("");

		// Clicking the Button
		TouchUtils.clickView(this, setBtn);

		// Assetring the objects to be not null
		assertNotNull(fromEdt);
		assertNotNull(toEdt);

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, valueEdt);
		getInstrumentation().sendStringSync(VALUE);

		// Clicking the Button
		TouchUtils.clickView(this, okBtn);

		// Assetring the objects to be not null
		assertNotNull(okBtn);

		// Verifyinf if the expected and actual value are equal or not
		assertEquals(toTxt.getText().toString(), VALUE);
	}

	public void test005_value_null() {

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, fromEdt);
		getInstrumentation().sendStringSync(USD);

		TouchUtils.tapView(this, toEdt);
		getInstrumentation().sendStringSync(INR);

		// Clicking the Button
		TouchUtils.clickView(this, setBtn);

		// Assetring the objects to be not null
		assertNotNull(fromEdt);
		assertNotNull(toEdt);

		// Tapping on the Edit Texts
		TouchUtils.tapView(this, valueEdt);
		getInstrumentation().sendStringSync("");

		// Clicking the Button
		TouchUtils.clickView(this, okBtn);

		// Assetring the objects to be not null
		assertNotNull(okBtn);

		// Verifyinf if the expected and actual value are equal or not
		assertEquals(toTxt.getText().toString(), VALUE);
	}
}
