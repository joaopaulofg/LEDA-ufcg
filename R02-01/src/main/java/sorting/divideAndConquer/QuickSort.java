package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		boolean arrayValido = validacao(array, leftIndex, rightIndex);

		if(arrayValido){
			int pivot = quick(array, leftIndex, rightIndex);

			sort(array, leftIndex, pivot-1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private int quick(T[] array, int leftIndex, int rightIndex) {

		int inicio = leftIndex + 1;
		int fim = rightIndex;

		while(inicio <= fim) {
			if(array[inicio].compareTo(array[leftIndex]) <= 0){
				inicio++;
			} else if(array[leftIndex].compareTo(array[fim]) < 0){
				fim--;
			} else{
				Util.swap(array, inicio, fim);
				inicio++;
				fim--;
			}
		}

		Util.swap(array, leftIndex, fim);

		return fim;
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
