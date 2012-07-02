package com.steven.android.firsttest;

import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class tutorialThree extends Activity implements OnClickListener{

	ImageView display; //this is the top image, as referenced by XML element below
	int toPhone; //int used to reference drawable Raw Resource
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE); //get rid of title bar on top
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //set view to full screen
		
		setContentView(R.layout.tutorial3);
	
		//referencing ImageViews to xml element
		display = (ImageView) findViewById(R.id.ivDisplay);
		ImageView image1 = (ImageView) findViewById(R.id.ivImage1);
		ImageView image2 = (ImageView) findViewById(R.id.ivImage2);
		ImageView image3 = (ImageView) findViewById(R.id.ivImage3);
		ImageView image4 = (ImageView) findViewById(R.id.ivImage4);
		Button setWall = (Button) findViewById(R.id.bSetWallpaper);
		
		toPhone = R.drawable.back_smoke; //initializing it to first point to back_smoke
		
		//set when clicked to goto "onClick" method, implemented by OnClickListner
		image1.setOnClickListener(this);	
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		setWall.setOnClickListener(this);
	}

	//do something when clicked on
	public void onClick(View v) {
		//switch case references the view ID
		switch (v.getId()){
		case R.id.ivImage1:
			display.setImageResource(R.drawable.back_smoke);
			toPhone = R.drawable.back_smoke;
			break;
		case R.id.ivImage2:
			display.setImageResource(R.drawable.back_fish);
			toPhone = R.drawable.back_fish; 
			break;
		case R.id.ivImage3:
			display.setImageResource(R.drawable.back_bmw);
			toPhone = R.drawable.back_bmw; 
			break;
		case R.id.ivImage4:
			display.setImageResource(R.drawable.back_andy);
			toPhone = R.drawable.back_andy; 
			break;
		
		case R.id.bSetWallpaper: //on click wall paper button, set
			Bitmap whatever = BitmapFactory.decodeStream(getResources().openRawResource(toPhone));
				try{
					getApplicationContext().setWallpaper(whatever);
				}	catch (IOException e){
						e.printStackTrace();
					}
				Toast tSetWallpaper = Toast.makeText(getApplicationContext(), "Wallpaper has been set successfully!", Toast.LENGTH_SHORT);
				tSetWallpaper.show();
		}
			
	}
		
}
	
	
