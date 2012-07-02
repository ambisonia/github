package com.steven.android.firsttest;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	MediaPlayer mpSplash;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        //Splash screen music
        mpSplash = MediaPlayer.create(this, R.raw.coldplay); //assign mp3 file to mpSplash
        mpSplash.start();
        
        Thread logoTimer = new Thread() //initiate new thread
        {
        	public void run()
        	{
        		try{
        			int logoTimer = 0; //timer used to countdown to new startActivity below
        			while (logoTimer < 5000){
        				sleep(100); //pause and do nothing on logo screen
        				logoTimer = logoTimer + 100;
        			}
        			startActivity(new Intent ("com.steven.android.firsttest.CLEARSCREEN"));
        		} 
        		catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		finally{
        			finish();
        		}      		
        	}
        };
        
        logoTimer.start();
    }

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mpSplash.release();//when MainActivity is closed/destroyed, stops music
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mpSplash.pause();//if another event occurs, e.g. get text message, pause music
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mpSplash.start();//start off where it was left at
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
}