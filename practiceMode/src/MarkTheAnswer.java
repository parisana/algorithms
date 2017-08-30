import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MarkTheAnswer {
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
        long x=reader.nextLong();
        int skipCount=0;
        int count=0;
        while(t!=0){
            if (skipCount>1)
                break;
            long current=reader.nextLong();
            if (current>x) {
                skipCount++;
                t--;
                continue;
            }
            count++;
            t--;
        }
        pw.print(count);
        pw.flush();
    }

}
/*
*n x    n=number of answers; x=max diffulty he can solve
*array[i]   i=1 to n; array[i]=difficulty of each question;
*
* OP: max number of questions he can solve without skipping more than 1 question.
* */
