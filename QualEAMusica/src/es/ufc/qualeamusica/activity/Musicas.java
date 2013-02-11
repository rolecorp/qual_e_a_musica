package es.ufc.qualeamusica.activity;

import java.util.List;

import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.model.LetrasMusica;
import es.ufc.qualeamusica.service.TocarMusicaService;
import es.ufc.qualeamusica.service.TocarMusicaService.LocalBinder;
import es.ufc.qualeamusica.thread.BarraProgressoThread;
import es.ufc.qualeamusica.thread.RetornarLetrasMusica;
import es.ufc.qualeamusica.util.MetodosComuns;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Musicas extends Activity{
	
	private ProgressBar progressBar;
	private TocarMusicaService mService;
    private boolean mBound = false;
    private TextView letraMusica;
    private List<LetrasMusica> letrasMusicas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_musicas);
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		
		//Inicializando o Bind Service
		Intent intent = new Intent(this, TocarMusicaService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        
        letraMusica = (TextView) findViewById(R.id.letraDaMusicaView);
        
        RetornarLetrasMusica letras = new RetornarLetrasMusica(this);
		letras.execute();
	}

	public List<LetrasMusica> getLetrasMusicas() {
		return letrasMusicas;
	}

	public void setLetrasMusicas(List<LetrasMusica> letrasMusicas) {
		this.letrasMusicas = letrasMusicas;
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
	
	public void tocarMusica(View v){
		
		//chamar o metodo random
		
		//Chamando o metodo executar do service
		
		letraMusica.setText(letrasMusicas.get(0).getTrechoLetra());
		
		int duracaoTotal = mService.executar(letrasMusicas.get(0).getNomeMusica());
		Log.d("Tempo Musica Total",""+duracaoTotal);
		if(duracaoTotal!=0){
			progressBar.setVisibility(ProgressBar.VISIBLE);
			progressBar.setProgress(0);
			progressBar.setMax(duracaoTotal);
			BarraProgressoThread barraProgressoThread = new BarraProgressoThread(progressBar, mService, this);
			new Thread(barraProgressoThread).start();
		}
		
	}
	
	public TextView getLetraMusica() {
		return letraMusica;
	}

	public void setLetraMusica(TextView letraMusica) {
		this.letraMusica = letraMusica;
	}

	//nao entendi
	private ServiceConnection mConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className,
                IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
        	LocalBinder binder = (LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    }; 

}
