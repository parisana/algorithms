package Array1D;

import java.io.*;
import java.util.*;

class TheAmazingRace {
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
        Reader s = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        int t=s.nextInt();
        while(t-->0)
        {
            int n=s.nextInt();
            int a[]=new int[n];
            int left[]=new int[n];
            int right[]=new int[n];
            long highest=0;
            int position=1;
            for(int i=0;i<n;i++)
            {
                a[i]=s.nextInt();
            }
            int leftpos=0;
            int rightpos=n-1;
            for(int i=1;i<n;i++){
                if (a[i-1]>=a[i]) {
                    left[i] = 1;
                    leftpos=i-1;
                }
                else {
                    while (leftpos>0){
                        if (a[leftpos--]>=a[i])
                            break;
                    }
                }
                left[i]=i-leftpos;
            }
            for (int i=n-2; i>=0; i--){
                if (a[i]<=a[i+1]) {
                    right[i] = 1;
                    rightpos=i+1;
                }
                else {
                    while (rightpos<n){
                        if (a[rightpos++]>=a[i])
                            break;
                    }
                }
                right[i]=rightpos-i;
            }
            for (int i=0; i<n; i++){
                long tempHighest = (((left[i]%MOD+right[i]%MOD+MOD)%MOD)*(i+1))%MOD;
                if (tempHighest>highest) {
                    highest = tempHighest;
                    position=i+1;
                }
            }
            pw.println(position);

        }
        pw.close();
    }
    /*public static void findWinner(int[] drivers){
        int size=drivers.length;
        int currentIndex;
        int winner[]={0,0};  //winner[0]=(position+1)*(frontCount+rearCount); winner[1]=position+1
        int previousCount=0;  //previousCount=rearCount+1 + frontCount-1
        for (int i=size-1; i>=0; i--){
            //winner=0;
            int rear=i;
            int rearCount=0;
            int front=i;
            int frontCount=0;
            int tempwinner=0;
            //int height=drivers[i];
            currentIndex=i;
            *//*if (i>0 && drivers[i]==drivers[i-1]){
                tempwinner=(i+1)*previousCount;
                if (tempwinner==winner[0])
                    winner[1]=i+1;
                continue;
            }*//*
            whileloop: while (++rear<=size-1){
                rearCount++;
                if (drivers[rear]>=drivers[currentIndex])
                    break whileloop;
            }
            whileloop2:while (--front>=0){
                frontCount++;
                if (drivers[front]>=drivers[currentIndex])
                    break whileloop2;
            }
            previousCount=(frontCount+rearCount);
            tempwinner=(i+1)*previousCount;
            //System.out.println(tempwinner +" height: "+ drivers[i] +" (i+1):"+(i+1)+"frontCount: " +frontCount+" rearCount: "+rearCount);
            if (tempwinner>winner[0]) {
                winner[0] = tempwinner;
                winner[1]=i+1;
            }

        }
        System.out.println(winner[1]);
    }*/
}