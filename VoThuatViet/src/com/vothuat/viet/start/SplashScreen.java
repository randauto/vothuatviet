package com.vothuat.viet.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.vothuat.viet.MainActivity;
import com.vothuat.viet.R;

public class SplashScreen extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_layout);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				startActivity(new Intent(SplashScreen.this, MainActivity.class));
				finish();
			}
		}, 1000);
	}
}
