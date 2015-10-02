package com.example.siah;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends FragmentActivity {

	Button backButton;
	Button menuButton;
	Button navigateButton;

	GoogleMap googleMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		createBackButton();
		createMenuButton();
		createNavigateButton();
		createGoogleMap();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	void createGoogleMap() {
		googleMap = ((SupportMapFragment) (getSupportFragmentManager()
				.findFragmentById(R.id.map))).getMap();

		CameraUpdate camUpd = null;
		LatLng myLatLng = new LatLng(results.data.get(results.clicked).getX(),
				results.data.get(results.clicked).getY());
		CameraPosition camera = new CameraPosition.Builder().target(myLatLng)
				.zoom(12).build();
		camUpd = CameraUpdateFactory.newCameraPosition(camera);

		MarkerOptions marker = new MarkerOptions().position(myLatLng);
		googleMap.addMarker(marker);
		googleMap.animateCamera(camUpd);
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

	void createNavigateButton() {
		navigateButton = (Button) findViewById(R.id.navigate);
		navigateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				/*** TODO ***/
				navigate();
			}

		});
	}

	void navigate() {

	}

}
