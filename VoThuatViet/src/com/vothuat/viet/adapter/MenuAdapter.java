package com.vothuat.viet.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vothuat.viet.data.MChapter;

public class MenuAdapter extends BaseAdapter {
	private ArrayList<MChapter> list;

	private Context context;

	public MenuAdapter(Context context, ArrayList<MChapter> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

}