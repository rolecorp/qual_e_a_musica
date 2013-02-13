package es.ufc.qualeamusica.sensores;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.widget.Toast;

public class Acelerometro implements SensorEventListener{
	
	private Activity activity;
	private SensorManager mSensorManager;
	private Sensor mSensor;
	private long lastUpdate = -1;
	private float x, y, z;
	private float last_x, last_y, last_z;
	private static final int SHAKE_THRESHOLD = 1000;
	
	public Acelerometro(Activity activity) {
		this.activity = activity;
		mSensorManager = (SensorManager) this.activity.getSystemService(Context.SENSOR_SERVICE ) ;
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER ) ;
		mSensorManager.registerListener(this , mSensor , SensorManager.SENSOR_DELAY_NORMAL ) ;
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
			long curTime = System.currentTimeMillis(); // only allow one update every 100ms. 
			if ((curTime - lastUpdate) > 100) { 
				long diffTime = (curTime - lastUpdate); 
				lastUpdate = curTime;
				x = event.values[0]; 
				y = event.values[1];
				z = event.values[2]; 
				float speed = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000; 
				
				if (speed > SHAKE_THRESHOLD) { 
					Context context = this.activity.getApplicationContext();
					AudioManager audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
					
					if(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)!=0){
						
						//audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);
						audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
						
					}else{
						int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
					    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);
						audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
						
					}
					
					int duration = Toast.LENGTH_LONG;
					
					CharSequence text = "Deu certo :) " +"Current Time: " + curTime + " Last Update: " + lastUpdate ;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				} 
				
				last_x = x; 
				last_y = y; 
				last_z = z; 
			} 
		}
		
	}

}
