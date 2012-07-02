package com.steven.android.firsttest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class tutorialFour extends Activity implements OnCheckedChangeListener {
	

	MediaPlayer song1, song2, song3, song4;
	int Rsong;
	int whatsong; //this is the variable that will change to what the radio button tells it to
	RadioGroup rgMusic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial4);
		
		whatsong = 0;//initializing
		
		rgMusic = (RadioGroup) findViewById(R.id.groupMusic);
		rgMusic.setOnCheckedChangeListener(this);
		
		song1 = MediaPlayer.create(tutorialFour.this, R.raw.song1);
		song2 = MediaPlayer.create(tutorialFour.this, R.raw.song2);
		song3 = MediaPlayer.create(tutorialFour.this, R.raw.song3);
		song4 = MediaPlayer.create(tutorialFour.this, R.raw.song4);
		
		Button bPlay = (Button) findViewById(R.id.bPlay);
		Button bStop = (Button) findViewById(R.id.bStop);
		Button bDelete = (Button) findViewById(R.id.bDelete);
		
		//on long click for Play button, save the selected song to SD card directory
		
		bPlay.setOnLongClickListener(new View.OnLongClickListener() {
			public boolean onLongClick(View v) {
				
				File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC); //path = path to phone SD (NOT external_SD)
				File file = new File(path, "Cornboyz Song" + whatsong + ".mp3"); //file is saved to "path" with name Cornboyz etc...
			
				try{
					switch (whatsong){
					case 1: 
						Rsong = R.raw.song1;
						break;
					case 2: 
						Rsong = R.raw.song2;
						break;
					case 3: 
						Rsong = R.raw.song3;
						break;
					case 4: 
						Rsong = R.raw.song4;
						break;
					}
					//file saving operations
					InputStream is = getResources().openRawResource(Rsong);
					OutputStream os = new FileOutputStream(file);
					byte[] data = new byte[is.available()]; //array for passing stuff in InputStream
					is.read(data);//read data from InputStream
					os.write(data);//write data to the file
					Toast.makeText(tutorialFour.this, "Saved", Toast.LENGTH_SHORT).show();
				}
				
				catch (IOException e){
					Toast fail = Toast.makeText(tutorialFour.this, "Saving Failed", Toast.LENGTH_SHORT); //toast to let user know IO failed
					fail.show();
				}
				
				return false;
			}
		});
		
		
		//setup Delete Button
		bDelete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
				File file = new File(path, "Cornboyz Song" + whatsong + ".mp3");
				
				if (file.exists() == false){
					Toast.makeText(tutorialFour.this, "File does not exists.", Toast.LENGTH_SHORT).show();
				}
				else {
					file.delete();
					Toast.makeText(tutorialFour.this, "Deleted", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		//setup Play Button
		bPlay.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				// get what the radio button is set up as and play the song accordingly
				//stop the current song if playing so we don't get overlaps
				if (song1.isPlaying()){
					song1.pause();
					song1.seekTo(0); //resets to 0sec
				}
				if (song2.isPlaying()){
					song2.pause();
					song2.seekTo(0); //resets to 0sec
				}
				if (song3.isPlaying()){
					song3.pause();
					song3.seekTo(0); //resets to 0sec
				}
				if (song4.isPlaying()){
					song4.pause();
					song4.seekTo(0); //resets to 0sec
				}
				
				//pass in value of whatsong and play the corresponding song file
				switch (whatsong){
				case 0:
					Toast noSong = Toast.makeText(tutorialFour.this, "Please select a song", Toast.LENGTH_SHORT);
					noSong.show();
					break;
				case 1:
					song1.start();
					break;
				case 2:
					song2.start();
					break;
				case 3:
					song3.start();
					break;
				case 4:
					song4.start();
					break;
				}
			}
		});
		
		//setup Stop Button
		bStop.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// stop all music
				if (song1.isPlaying()){
					song1.seekTo(0);
					song1.pause();
				}
				else if (song2.isPlaying()){
					song2.seekTo(0);
					song2.pause();
				}
				else if (song3.isPlaying()){
					song3.seekTo(0);
					song3.pause();
				}
				else if (song4.isPlaying()){
					song4.seekTo(0);
					song4.pause();
				}
				
			}
		});
		

	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		//change our song to what the current radio button is
		//this will happen automatically as radio button is changed
		//first checks the ID of the radio button, which is int passed into this method (arg1)
		switch (arg1){
		case R.id.rbMusic1:
			//set reference of whatsong to the first file
			whatsong = 1;
			break;
		case R.id.rbMusic2:
			whatsong = 2;
			break;
		case R.id.rbMusic3:
			whatsong = 3;
			break;
		case R.id.rbMusic4:
			whatsong = 4;
			break;
		}
	}
	
	

}
