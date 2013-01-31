package es.ufc.qualeamusica.networking;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import es.ufc.qualeamusica.activity.Recordes;
import es.ufc.qualeamusica.model.Ranking;
import es.ufc.qualeamusica.util.DataSerializer;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class VisualizarRankingGeral extends AsyncTask<String, Void, String>{
	
	private Recordes recordes;
	
	public VisualizarRankingGeral(Recordes recordes) {
		this.recordes = recordes;
	}

	@Override
	protected String doInBackground(String... urls) {
		String output = null;
        for (String url : urls) {
            output = getOutputFromUrl(url);
        }
        return output;
	}

	
	private String getOutputFromUrl(String url) {
        String output = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            output = EntityUtils.toString(httpEntity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
	
	@Override
    protected void onPostExecute(String output) {
        Context context = recordes.getApplicationContext();
		
		int duration = Toast.LENGTH_LONG;
		CharSequence text = output;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		
		ArrayList<Ranking> rankings;
		String nomeTextView = "NOME";
		String pontosTextView = "PONTOS";
		
			try {
				rankings = (ArrayList<Ranking>) DataSerializer.getInstance().converterJSONParaListaRanking(output);
				for (Ranking ranking : rankings) {
					nomeTextView += "\n" + ranking.getNomeUsuario();
					pontosTextView += "\n" + ranking.getPontuacao();
				}
				recordes.getNomeTextView2().setText(nomeTextView);
				recordes.getPontosTextView2().setText(pontosTextView);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
    }

}
