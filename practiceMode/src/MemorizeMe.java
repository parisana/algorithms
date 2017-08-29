import java.io.*;
import java.util.HashMap;
import java.util.Map;

class MemorizeMe {
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
    }

    public static void main(String args[] ) throws Exception {
        Reader reader=new Reader();
        PrintWriter pw=new PrintWriter(System.out);
        int n=reader.nextInt();
        Map<Integer, Integer> map=new HashMap<>();
        int temp;
        for (int i=0; i<n; i++){
            temp=reader.nextInt();
            if (!map.containsKey(temp))
                map.put(temp, 1);
            else {
                Integer value = map.get(temp);
                map.replace(temp, value, value+1);
            }
        }
        int m=reader.nextInt();
        while (m!=0){
            temp=reader.nextInt();
            if (map.containsKey(temp))
                pw.println(map.get(temp));
            else
                pw.println("NOT PRESENT");
            m--;
        }
        pw.flush();
    }
}
/*
*n=number of integers to be memorized.
*A[i]= the integers to be memorized. i=1 to n.
*m=number of test queries.
*B[i]= the integer to be tested if present. i=1 to m.
* */
