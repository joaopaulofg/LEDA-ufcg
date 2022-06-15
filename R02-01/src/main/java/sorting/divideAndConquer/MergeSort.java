package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		boolean arrayValido = validacao(array, leftIndex, rightIndex);

		if(arrayValido){

			int meio = (rightIndex + leftIndex) / 2;

			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);

			merge(array, leftIndex, rightIndex, meio);
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
