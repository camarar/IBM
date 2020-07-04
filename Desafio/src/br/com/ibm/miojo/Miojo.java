package br.com.ibm.miojo;
import java.util.Scanner;
import java.lang.Math;


public class Miojo {
	
	final static int LIMITE_TEMPO = 5000;

	private static int tempoPreparo (int t, int a, int b) {
    	int x = 0;
    	int y = 0;
    	int contA = 0;
    	int contB = 0;
    	int tempoTotal;
    	
    	
    	do {
			if (x == 0) {
				x = a; contA ++;
			}	
			if (y == 0) {
				y = b; contB ++;
			}
			
			if(x > y) {
				x = x - y; y = 0;
			}
			else {
				y = y - x; x = 0;
			}
			
			if(x == t) {
				break;
			}
			
			if (y == t) {
				break;
			}
			
			if ( (a * contA >= LIMITE_TEMPO) || (b * contB >= LIMITE_TEMPO)) {
				System.out.println("Infelizmente atingimos o limite de tempo possível para calcular o tempo exato de preparo do Miojo.");
				break;				
			}
			
		} while (true);
    	
    	
    	if ( (a * contA == LIMITE_TEMPO) || (b * contB == LIMITE_TEMPO)) {
    		

    		tempoTotal = 0;			
		}else {
			tempoTotal = Math.max(a * contA, b * contB);
		}
    	
    	return tempoTotal ;
    }

	public static void main(String[] args) {
		int tempoTotal;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o tempo de preparo do Miojo: ");
		int tempoMiojo = scanner.nextInt();
		
		System.out.print("Informe o tempo da primeira ampulheta: ");
		int ampulheta1 = scanner.nextInt();
		
		System.out.print("Informe o tempo da segunda ampulheta: ");
		int ampulheta2 = scanner.nextInt();
		
		if (tempoMiojo == ampulheta1 || tempoMiojo == ampulheta2) {
			
			System.out.println("O tempo total para o preparo é : " + tempoMiojo + " minutos");
		}else if (ampulheta1 == ampulheta2) {
			System.out.println("O tempo total para o preparo do Miojo não será possível calcular pois as ampulhetas são do mesmo tempo!");
		}else {
			
			tempoTotal = tempoPreparo(tempoMiojo, ampulheta1, ampulheta2);
			
			if (tempoTotal == 0) {
				System.out.println("O tempo total para o preparo do Miojo não será possível calcular o tempo exato com as ampulhetas disponíveis!");
			}else {
    			System.out.println("O tempo total para o preparo é : " + tempoTotal + " minutos");
			}

		}
		
		scanner.close();

	}

}
