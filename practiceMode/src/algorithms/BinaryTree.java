package algorithms;

public class BinaryTree {
    BinaryNode root;
    int treeSize=0;
    int treeHeight;
    public void addNode(int key, String name){
        BinaryNode newNode= new BinaryNode(key, name);
        if(root==null){
            root = newNode;
            treeSize++;
            return;
        }
        BinaryNode currentNode= root;
        boolean foundInsertPoint=false;
        while(!foundInsertPoint){
            BinaryNode parent= currentNode;
            if(key<currentNode.key){
                currentNode= currentNode.leftChild;
                if (currentNode==null){
                    parent.leftChild= newNode;
                    foundInsertPoint=true;
                }
            }else{
                currentNode= currentNode.rightChild;
                if(currentNode==null){
                    parent.rightChild= newNode;
                    foundInsertPoint=true;
                }
            }
        }
        treeSize++;
        return;
    }
    private void inOrderTraversal(BinaryNode startNode){
        if(startNode!=null){
            inOrderTraversal(startNode.leftChild);
            System.out.println(startNode);
            inOrderTraversal(startNode.rightChild);
        }
    }
    private void preOrderTraversal(BinaryNode startNode){
        if(startNode!=null){
            System.out.println(startNode);
            preOrderTraversal(startNode.leftChild);
            preOrderTraversal(startNode.rightChild);
        }
    }
    private void postOrderTraversal(BinaryNode startNode){
        if(startNode!=null){
            postOrderTraversal(startNode.leftChild);
            postOrderTraversal(startNode.rightChild);
            System.out.println(startNode);
        }
    }
    private BinaryNode findNode(int key){
        BinaryNode currentNode= root;
        while(currentNode!=null && currentNode.key!=key){
            if(key<currentNode.key){
                currentNode= currentNode.leftChild;
            }else{
                currentNode= currentNode.rightChild;
            }
        }
        return currentNode;
    }
    public boolean remove(int key){
        BinaryNode currentNode=root;
        BinaryNode parent =root;

        if (currentNode==null) {
            System.out.println("Tree is empty!");
            return false;
        }
        boolean isLeftChild= true;
        //iterate till key is found.
        while (currentNode.key!=key){
            parent=currentNode;
            //if key is less than the current node's key
            if (key<currentNode.key){
                isLeftChild= true;
                currentNode= currentNode.leftChild;
            }else{
                isLeftChild=false;
                currentNode= currentNode.rightChild;
            }
            if (currentNode==null)
                return false;
        }
        //if leaf node contains the key.
        if (currentNode.leftChild==null && currentNode.rightChild==null){
            if (currentNode==root) {
                root = null;
            }
            else if(isLeftChild){
                parent.leftChild=null;
            }else {
                parent.rightChild=null;
            }
        }else if(currentNode.rightChild==null){
            //if the node to be deleted does not have a leftchild
            if (currentNode==root){
                root= currentNode.rightChild;
            }
            else if (isLeftChild){
                parent.leftChild=currentNode.leftChild;
            }else{
                parent.rightChild=currentNode.leftChild;
            }
        }else if(currentNode.leftChild==null){
            if (currentNode==root){
                root=currentNode.rightChild;
            }
            else if (isLeftChild){
                parent.leftChild= currentNode.rightChild;
            }else {
                parent.rightChild= currentNode.rightChild;
            }
        }else{
            BinaryNode replacementNode= getReplacementNode(currentNode);
            if (currentNode==root){
                root=replacementNode;
                replacementNode.leftChild=currentNode.leftChild;
                replacementNode.rightChild=currentNode.rightChild;
            }else{
                if (isLeftChild)
                    parent.leftChild=replacementNode;
                else
                    parent.rightChild=replacementNode;
                replacementNode.leftChild=currentNode.leftChild;
                replacementNode.rightChild=currentNode.rightChild;
                currentNode=null;
            }
        }
        treeSize--;
        return true;
    }
    private BinaryNode getReplacementNode(BinaryNode nodeToBeReplaced){
        BinaryNode replacementNode= nodeToBeReplaced;
        BinaryNode replacementParentNode= nodeToBeReplaced;
        //right child (or its far left child that is the leaf node) of the nodeToBeReplaced will be the replacement node;
        BinaryNode currentNode= replacementNode.rightChild;
        while (currentNode!=null){
            replacementParentNode=replacementNode; //store the parent of the node that will replace the required node
            replacementNode=currentNode; //This will be the replacement node
            currentNode= currentNode.leftChild; //This will be null at final iteration.
        }
        if (replacementNode!=nodeToBeReplaced.rightChild){
            replacementParentNode.leftChild= replacementNode.rightChild;  //assign replacement node's right subtree to the parent of the replacement node.
        }
        return replacementNode;
    }
    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        //System.out.println("Tree size= "+tree.treeSize);
        tree.addNode(59, "loki");
        tree.addNode(45, "kiss");
        tree.addNode(50, "jiskd");
        tree.addNode(51, "dike");
        tree.addNode(47, "tuko");
        tree.addNode(44, "mino");
        tree.addNode(40, "cuko");
        tree.addNode(44, "mile");
        tree.addNode(70, "milky");
        tree.addNode(61, "pilse");
        tree.addNode(80, "mono");
        tree.addNode(88, "mono");
        //tree.addNode(89, "mono");
        tree.inOrderTraversal(tree.root);
        //the tree height may go up to n so it can throw array index out of bound as i'm taking log n as the max height
        tree.treeHeight= 32-Integer.numberOfLeadingZeros(tree.treeSize);   //find the ceil of lg of treesize
        System.out.println("Tree size= "+tree.treeSize+" Tree height: "+tree.treeHeight);
        System.out.println("**************************");
        Integer[] BSTArray = tree.treeToArray(tree);   //get the values of nodes in an array
        //now lets print a tree;
        System.out.println("Items in the tree: ");
        for (Integer x: BSTArray){
            System.out.print(x+"  ");
        }
        System.out.println();
        printTree(BSTArray, tree.treeHeight);
    }
