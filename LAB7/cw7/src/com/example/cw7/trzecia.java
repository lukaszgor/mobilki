package com.example.cw7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;

import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class trzecia extends Activity implements OnClickListener {
	Button btn1;
	protected void onCreate(Bundle savedinstanceState) {
		super.onCreate(savedinstanceState);
		setContentView(R.layout.ekr3);
		Toast.makeText(getBaseContext(), "załadowano poprawnie klase 3", Toast.LENGTH_SHORT).show();
		
		
		btn1=(Button)findViewById(R.id.button1);
		
		btn1.setOnClickListener(this);
	}
	

	
	
	
	
	public void onClick(View v) {
		switch(v.getId()) {
		case(R.id.button1):
			obracanie(v);
			break;
		default:break;
		}
	}
	
	
	
	public void obracanie(View v) {
		
		
	
		RotateAnimation obroc =new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		Button btnV=(Button)findViewById(R.id.button1);
	
		obroc.setDuration(4000);
		obroc.setRepeatCount(Animation.INFINITE);

		
		
		btnV.setAnimation(obroc);
		btnV.startAnimation(obroc);
	}
	
	
}
