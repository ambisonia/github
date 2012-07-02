package com.steven.android.firsttest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Cornboyz extends View{
	
	Bitmap bar;
	int x = 0;
	int y = 0;
	Paint paint = new Paint();
	
	
	public Cornboyz(Context contextTut5) {
		super(contextTut5);
		// TODO Auto-generated constructor stub
		bar = BitmapFactory.decodeResource(getResources(), R.drawable.bar1);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//set background
		Rect cBK = new Rect();
		cBK.set(0, 0, canvas.getWidth(), canvas.getHeight());
		
		//set up a paint
		Paint pBlue = new Paint();
		pBlue.setStyle(Paint.Style.FILL);
		pBlue.setColor(Color.BLUE);
		
		//set in the background and paint we've set up
		canvas.drawRect(cBK, pBlue);
		
		//call method
		drawBar(x, y, canvas); 
		drawBar(100 + x,300 + y, canvas);
		
		//loop movement
		if (x < canvas.getWidth()) {
			x = x + 10; 
		}
		else {
			y = y + 10;
			x = 0;
		}
		
		invalidate(); //make thread run through continuously?		

	}
	
	//new method for drawing the bar
	private void drawBar(int x2, int y2, Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawBitmap(bar, x2, y2, paint);	
	}

	
	
}
