public class Main {
    public static void main(String[] args) {

        String str = "1203004056";
        stringToArray(str);
        int[] res = stringToArray(str);
        for (int i = 0; i < res.length; i++) {
            //		System.out.print(res[i]);
        }
        int [] res2 = sortBasedOnZero(res);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res[i]);
        }

    }
    public static int[] stringToArray(String str) {
        String [] words = str.split("");
        int size = words.length;
        int [] arr = new int [size ];
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(words[i]);
        }
        return arr;

    }

    private static int[] sortBasedOnZero(int[] arr) {
        int k=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                k++;
            }
        }
        return arr;
    }
    public static void mutate(String input){
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '0') {

            }
        }
    }

}

