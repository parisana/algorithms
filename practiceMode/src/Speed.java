import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Speed {
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
        int t=reader.nextInt();
        long speed;
        for (int i=0; i< t; i++) {
            int n = reader.nextInt();
            int count = 0;
            long highest=0L;
            speed = 0L;
            for (int j = 0; j < n; j++) {
                speed = reader.nextLong();
                if (j==0) {
                    highest = speed;
                    count++;
                }
                else
                    //System.out.println(highest+":highest and speed["+j+"]: "+speed[j]);
                    if (speed <= highest) {
                        highest =speed;
                        count++;
                    }
            }
            pw.println(count);
        }
        pw.flush();
    }
}
/*
*T=No.of test cases
*for each test case T[i], take n= number of cars
*   followed by the maxm speed of each cars in order
*Find the number of cars that are at their maxm speed after they enter the straight lap
* */
