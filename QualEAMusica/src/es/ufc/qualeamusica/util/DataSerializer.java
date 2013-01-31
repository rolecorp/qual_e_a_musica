package es.ufc.qualeamusica.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ufc.qualeamusica.model.Ranking;



public class DataSerializer {

	private static DataSerializer instance;
	ObjectMapper objectMapper = null;
	
	private DataSerializer() {
		objectMapper = new ObjectMapper();
	}
	
	public static DataSerializer getInstance() {
		if(instance == null)
			instance = new DataSerializer();
		
		return instance;
	}

//	public String toJson(Object content) throws IOException {		
//		
////		objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL);
//		return objectMapper.writeValueAsString(content);
//	}
//		
//	public<T>  T toObject(String json, Class targetClass) throws JsonParseException, JsonMappingException, IOException {
//		return (T) objectMapper.readValue(json, targetClass);	
//	}
	
	public String converterListaRankingParaJson(List<Ranking> r) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); //ObjectMapper é uma classe da biblioteca Jackson
		return mapper.writeValueAsString(r); //Este metodo irá retornar o JSON da variável "p".
	}
	
	public List<Ranking> converterJSONParaListaRanking(String json) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Log.d("Metodo" , "ENTROU");
		ArrayList<Ranking> lista = mapper.readValue(json,new TypeReference< List<Ranking> >(){});
		Log.d("Retorno da Lista ",lista.get(0).getNomeUsuario());
		return lista; //Método utilizado para ler o json e retornar a instância da classe.
	}
	
}
