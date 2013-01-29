package es.ufc.qualeamusica.networking;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class EnviaRanking extends AsyncTask<String, Void, String>  {

	//private String outputText;
	private Activity activity;
	
	public EnviaRanking(Activity activity) {
		this.activity = activity;
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
        Context context = activity.getApplicationContext();
		
		int duration = Toast.LENGTH_LONG;
		
		CharSequence text = output;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
    }
	
}
