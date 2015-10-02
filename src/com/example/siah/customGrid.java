package com.example.siah;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customGrid extends BaseAdapter {
	private Context mContext;
	private final ArrayList<Data> data;

	public customGrid(Context c, ArrayList<Data> data) {
		mContext = c;
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View grid;
		TextView store_t = null;
		TextView price_t = null;
		ImageView imageView = null;

		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			grid = new View(mContext);
			grid = inflater.inflate(R.layout.grid_single, null);
			store_t = (TextView) grid.findViewById(R.id.store);
			price_t = (TextView) grid.findViewById(R.id.price);
			imageView = (ImageView) grid.findViewById(R.id.grid_image);
			store_t.setText(data.get(position).getBrandName());
			price_t.setText(data.get(position).getPrice());
			imageView.setImageResource(R.drawable.main);
		} else {
			grid = (View) convertView;
			store_t = (TextView) grid.findViewById(R.id.store);
			price_t = (TextView) grid.findViewById(R.id.price);
			imageView = (ImageView) grid.findViewById(R.id.grid_image);
		}
		return grid;
	}
}