package Array1D;

import java.io.*;
import java.util.*;

class MonkAndPowerOfTime {
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
*you are given two things:

    The calling order in which all the processes are called.
    The ideal order in which all the processes should have been executed.

Now, let us demonstrate this by an example. Let's say that there are 3 processes, the calling order of the processes is: 3 - 2 - 1. The ideal order is: 1 - 3 - 2, i.e., process number 3 will only be executed after process number 1 has been completed; process number 2 will only be executed after process number 3 has been executed.

    Iteration #1: Since the ideal order has process #1 to be executed firstly, the calling ordered is changed, i.e., the first element has to be pushed to the last place. Changing the position of the element takes 1 unit of time. The new calling order is: 2 - 1 - 3. Time taken in step #1: 1.

    Iteration #2: Since the ideal order has process #1 to be executed firstly, the calling ordered has to be changed again, i.e., the first element has to be pushed to the last place. The new calling order is: 1 - 3 - 2. Time taken in step #2: 1.

    Iteration #3: Since the first element of the calling order is same as the ideal order, that process will be executed. And it will be thus popped out. Time taken in step #3: 1.

    Iteration #4: Since the new first element of the calling order is same as the ideal order, that process will be executed. Time taken in step #4: 1.

    Iteration #5: Since the last element of the calling order is same as the ideal order, that process will be executed. Time taken in step #5: 1.

Total time taken: 5 units.
* */
