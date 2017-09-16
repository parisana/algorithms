package Array1D;/*
* The data would look like:

UNIQUE ID NAME D.O.B. GENDER TOE NTY SCD RESULT
911215011 LOVEPREET THAKUR 28/07/2000 BOY 1 I 3 SRL No 123340
ENG - 3 - 74 HIN - 2 - 87 HCG - 6 - 50 DC MAT - 5 - 58 SCI - 6 - 44 DDD CTA - 2 - 82 SUPW:C PCA
1173387/ 001 Son of AMANDEEP KAUR and MANJEET THAKUR

911215053 PRANCHAL CHAUTALA 06/09/2000 BOY 1 I 3 SRL No 123341
ENG - 4 - 63 HIN - 3 - 75 HCG - 5 - 57 CC MAT - 6 - 47 SCI - 6 - 45 DDD CAS - 5 - 60 SUPW:C PCA
1173387/ 002 Son of MADHU CHAUTALA and SUNIL KUMAR CHAUTALA

In the first entry, TOE is 1, NTY is I, SCD is 3 and RESULT is PCA.

Write a program which can read the results data from results.txt and answer the following question:

Top 10 student names and unique IDs based on marks in ENG (English) + Best 4 subjects as:
Unique ID,Name,Rank*/
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AmazonHiring {
    public static void main(String args[]) throws Exception {
        String fileName = "/home/pari/Desktop/result.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        List<Student> listOfStudents= new ArrayList<>();
        Set<String> setOfSubjectCodes= new HashSet<>(Arrays.asList("ENG","ASM","BEN","GUJ","HIN","KAN","KHA","MAL","MAR","NEP","ODI","PUN","TAM"+
                "TEL","TIB","URD","MIZ","MAN","SAN","LEP","ARB","ARM","CHI","DZO","FRE","GER","JPN","SPA","GAR","ANG","BID","TAN","HCG","MAT","SCI","FRE","ART","CST","ECO","TDA","HSC","CKY","FAD","PED","FRE","EVS","YOG","CTA","EAS","CAS","ENA","IMH","IMC","WMS","IND","DMA"
        ));
        Map<Integer, Integer> totalMarksMap= new TreeMap<Integer, Integer>();
        while ((line = bufferedReader.readLine()) != null) {
            if ((line = bufferedReader.readLine()) == "\\s+")
                break;
            Student student = new Student();
            String[] strings = line.split("\\s+");
            student.uniqueId=Integer.parseInt(strings[0]);
            student.name=strings[1]+" "+strings[2];
            student.dateOfBirth=strings[3];
            student.gender=strings[4];
            student.result.typeOfEntry= Integer.parseInt(strings[5]);
            student.result.nty=strings[6];
            student.result.status=strings[7];
            student.result.serialNum= Integer.parseInt(strings[10]);  //last item of 1st line
            student.result.studId=student.uniqueId;
            //System.out.println(student.name+"****************************************************""""""""""""""""");

            line= bufferedReader.readLine();

            strings=line.split("\\s+");
            for (int i=0; i<strings.length;){
                String str= strings[i];
                if (setOfSubjectCodes.contains(str)){
                    Subject sub=new Subject();
                    sub.code=str;
                    sub.grade= Integer.parseInt(strings[i=i+2]);
                    sub.marks=Integer.parseInt(strings[i=i+2]);
                    student.totalMarks+=sub.marks;
                    if (str.equals("SCI")){
                        str=strings[++i];
                        sub.science.physics=str.charAt(0);
                        sub.science.chemistry=str.charAt(1);
                        sub.science.biology=str.charAt(2);
                        //System.out.println(sub.science.physics+"**********************");
                    }else if(str.equals("HCG")){
                        str=strings[++i];
                        //System.out.println(str);
                        sub.historyCG.civics=str.charAt(0);
                        sub.historyCG.geo=str.charAt(1);
                    }else if(str.equals("SUPW:\\c")){
                        sub.supw=str.charAt(str.length()-1);
                    }else{
                        student.result.status=str;
                    }
                    i++;
                    student.subjects.add(sub);
                }else{
                    i++;
                }

            }
            totalMarksMap.put(student.uniqueId, student.totalMarks);
            //1173387/ 102 Son of MADHU CHAUTALA and SUNIL KUMAR CHAUTALA
            line =bufferedReader.readLine();
            strings=line.split("\\s+");
            student.rollNum=strings[0]+strings[1];
            for (int i=1; i<strings.length;){
                //System.out.println(i+" "+strings[i]+" strings[i]***************************************************************************");
                if (strings[i++].equals("of")){
                    while(!strings[i].equals("and"))
                        student.motherName=student.motherName==null?strings[i++]:student.motherName+" "+strings[i++];
                    while(i++<strings.length-1)
                        student.fatherName=student.fatherName==null?strings[i]:student.fatherName+" "+strings[i];
                }
                i++;
            }

            listOfStudents.add(student);
        }
        /*for (Student student:listOfStudents){
            if (!student.subjects.isEmpty()){
                for (Subject subject:student.subjects)
                    System.out.println(subject.marks);
            }
        }*/
        Map<Integer, Integer> sortedMap= sortByValue(totalMarksMap);
        int count=10;
        for (Map.Entry<Integer,Integer> entry: sortedMap.entrySet()){
            if(count--<=0)
                break;
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }
}
class Subject{
    public String name;
    public String code;
    public int marks;
    public int grade=0;
    public Science science;
    public HistoryCG historyCG;
    public char supw;

    public Subject(){
        science= new Science();
        historyCG=new HistoryCG();
    }
    public String toString(){
        return "code:"+code+" marks:"+marks+" grade:"+grade+" science:"+science.toString()+" history:"+historyCG.toString()+" supw:"+supw;
    }
}
class Student{
    int uniqueId;
    String name;
    String gender;
    String dateOfBirth;
    String fatherName;
    String motherName;
    int totalMarks=0;
    int caste;
    String rollNum;
    Result result;
    List<Subject> subjects;
    public Student(){
        this.result=new Result();
        this.subjects= new ArrayList<>();
    }
    public String toString(){
        return uniqueId+" name: "+name+" gender:"+gender+" dateOfBirth:"+dateOfBirth+" fatherName:"+fatherName+" motherName:"+motherName+" rollNum:"+rollNum+" result:"+result+"\n";
    }
}
class Science{
    char physics;
    char chemistry;
    char biology;
}
class HistoryCG{
    char civics;
    char geo;
}
class Result{
    int serialNum;
    int studId;
    int typeOfEntry;
    char SUPW;
    String status;
    String nty;
}