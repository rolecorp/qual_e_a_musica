package es.ufc.qualeamusica.activity;


import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.networking.EnviaRanking;
import es.ufc.qualeamusica.networking.VisualizarRankingGeral;
import es.ufc.qualeamusica.util.MetodosComuns;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TableRow;
import android.widget.TextView;

public class Recordes extends Activity {
	
	private String URLinicio = "http://";
	private String ip = "10.0.22.28";
	private String URLmeio = ":8080/ServidorQEAM/";
	private String servletRequisicao = "servletRequisicaoGet?nome=";
	private String servletJSON = "servletJSON";
	private String nomeUsuario = "Rodrigo";
	private String URLfim = "&pontuacao=";
	private double pontuacao = 12345;
	
	private TabHost tabHost;
	private TabSpec spec1;
	private TabSpec spec2;
	private TextView nomeTextView1;
	private TextView nomeTextView2;
	private TextView pontosTextView1;
	private TextView pontosTextView2;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recordes);
		
		tabHost=(TabHost)findViewById(R.id.tabHost);
		tabHost.setup();

		spec1=tabHost.newTabSpec("Meus Recordes");
		spec1.setContent(R.id.Meus_Recordes);
		spec1.setIndicator("Meus Recordes");

		spec2=tabHost.newTabSpec("Ranking Geral");
		spec2.setIndicator("" ,getResources().getDrawable(R.drawable.ic_launcher));
		spec2.setContent(R.id.Ranking_Geral);

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		
		nomeTextView1 = (TextView) findViewById(R.id.nomeTextView1);
		nomeTextView2 = (TextView) findViewById(R.id.nomeTextView2);
		pontosTextView1 = (TextView) findViewById(R.id.pontosTextView1);
		pontosTextView2 = (TextView) findViewById(R.id.pontosTextView2);
		
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
		String URL = URLinicio + ip + URLmeio + servletRequisicao + nomeUsuario + URLfim + pontuacao;
		enviaRanking.execute(new String[] { URL });
		
	
	}
	
	public void visualizarRankingGeral(View v)
	{
		VisualizarRankingGeral visualiza = new VisualizarRankingGeral(this);
		String URL = URLinicio + ip + URLmeio + servletJSON;
		visualiza.execute(new String[] { URL });

	}

	public TextView getNomeTextView1() {
		return nomeTextView1;
	}

	public void setNomeTextView1(TextView nomeTextView1) {
		this.nomeTextView1 = nomeTextView1;
	}

	public TextView getNomeTextView2() {
		return nomeTextView2;
	}

	public void setNomeTextView2(TextView nomeTextView2) {
		this.nomeTextView2 = nomeTextView2;
	}

	public TextView getPontosTextView1() {
		return pontosTextView1;
	}

	public void setPontosTextView1(TextView pontosTextView1) {
		this.pontosTextView1 = pontosTextView1;
	}

	public TextView getPontosTextView2() {
		return pontosTextView2;
	}

	public void setPontosTextView2(TextView pontosTextView2) {
		this.pontosTextView2 = pontosTextView2;
	}
	
	

}
