package test;


import java.util.concurrent.ThreadLocalRandom;


public class DefaultCountingSort {
	private static final int N_ITEMS = 30_000_000;
	
	//private static final int N_ITEMS = 20_000_000;
	
	//private static final int N_ITEMS = 10_000_000;
	
	 //private static final int N_ITEMS = 1_000_000;

	 //private static final int N_ITEMS = 100_000;

	 //private static final int N_ITEMS = 10_000;

	 //private static final int N_ITEMS = 1_000;
	 
	 

    private static int MAX_VAL = 20_000;

    /**
     * este metodo chequea si el array esta sorteado de forma
     * ascendente
     */
    static boolean isSorted(int[] array){
        int prev = 0;
        for(int item: array)
            if(item >= prev)
                prev = item;
            else
                return false;
        return true;
    }

    /**
     * este metodo realiza un array 
     * This method sorts an array using a counting sort algorithm.
     *
     * @param array el array al sort
     * @param la salida del array se ingresa en sort to store the sorted elements in
     * @param count es un array auxiliar usado por cunting 
     */
    static void countSort(int[] array, int[] output, int[] count) {
        int i;
        for (i = 1; i <= N_ITEMS; i++)
            count[array[i]]++;

        for (i = 1; i <= MAX_VAL - 1; i++)
            count[i] += count[i - 1];

        for (i = N_ITEMS; i >= 1; i--) {
            output[count[array[i]]] = array[i];
            count[array[i]]--;
        }
    }

    /**
     * se  inicia un array con valores random, sorts usa el
     * metodo cuntSort, se mide el tiempo del ordenamiento y se mustra 
     * cuanto tardo y si esta sorted o no 
     */
    public static void main(String[] args) {
        var array = new int[N_ITEMS + 1];
        var output = new int[N_ITEMS + 1];
        var count = new int[MAX_VAL + 1];

        for (int i = 0; i < N_ITEMS; i++)
            array[i] = ThreadLocalRandom.current().nextInt(0, MAX_VAL);

        var t0 = System.currentTimeMillis();
        countSort(array, output, count);
        var t1 = System.currentTimeMillis();


        System.out.println("\nORDENAMIENTO SECUENCIAL TARDO: " + (t1 - t0) + " millisegundos.");
        System.out.println("Array is sorted: "+isSorted(output));
    }
}