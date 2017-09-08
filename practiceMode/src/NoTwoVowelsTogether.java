import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NoTwoVowelsTogether {
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
    /*public static int findGCD(int[] arr, int n) {
        if (n<2|| n>10_000)
            System.exit(0);
        int result=arr[n-1];
        int position=0;
        int highest;
        int[] gcdArr=new int[n-1];
        for (int i=n-2; i>=0;i--){
            result = GCD(arr[i], result);
            gcdArr[i]=result;
            System.out.print(i+": "+result+"\t");
        }
        highest=gcdArr[n-2];
        //System.out.println(highest+"highest");
        for (int i=0; i<n-1; i++){
            if (gcdArr[i]<highest)
                position=i+1;
            //System.out.println(i+": "+gcdArr[i]);
        }
        //System.out.println(position+" position");
        //System.out.println(arr[position]);
        return position==0?1:position;
    }
    public static int GCD(int a, int b){
        //int gcd;
        if (a==0)
            return b;
        return GCD(b%a, a);
    }*/
    public static void main(String args[] ) throws Exception {
        //Reader reader = new Reader();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
        long rt = 0;
        int n = Integer.valueOf(bufferedReader.readLine());
        for (int i=0; i<n; i++){
            String s=bufferedReader.readLine();
            rt=System.currentTimeMillis();
            compute(s);
        }
        pw.println(System.currentTimeMillis()-rt);
        pw.close();
    }
    private static void compute(String s) {
        int[] charCountArray = new int[26];
        int vowelCount = 0;
        int consonantCount = 0;
        long repitionFact = 1L;
        List<Integer> vowelList = Arrays.asList(0, 4, 8, 18, 20);
        for (int i = 0; i < s.length(); i++) {
            charCountArray[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            int count = charCountArray[i];
            long temp;
            if (count == 0) continue;
            if (vowelList.contains(i)) {
                vowelCount += count;
                if (count > 1) {
                    temp=fact(count,1);
                    repitionFact *= temp;
                }
            } else {
                consonantCount += count;
                if (count > 1) {
                    temp=fact(count, 1);
                    repitionFact *= temp;
                }
            }
            System.out.println(repitionFact+"\t repition");

        }
        if (vowelCount>consonantCount+1){
            System.out.println("-1");
            return;
        }else {
            long factOfConsonants = fact(consonantCount, consonantCount - consonantCount);
            long factOfVowels=fact(consonantCount+1, (consonantCount+1-vowelCount)+1);
            System.out.println(factOfConsonants+"\t"+factOfVowels);
            long result= (factOfConsonants*factOfVowels)/repitionFact;
            System.out.println(result);
            return;
        }


    }
    private static int fact(int n, int r){
        if (n<=1)
            return 1;
        else if (n==r)
            return r;
        else {
            //System.out.println(n);
            return n*fact(n-1, r);
        }
    }
}