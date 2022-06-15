package sorting.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean arrayValido = validacao(array, leftIndex, rightIndex);

		if(arrayValido){
			hybridMergeSort(array, leftIndex, rightIndex);
		}

	}

	private void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {

		MERGESORT_APPLICATIONS ++;

		if(leftIndex < rightIndex){
			
			int meio = (leftIndex + rightIndex) / 2;

			if(array.length > SIZE_LIMIT) {
				hybridMergeSort(array, leftIndex, meio);
				hybridMergeSort(array, meio + 1, rightIndex);

				merge(array, leftIndex, rightIndex, meio);

			} else {
				insertionSort(array, leftIndex, meio);
				insertionSort(array, meio + 1, rightIndex);

				merge(array, leftIndex, rightIndex, meio);
			}
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {

		INSERTIONSORT_APPLICATIONS++;

		int n = (rightIndex - leftIndex) + 1;

		for (int j = leftIndex + 1; j < n; j++) {

			T chave = array[j];

			int i = j - 1;

			while (i >= 0 && (array[i].compareTo(chave) > 0)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = chave;
		}
	}

	private void merge(T[] array, int leftIndex, int rightIndex, int meioIndex) {

		T[] auxiliar = Arrays.copyOf(array, array.length);

		int primeiro = leftIndex;
		int inicio = leftIndex;
		int meio = meioIndex + 1;


		while (inicio <= meioIndex && meio <= rightIndex) {

			if (auxiliar[meio].compareTo(auxiliar[inicio]) > 0) {
				array[primeiro] = auxiliar[inicio];
				inicio++;
			} else {
				array[primeiro] = auxiliar[meio];
				meio++;
			}
			primeiro++;
		}

		while (inicio <= meioIndex) {
			array[primeiro] = auxiliar[inicio];
			inicio++;
			primeiro++;
		}

		while (meio <= rightIndex) {
			array[primeiro] = auxiliar[meio];
			meio++;
			primeiro++;
		}
	}

	private boolean validacao(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		if (leftIndex < 0 || rightIndex < 0)
			return false;
		if (leftIndex >= rightIndex)
			return false;
		if (rightIndex >= array.length)
			return false;
		
		return true;
	}
}
