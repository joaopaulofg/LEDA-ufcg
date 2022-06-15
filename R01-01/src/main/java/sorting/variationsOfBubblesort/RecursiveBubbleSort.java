package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
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
			withRecursivity(array, array.length);
		}
	}

	public void withRecursivity(T[] arr, int n) {

		if(n == 1){
			return;
		}

		for(int i = 0; i < n - 1; i++){
			if(arr[i].compareTo(arr[i + 1]) > 0){
				Util.swap(arr, i, i+1);
			}
		}

		withRecursivity(arr, n - 1);
	}
}