package com.vothuat.viet.utils;

import android.content.Context;
import android.content.Intent;

import com.vothuat.viet.R;

public class SocialUtils {

	private static SocialUtils instance;

	private Context mContext;

	public static SocialUtils getInstance(Context context) {
		if (instance == null) {
			instance = new SocialUtils(context);
		}

		return instance;
	}

	private SocialUtils(Context context) {
		this.mContext = context;
	}

	private String extra = "";

	public void shareText(String shareBody) {
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				mContext.getString(R.string.app_name));
		sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody + extra);

		mContext.startActivity(Intent.createChooser(sharingIntent, mContext
				.getResources().getString(R.string.share_via)));
	}
}
