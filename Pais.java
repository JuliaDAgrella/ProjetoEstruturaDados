package applications;

public class Pais {
	
	//Perguntar se precisa separar as variaveis
	String sigla,pais;
	int qtdeTitulos,qtdeShows,qtdeFilmes;
	double tarifaBasica,tarifaStandard,tarifaPremium;

	
	Pais() {
	}
	
	Pais(String sigla, String pais, int qtdeTitulos, int qtdeShows, int qtdeFilmes, double tarifaBasica,
			double tarifaStandard, double tarifaPremium) {
		super();
		this.sigla = sigla;
		this.pais = pais;
		this.qtdeTitulos = qtdeTitulos;
		this.qtdeShows = qtdeShows;
		this.qtdeFilmes = qtdeFilmes;
		this.tarifaBasica = tarifaBasica;
		this.tarifaStandard = tarifaStandard;
		this.tarifaPremium = tarifaPremium;
	}

 
	public void CarregarArquivo() {
		System.out.println(sigla + " - " + pais + " - " + qtdeTitulos +  " - " + qtdeShows +
				" - " + qtdeFilmes + " - " + tarifaBasica + " - " + tarifaStandard + " - " + tarifaPremium);
	}
	
	
}
		

	
	/*public int getQtdeShows() {
		return qtdeShows;
	}

	public void setQtdeShows(int qtdeShows) {
		this.qtdeShows = qtdeShows;
	}

	public int getQtdeFilmes() {
		return qtdeFilmes;
	}

	public void setQtdeFilmes(int qtdeFilmes) {
		this.qtdeFilmes = qtdeFilmes;
	}


	public double getTarifaBasica() {
		return tarifaBasica;
	}

	public void setTarifaBasica(double tarifaBasica) {
		this.tarifaBasica = tarifaBasica;
	}


	public double getTarifaStandard() {
		return tarifaStandard;
	}


	public void setTarifaStandard(double tarifaStandard) {
		this.tarifaStandard = tarifaStandard;
	}

	public double getTarifaPremium() {
		return tarifaPremium;
	}


	public void setTarifaPremium(double tarifaPremium) {
		this.tarifaPremium = tarifaPremium;
	}

	public int getQtdeTitulos() {
		return qtdeTitulos;
	}


	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public int setQtdeTitulos() {
		return qtdeTitulos;
	}
	
	public void setQtdeTitulos(int qtdeTitulos) {
		this.qtdeTitulos = qtdeTitulos;
	}*/
	

	
	

