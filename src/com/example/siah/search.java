package com.example.siah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

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
import android.widget.Spinner;

public class search extends Activity {
	private static final int PRODUCT = 1;
	private static final int COLOUR = 2;
	private static final int PRICE = 3;
	private static final int DISTANCE = 4;
	private static final int PRODUCT_TYPE = 5;
	private static final int PRODUCT_BRAND = 6;
	private static final String initSel = "Any";
	ArrayAdapter<String> adapter;

	Spinner prodType;
	Spinner prodBrand;
	Spinner productSpinner;
	Spinner colourSpinner;
	Spinner priceSpinner;
	Spinner distanceSpinner;

	String product;
	String productType;
	String productBrand;
	String colour;
	String price;
	String distance;

	Button clearButton;
	Button goButton;
	Button menuButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		initValues();
		createClearButton();
		createMenuButton();
		createSpinnerProduct();
		createSpinnerColour();
		createSpinnerPrice();
		createSpinnerDistance();
		createGoButton();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	void initValues() {
		product = "";
		productType = "";
		productBrand = "";
		colour = "";
		price = "";
		distance = "";
	}

	void createClearButton() {
		clearButton = (Button) findViewById(R.id.clear);
		clearButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				prodType.setSelection(0);
				prodBrand.setSelection(0);
				productSpinner.setSelection(0);
				colourSpinner.setSelection(0);
				priceSpinner.setSelection(0);
				distanceSpinner.setSelection(0);
				initValues();
			}

		});
	}

	void createSpinnerProduct() {
		productSpinner = (Spinner) findViewById(R.id.product);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getProd(PRODUCT, ""));
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		productSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// An item was selected. You can retrieve the selected item
				// using
				product = parent.getItemAtPosition(pos).toString();
				prodType = (Spinner) findViewById(R.id.productType);
				doProdType();
			}

			public void onNothingSelected(AdapterView<?> parent) {
				// Another interface callback
			}

		});
		productSpinner.setAdapter(adapter);
	}

	void createSpinnerColour() {
		colourSpinner = (Spinner) findViewById(R.id.colour);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getProd(COLOUR, ""));
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		colourSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// An item was selected. You can retrieve the selected item
				// using
				colour = parent.getItemAtPosition(pos).toString();
			}

			public void onNothingSelected(AdapterView<?> parent) {
				// Another interface callback
			}

		});
		colourSpinner.setAdapter(adapter);
	}

	void createSpinnerPrice() {
		priceSpinner = (Spinner) findViewById(R.id.price);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getProd(PRICE, ""));
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		priceSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// An item was selected. You can retrieve the selected item
				// using
				price = parent.getItemAtPosition(pos).toString();
			}

			public void onNothingSelected(AdapterView<?> parent) {
				// Another interface callback
			}

		});
		priceSpinner.setAdapter(adapter);
	}

	void createSpinnerDistance() {
		distanceSpinner = (Spinner) findViewById(R.id.distance);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getProd(DISTANCE, ""));
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		distanceSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// An item was selected. You can retrieve the selected item
				// using
				distance = parent.getItemAtPosition(pos).toString();
			}

			public void onNothingSelected(AdapterView<?> parent) {
				// Another interface callback
			}

		});
		distanceSpinner.setAdapter(adapter);
	}

	void createGoButton() {
		goButton = (Button) findViewById(R.id.go);
		goButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						results.class);
				startActivity(intent);
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

	void doProdType() {
		// Resources r = getResources();
		// int id = r.getIdentifier(product + "Type_array", "array",
		// "com.example.siah");
		// Log.d("id", Integer.toString(id));
		// Log.d("id_verify", Integer.toString(R.array.clothingType_array));

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getProd(PRODUCT_TYPE,
						product));
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		prodType.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// An item was selected. You can retrieve the selected item
				// using
				productType = parent.getItemAtPosition(pos).toString();
				prodBrand = (Spinner) findViewById(R.id.productBrand);
				doBrandType();
			}

			public void onNothingSelected(AdapterView<?> parent) {
				// Another interface callback
			}

		});

		prodType.setAdapter(adapter);

	}

	void doBrandType() {
		// Resources r = getResources();
		// int id = r.getIdentifier(product + "Type_array", "array",
		// "com.example.siah");
		// Log.d("id", Integer.toString(id));
		// Log.d("id_verify", Integer.toString(R.array.clothingType_array));

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getProd(PRODUCT_BRAND,
						productType));
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		prodBrand.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				// An item was selected. You can retrieve the selected item
				// using
				productBrand = parent.getItemAtPosition(pos).toString();

			}

			public void onNothingSelected(AdapterView<?> parent) {
				// Another interface callback
			}

		});

		prodBrand.setAdapter(adapter);
	}

	ArrayList<String> getProd(int searchType, String searchFor) {
		ArrayList<String> any = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		any.add(initSel);
		InputStreamReader file = null;
		try {
			switch (searchType) {
			case PRODUCT:
				file = new InputStreamReader(getAssets().open("product.in"));
				break;
			case COLOUR:
				file = new InputStreamReader(getAssets().open("colour.in"));
				break;
			case PRICE:
				file = new InputStreamReader(getAssets().open("price.in"));
				break;
			case DISTANCE:
				file = new InputStreamReader(getAssets().open("distance.in"));
				break;
			case PRODUCT_TYPE:
				file = new InputStreamReader(getAssets().open("product.in"));
				break;
			case PRODUCT_BRAND:
				file = new InputStreamReader(getAssets().open("product.in"));
				break;
			default:
				break;
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (searchType != PRODUCT && searchType != PRODUCT_TYPE
				&& searchType != PRODUCT_BRAND) {
			BufferedReader br = null;
			br = new BufferedReader(file);
			String line;
			try {
				while ((line = br.readLine()) != null) {
					temp.add(line);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			BufferedReader br = null;
			br = new BufferedReader(file);
			String line;
			try {
				while ((line = br.readLine()) != null && !(line.equals(""))) {
					String[] temp1 = line.split(" ");

					Log.e("wtf why", Arrays.asList(temp1).toString());

					if (searchType == PRODUCT)
						temp.add(temp1[0]);
					else if (searchType == PRODUCT_TYPE) {
						if (searchFor.equals("Any")) {
							temp.add(temp1[1]);
						} else if (temp1[0].equals(searchFor)) {
							temp.add(temp1[1]);
						}
					} else {
						String[] bTemp = temp1[2].split(",");
						for (String s : bTemp) {
							if (searchFor.equals("Any")) {
								temp.add(s);
							} else if (temp1[1].equals(searchFor)) {
								temp.add(s);
							}
						}
					}
				}

				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if ((searchType == PRICE) || (searchType == DISTANCE)) {
		} else {
			HashSet<String> tempHash = new HashSet<String>(temp);

			temp = new ArrayList<String>(tempHash);
			Collections.sort(temp);
		}
		any.addAll(temp);
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return any;
	}
}
