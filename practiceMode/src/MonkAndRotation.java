import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MonkAndRotation {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }

    public static void main(String args[] ) throws Exception {
        Reader reader=new Reader();
        PrintWriter pw=new PrintWriter(System.out);
        byte t= (byte) reader.nextInt();
        while(t!=0){
            int n=reader.nextInt();
            int k=reader.nextInt();
            int[] finalArray=new int[n];
            if (k>=n)
                k=k%n;
            for(int i=0; i<n; i++){
                finalArray[i]=reader.nextInt();
            }
            for (int i=n-k,j=0; j<n; i++,j++){
                if (i>=n){
                    i=i%n;
                }
                pw.print(finalArray[i]+" ");
            }
            pw.println();
            t--;
        }
        pw.flush();
    }
    /*static int[] rotateAndPrint(int n, int k,Reader reader) throws IOException {
        int[] tempArray=new int[n-k];
        int[] finalArray= new int[n];
        for (int i=0; i<n; i++){
            if (i>=n-k)
                finalArray[i-n+k]=reader.nextInt();
            else {
                tempArray[i]=reader.nextInt();
            }
        }
        for (int i=k, j=0; i<n; i++, j++)
            finalArray[i]=tempArray[j];
        return finalArray;
    }*/
}
/*
*
* */
