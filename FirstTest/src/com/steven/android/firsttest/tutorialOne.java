package com.steven.android.firsttest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class tutorialOne extends Activity implements OnCheckedChangeListener{
	
	TextView textOut;
	EditText getInput;
	RadioGroup Gunit; // Gravity unit
	RadioGroup Sunit; //Style unit
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial1); //reference XML layout file
		
		Gunit = (RadioGroup) findViewById(R.id.rgGravity);
		Gunit.setOnCheckedChangeListener(this); //this refers to Gunit
		
		Sunit = (RadioGroup) findViewById(R.id.rgStyle);
		Sunit.setOnCheckedChangeListener(this); //this refers to Sunit
		
		
		textOut = (TextView) findViewById(R.id.tvGetInput); //set textOut to the "Enter Something..." line
		getInput = (EditText) findViewById(R.id.etInput);
		
		Button ok = (Button) findViewById(R.id.bOK);
		ok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// do something when OK button is clicked
				textOut.setText(getInput.getText()); //set textOut to w.e. user inputs in editView(which is retrieved by getText)
			}
		});
		
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rbLeft:
			textOut.setGravity(Gravity.LEFT);
			break;
		case R.id.rbCentre:
			textOut.setGravity(Gravity.CENTER);
			break;
		case R.id.rbRight:
			textOut.setGravity(Gravity.RIGHT);
			break;
			
		case R.id.rbNormal:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
			break;
		case R.id.rbBold:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			break;
		case R.id.rbItalic:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
			//textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
			break;
		}
		
	}
	
	
	
	
}
