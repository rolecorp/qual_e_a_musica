package es.ufc.qualeamusica.activity;

import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.model.LetrasMusica;
import es.ufc.qualeamusica.util.MetodosComuns;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;

public class OpcoesResposta extends Activity {
	
	private LetrasMusica musicas;
	private RadioButton rb1;
	private RadioButton rb2;
	private RadioButton rb3;
	private RadioButton rb4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opcoes_resposta);
		
		Bundle extras = getIntent().getExtras();
		musicas = (LetrasMusica) extras.get("LetrasMusicas");
		
		rb1 = (RadioButton) findViewById(R.id.radioButton1);
		rb2 = (RadioButton) findViewById(R.id.radioButton2);
		rb3 = (RadioButton) findViewById(R.id.radioButton3);
		rb4 = (RadioButton) findViewById(R.id.radioButton4);
		
		rb1.setText(musicas.getRespostaCerta());
		rb2.setText(musicas.getRespostaErrada1());
		rb3.setText(musicas.getRespostaErrada2());
		rb4.setText(musicas.getRespostaErrada3());
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

}
