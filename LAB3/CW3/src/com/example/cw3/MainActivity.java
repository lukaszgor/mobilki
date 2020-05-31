package com.example.cw3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btn1;
	TextView lab1;
	EditText txt1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		btn1=(Button)findViewById(R.id.button1);
		lab1=(TextView)findViewById(R.id.textView1);
		txt1=(EditText)findViewById(R.id.editText1);
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
	
	
	public void cw3(View v) {
		lab1.setText(txt1.getText());
		
	}
	public void coDruga(View v) {
		String title1 = txt1.getText().toString();
		String title2 = "";
		for (int i = 0; i < title1.length(); i += 2)
		{
		  title2 += title1.charAt(i);
		}
		lab1.setText(title2);
	}
	public void delSpace(View v) {
		String withoutspace;
		withoutspace = txt1.getText().toString();
		//lab1.setText(withoutspace.replace(" ", ""));
		
		
		String input = withoutspace;
		StringBuilder sb = new StringBuilder();
		for( String oneString : input.toLowerCase().split(" ") )
		{
		    sb.append( oneString.substring(0,1).toUpperCase() );
		    sb.append( oneString.substring(1) );
		    lab1.setText(sb);
		}
		
		
	}

}
