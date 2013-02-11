package es.ufc.qualeamusica.bancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static final String BANCO_DADOS = "QualEAMusica.db";
	private static int VERSAO = 1;


	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE  TABLE respostas (_id INTEGER PRIMARY KEY autoincrement, "+
				"nome TEXT , "+
				"trecho_letra TEXT , "+
				"resposta_certa TEXT, "+
				"resposta_errada1 TEXT, "+
				"resposta_errada2 TEXT, "+
				"resposta_errada3 TEXT);");
		
		db.execSQL("CREATE TABLE ranking_local (_id INTEGER PRIMARY KEY autoincrement, "+
				"nome_usuario TEXT, "+
				"pontuacao DOUBLE);");

		inserirRespostasBanco("mais_que_um_mero_poema","A vida segue a sina / Mães enterram filhos, filhos perdem amigos / " +
				"Amigos matam primos / Jogam os corpos nas margens dos rios contaminados / " +
				"Por gigantes barcos","Aquilo no retrato é sangue ou óleo negro?", "É o frio que segue o rumo e com ele a sua sorte",
				"Aqui jaz um coração", "Estraga qualquer face limpa",db);
		
		inserirRespostasBanco("", "", "", "", "", "", db);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		
	}
	
	public void inserirRespostasBanco(String nomeMusica, String trechoLetra, String respostaCerta, String respostaErrada1, String respostaErrada2, String respostaErrada3, SQLiteDatabase db){
//		SQLiteDatabase db = this.getWritableDatabase();
		
		//SQLiteDatabase db = dbh.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("nome", nomeMusica);
		values.put("trecho_letra", trechoLetra);
		values.put("resposta_certa", respostaCerta);
		values.put("resposta_errada1", respostaErrada1);
		values.put("resposta_errada2", respostaErrada2);
		values.put("resposta_errada3", respostaErrada3);
		
		long resultado = db.insert("respostas", null , values);
		
		if(resultado != -1 ){
			Log.d("inserirRespostasBanco", "Resposta salva no banco");
		}else{
			Log.d("inserirRespostasBanco", "Erro ao salvar");
		}

	}

}
