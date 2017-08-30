import java.io.*;
import java.util.*;

class MostFrequent {
    public static void main(String args[] ) throws Exception {
        Scanner reader= new Scanner(new InputStreamReader(System.in));
        int n=reader.nextInt();
        int highest=0;
        int key=0;
        Map<Integer,Integer> map= new HashMap();
        for (int i=0; i<n; i++){
            int temp=reader.nextInt();
            if (map.containsKey(temp)){
                Integer value = map.get(temp);
                map.replace(temp, value, value+1);
                if (++value>highest || (value==highest && temp<key)){
                    highest=value;
                    key=temp;
                }
            }else
                map.put(temp, 1);
        }
        System.out.println(key);
    }
}
