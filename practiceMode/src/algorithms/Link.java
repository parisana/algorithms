package algorithms;

public class Link {
    public String bookName;
    public int millionsSold;

    public Link next;
    public Link(String bookName, int millionsSold){
        this.bookName= bookName;
        this.millionsSold= millionsSold;
    }

    public void displayLink(){
        System.out.println(bookName+": "+ millionsSold+ ",000,000");
    }

    public String toString(){
        return  bookName;
    }
    public static void main(String[] args){
        LinkList theLinkedList= new LinkList();

        theLinkedList.insertFirstLink("Harry Potter", 500);
        theLinkedList.insertFirstLink("A Tale of Two Cities", 500);
        theLinkedList.insertFirstLink("The Lord Of the Rings", 500);
        theLinkedList.insertFirstLink("Pirates Of the Carribean", 500);
        theLinkedList.displayAllLink();

        theLinkedList.removeLink("Harry Potter");
        theLinkedList.displayAllLink();
        Link tempLink= theLinkedList.find("Pong");
        System.out.println(tempLink!=null?tempLink.bookName+" was found":null);

    }

}
class LinkList{
    public Link firstLink;
    LinkList(){
        firstLink=null;
    }
    public boolean isEmpty(){
        return (firstLink==null);
    }
    public void insertFirstLink(String bookName, int millionsSold){
        Link newLink= new Link(bookName, millionsSold);
        newLink.next= firstLink;
        firstLink= newLink;
    }
    public Link removeFirst(){
        Link linkReference= firstLink;
        if(!isEmpty()){
            firstLink= firstLink.next;
        }else{
            System.out.println("Empty LinkedList");
        }
        return linkReference;
    }
    public void displayAllLink(){
        Link theLink= firstLink;
        while(theLink!=null){
            theLink.displayLink();
            System.out.println("Next Link: "+ theLink.next);
            theLink=theLink.next;
            System.out.println();
        }
    }
    public Link find(String bookName){
        Link theLink= firstLink;
        if(!isEmpty()){
            while(theLink.bookName!=(bookName)){
                if(theLink.next==null){
                    return null;
                }else{
                    theLink= theLink.next;
                }
            }
        }else {
            System.out.println("Empty LinkedList");
            return null;
        }
        return theLink;
    }
    public Link removeLink(String bookName){
        Link currentLink= firstLink;
        Link previousLink= firstLink;
        while(currentLink.bookName!=bookName){
            if(currentLink.next==null){
                return null;
            }else{
                previousLink= currentLink;
                currentLink= currentLink.next;
            }
        }
        if(currentLink==firstLink){
            firstLink= firstLink.next;
        }else {
            previousLink.next=currentLink.next;
        }
        return currentLink;
    }
}