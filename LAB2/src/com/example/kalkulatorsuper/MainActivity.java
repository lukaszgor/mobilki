package com.example.kalkulatorsuper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView lab1;
	CharSequence bufor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lab1=(TextView)findViewById(R.id.textView1);
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
	
	
	public void jeden(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"1");
	}
	public void dwa(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"2");
	}
	public void trzy(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"3");
	}
	public void cztery(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"4");
	}
	public void piec(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"5");
	}
	public void szesc(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"6");
	}
	public void siedem(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"7");
	}
	public void osiem(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"8");
	}
	public void dziewiec(View v) {
		bufor=lab1.getText();
		lab1.setText(bufor+"9");
	}
	
	public CharSequence oblicz_txt(CharSequence bufor_a) {
		
		CharSequence wynik_char,zmienna1,zmienna2;
		int index_znak = 0;
		int index_rownosc=0;
		
		int a=0;
		int b=0;
		int wynik=0;
		
		for(int i=0;i<=(bufor_a.length() -1); i++) {
			if(bufor_a.charAt(i)=='+') 
				index_znak=i;
			if(bufor_a.charAt(i)=='-') 
				index_znak=i;
			if(bufor_a.charAt(i)=='*') 
				index_znak=i;
			if(bufor_a.charAt(i)=='=')
				index_rownosc=i;
			
			
		}
		
		
		
		if(bufor_a.charAt(index_znak)=='+') {
			zmienna1=bufor_a.subSequence(0, index_znak);
			index_znak++;
			zmienna2=bufor_a.subSequence(index_znak, index_rownosc);
			a=Integer.parseInt(zmienna1.toString());
			b=Integer.parseInt(zmienna2.toString());
			wynik=a+b;
		}
		if(bufor_a.charAt(index_znak)=='-') {
			zmienna1=bufor_a.subSequence(0, index_znak);
			index_znak++;
			zmienna2=bufor_a.subSequence(index_znak, index_rownosc);
			a=Integer.parseInt(zmienna1.toString());
			b=Integer.parseInt(zmienna2.toString());
			wynik=(a-b);
		}
		if(bufor_a.charAt(index_znak)=='*') {
			zmienna1=bufor_a.subSequence(0, index_znak);
			index_znak++;
			zmienna2=bufor_a.subSequence(index_znak, index_rownosc);
			a=Integer.parseInt(zmienna1.toString());
			b=Integer.parseInt(zmienna2.toString());
			wynik=a*b;
}
		
		
		wynik_char=Integer.toString(wynik);
		return wynik_char;
		
	}
public void czysc(View v) {
	lab1.setText("");
}
public void dodaj(View v) {
	bufor=lab1.getText();
	lab1.setText(bufor + "+");
}
public void minus(View v) {
	bufor=lab1.getText();
	lab1.setText(bufor + "-");
}
public void rowna(View v) {
	bufor=lab1.getText();
	lab1.setText(bufor + "*");
}
public void rownosc(View v) {
	CharSequence bufor1;
	bufor=lab1.getText();
	lab1.setText(bufor+"=");
	bufor=lab1.getText();
	bufor1=oblicz_txt(bufor);
	lab1.setText(bufor +""+bufor1);
	
}

}