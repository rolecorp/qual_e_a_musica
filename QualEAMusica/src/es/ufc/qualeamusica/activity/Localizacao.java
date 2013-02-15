package es.ufc.qualeamusica.activity;

import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.R.layout;
import es.ufc.qualeamusica.R.menu;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.TextView;

public class Localizacao extends Activity {

	private LocationManager locationManager;
	private TextView latitude, longitude, provedor;
	private String urlBase = "http://maps.googleapis.com/maps/api" +
			"/staticmap?size=400x400&sensor=true&markers=color:red|%s,%s";
	private WebView mapa;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localizacao);
		latitude = (TextView) findViewById(R.id.latitude);
		longitude = (TextView) findViewById(R.id.longitude);
		provedor = (TextView) findViewById(R.id.provedor);
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		Listener listener = new Listener();
		long tempoAtualizacao = 0;
		float distancia = 0;
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,tempoAtualizacao, distancia, listener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,tempoAtualizacao, distancia, listener);
		mapa = (WebView) findViewById(R.id.mapa);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_padrao, menu);
		return true;
	}
	
	//Classe Privada 
	private class Listener implements LocationListener{
		
		@Override
		public void onLocationChanged(Location location) {
			String latitudeStr = String.valueOf(location.getLatitude());
			String longitudeStr = String.valueOf(location.getLongitude());
			provedor.setText(location.getProvider());
			latitude.setText(latitudeStr);
			longitude.setText(longitudeStr);
			
			String url = String.format(urlBase, latitudeStr, longitudeStr);
			mapa.loadUrl(url);

		}
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			
		}
	
	}

}



