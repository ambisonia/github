package com.steven.android.firsttest;

import android.app.Activity;
import android.os.Bundle;

public class tutorialFive extends Activity{
	
	Cornboyz sweetBK;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		sweetBK = new Cornboyz(this); //passing in context of tutorialFive.java into cornboyz.java
		
		setContentView(sweetBK);
	}

}
