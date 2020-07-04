package br.com.ibm.assassino;
public class Crime {
	
	static String[] suspeitos = {"Charles B. Abbage", "Donald Duck Knuth", "Ada L. Ovelace", "Alan T. Uring", "Ivar J. Acobson", "Ras Mus Ler Dorf"};
	
	static String[] locais = {"Redmond", "Palo Alto", "San Francisco", "Tokio", "Restaurante no Fim do Universo", "São Paulo", "Cupertino", "Helsinki", "Maida Vale", "Toronto"};
	
	static String[] armas = {"Peixeira", "DynaTAC 8000X", "Trezoitão", "Trebuchet", "Maça", "Gládio"};	
	
	
	public static String[] getSuspeitos() {
		return suspeitos;
	}

	public static void setSuspeitos(String[] suspeitos) {
		Crime.suspeitos = suspeitos;
	}

	public static String[] getLocais() {
		return locais;
	}

	public static void setLocais(String[] locais) {
		Crime.locais = locais;
	}

	public static String[] getArmas() {
		return armas;
	}

	public static void setArmas(String[] armas) {
		Crime.armas = armas;
	}
	
	

}
