package com.pcs.celebsgallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class ImageActivity extends Activity implements OnClickListener{

	protected Button maheshBtn;
	protected Button ntrBtn;
	protected Button ramBtn;
	protected Button prabhasBtn;
	protected Button aaBtn;
	protected Button anushkaBtn;
	protected Button jsBtn;
	protected Button shBtn;
	protected Button samanthaBtn;
	protected Button rajniBtn;
	protected Button ajithBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.celebsgallery);

		maheshBtn = (Button) findViewById(R.id.btn_mahesh);
		ntrBtn = (Button) findViewById(R.id.btn_ntr);
		ramBtn = (Button) findViewById(R.id.btn_ram);
		prabhasBtn = (Button) findViewById(R.id.btn_prabhas);
		aaBtn = (Button) findViewById(R.id.btn_aa);
		anushkaBtn = (Button) findViewById(R.id.btn_anushka);
		samanthaBtn = (Button) findViewById(R.id.btn_samantha);
		shBtn = (Button) findViewById(R.id.btn_sh);
		jsBtn = (Button) findViewById(R.id.btn_js);
		rajniBtn = (Button) findViewById(R.id.btn_rajni);
		ajithBtn = (Button) findViewById(R.id.btn_ajith);
		

	}
	private LinearLayout ll = (LinearLayout) findViewById(R.id.llid);
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.btn_mahesh: ll.setBackgroundResource(R.drawable.img_mahesh);

			break;
		
		case R.id.btn_aa:ll.setBackgroundResource(R.drawable.img_aa);

			break;

		case R.id.btn_ajith:ll.setBackgroundResource(R.drawable.img_ajith);

			break;

		case R.id.btn_anushka:ll.setBackgroundResource(R.drawable.img_anushka);

			break;

		case R.id.btn_js:ll.setBackgroundResource(R.drawable.img_js);

			break;

		case R.id.btn_ntr:ll.setBackgroundResource(R.drawable.img_ntr);

			break;

		case R.id.btn_prabhas:ll.setBackgroundResource(R.drawable.img_prabhas);

			break;

		case R.id.btn_rajni:ll.setBackgroundResource(R.drawable.img_rajni);

			break;

		case R.id.btn_ram:ll.setBackgroundResource(R.drawable.img_ram);

			break;

		case R.id.btn_samantha:ll.setBackgroundResource(R.drawable.img_samantha);

			break;

		case R.id.btn_sh:ll.setBackgroundResource(R.drawable.img_sh);

			break;


		default:
			break;
		}

	}


}
