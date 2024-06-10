package test;


/*
 * el metodo run llama al metodo hideSort contenido en 
 * ParallelizedCountingSort y al main contenido en DefaultCountingSort
 */
public class RunSort {
	
    public static void main(String[] args) {
        ParallelizedCountingSort.hideSort();
        DefaultCountingSort.main(args);
    }
}