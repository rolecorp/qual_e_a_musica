package es.ufc.qualeamusica.bancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static final String BANCO_DADOS = "QualEAMusica";
	private static int VERSAO = 1;


	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE  TABLE respostas (_id INTEGER PRIMARY KEY , "+
				"resposta_certa TEXT , "+
				"resposta_errada1 TEXT , "+
				"resposta_errada2 TEXT , "+
				"resposta_errada3 TEXT);");
				
		db.execSQL("CREATE TABLE letra_musica (_id INTEGER PRIMARY KEY ,"+
				"trecho_letra TEXT , "+
				"FOREIGN KEY(respostas_id) REFERENCES respostas(_id));");
		
		db.execSQL("CREATE TABLE musica(_id INTEGER PRIMARY KEY ,"+
				"nome TEXT , "+
				"FOREIGN KEY(musica_letra_musica) REFERENCES letra_musica(_id));");
		
		db.execSQL("CREATE TABLE ranking_local (_id INTEGER PRIMARY KEY , "+
				"nome_usuario TEXT , "+
				"pontuacao DOUBLE);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
