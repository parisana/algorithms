package Array1D;

import java.io.*;
import java.util.*;

class WeightingTheStones {
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
        int t= reader.nextInt();
        while (t>0) {
            byte n= (byte) reader.nextInt();
            pw.println(weightTheStones(n, reader));
            t--;
        }
        pw.flush();
    }
    private static String weightTheStones(byte n, Reader reader) throws IOException {
        Map<Byte,Integer> mapA=new HashMap<>();
        Map<Byte,Integer> mapB=new HashMap<>();
        byte aHighest=0;
        byte bHighest=0;
        int aCount=0;
        int bCount=0;
        int aKey=0;
        int bKey=0;
        for (byte i=0; i<n;i++){
            byte temp= (byte) reader.nextInt();
            if (!mapA.containsKey(temp)){
                mapA.put(temp,1);
                if (temp>aHighest)
                    aHighest=temp;
            }else{
                int value= mapA.get(temp);
                mapA.replace(temp, value, ++value);
                if (value>aCount|| (value>=aCount && temp>aKey) ) {
                    aCount = value;
                    aKey=temp;
                }
            }
        }
        for (byte i=0; i<n;i++){
            byte temp= (byte) reader.nextInt();
            if (!mapB.containsKey(temp)){
                mapB.put(temp,1);
                if (bHighest<temp)
                    bHighest=temp;
            }else{
                int value= mapB.get(temp);
                mapB.replace(temp, value, ++value);
                if ((value>=bCount && temp>bKey) || value>bCount ) {
                    bCount = value;
                    bKey=temp;
                }
            }
        }
        if (aCount!=0){
            aCount=aKey;
        }else
            aCount=aHighest;
        if (bCount!=0)
            bCount=bKey;
        else bCount=bHighest;
        if (aCount==bCount)
            return "Tie";
        else if (aCount>bCount)
            return "Rupam";
        else return "Ankit";
    }
}