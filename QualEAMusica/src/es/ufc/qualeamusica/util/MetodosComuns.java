package es.ufc.qualeamusica.util;

import es.ufc.qualeamusica.R;
import es.ufc.qualeamusica.activity.Sobre;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

public class MetodosComuns{
	
	public static boolean clickItemDoMenu (int featureId, MenuItem item, Activity activity ){
		switch (item.getItemId()) {
		case R.id.sobre:
			activity.startActivity(new Intent(activity, Sobre.class));
			return true;
		case R.id.menu_settings:
			
			
			return true;
		default:
			return true;
		}		
	}

}
