package es.ufc.qualeamusica.util;

import java.util.HashMap;
import java.util.Map;

import es.ufc.qualeamusica.R;


public class MapaDeMusicas {

	private Map<String, Integer> mapa;
	
	public MapaDeMusicas(){
		mapa = new HashMap<String, Integer>();
	    adicionarMusica("mais_que_um_mero_poema", R.raw.mais_que_um_mero_poema);
	    adicionarMusica("tulio", R.raw.tulio);
	}
	
	public void adicionarMusica(String nomeMusica, int enderecoMusica){
		mapa.put(nomeMusica, enderecoMusica);
	}
	
	public int retornarMusica(String nomeMusica){
		return mapa.get(nomeMusica);
	}
	
}
