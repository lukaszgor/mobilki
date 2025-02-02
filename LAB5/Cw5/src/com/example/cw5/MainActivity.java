package com.example.cw5;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button btn1,btn2,btn3,btn4,btn5;
	TextView lab1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		btn4=(Button)findViewById(R.id.button4);
		btn5=(Button)findViewById(R.id.button5);
	
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		
		
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
	
	
	public void onClick(View v) {
		
		switch(v.getId()) {
		case(R.id.button1):
			
			obracanie(v);
		break;
		
		case(R.id.button2):
			
			zmien_rozmiar(v);
		break;
		case(R.id.button3):
			
			znikanie(v);
		
		break;
		
		case(R.id.button4):
			
			translacja(v);
		
		break;
		
		case(R.id.button5):
			
			skalowanie(v);
			
			break;
		default:
			break;
		}
		
		
	}
	
	
	public void obracanie(View v) {
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		RotateAnimation obroc = new RotateAnimation(0,360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
		obroc.setDuration(4000);
		obroc.setRepeatCount(Animation.INFINITE);
		img.setAnimation(obroc);
		img.startAnimation(obroc);
	}
	
	
	public void zmien_rozmiar(View v) {
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		ScaleAnimation rozmiar = new ScaleAnimation(0.5f,3.0f,0.5f,3.0f,0.5f,0.5f);
		rozmiar.setDuration(4000);
		rozmiar.setRepeatCount(Animation.INFINITE);
		img.setAnimation(rozmiar);
		img.startAnimation(rozmiar);
	}
	
	
	public void znikanie(View v) {
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		AlphaAnimation alfa = new AlphaAnimation(0,1);
		alfa.setDuration(4000);
		alfa.setRepeatCount(Animation.INFINITE);
		img.setAnimation(alfa);
		img.startAnimation(alfa);
	}
	
	public void translacja(View v) {
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		TranslateAnimation trans = new TranslateAnimation(-90, 150, 0, 0);
		trans.setDuration(4000);
		trans.setRepeatCount(Animation.INFINITE);
		img.setAnimation(trans);
		img.startAnimation(trans);
	}
	
	
	public void skalowanie(View v) {
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		ScaleAnimation  scala = new ScaleAnimation (1.25f, 1f, 1.25f, 1f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		scala.setDuration(4000);
		scala.setRepeatCount(Animation.INFINITE);
		img.setAnimation(scala);
		img.startAnimation(scala);
	}
	
	
}
