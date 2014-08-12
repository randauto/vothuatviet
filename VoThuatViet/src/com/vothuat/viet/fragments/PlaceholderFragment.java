package com.vothuat.viet.fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vothuat.viet.MainActivity;
import com.vothuat.viet.NavigationDrawerFragment;
import com.vothuat.viet.R;
import com.vothuat.viet.adapter.ListItemAdapter;
import com.vothuat.viet.data.IItem;
import com.vothuat.viet.data.MContent;
import com.vothuat.viet.data.VoThuatVietFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
	private ListView listView;

	private IItem category;

	private ArrayList<MContent> data;

	private ListItemAdapter adapter;

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static PlaceholderFragment newInstance(int sectionNumber) {
		PlaceholderFragment fragment = new PlaceholderFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public PlaceholderFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		category = VoThuatVietFactory.getInstance(getActivity()).getCategory(
				NavigationDrawerFragment.menus[getArguments().getInt(
						ARG_SECTION_NUMBER) - 1]);

		data = category.getData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		listView = (ListView) rootView.findViewById(R.id.listView);
		adapter = new ListItemAdapter(getActivity(), data);
		listView.setAdapter(adapter);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}
}
