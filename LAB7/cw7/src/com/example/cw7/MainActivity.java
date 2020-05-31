package com.example.cw7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity   {
	Button btn1,btn2,btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	
		
		btn1=(Button)findViewById(R.id.button1xd);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		btn1.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent int1=new Intent(getApplicationContext(),pierwsza.class);
				startActivity(int1);
			}
		
			
		});
		
	btn2.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent int2=new Intent(getApplicationContext(),druga.class);
				startActivity(int2);
			}
		
			
		});
	
	
	btn3.setOnClickListener(new OnClickListener(){
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent int3=new Intent(getApplicationContext(),trzecia.class);
			startActivity(int3);
		}
	
		
	});
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
}
