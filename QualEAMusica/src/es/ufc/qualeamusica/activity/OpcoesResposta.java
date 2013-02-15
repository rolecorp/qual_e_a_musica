package es.ufc.qualeamusica.activity;

import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.model.LetrasMusica;
import es.ufc.qualeamusica.util.MetodosComuns;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OpcoesResposta extends Activity {
	
	private LetrasMusica musica;
	private RadioGroup radioGroup;
	private RadioButton rb1;
	private RadioButton rb2;
	private RadioButton rb3;
	private RadioButton rb4;
	private long tempoResposta;
	private double pontuacaoMaxima;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opcoes_resposta);
		
		pontuacaoMaxima = 3000;
		
		Bundle extras = getIntent().getExtras();
		musica = (LetrasMusica) extras.get("LetrasMusicas");
		radioGroup = (RadioGroup) findViewById(R.id.opcaoMusica);
		
		rb1 = (RadioButton) findViewById(R.id.radioButton1);
		rb2 = (RadioButton) findViewById(R.id.radioButton2);
		rb3 = (RadioButton) findViewById(R.id.radioButton3);
		rb4 = (RadioButton) findViewById(R.id.radioButton4);
		
		rb1.setText(musica.getRespostaCerta());
		rb2.setText(musica.getRespostaErrada1());
		rb3.setText(musica.getRespostaErrada2());
		rb4.setText(musica.getRespostaErrada3());
		
		tempoResposta = System.currentTimeMillis();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_padrao, menu);
		return true;
	}
	
	public void responder(View v){
		//Pega o tempo que o usuario levou clicar no responder
		tempoResposta = System.currentTimeMillis()-tempoResposta;
		Log.d("RESPONDER", ""+tempoResposta);
		Double pontos;
		if(tempoResposta < 30000) {
			pontos = (double) (pontuacaoMaxima - tempoResposta/10);
		}else{
			pontos = (double) 100;
		}
		Intent intent = new Intent(this,Pontos.class);
		int opcao = radioGroup.getCheckedRadioButtonId();
		switch(opcao){
			case R.id.radioButton1:
				
				Log.d("Switch", "Entrou no case 1");
				if(rb1.getText().equals(musica.getRespostaCerta())){
				intent.putExtra("status", "Resposta Correta");
				intent.putExtra("pontos", pontos);
				startActivity(intent);
				}else{
					intent.putExtra("status", "Resposta Errada");
					intent.putExtra("pontos", 0);
					startActivity(intent);
				}
				break;
			case R.id.radioButton2:
				if(rb2.getText().equals(musica.getRespostaCerta())){
				intent.putExtra("status", "Resposta Correta");
				intent.putExtra("pontos", pontos);
				}else{
					intent.putExtra("status", "Resposta Errada");
					intent.putExtra("pontos", 0);
				}
				break;

			case R.id.radioButton3:
				if(rb3.getText().equals(musica.getRespostaCerta())){
				intent.putExtra("status", "Resposta Correta");
				intent.putExtra("pontos", pontos);
				}else{
					intent.putExtra("status", "Resposta Errada");
					intent.putExtra("pontos", 0);
				}
				break;

			case R.id.radioButton4:
				if(rb4.getText().equals(musica.getRespostaCerta())){
				intent.putExtra("status", "Resposta Correta");
				intent.putExtra("pontos", pontos);
				}else{
					intent.putExtra("status", "Resposta Errada");
					intent.putExtra("pontos", 0);
				}
				break;
		}
		
		

		
		
		
		//Intent intent = new Intent(this,Pontos.class);
		
	}
	
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		return MetodosComuns.clickItemDoMenu(featureId, item, this);
	}

}
