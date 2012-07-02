package com.steven.android.firsttest;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class myMenu extends Activity{

	MediaPlayer mpButton1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//set up the button sounds
		mpButton1 = MediaPlayer.create(this, R.raw.button_click);//assign mp3 file
	
		
		//button1 - TUTORIAL ONE
		Button bButton1 = (Button) findViewById(R.id.button1); //declare and assign button to id
		
		bButton1.setOnClickListener(new View.OnClickListener() {//set listen to bButton1
			public void onClick(View v) { //set what the button does
				startActivity(new Intent("com.steven.android.firsttest.TUTORIALONE"));//transitions to tutorialOne.java
				mpButton1.start(); //play button sound
			}
		});
		
		//button2 - TUTORIAL TWO
		Button bButton2 = (Button) findViewById(R.id.button2);
		
		bButton2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent("com.steven.android.firsttest.TUTORIALTWO"));
				mpButton1.start();//play button sound
			}
		});
		
		//button3
		Button bButton3 = (Button) findViewById(R.id.button3);
		
		bButton3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent("com.steven.android.firsttest.TUTORIALTHREE"));
				mpButton1.start();//play button sound
			}
		});
		
		//button4
		Button bButton4 = (Button) findViewById(R.id.button4);
		
		bButton4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent("com.steven.android.firsttest.TUTORIALFOUR"));
				mpButton1.start();//play button sound
			}
		});
		
		//button5
		Button bButton5 = (Button) findViewById(R.id.button5);
		
		bButton5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent("com.steven.android.firsttest.TUTORIALFIVE"));
				mpButton1.start();//play button sound
			}
		});
		
	}

	//method for setting up hardware of the phone and set to inflate main_menu when clicked
	public boolean onCreateOptionsMenu(Menu menu){ 
		super.onCreateOptionsMenu(menu);
		MenuInflater awesome = getMenuInflater();
		awesome.inflate(R.menu.main_menu, menu); //inflate main_menu when menu button is pressed
		return true;
	}
	
	//method for setting up what to do when an item in the menu is clicked
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.menuSweet: //if menuSweet is clicked on
			startActivity(new Intent("com.steven.android.firsttest.SWEET"));
			return true;
		case R.id.menuToast:
			//TODO place holder for future implementations
			Toast display = Toast.makeText(this, "TOAST MESSAGE", Toast.LENGTH_SHORT);
			display.show();
			return true;
		}
		return false; //can't find any of the switch cases, then return false
	}

}
