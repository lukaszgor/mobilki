package com.example.cw4;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	Button btn1,btn2,btn3;
	TextView lab1;
	List<String> lista2 = new ArrayList<String>();
	List<String> lista3 = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		lab1=(TextView)findViewById(R.id.textView1);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
		
		
		lista2.add("1");
		lista2.add("2");
		lista2.add("3");
		
		
		lista3.add("3");
		lista3.add("2");
		lista3.add("1");
		
		
		
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
	
	List<String> lista = new ArrayList<String>();
	
	
	public void onClick(View v) {
		
		
		switch(v.getId()) {
		case(R.id.button1):
			lab1.setText("Witaj");
		lista.add("1");
		
		
		if(lista3.equals(lista)==true) {
			lab1.setText(" dzia�a 2");
			btn1.setBackgroundColor(Color.GREEN) ;
			btn2.setBackgroundColor(Color.GREEN) ;
			btn3.setBackgroundColor(Color.GREEN) ;
			
		}else {
			lab1.setText(" nie dzia�a 2");
			
			
		}
		
		
		
		czyszczenie();
		
		
		break;
		case(R.id.button2):
			lab1.setText("2");
		lista.add("2");
		
		
		czyszczenie();
		
		
		
		break;
		case(R.id.button3):
			
		lista.add("3");
		
		
		if(lista2.equals(lista)==true) {
			lab1.setText(" dzia�a");
			btn1.setTextColor(Color.RED);
			btn2.setTextColor(Color.RED);
			btn3.setTextColor(Color.RED);
			
		}else {
			lab1.setText(" nie dzia�a");
			
			btn1.setTextColor(Color.BLACK);
			btn2.setTextColor(Color.BLACK);
			btn3.setTextColor(Color.BLACK);
		}
		
		
		
		czyszczenie();
		
		
		break;

		}
		
	}
	
	
	public void czyszczenie() {
		
		if(lista.size()>2) {
			lista.removeAll(lista);
			
		}
		
	}
	
	
	
}
