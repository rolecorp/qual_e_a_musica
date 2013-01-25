package es.ufc.qualeamusica.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;


public class ConectarServidor implements Runnable 
{
	static final String TAG = "ConnectServerRunnable";
	String ip;
	int port;
	
	public ConectarServidor(Networking networking ){
		this.ip = "192.168.2.20";
		this.port = 5000;
	}
	
	

	public void run() 
	{
try { 
			
			InetAddress inetAddr = InetAddress.getByName(ip);
			Socket socket = new Socket( inetAddr, port );
			
			//androidNetworkingActivity.initConecao( socket );
			
			Log.d(TAG, "Connected to server: " + ip + " - Port: " + port );
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
