package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (array.length == 0){

			return;

		} else {

			withRecursivity(array, array.length - 1, 0, 1);

		}
	}

	private void withRecursivity(T[] arr, int n, int i, int j) {

		if (i == n) {
			return;
		}

		if (arr[i].compareTo(arr[j]) > 0) {
			Util.swap(arr, i, j);
		}

		if (j == n) {
			withRecursivity(arr, n, i + 1, i + 2);
		} else {
			withRecursivity(arr, n, i, j + 1);
		}
	}
}