import java.io.*;

class BinaryQueries {
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
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);*/
        //Scanner
        /*Scanner s = new Scanner(System.in);
        int n = s.nextInt();*/
        Reader reader=new Reader();
        PrintWriter pw=new PrintWriter(System.out);
        int arraySize=reader.nextInt();
        int testCases=reader.nextInt();
        int[] aArray=new int[arraySize];
        for (int i=0; i<arraySize;i++){
            aArray[i]=reader.nextInt();
        }
        int temp;
        for (int i=0; i<testCases; i++){
            temp=reader.nextInt();
            if (temp==1){
                int flipPosition=reader.nextInt();
                aArray[flipPosition-1]^=1;
            }else {
                reader.nextInt();
                if (aArray[reader.nextInt()-1]==0)
                    pw.println("EVEN");
                else
                    pw.println("ODD");
            }
            pw.flush();
        }
        pw.flush();

        /*BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in), 4098);
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(bufferedReader.readLine());
        int[] aArray= new int[n];
        for (int i = 1; i<=2; i++){
            String[] tokens=bufferedReader.readLine().split(" ");
            int j=0;
            for (String e: tokens){
                aArray[j]+=Integer.parseInt(e);
                j++;
            }
        }
        for (int e: aArray)
            pw.print(e+" ");
        pw.close();*/
    }
}
/*
*
* */
