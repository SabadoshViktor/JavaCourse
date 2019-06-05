import java.util.concurrent.RecursiveTask;

public class ArrayCounter extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 100000;

    private int [] array;
    private int start;
    private int end;

    public ArrayCounter(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start < THRESHOLD){
            return computeDirectly();
        }

        int middle = start + (end -start) / 2;

        ArrayCounter left = new ArrayCounter(array, start, middle);
        ArrayCounter right = new ArrayCounter(array, middle + 1, end);

        invokeAll(left, right);

        return left.join() + right.join();
    }

    private Integer computeDirectly(){
        int count = 0;

        for (int i = start; i < end; i++) {
            if(array[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
