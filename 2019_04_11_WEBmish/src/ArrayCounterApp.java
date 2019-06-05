import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ArrayCounterApp {

    private static final int SIZE = 10000000;

    public static void main(String[] args) {
        int [] arr = randomArray();
        ArrayCounter arrayCounter = new ArrayCounter(arr,0,arr.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer num = forkJoinPool.invoke(arrayCounter);

        System.out.println("Number of even numbers: " + num);

    }

    private static int[] randomArray() {
        int []  ints = new int[SIZE];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt(100);
        }
        return ints;
    }




}