/*
* 4 row tree
* _______1
* ___1_______1
* _1___1___1___1
* 1_1_1_1_1_1_1_1
* //this is for 1 digit tree
* 1st row indent 7 spaces 0
* 2nd row indent 3 spaces 7
* 3rd row indent 1 spaces 3
* 4th row indent 0 spaces 1
*
* Indent: (7,3,1,0): a(n)= 2^(heightOfTree-n)-1;   n=1 to n
* (taking 4digit tree: (4*8, 4*4, 4*2, 4*1) : a(n)= 4*2^(heightOfTree-1))
*   will need a count that keeps track of n;
* spaces: starts with 0 and next spaces=last indent;
* Indexes of the leftmost nodes for each subtree: 0,1,3,7,...
*   index= a(n)= 2^(n-1) -1    ; n=1 to n
*
* Number of items per row: 2^(n-1)   ; n=1 to n
*
* Max Index per row= indexToPrintFirst + itemsPerRow
* */
    private static void printTree(Integer[] BSTArray, int noOfRows) {
        int spaces=0;
        int n=1;

        while(n<=noOfRows){
            int indent= (int)Math.abs(Math.pow(2,noOfRows-n));
            int firstIndex=(int) (Math.pow(2, n-1)-1);// the first index of each row
            int itemsPerRow= firstIndex+1;
            int lastIndex= firstIndex+itemsPerRow;  //lastIndex of a row
            System.out.println("");
            for(int i=0; i<indent; i++){
                System.out.print("    ");
            }
            for (int i=firstIndex; i<lastIndex ; i++){
                System.out.printf("%4s",BSTArray[i]);
                if (i!=lastIndex-1)
                for (int j=0; j<spaces; j++)
                    System.out.print("~~~~");
            }
            spaces=indent-1;
            n++;
            System.out.println();
        }
    }

    private Integer[] treeToArray(BinaryTree tree){
        if (treeSize==0){
            System.out.println("Tree doesn't have any item!");
            return null;
        }
        int arraySize=(int)Math.pow(2,treeHeight)-1;   //2^n -1
        //System.out.println(logOfTreeSize+"********"+arraySize);
        Integer[] BSTArr= new Integer[arraySize];

        tree.makeArray(root, 0, BSTArr);
        return BSTArr;
    }

    private void makeArray(BinaryNode node, int index, Integer[] BSTArray) {
        if(node!=null){
            BSTArray[index]= getValue(node);
            makeArray(getLeft(node), index*2+1, BSTArray);
            makeArray(getRight(node), index*2+2, BSTArray);
        }
    }

    public BinaryNode getRight(BinaryNode node) {
        if (node.rightChild!=null)
            return node.rightChild;
        return null;
    }

    public BinaryNode getLeft(BinaryNode node) {
        if (node.leftChild!=null)
            return node.leftChild;
        return null;
    }

    public Integer getValue(BinaryNode node) {
        if (node!=null)
            return node.key;
        return null;
    }

}
class BinaryNode{
    int key;
    String name;
    BinaryNode leftChild;
    BinaryNode rightChild;
    BinaryNode(int key, String name){
        this.key= key;
        this.name= name;
    }
    public String toString(){
        return name+" has a key "+ key;
    }


}