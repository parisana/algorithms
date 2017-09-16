package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

class Heap{
    private Data[] theHeap;
    private int itemsInArray= 0;
    private  int maxSize;
    public Heap(int maxSize){
        this.maxSize= maxSize;
        theHeap= new Data[maxSize];
    }
    public void insert(int index, Data newData){
        theHeap[index]= newData;
        //itemsInArray++; //incrementing done in increment method
    }
    public void incrementNoItemsInArray(){
        itemsInArray++;
    }
    public Data pop(){
        Data dataToBePopped= null;
        if (itemsInArray!=0){
            dataToBePopped= theHeap[0];
            theHeap[0]=theHeap[--itemsInArray];
            heapify(0);
        }
        return dataToBePopped;
    }

    private void heapify(int index) {
        int indexOfLargest;
        Data root= theHeap[index];
        int indexOfLeft;
        int indexOfRight;
        while(index<itemsInArray/2){
            indexOfLeft= 2*index+1;
            indexOfRight= indexOfLeft+1;
            if (indexOfRight<itemsInArray && theHeap[indexOfLeft].key<theHeap[indexOfRight].key){
                indexOfLargest=indexOfRight;
            }else indexOfLargest= indexOfLeft;
            if (root.key>= theHeap[indexOfLargest].key)
                return;
            theHeap[index]=theHeap[indexOfLargest];
            index= indexOfLargest;
        }
        theHeap[index]=root;
    }
    //heap sort by making a new heap (don't make changes to the original heap)
    private void heapSort(){
        Data largestNode;
        Heap sortedHeap= new Heap(maxSize);
        sortedHeap.theHeap=theHeap.clone();
        sortedHeap.maxSize= this.maxSize;
        sortedHeap.itemsInArray= this.itemsInArray;
        for (int i=maxSize-1; i>=0; i--){
            largestNode= sortedHeap.pop();
            sortedHeap.insert(i, largestNode);
        }
        System.out.println(Arrays.toString(sortedHeap.theHeap));
    }

    public void generateRandomArray(int randomNum){
        Data randomData;
        for(int i=0; i<this.maxSize; i++){
            randomData= new Data((int)(Math.random()*randomNum)+1);
            this.insert(i, randomData);
            incrementNoItemsInArray();
        }
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Heap newHeap= new Heap(8);
        newHeap.generateRandomArray(977);
        /*System.out.println("Initial Array: \n**************");
        newHeap.printTree();
        System.out.println("--------------After heapify--------------");*/
        for(int i=newHeap.maxSize/2-1; i>=0; i--){
            newHeap.heapify(i);
        }
        System.out.println("Heap after heapify");
        System.out.println(Arrays.toString(newHeap.theHeap));
        System.out.println();
        //newHeap.printTree();
        System.out.println("Heap after sorting");
        newHeap.heapSort();
        System.out.println();
        System.out.println("The original heap");
        System.out.println(Arrays.toString(newHeap.theHeap));
        System.out.println(System.currentTimeMillis()-start);
    }
    private void printTree() {
        int spaces=0;
        int n=1;
        int noOfRows= 32-Integer.numberOfLeadingZeros(maxSize);//maxSize 1 greater than largest index so its fine.
        System.out.println("noOfRows: "+noOfRows);
        int[] indent= getIndentArray(noOfRows);
        while(n<=noOfRows){
            int firstIndex=(int) (Math.pow(2, n-1)-1);// the first index of each row
            int itemsPerRow= firstIndex+1;
            int lastIndex= firstIndex+itemsPerRow;  //lastIndex of a row
            for(int i=0; i<indent[n-1]; i++){
                System.out.print("  ");
            }
            for (int i=firstIndex; i<lastIndex ; i++){
                if (i<itemsInArray)
                System.out.printf("%02d",theHeap[i].key);
                for (int j=0; j<spaces; j++)
                    System.out.print("  ");
            }
            spaces=indent[n-1];
            n++;
            System.out.println();
        }
    }
    public int[] getIndentArray(int rows){
        int[] indentArray= new int[rows];
        for(int i=0; i<rows; i++){
            indentArray[i]=(int) Math.abs(Math.pow(2, i)-1);
        }
        Arrays.sort(indentArray);
        indentArray= reverseArray(indentArray);
        return indentArray;
    }

    private int[] reverseArray(int[] intArray) {
        int leftIndex= 0;
        int rightIndex= intArray.length-1;
        //if left==right leave it be.
        while(leftIndex<rightIndex){
            int temp= intArray[leftIndex];
            intArray[leftIndex]=intArray[rightIndex];
            intArray[rightIndex]= temp;

            rightIndex--;
            leftIndex++;
        }
        return intArray;
    }

    private class Data {
        public int key;
        public Data(int key) {
            this.key = key;
        }
        public String toString(){
            return key+" ";
        }
    }
}
