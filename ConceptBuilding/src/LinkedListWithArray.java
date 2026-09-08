public class LinkedListWithArray {

    public static void main(String[] args){

        int [] arr = {3,6,2,8};
        Node headStart = convertToLL(arr);
        System.out.println("Node value is : "+headStart.next.next.data);

        Node temp = headStart;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

        System.out.println("\nLength of Linked List is : "+countLengthOfLL(headStart));
        System.out.println("Value present in Linked List : "+isPresent(headStart, 6));

        System.out.println("Before deletion of Head value is : "+headStart.data);
        headStart = deleteHead(headStart);
        System.out.println("After deletion of Head value is : "+headStart.data);

        Node newTemp = headStart;

        System.out.print("After deletion of Head Linked List is : ");

        while(newTemp != null){
            System.out.print(newTemp.data+" ");
            newTemp = newTemp.next;
        }




    }

    static int countLengthOfLL(Node head){
        Node temp = head;
        int count = 0;

        while(temp != null){
            temp=temp.next;
            count++;
        }
        return count;
    }

   static Node convertToLL(int [] arrPass){
        Node y = new Node(arrPass[0]);
        Node head = y;
        Node mover = head;

        for (int i=1; i <arrPass.length; i++){
            Node temp = new Node(arrPass[i]);
            mover.next = temp;
            mover=temp;
        }
        return head;
    }

    static boolean isPresent(Node head, int value){

        boolean present= false;

        Node temp = head;
        while( temp != null){
            if(temp.data == value){
                present = true;
            }
            temp = temp.next;
        }
        return present;
    }

    static Node deleteHead(Node head){

        if(head == null) return head;
        Node temp = head;
        head = head.next;
        return head;

    }
}

class Node{

    int data;
    Node next;

    Node(int data){
        this.data= data;
        this.next = null;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

}
