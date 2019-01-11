package algorithms;

public class MyQuickSort {
    static int[] arr;
    static int arraySize;

    public MyQuickSort(int size) {
        this.arraySize= size;
        generateRandomArray();
    }

    private void generateRandomArray() {
        arr= new int[arraySize];
        for (int i=0; i<arraySize; i++){
            arr[i]= (int)((Math.random()*100)*(Math.random()*10));
        }
    }

    public void quickSort( int left , int right){
        if (right<=left)
            return;
        int pivot= arr[right];
        int pivotPosition= partition(left, right, pivot);
        System.out.println("Calling quickSort1");
        quickSort(left, pivotPosition-1);
        System.out.println("Calling quickSort2");
        quickSort(pivotPosition+1, right);
    }
    private static int partition(int left, int right, int pivot){
        int leftPointer= left-1;
        int rightPointer=right;
        while(true){
            while (arr[++leftPointer]<pivot) System.out.println("leftPointer: "+leftPointer);
            //printTheArray(leftPointer, rightPointer);
            while (rightPointer>0 && arr[--rightPointer]>pivot);
            //printTheArray(leftPointer, rightPointer);
            if (rightPointer<=leftPointer){
                //System.out.println(rightPointer+"<="+leftPointer+" so start again!");
                break;
            }else{
                swapValues(leftPointer, rightPointer);
                //System.out.println(arr[leftPointer]+" swapped with: "+ arr[rightPointer]);
            }
        }
        swapValues(leftPointer, right);
        return leftPointer;
    }

    private static void swapValues(int leftPointer, int rightPointer) {
        int temp=arr[leftPointer];
        arr[leftPointer]= arr[rightPointer];
        arr[rightPointer]=temp;
        return;
    }

    private static void printTheArray(int i, int j) {
        for (int n = 0; n < (6*arraySize+1); n++)
        System.out.print("-");
        System.out.println();
        for (int n = 0; n < arraySize; n++) {
            System.out.format("| %4s " + " ", n);
        }
        System.out.println("|");
        for (int n = 0; n < 61; n++)
        System.out.print("-");
        System.out.println();
        for (int n = 0; n < arraySize; n++) {
            System.out.print(String.format("| %4s " + " ", arr[n]));
        }
        System.out.println("|");
        for (int n = 0; n < 6*arraySize+1; n++)
        System.out.print("-");
        System.out.println();
        if (i != -1) {
            // Number of spaces to put before the F
            int spacesBeforeFront = 6 * (i + 1) - 5;
            for (int k = 0; k < spacesBeforeFront; k++)
            System.out.print(" ");
            System.out.print("L" + i);
            // Number of spaces to put before the R
            int spacesBeforeRear = 5 * (j + 1) - spacesBeforeFront;
            for (int l = 0; l < spacesBeforeRear; l++)
            System.out.print(" ");
            System.out.print("R" + j);
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        MyQuickSort myQuickSort= new MyQuickSort(500);
        long start = System.currentTimeMillis();
        myQuickSort.quickSort(0, arr.length-1);
        System.out.println("Time taken: "+(System.currentTimeMillis()-start));
        printTheArray(0,arraySize);
    }
}
