package applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Vetor {
	Pais[]A;
	int capacity;
	int size;
	
	
	public Vetor(int capacity) {
        A = new Pais[capacity];
        this.size = 0;
        this.capacity = capacity;
    }
	
	 public boolean isEmpty() {
	        //verifica se o Vetor está vazio ou não
	        if (size==0)
	            return true;
	        else
	            return false;
	 }
	 
	 public boolean isFull() {
	        //verifica se o Vetor está cheio
	        if (size==capacity)
	            return true;
	        else
	            return false;            
	  }
	 
	 public Pais get(int i) throws Exception {
	        // retorna o elemento da posição i
	        if (i<0 || i>=size)
	            throw new Exception("Posição inválida!!");
	        return A[i];
	    }
	 
	 public void set(int i, Pais n) throws Exception {
	        //substitui o conteúdo da posição i por n
	        if (i<0 || i>=size)
	            throw new Exception("Posição inválida!!");
	        A[i]=n;
	    }
	 
	 public void add(int i, Pais n) throws Exception {
	        //adiciona o elemento n na posição i
	        if (isFull()) {
	            throw new Exception("A lista está cheia!! Impossível inserir");
	        }
	        if (i<0 || i > size) {
	            throw new Exception("Posição inválida!!");
	        }
	        for (int p = size; p > i; p--) {
	            A[p] = A[p - 1];
	        }
	        A[i] = n;
	        size++;
	    }
	 
	 public int search(String n) {
	        // busca o valor n na lista - retornando a posição ou -1, se não existir
	        for (int i=0;i<size;i++)
	            if (A[i].pais==n)
	                return i;
	        return -1;
	    }
	 
	 public void show() {
	        // mostra todo o conteúdo da lista
	        for (int i=0;i<size;i++)
	           A[i].CarregarArquivo();
	        
	       System.out.println("\nFim da lista!!");
	    }
	 
	 public void bubbleSortPremium() {
			//
	        int n = size;
	        boolean trocado;
	        for (int i = 0; i < n - 1; i++) {
	            trocado = false;
	            for (int j = 0; j < n - i - 1; j++) {
	                if (A[j].tarifaPremium < A[j + 1].tarifaPremium) {
	                    Pais temp = A[j];
	                    A[j] = A[j + 1];
	                    A[j + 1] = temp;
	                    trocado = true;
	                }
	            }
	            if (!trocado) {
	                break;
	            }
	        }
	    }

		public void mostrarPaisesOrdenados() {
			// ordena países em ordem de tarifa básica usando Merge Sort
			if (size <= 1) {
				return;
			}
			Pais[] tempArray = Arrays.copyOf(A, size);
			mergeSort(tempArray, 0, size - 1);
	
			System.out.println("-------------------------------");
			System.out.println("\nPaíses ordenados por tarifa básica em ordem crescente:");
			for (Pais pais : tempArray) {
				pais.CarregarArquivo();
			}
		}
	
		private void mergeSort(Pais[] array, int esquerda, int direita) {
			if (esquerda < direita) {
				int meio = esquerda + (direita - esquerda) / 2;
				mergeSort(array, esquerda, meio);
				mergeSort(array, meio + 1, direita);
				merge(array, esquerda, meio, direita);
			}
		}
	
		private void merge(Pais[] array, int esquerda, int meio, int direita) {
			int n1 = meio - esquerda + 1;
			int n2 = direita - meio;
	
			Pais[] esquerdaArray = new Pais[n1];
			Pais[] direitaArray = new Pais[n2];
	
			for (int i = 0; i < n1; i++) {
				esquerdaArray[i] = array[esquerda + i];
			}
			for (int j = 0; j < n2; j++) {
				direitaArray[j] = array[meio + 1 + j];
			}
	
			int i = 0, j = 0, k = esquerda;
			while (i < n1 && j < n2) {
				if (esquerdaArray[i].tarifaBasica <= direitaArray[j].tarifaBasica) {
					array[k++] = esquerdaArray[i++];
				} else {
					array[k++] = direitaArray[j++];
				}
			}
	
			while (i < n1) {
				array[k++] = esquerdaArray[i++];
			}
	
			while (j < n2) {
				array[k++] = direitaArray[j++];
			}
		}

		public void compararPrecos() {
			//compara preço entre dois países
			Scanner scanner = new Scanner(System.in);
			System.out.print("Digite a sigla do primeiro país: ");
			String sigla1 = scanner.nextLine().toUpperCase(); // Converter para maiúsculas
			System.out.print("Digite a sigla do segundo país: ");
			String sigla2 = scanner.nextLine().toUpperCase(); // Converter para maiúsculas
	
			Pais pais1 = null;
			Pais pais2 = null;
	
			for (int i = 0; i < size; i++) {
				if (A[i].sigla.equalsIgnoreCase(sigla1)) {
					pais1 = A[i];
				}
				if (A[i].sigla.equalsIgnoreCase(sigla2)) {
					pais2 = A[i];
				}
			}
	
			if (pais1 == null || pais2 == null) {
				if (pais1 == null) {
					System.out.println("País com a sigla " + sigla1 + " não encontrado.");
				}
				if (pais2 == null) {
					System.out.println("País com a sigla " + sigla2 + " não encontrado.");
				}
			} else {
				System.out.println("-------------------------------");
				System.out.println("\nComparação de preços entre " + pais1.pais + " e " + pais2.pais + ":");
				System.out.printf("%s - Tarifa Básica: %.2f, Tarifa Standard: %.2f, Tarifa Premium: %.2f\n",
						pais1.pais, pais1.tarifaBasica, pais1.tarifaStandard, pais1.tarifaPremium);
				System.out.printf("%s - Tarifa Básica: %.2f, Tarifa Standard: %.2f, Tarifa Premium: %.2f\n",
						pais2.pais, pais2.tarifaBasica, pais2.tarifaStandard, pais2.tarifaPremium);
			}
		}
	 
	 	public void calcularEstatisticas() {
	        if (!isEmpty()) {
	            double somaBasica = 0;
	            double somaStandard = 0;
	            double somaPremium = 0;
	            int somaTitulos = 0;

	            for (int i = 0; i < size; i++) {
	                Pais pais = A[i];
	                somaBasica += pais.tarifaBasica;
	                somaStandard += pais.tarifaStandard;
	                somaPremium += pais.tarifaPremium;
	                somaTitulos += pais.qtdeTitulos;
	            }

	            double mediaBasica = somaBasica / size;
	            double mediaStandard = somaStandard / size;
	            double mediaPremium = somaPremium / size;
	            double mediaTitulos = (double) somaTitulos / size;

	            System.out.println("\nEstatísticas:");
	            System.out.printf("Média da Tarifa Básica: %.2f\n", mediaBasica);
	            System.out.printf("Média da Tarifa Standard: %.2f\n", mediaStandard);
	            System.out.printf("Média da Tarifa Premium: %.2f\n", mediaPremium);
	            System.out.printf("Média da Quantidade de Títulos: %.2f\n", mediaTitulos);
	        } else {
	            System.out.println("Não há dados para calcular as estatísticas.");
	        }
	    }
}


	 