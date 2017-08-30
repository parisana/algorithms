import java.io.*;
import java.util.HashMap;
import java.util.Map;

class MonkAndLucky {
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
        if (t==0|| t>10)
            System.exit(0);
        for (int i=0; i< t; i++) {
            int n = reader.nextInt();
            int count = 1;
            long smallest=reader.nextLong();
            long currentValue;
            for (int j = 1; j < n; j++) {
                currentValue=reader.nextLong();
                if (currentValue>smallest){}
                else if (currentValue<smallest) {
                    smallest=currentValue;
                    count = 1;
                }
                else if (currentValue==smallest)
                    count++;
            }
            pw.println(count%2==0?"Unlucky":"Lucky");
        }
        pw.flush();
    }
}
/*
*
* */
