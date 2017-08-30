import java.io.*;
import java.util.*;

class Solution {
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
        byte n= (byte) reader.nextInt();
        int count=0;
        List<Byte> callingOrder=new ArrayList<>();
        for (int i=0; i<n; i++) {
            callingOrder.add((byte)reader.nextInt());
        }
        for (int i=0; i<n; i++){
            Byte temp = callingOrder.remove(0);
            byte currentInput= (byte) reader.nextInt();
            if (temp==currentInput){
                count++;
                continue;
            }else{
                callingOrder.add(temp);
                count++;
                while ((temp=callingOrder.remove(0))!=currentInput){
                    callingOrder.add(temp);
                    count++;
                }
                count++;
            }
        }
        callingOrder.stream().forEach(System.out::print);
        pw.print(count);
        pw.flush();
    }

}
/*
*
* */
