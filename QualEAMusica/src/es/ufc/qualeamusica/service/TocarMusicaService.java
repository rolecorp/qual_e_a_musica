package es.ufc.qualeamusica.service;

import es.ufc.qualeamusica.R;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class TocarMusicaService extends Service {
	private static final String TAG = "TocaMusicaService";
	MediaPlayer mMediaPlayer = new MediaPlayer();

	private final IBinder mBinder = new LocalBinder();

	 public class LocalBinder extends Binder {
	    	public TocarMusicaService getService() {
	            // Return this instance of LocalService so clients can call public methods
	            return TocarMusicaService.this;
	        }
	 }

	  
	 public IBinder onBind(Intent intent) {
	        return mBinder;
	    }
	
	@Override
	public void onCreate() 
	{	
		
		Log.d(TAG, "Criando serviço" );
		
		Context context = getApplicationContext();
		
		int duration = Toast.LENGTH_LONG;
		
		CharSequence text = TAG + " - Inicializando service";

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		
		super.onCreate();
	}

	public int onStartCommand(Intent intent, int flags, int startId)
	{	
		Log.d( TAG, "Iniciando Serviço" );
			
				
			
		return START_NOT_STICKY;
	}
	
	public int executar() {
		int duracao = 0;
		if(!mMediaPlayer.isPlaying()) {
			mMediaPlayer = MediaPlayer.create(this, R.raw.tulio);
			duracao = mMediaPlayer.getDuration();
			mMediaPlayer.start();
		}
		return duracao;
		
	}
	
	public MediaPlayer getmMediaPlayer() {
		return mMediaPlayer;
	}

	public void setmMediaPlayer(MediaPlayer mMediaPlayer) {
		this.mMediaPlayer = mMediaPlayer;
	}
	
	
}
