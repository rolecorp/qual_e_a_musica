package es.ufc.qualeamusica.thread;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ProgressBar;
import es.ufc.qualeamusica.activity.OpcoesResposta;
import es.ufc.qualeamusica.service.TocarMusicaService;

public class BarraProgressoThread implements Runnable {

	private ProgressBar progressBar;
	private TocarMusicaService mService;
	private Activity musicasActivity;
	
	 public BarraProgressoThread(ProgressBar progressBar,TocarMusicaService mService, Activity musicasActivity) {
		this.progressBar = progressBar;
		this.mService = mService;
		this.musicasActivity = musicasActivity;
	}

	@Override
	    public void run() {
	        int currentPosition= 0;
	        while(mService.getmMediaPlayer().isPlaying() && currentPosition<progressBar.getMax()){
	            try {
	                Thread.sleep(300);
	                currentPosition= mService.getmMediaPlayer().getCurrentPosition();
	            } catch (InterruptedException e) {
	                return;
	            } catch (Exception e){
	                return;
	            }            
	            progressBar.setProgress(currentPosition);
	            Log.d("MUSICAS","ENTROU NO WHILE DA THREAD");
	        }
	        Log.d("MUSICAS","SAIU DO WHILE DA THREAD");
	        Intent intent = new Intent(musicasActivity,OpcoesResposta.class);
			musicasActivity.startActivity(intent);
	    }
}
