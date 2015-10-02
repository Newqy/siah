package com.example.siah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends Activity {

	TextView brandName;
	TextView productName;
	TextView price;
	TextView inStock;
	TextView cNum;
	Button menuButton;
	Button backButton;
	Button mapPreview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		createMenuButton();
		createBackButton();
		display();
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

	void createBackButton() {
		backButton = (Button) findViewById(R.id.back);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}

		});
	}

	private void display() {
		ImageView iv = (ImageView) findViewById(R.id.productImage);
		iv.setImageResource(R.drawable.main);
		productName = (TextView) findViewById(R.id.productName);
		brandName = (TextView) findViewById(R.id.brandName);
		price = (TextView) findViewById(R.id.price);
		inStock = (TextView) findViewById(R.id.inStock);
		cNum = (TextView) findViewById(R.id.contactNumber);
		setData();
	}

	private void setData() {
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
		int position = results.clicked;
		productName.setText(results.data.get(position).getProductType() + " "
				+ results.data.get(position).getBrandName());
		brandName.setText(results.data.get(position).getBrandName());
		price.setText(results.data.get(position).getPrice());
		inStock.setText("Contact Now");
		cNum.setText("01234");
		enableMapPreview();

	}

	private void enableMapPreview() {
		mapPreview = (Button) findViewById(R.id.preview);
		mapPreview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), map.class);
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

}
