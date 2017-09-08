package Array1D;

import java.io.*;
import java.util.*;

class LastOccurence {
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
    static int MOD=(int)(1e9+7);
    public static void main(String args[] ) throws Exception {
        Reader reader = new Reader();
        PrintWriter pw= new PrintWriter(System.out);
        int t = reader.nextInt();
        while (t-->0){
            int n= reader.nextInt();
            pw.println(myMethod(n, reader));
        }
        pw.close();
    }
    public static String myMethod(int n, Reader reader) throws IOException {
        int[] arr=new int[100001];
        Arrays.fill(arr, -1);
        StringBuilder answer=new StringBuilder();
        for (int i=0; i<n; i++){
            int temp=reader.nextInt();
            arr[temp]=i+1;
        }
        int q=reader.nextInt();
        //System.out.println("q: "+q);
        while (q-->0){
            int x=reader.nextInt();
            answer.append((arr[x]==-1?-1:arr[x]) + "\n");
        }
        return String.valueOf(answer);
    }
}