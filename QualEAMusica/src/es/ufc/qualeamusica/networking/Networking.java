package es.ufc.qualeamusica.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import android.app.Activity;

public class Networking extends Activity
{
	final static String TAG = "Networking";
	
	boolean conectado;//depois tirar
	Socket socket;
	InputStream entrada;
	OutputStream saida;
	Object conectadaFlag;//depois tirar
	
	public  boolean isConectado() {
		return conectado;
	}
	
	public void setConectado( boolean conectado ) {
		this.conectado = conectado;
	}
	
	public void initConecao( Socket socket ){
		
		this.conectado=true;
					
			try {
				
				this.socket = socket;
				this.entrada = socket.getInputStream();
				this.saida = socket.getOutputStream();							
		
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep( 200 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
}
