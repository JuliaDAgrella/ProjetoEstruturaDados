package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[]args) throws Exception {
		Vetor lista = new Vetor(100);
		int opcao;
		
		
		Scanner sc = new Scanner(System.in);
		
		String path = "c:\\temp\\paises.txt";
		int cont = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while(line != null) {
				String[]dados = line.split(",");
				Pais p = new Pais();
				
				p.sigla = dados[0];
				p.pais = dados[1];
				p.qtdeTitulos = Integer.parseInt(dados[2]);
				p.qtdeShows = Integer.parseInt(dados[3]);
				p.qtdeFilmes = Integer.parseInt(dados[4]);
				p.tarifaBasica = Double.parseDouble(dados[5]);
				p.tarifaStandard = Double.parseDouble(dados[6]);
				p.tarifaPremium = Double.parseDouble(dados[7]);
				lista.add(cont,p);
				line = br.readLine();
				cont++;
			}
		}
		
		catch(IOException e) {
			System.out.println("Erro: " +e.getMessage());
		}
		
	    
	    do{
	        System.out.println("1 - Carregar dados do arquivo");
	        System.out.println("2 - Exibir os 5 países que têm a tarifa premium mais cara");
	        System.out.println("3 - Exibir todos os registros em ordem crescente de tarifa básica");
	        System.out.println("4 - Comparar preço entre dois países");
	        System.out.println("5 - Estatísticas");
	        System.out.println("6 - SAIR");
	        System.out.println("");
	        System.out.println("Digite a opção desejada: ");
	        opcao = sc.nextInt();
	        
	        switch(opcao){
	            case 1:
	            	lista.show();
	                break;
	            case 2:
	            		System.out.println();
	                break;
	           case 3:
	               break;
	           case 4:
	               break;
	           case 5:
	               break;
	           case 6:
	               break;

	           default:
	                System.out.println("Digite uma opção válida!");
	               
	        }
	           
	    }while(opcao !=6);
	   
	    sc.close();	
	}
}
