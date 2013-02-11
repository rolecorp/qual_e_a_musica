package es.ufc.qualeamusica.model;

import java.io.Serializable;

public class LetrasMusica implements Serializable{
	
	private String nomeMusica;
	private String trechoLetra;
	private String respostaCerta;
	private String respostaErrada1;
	private String	respostaErrada2;
	private String respostaErrada3;
	
	
	public String getNomeMusica() {
		return nomeMusica;
	}
	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}
	public String getTrechoLetra() {
		return trechoLetra;
	}
	public void setTrechoLetra(String trechoLetra) {
		this.trechoLetra = trechoLetra;
	}
	public String getRespostaCerta() {
		return respostaCerta;
	}
	public void setRespostaCerta(String respostaCerta) {
		this.respostaCerta = respostaCerta;
	}
	public String getRespostaErrada1() {
		return respostaErrada1;
	}
	public void setRespostaErrada1(String respostaErrada1) {
		this.respostaErrada1 = respostaErrada1;
	}
	public String getRespostaErrada2() {
		return respostaErrada2;
	}
	public void setRespostaErrada2(String respostaErrada2) {
		this.respostaErrada2 = respostaErrada2;
	}
	public String getRespostaErrada3() {
		return respostaErrada3;
	}
	public void setRespostaErrada3(String respostaErrada3) {
		this.respostaErrada3 = respostaErrada3;
	}

}
