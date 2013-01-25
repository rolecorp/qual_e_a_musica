package es.ufc.qualeamusica.bancoDeDados;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class BancoDeDados extends Activity{
	
	private DatabaseHelper helper;

	public void inserirRespostasBanco(String respostaCerta, String respostaErrada1, String respostaErrada2, String respostaErrada3){
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("resposta_certa", respostaCerta);
		values.put("resposta_errada1", respostaErrada1);
		values.put("resposta_errada2", respostaErrada2);
		values.put("resposta_errada3", respostaErrada3);
		
		long resultado = db.insert("respostas", null , values);
		
		if(resultado != -1 ){
			System.out.println("Resposta salva no banco");
		}else{
			System.out.println("Erro ao salvar");
		}

	}
	
	
	

}
