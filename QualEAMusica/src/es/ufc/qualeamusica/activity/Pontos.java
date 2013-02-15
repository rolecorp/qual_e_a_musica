package es.ufc.qualeamusica.activity;

import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.R.layout;
import es.ufc.qualeamusica.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Pontos extends Activity {
	
	private TextView statusResposta;
	private TextView pontos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pontos);
		
		statusResposta = (TextView) findViewById(R.id.repostaView);
		pontos = (TextView) findViewById(R.id.pontosView);
		
		Bundle extras = getIntent().getExtras();
		statusResposta.setText(extras.getString("status"));
		pontos.setText(""+extras.getDouble("pontos"));
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_padrao, menu);
		return true;
	}
	
	public void proximaMusica(View v){
		Log.d("PontosActivity", "PROXIMA MUSICA");
		this.finish();
		
	}

}
