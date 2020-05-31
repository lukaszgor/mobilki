package com.example.cw7;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class druga extends Activity implements OnClickListener {
	private timerek minutnik;
	TextView txt1;
	private long startTime=50*1000;
	private final long interval =1000;
	private Button btn1,btn2,btn3;
	private EditText edit1;
	public int godzina=0;
	public int minuta=0;
	public int sekunda=0;
	public int milisekunda=0;
	
	String godz_str="";
	String min_str="";
	String sek_str="";
	
	
	protected void onCreate(Bundle savedinstanceState) {
		super.onCreate(savedinstanceState);
		setContentView(R.layout.ekr2);
		Toast.makeText(getBaseContext(), "za�adowano poprawnie klase 2", Toast.LENGTH_SHORT).show();
		
		
		txt1=(TextView)findViewById(R.id.textView1);
	
		
		btn1=(Button)findViewById(R.id.button1xd);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		
	
		
		edit1=(EditText)findViewById(R.id.editText1);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
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
	

	@Override 
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.button1xd:
			pobierz_czas(edit1.getText().toString());
		
			konwersja_int(godz_str,min_str,sek_str);
			startTime=milisekundy;
			minutnik=new timerek(startTime,interval);
			minutnik.start();
			btn1.setEnabled(false);
			edit1.setEnabled(false);
			break;
		case R.id.button2:
			minutnik.cancel();
			btn1.setEnabled(true);
			edit1.setEnabled(true);
			break;
		case R.id.button3:
			edit1.setText("");
			txt1.setText("");
			break;
			
		
		}
		
			
	}
	
	
	
	public class timerek extends CountDownTimer{
		public timerek(long startCzas,long interval) {
			super(startCzas,interval);
		}
		
		@Override
		public void onFinish() {
			txt1.setText("Koniec czasu");
			
		}
		@Override
		public void onTick(long millisUnitilFinished) {
			wypisz_czas();
			
		}
	}
	
	
	
	
	

	
	public void pobierz_czas(String czas_txt) {
		String bufor="";
		int dl_txt=czas_txt.length();
		int licznik=0;
		int licz_dwa=0;
		txt1.setText("00");
		
		
		
		for(int i=0;i<dl_txt;i++) {
			if(czas_txt.charAt(i)==':')
				licznik++;
		}
		
		if(licznik==1) {
			for(int i=0;i<dl_txt;i++) {
				if(czas_txt.charAt(i)==':') {
					godz_str=bufor;
					bufor="";
				}else {
					bufor+=czas_txt.charAt(i);
				}
			}
			min_str=bufor;
			sek_str="00";
		}
		
		
		if(licznik==2) {
			for(int i=0;i<dl_txt;i++) {
				
				if(czas_txt.charAt(i)==':') {
					if(licz_dwa==0) {
						godz_str=bufor;
						bufor="";
						licz_dwa++;
						
					}
					if(licz_dwa==1) {
						min_str=bufor;
						bufor="";
					}
				}else {
					bufor+=czas_txt.charAt(i);
				}
				
				
			}
			
			sek_str=bufor;
			}
		
		if(licznik>2||licznik==0) {
			txt1.setText("b�ad");
		}
		}
		
	
	Integer milisekundy;
	public void konwersja_int(String godz,String min,String sek) {
		godzina= Integer.parseInt(godz_str);
		minuta= Integer.parseInt(min_str);
		sekunda= Integer.parseInt(sek_str);
		
		milisekundy=(godzina*3600+minuta*60+sekunda)*1000;
	}
	
	
	public void wypisz_czas() {
		if(sekunda==0) {
			if(godzina >0 && minuta == 0) {
				godzina-=1;
				minuta=60;
			}
			sekunda=60;
			if(minuta>0) {
				minuta -=1;
			}
		}
		sekunda--;
		txt1.setText("Czas :"+godzina+":"+minuta+":"+sekunda);
	}
	
	
	
}



