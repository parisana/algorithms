/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.*;
import java.util.StringTokenizer;

class Solution {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in), 4098);
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
        pw.close();
    }
}
