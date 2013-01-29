package es.ufc.qualeamusica.activity;


import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.networking.EnviaRanking;
import es.ufc.qualeamusica.util.MetodosComuns;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Recordes extends Activity {

	private String URLinicio = "http://";
	private String ip = "10.0.10.45";
	private String URLmeio = ":8080/ServidorQEAM/servletJSON?nome=";
	private String nomeUsuario = "Rodrigo";
	private String URLfim = "&pontuacao=";
	private double pontuacao = 12345;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recordes);
		
		TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
		tabHost.setup();

		TabSpec spec1=tabHost.newTabSpec("Meus Recordes");
		spec1.setContent(R.id.Meus_Recordes);
		spec1.setIndicator("Meus Recordes");

		TabSpec spec2=tabHost.newTabSpec("Ranking Geral");
		spec2.setIndicator("" ,getResources().getDrawable(R.drawable.ic_launcher));
		spec2.setContent(R.id.Ranking_Geral);

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_padrao, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		return MetodosComuns.clickItemDoMenu(featureId, item, this);
	}
	
	public void enviarRankingParaServidor(View v){
		EnviaRanking enviaRanking = new EnviaRanking(this);
		String URL = URLinicio + ip + URLmeio + nomeUsuario + URLfim + pontuacao;
		enviaRanking.execute(new String[] { URL });
		
	}

}
