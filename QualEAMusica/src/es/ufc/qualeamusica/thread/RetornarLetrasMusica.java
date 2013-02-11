package es.ufc.qualeamusica.thread;

import java.util.ArrayList;
import java.util.List;

import es.ufc.qualeamusica.activity.Musicas;
import es.ufc.qualeamusica.bancoDeDados.DatabaseHelper;
import es.ufc.qualeamusica.model.LetrasMusica;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

public class RetornarLetrasMusica extends AsyncTask<Void, Void, List<LetrasMusica>> {

	private Musicas musicasActivity;
	 private DatabaseHelper helper;
	 
	 public RetornarLetrasMusica(Musicas musicasActivity) {
			this.setMusicasActivity(musicasActivity);
//			musicasActivity.deleteDatabase("QualEAMusica");
			helper = new DatabaseHelper(musicasActivity);
			
		}
	 
	 @Override
		protected List<LetrasMusica> doInBackground(Void... params) {
			//helper.inserirRespostasBanco("R. Certa", "B", "C", "D");

		 SQLiteDatabase db = helper.getReadableDatabase();

			Cursor cursor =
					db.rawQuery("SELECT " +
							"nome,"+
							"trecho_letra,"+
							"resposta_certa,"+
							"resposta_errada1,"+
							"resposta_errada2,"+
							"resposta_errada3 FROM respostas",
					null);
			cursor.moveToFirst();

			Log.d("Retornar Letras Musica","DO IN BCKGROUND");

			List<LetrasMusica> letrasMusicas = new ArrayList<LetrasMusica>();
			
			for (int i = 0; i < cursor.getCount(); i++) {
				Log.d("Retornar Letras Musica","ENTROU NO FOR DO ASYNCTASK");
				String nome = cursor.getString(0);
				String trecho_letra = cursor.getString(1);
				String respostaCerta = cursor.getString(2);
				String respostaErrada1 = cursor.getString(3);
				String respostaErrada2 = cursor.getString(4);
				String respostaErrada3 = cursor.getString(5);
				
				LetrasMusica musica = new LetrasMusica();
				musica.setNomeMusica(nome);
				musica.setTrechoLetra(trecho_letra);
				musica.setRespostaCerta(respostaCerta);
				musica.setRespostaErrada1(respostaErrada1);
				musica.setRespostaErrada2(respostaErrada2);
				musica.setRespostaErrada3(respostaErrada3);
				letrasMusicas.add(musica);
				cursor.moveToNext();

			}
			cursor.close();
			return letrasMusicas;
	        
	}
	
    @Override
    protected void onPostExecute(List<LetrasMusica> letras) {
        
        musicasActivity.setLetrasMusicas(letras);
	}

	public Musicas getMusicasActivity() {
		return musicasActivity;
	}

	public void setMusicasActivity(Musicas musicasActivity) {
		this.musicasActivity = musicasActivity;
	}

}
