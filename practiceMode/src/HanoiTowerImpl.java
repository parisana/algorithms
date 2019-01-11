
public class HanoiTowerImpl{
    static int size=4;
    public static void main(String[] args){
        Stack stackA=new HanoiStack(size,"StackA");
        Stack stackB=new HanoiStack(size,"StackB");
        Stack stackC=new HanoiStack(size,"StackC");
        stackA.push(4);
        stackA.push(3);
        stackA.push(2);
        stackA.push(1);
        for (int i=size-1;i>=0;i--) {
            System.out.println(stackA.items[i]+"\t"+stackB.items[i]+"\t"+stackC.items[i]);
        }
        towerOfHanoi(size, stackA, stackC, stackB);
        for (int i=size-1;i>=0;i--) {
            System.out.println(stackA.items[i]+"\t"+stackB.items[i]+"\t"+stackC.items[i]);
        }

    }
    static void towerOfHanoi(int n,Stack Beg, Stack End, Stack Aux){
        if (n==0)
            return;
        if (n==1){
            int temp = Beg.pop();
            End.push(temp);
            System.out.println("-----------------Call to Main--------------------"+n);
            System.out.println("Move disk " + temp + " from " + Beg.name + " to " + End.name);
            System.out.println("Beg: "+Beg.name + "\t\tAux:" + Aux.name+"\t\tEnd:" + End.name);
            for (int i=size-1;i>=0;i--) {
                System.out.println(Beg.items[i]+"\t\t"+Aux.items[i]+"\t\t"+End.items[i]);
            }
            System.out.println("$$$$$$$$$$$$$$$$$$$Returned############################");
            return;
        }else {
            System.out.println("1st Call to Line:34***************n-1= "+(n-1));
            towerOfHanoi(n - 1, Beg, Aux, End);
            System.out.println("2nd Call to Line:36***************= "+1);
            towerOfHanoi(1, Beg, End, Aux);
            System.out.println("3rdCall to Line:38***************n-1= "+(n-1));
            towerOfHanoi(n-1, Aux, End, Beg);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+n);
        }
    }
}
class HanoiStack extends Stack {
    HanoiStack(int size, String name) {
        super(size, name);
    }

    HanoiStack() {}

    void push(int item) {
        if (top==-1)
            items[++top]=item;
        else if (top > items.length - 1) {
            System.out.println("Stack Overflow ");
            return;
        }else if(top>=0 && item<items[top]) {
            items[++top] = item;
        }else{
            System.out.println("Invalid operation top item "+item+" cannot be larger than bottom item "+items[top]);
            return;
        }
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }
        int tempItem=items[top];
        items[top--]=null;
        return tempItem;
    }
}
