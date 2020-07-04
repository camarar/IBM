package br.com.ibm.assassino;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Assassino {
	
	static String[] suspeitos = Crime.getSuspeitos();
	static String[] locais = Crime.getLocais();
	static String[] armas = Crime.getArmas();
	
	private static String[] cenaCrime() {
		String[] crime = new String[3];
		String suspeito = null;
		String local = null;
		String arma = null;
		
		int rndSuspeitosCrime = new Random().nextInt(suspeitos.length);
		suspeito = suspeitos[rndSuspeitosCrime];
		
		int rndLocaisCrime = new Random().nextInt(locais.length);
		local = locais[rndLocaisCrime];
	    
	    int rndArmasCrime = new Random().nextInt(armas.length);
	    arma = armas[rndArmasCrime];
	    
	    crime[0] = suspeito;
	    crime[1] = local;
	    crime[2] = arma;
		
		
		return crime;	
	}
	
	public static String[] criarTeoria() {
		String[] teoria = new String[3];
		String suspeito = null;
		String local = null;
		String arma = null;
		
		int rndSuspeitosTeoria = new Random().nextInt(suspeitos.length);
		suspeito = suspeitos[rndSuspeitosTeoria];
		
		int rndLocaisTeoria = new Random().nextInt(locais.length);
		local = locais[rndLocaisTeoria];
	    
	    int rndArmasTeoria = new Random().nextInt(armas.length);
	    arma = armas[rndArmasTeoria];
	    
	    teoria[0] = suspeito;
	    teoria[1] = local;
	    teoria[2] = arma;
	    
		return teoria;
	}
	
	
	
	public static String[] criarTeoria(String[] teoria, int chute) {
		
		switch (chute) {
		case 1:
			suspeitos = removeElemento(suspeitos, getElemento(suspeitos, teoria[0]));
			int rndSuspeitosTeoria = new Random().nextInt(suspeitos.length);
			teoria[0] = suspeitos[rndSuspeitosTeoria];
			break;
		case 2:			
			locais = removeElemento(locais, getElemento(locais, teoria[1]));
			int rndLocaisTeoria = new Random().nextInt(locais.length);
			teoria[1] = locais[rndLocaisTeoria];
			break;
		case 3:
			armas = removeElemento(armas, getElemento(armas, teoria[2]));
			int rndArmasTeoria = new Random().nextInt(armas.length);
			teoria[2] = armas[rndArmasTeoria];
			break;
		default:
			break;
		}
	    
		return teoria;
	}
	
	public static int getElemento( String[] arr, String valor ){
		int index;
        List<String> tempList = new ArrayList<String>(Arrays.asList(arr));
        index = tempList.indexOf(valor);
        return index;
    }
	
	public static String[] removeElemento( String[] arr, int index ){
        List<String> tempList = new ArrayList<String>(Arrays.asList(arr));
        tempList.remove(index);
        return (String[]) tempList.toArray(new String[tempList.size()]);
    }
	
	public static int averiguarTestemunha(String[] teoria, String[] crime) {
		ArrayList<Integer> codigoTestemunha = new ArrayList<Integer>();
		
		int CRIME_SOLUCIONADO = 0;
		int SUSPEITO_ERRADO = 1;
		int LOCAL_ERRADO = 2;
		int ARMA_ERRADA = 3;

		if (teoria[0] != crime[0]) {
			codigoTestemunha.add(SUSPEITO_ERRADO);
		}
		
		if (teoria[1] != crime[1]) {
			codigoTestemunha.add(LOCAL_ERRADO);
		}
		
		if (teoria[2] != crime[2]) {
			codigoTestemunha.add(ARMA_ERRADA);
		}
		
		if (codigoTestemunha.size() == 0) {
			codigoTestemunha.add(CRIME_SOLUCIONADO);
		}
		
		int rndcodigoTestemunha = new Random().nextInt(codigoTestemunha.size());
		
		return codigoTestemunha.get(rndcodigoTestemunha);
	}
	
	public static void main(String[] args) {
		
		int retorno;
		int contTeoria = 0;
		
		String[] crime = cenaCrime();
		System.out.println("Crime: " + crime[0] + " - " + crime[1] + " - " + crime[2]);
		System.out.println("-----------------------------------------------------");
		String[] teoria = criarTeoria();
		System.out.println("Teoria 1: " + teoria[0] + " - " + teoria[1] + " - " + teoria[2]);
		
		boolean solucionado = false;
		
		do {
			contTeoria ++;
			retorno = averiguarTestemunha(teoria, crime);
	
			if (retorno == 0) {
				solucionado = true;
			}else {
				teoria = criarTeoria(teoria, retorno);
				System.out.println("Teoria "+ contTeoria +": " + teoria[0] + " - " + teoria[1] + " - " + teoria[2]);
			}
		} while (solucionado == false);
		
		System.out.println("-----------------------------------------------------");
		System.out.println("O caso foi solucionado em " + contTeoria + " teorias.");

	}

}
