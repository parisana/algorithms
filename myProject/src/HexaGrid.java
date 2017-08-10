/*Input Format

        The first line contains a single integer , the number of test cases.

        The 2nd line of each test case contains a single integer denoting the length of the grid.
        The 3rd line contains a binary string of length . The character describes whether cell is blackened.
        The 4th line contains a binary string of length . The character describes whether cell is blackened.
        A 0 corresponds to an empty cell and a 1 corresponds to blackened cell.

        ex: 1                              1. 00 is valid
            5                              2. 0
            10011                             0 is valid
            00111                          3.  0
                                              0 is valid
        op: YES
        */


import java.util.*;

public class HexaGrid {

    static String findPair(String[] str, int n){
        int count=0;
        StringBuilder a=new StringBuilder(str[0]);
        StringBuilder b=new StringBuilder(str[1]);
        for(int i=0; i<2; i++){
            //System.out.println(str[i]);
            for(int j=0; j<n; j++){
                //System.out.println(str[i]);
                char c = str[i].charAt(j);

                if(c=='0')
                    count++;
            }
        }
        if(count==0)
            return "YES";
        else if (count%2==0){
            int i=0;
            while(i<n-1){
                while(i<n && (a.charAt(i)=='1')&&(b.charAt(i)=='1')){
                    if (i==n-1)
                        return "YES";
                    i++;
                }
                if(i==n-1){
                    if(a.charAt(i)=='0' && b.charAt(i)=='0'){
                        a.setCharAt(i, '4');
                        b.setCharAt(i, '4');
                        //System.out.println(a+"\n"+b);//////////////////////////////////////
                    }
                    else return "NO";
                }
                else if(b.charAt(i)=='0'){
                    if(a.charAt(i)!='0'){
                        if(a.charAt(i+1)=='0'){
                            b.setCharAt(i, '2');
                            a.setCharAt(i+1, '2');
                            //System.out.println(a+"\n"+b);//////////////////////////////////////
                        }else if(b.charAt(i+1)=='0'){
                            b.setCharAt(i, '3');
                            b.setCharAt(i+1, '3');
                            //System.out.println(a+"\n"+b);//////////////////////////////////////
                        }else{
                            return "NO";
                        }
                    }else if(a.charAt(i)=='0'){
                        b.setCharAt(i, '4');
                        a.setCharAt(i,'4');
                        //System.out.println(a+"\n"+b);//////////////////////////////////////
                    }else if(b.charAt(i+1)=='0'){
                        b.setCharAt(i, '4');
                        b.setCharAt(i+1,'4');
                        //System.out.println(a+"\n"+b);//////////////////////////////////////
                    }
                }else if(a.charAt(i)=='0'){
                    if(b.charAt(i)!='0' && a.charAt(i+1)=='0'){
                        a.setCharAt(i,'3');
                        a.setCharAt(i+1,'3');
                        //System.out.println(a+"\n"+b);//////////////////////////////////////
                    }else return "NO";
                }
                i++;
            }
            /*if((str[0].charAt(n-1)=='1' && str[1].charAt(n-2)=='1')||(str[0].charAt(1)=='1' && str[1].charAt(0)=='1')){
                return "NO";
            }*/
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        String[] result=new String[t];
        for (int i=0; i<t; i++){
            int n= sc.nextInt();
            String[] str= new String[2];
            for (int j=0; j<2; j++){
                str[j]=sc.next();
            }
            result[i]= findPair(str, n);
        }
        for (int i=0; i<t; i++){
            System.out.println(result[i]);
        }
    }
}
