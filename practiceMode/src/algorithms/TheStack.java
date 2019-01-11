package algorithms;

import java.util.Arrays;

public class TheStack {

    private String[] stackArray;
    private int stackSize;
    private int topOfStack=-1;

    TheStack(int size){
        stackSize=size;
        stackArray = new String[size];

        Arrays.fill(stackArray, "-1");
    }
    public void push(String input){
        if ((topOfStack +1< stackSize)){
            topOfStack++;
            stackArray[topOfStack]= input;
        }else System.out.println("Stack is full");
        displayTheStack();

        System.out.println("PUSH \""+ input+"\" was added to the Stack");
    }

    public  String pop(){

        if(topOfStack>=0){
            String temp=stackArray[topOfStack];
            stackArray[topOfStack]="-1";
            displayTheStack();
            System.out.println("POP "+ temp+ " was removed from the stack");

            return  stackArray[topOfStack--];
        }else{
            displayTheStack();
            System.out.println("Sorry Buth the stack is empty");
            return "-1";
        }
    }
    public String peek(){
        displayTheStack();
        System.out.println("PEEK "+ stackArray[topOfStack]+ " is at the top of the stack");
        return stackArray[topOfStack];
    }
    public void pushMany(String[] multipleItems){
        for (int i= topOfStack; i<multipleItems.length; i++){
            push(multipleItems[i]);
        }
    }
    public void popAll(){
        for (int i=topOfStack; i>=0; i--){
            pop();
        }
    }

    public static void  main(String[] args){

        TheStack theStack= new TheStack(10);
        theStack.push("10");
        theStack.push("15");
        theStack.peek();
        theStack.pop();
        String[] stringsToPush={"12", "43", "64", "99"};
        theStack.pushMany(stringsToPush);
        theStack.popAll();

    }

    public void displayTheStack(){
        int barLen=stackSize*6+1;
        for(int n = 0; n < barLen; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < stackSize; n++){
            System.out.format("| %2s "+ " ", n);
        }
        System.out.println("|");
        for(int n = 0; n < barLen; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < stackSize; n++){
            if(stackArray[n].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
    }

}
