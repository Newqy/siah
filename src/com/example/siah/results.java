package com.example.siah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;

public class results extends Activity {

	// item name_product_productType_productBrand_colour_price_distance

	Button backButton;
	Button menuButton;

	public static ArrayList<Data> data = new ArrayList<Data>();
	ArrayList<String> sortList = new ArrayList<String>();

	// String[] price;
	String[] store;
	int[] imageID;
	public static int clicked;

	Spinner sortSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results);

		createBackButton();
		createMenuButton();
		search();
		display();
		sortList.add("-");
		sortList.add("Low - High");
		sortList.add("High - Low");
		// createSortSpinner();
	}

	private void display() {
		GridView grid;
		getData();

		customGrid adapter = new customGrid(getApplicationContext(), data);
		grid = (GridView) findViewById(R.id.gridresults);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				clicked = position;
				Intent intent = new Intent(getApplicationContext(),
						details.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	void createBackButton() {
		backButton = (Button) findViewById(R.id.back);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}

		});
	}

	void createMenuButton() {
		menuButton = (Button) findViewById(R.id.navmenu);
		menuButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				openOptionsMenu();
			}

		});
	}

	void createSortSpinner() {
		sortSpinner = (Spinner) findViewById(R.id.sort);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, sortList);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		sortSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// An item was selected. You can retrieve the selected item
				// using
				if (pos == 1) {
					sort();
				} else {
					ArrayList<Integer> priceSort = new ArrayList<Integer>();
					// for (String s : priceData)
					// priceSort.add(Integer.parseInt(s.substring(1)));
					// Collections.sort(priceSort);
					// Collections.reverse(priceSort);
					// priceData.clear();
					// for (int i : priceSort)
					// priceData.add("$" + Integer.toString(i));
				}

			}

			public void onNothingSelected(AdapterView<?> parent) {
				// Another interface callback
			}

		});
		sortSpinner.setAdapter(adapter);

	}

	private void sort() {
		for (Data d : data) {
			Collections.sort(data, new priceCompare());
		}
		display();
	}

	private void getData() {
		// product_productType_productBrand_colour_price_distance
		InputStreamReader file = null;
		try {
			file = new InputStreamReader(getAssets().open("myItems.in"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(file);

		String line;
		try {
			while ((line = br.readLine()) != null) {
				String[] temp = line.split("_");
				String[] coor = temp[6].split(":");
				Data tempD = new Data(temp[0], temp[1], temp[2], temp[3],
						temp[4], Integer.parseInt(temp[5]),
						Double.parseDouble(coor[0]),
						Double.parseDouble(coor[1]));
				data.add(tempD);
			}
			Log.e("DATA", data.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void search() {

	}

}
