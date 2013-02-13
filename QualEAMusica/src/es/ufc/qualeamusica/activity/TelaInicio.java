package es.ufc.qualeamusica.activity;


import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.bancoDeDados.DatabaseHelper;
import es.ufc.qualeamusica.util.MetodosComuns;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TelaInicio extends Activity {
	
	private DatabaseHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_inicio);
		helper = new DatabaseHelper(this);
	}
	
	@Override
	protected void onDestroy() {
		helper.close();
		super.onDestroy();
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

	public void telaNovoJogo(View v){

		Intent intent = new Intent(this,Musicas.class);
		startActivity(intent);	
	}

		public void telaRecordes(View v){
			Intent intent = new Intent(this,Recordes.class);
			startActivity(intent);
	
		}
		public void telaInstrucoes(View v){
			Intent intent = new Intent(this,Instrucoes.class);
			startActivity(intent);
		}

	public void sair(View v){
		this.finish();
	}
	
	public void escolherOpcao(View view){
		Intent intent = new Intent(this, Localizacao.class);
		startActivity(intent);
		}
	
}
