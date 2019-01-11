package Array1D;

import java.io.IOException;

public class MergeSortUsingArrays {
    public static void main(String[] args) throws IOException {
        int[] mergeArr={2,3,4,5,5,6,7,88};
        divideArray(mergeArr, 0, 7);
        System.out.println();
        for (int e: mergeArr){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    private static void divideArray(int[] arrayToDivide, int start,int end){
        if (start<end) {
            int mid = (end + start) / 2;
            System.out.println("call to divideArray()!**********************start:"+start+"***end:"+end+"*******************");
            divideArray(arrayToDivide, start, mid);
            divideArray(arrayToDivide, mid + 1, end);
            merge(arrayToDivide, start, mid, end);
        }
    }
    private static void merge(int[] aArr, int start, int mid, int end){
        System.out.println("Call to merge()!*********start:"+start+"******end: "+end+"**********");
        int p=start, q=mid+1;
        int[] finalArr=new int[end-start+1];
        int k=0;
        for (int i=start; i<end; i++){
            if (p>mid){
                finalArr[k++]=aArr[q++];
            }
            else if (q>end){
                finalArr[k++]=aArr[p++];
            }
            else if (aArr[p]<aArr[q]){
                finalArr[k++]=aArr[p++];
            }else if(aArr[q]<aArr[p]){
                finalArr[k++]=aArr[q++];
            }
        }for (int i=0; i<k; i++){
            aArr[start++]=finalArr[i];
        }
    }
}