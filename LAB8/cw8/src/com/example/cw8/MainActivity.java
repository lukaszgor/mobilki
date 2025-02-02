package com.example.cw8;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



@SuppressLint("WrongCall")//inaczej blad w onDrave
public class MainActivity extends Activity {
	
	public AnimacjaSilnik mojSpirite1;
	public AnimacjaSilnik mojSpirite2;
	public AnimacjaSilnik mojSpirite3;
	public long GameTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}
	
	
	public class MojWatekGlowny extends Thread{
		private SurfaceHolder WatekPowierzchni;
		private MySurfaceView PrzedstawPowierzchnie;// samo SurfaceView dziala
		private boolean WatekDziala=false;
		
		public  MojWatekGlowny(SurfaceHolder surfaceHolder,
				MySurfaceView surfaceView) {
			
			WatekPowierzchni=surfaceHolder;
			PrzedstawPowierzchnie=surfaceView;
		}
	
	
	public void setRunning(boolean b) { 
		WatekDziala = b; 
		
	}
	
	@Override public void run() {
		while (WatekDziala) {
		Canvas c = null;
		try {
		GameTime = System.currentTimeMillis() ;
		c = WatekPowierzchni.lockCanvas(null); 
		synchronized (WatekPowierzchni) {
			PrzedstawPowierzchnie.onDraw(c);// w instrukcji jest tu OnDrive
		}
		} finally {
		if (c != null) {
			WatekPowierzchni.unlockCanvasAndPost(c);
		}
		}
		}
	}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
		private MojWatekGlowny thread;
	
	
	
	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.BLACK);
		mojSpirite1.Update(GameTime) ;
		mojSpirite2.Update(GameTime) ;
		mojSpirite3.Update(GameTime) ;
		mojSpirite1.draw(canvas); 
		mojSpirite2.draw(canvas);
		mojSpirite3.draw(canvas);
	}
		public MySurfaceView(Context context) {
		super(context) ;
		init();
		}

		
		
		private void init(){
			getHolder().addCallback(this) ;
			thread = new MojWatekGlowny(getHolder(),this);
			// create a graphic 
			mojSpirite1 =new AnimacjaSilnik();
			mojSpirite2 = new AnimacjaSilnik(); 
			mojSpirite3 = new AnimacjaSilnik();
			mojSpirite1.init(BitmapFactory.decodeResource(getResources(), R.drawable.mario), 95, 60, 8, 3); 
			mojSpirite2.init(BitmapFactory.decodeResource(getResources(), R.drawable.mario), 95, 60, 8, 3); 
			mojSpirite3.init(BitmapFactory.decodeResource(getResources(), R.drawable.mario), 95, 60, 8, 3);
		}
		
		
		
		@Override
		public void surfaceChanged(SurfaceHolder arg0, int argl, int arg2, int arg3) {
		}
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
			thread.setRunning(true) ;
			thread.start();
			}
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
			boolean retry = true; 
			thread.setRunning(false) ;
			while (retry) {
			try {
			thread.join(); retry = false; 
			} catch (InterruptedException e) {
			}
			}
			}
	}
	

			public class AnimacjaSilnik {
				private Bitmap mAnimacja; 
				private int mXPos; 
				private int mYPos; 
				private Rect mRamka; 
				private int mFPS; 
				private int mNrRamek; 
				private int mAktualnaRamka;
				private long mLicznikRamek;
				private int mSpritewysokosc;
				private int mSpriteSzerokosc;
				public AnimacjaSilnik() {
				mRamka = new Rect(0, 0, 0, 0); 
				mLicznikRamek = 0; 
				mAktualnaRamka = 0;
				mXPos = 50;
				mYPos = 50;
				}
				public void init(Bitmap theBitmap, int Height, int Width, int theFPS, int theFrameCount)
				{
					mAnimacja = theBitmap; 
				mSpritewysokosc = Height;
				mSpriteSzerokosc = Width;
				mRamka.top = 3;
				mRamka.bottom =mSpritewysokosc;
				mRamka.left =0 ; 
				mRamka.right = mSpriteSzerokosc;
				mFPS = 1000 / theFPS;
				mNrRamek = theFrameCount;	
			
				}
		
			
			
			public void Update(long GameTime) {
				if(GameTime>mLicznikRamek +mFPS) {
					mLicznikRamek = GameTime;
					mAktualnaRamka +=1;
					if(mAktualnaRamka>=mNrRamek) {
						mAktualnaRamka=0;
					}
				}
				
				mRamka.left =mAktualnaRamka*mSpriteSzerokosc;
				mRamka.right =mRamka.left+mSpriteSzerokosc;
			}
			
			public void draw(Canvas canvas) {
				Rect dest=new Rect(getXPos(),getYPos(),getXPos()+mSpriteSzerokosc,getYPos()+mSpritewysokosc);
				canvas.drawBitmap(mAnimacja, mRamka, dest,null);
			}
			
			public int getYPos() {
				return mYPos;
			}
			public int getXPos() {
				return mXPos;
			}
			
			}
			
	}
			











