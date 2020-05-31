package com.example.cw7;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class pierwsza extends Activity {
protected void onCreate(Bundle savedinstanceState) {
	super.onCreate(savedinstanceState);
	setContentView(R.layout.ekr1);
	Toast.makeText(getBaseContext(), "za³adowano poprawnie klase", Toast.LENGTH_SHORT).show();
}
}
