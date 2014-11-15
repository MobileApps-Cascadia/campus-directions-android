package com.campusdirection;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class InstructionsFragment extends Fragment {

	private static final String EXTRA_CODE = "com.example.testingcodereading.code";
	private Button scanButton;
	private TextView mTextView;
	private static InstructionsFragment fragment;
	private static String codex;
	private static String codey;


	public static InstructionsFragment newInstance(String code, String code2) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_CODE, code+code2);

		fragment = new InstructionsFragment();
		fragment.setArguments(args);

		codex = code;
		codey = code2;
		
		return fragment;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.activity_instructions, parent, false);

		mTextView = (TextView) v.findViewById(R.id.textView1);
//		mTextView.setText((String) getArguments().getSerializable(EXTRA_CODE));
		mTextView.setText(codex);

		scanButton = (Button) v.findViewById(R.id.scanButton);
		
		scanButton.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {

				IntentIntegrator integrator = new IntentIntegrator(getActivity());
				integrator.initiateScan();
			}
		});

		return v;
	}

	/*
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
//		System.out.println("the code is catch");

		IntentResult scanResult = IntentIntegrator.parseActivityResult(
				requestCode, resultCode, intent);
		// handle scan result
		if (scanResult != null) {
			FragmentManager fm = getFragmentManager();

			String myResult = intent.getStringExtra("SCAN_RESULT");

			InstructionsFragment newFrame = InstructionsFragment.newInstance(scanResult.toString(), myResult);
//			Fragment newFrame = InstructionsFragment.newInstance(myResult);

			//send result to new fragment.
			fm.beginTransaction().replace(R.id.fragmentContainer, newFrame).commit();
		}
	}
	*/
}