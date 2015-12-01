package com.vlad.thenewboston;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyBringBackSurface extends SurfaceView implements Runnable{

	SurfaceHolder ourHolder;
	Thread ourThread = null;
	boolean isRunning = true;
	
	
	public MyBringBackSurface(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		ourHolder = getHolder();
		ourThread = new Thread(this);
		ourThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning){
			if (!ourHolder.getSurface().isValid())
				continue;
			
			Canvas canvas = ourHolder.lockCanvas();
			canvas.drawRGB(2, 2, 150);
			ourHolder.unlockCanvasAndPost(canvas);
			
		}
		
		
	}

}
