package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {

		boolean arrayValido = validacao(array, leftIndex, rightIndex);

		if(arrayValido){
			int meio = (leftIndex + rightIndex) / 2;
			medianaDeTres(array, leftIndex, rightIndex, meio);
			Util.swap(array, meio, rightIndex - 1);
			int pivotIndex = particao(array, leftIndex, rightIndex - 1);

			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int particao(T[] array, int leftIndex, int k) {

		T pivot = array[leftIndex];
        int i = leftIndex;
		
        for(int j = i + 1; j <= k; j++) {
            if(array[j].compareTo(pivot) <= 0) {
                i++;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, leftIndex, i);
        return i;
	}

	private void medianaDeTres(T[] array, int leftIndex, int rightIndex, int meio) {

		if(array[leftIndex].compareTo(array[rightIndex]) > 0)
			Util.swap(array, leftIndex, rightIndex);
		if(array[meio].compareTo(array[leftIndex]) < 0)
			Util.swap(array, meio, leftIndex);
		if(array[meio].compareTo(array[rightIndex]) > 0)
			Util.swap(array, meio, rightIndex);

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
