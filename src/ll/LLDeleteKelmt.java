package ll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
public class LLDeleteKelmt {

    public static void main(String args[])
    {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(44);
        head.next.next.next.next.next=new Node(50);
        findPairsWithGivenSum2(30,head);
        findPairsWithGivenSum(30,head);
        printList(head);
        head=deleteKth(head,4);
        System.out.println("AFTER DELETE");
        printList(head);
        head=deleteKth(head,0);
        System.out.println("AFTER DELETE");

    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum2(int target, Node head) {
        Node temp=head;
        ArrayList<ArrayList<Integer>> mainL=new ArrayList();
        Set<Integer> set= new HashSet<>();
        while(temp!=null){
            int val =temp.data;
            int req=target-val;
            if(set.contains(req)){
                ArrayList<Integer> tempL= new ArrayList<Integer>();
                tempL.add(val);
                tempL.add(req);
                mainL.add(tempL);
            }
            set.add(val);
            temp=temp.next;
        }
        return mainL;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        Node temp=head;
        ArrayList<ArrayList<Integer>> mainL=new ArrayList<>();
        while(temp!=null){

            Node temp2=temp.next;
            while(temp2!=null){

                if(temp.data+temp2.data==target){
                    ArrayList<Integer> tempL= new ArrayList<Integer>();
                    tempL.add(temp.data);
                    tempL.add(temp2.data);
                    mainL.add(tempL);
                }
                temp2=temp2.next;
            }


            temp=temp.next;
        }
        System.out.println(mainL);
        return mainL;
    }

    private static void printList(Node head) {
        if (head==null) return;
        Node first=head;
        do{
            System.out.println(head.data);
            head=head.next;
        }
        while (head!=first);
    }

    private static Node deleteKth(Node head,int k) {
        if (k==0) deleteKth(head);
        Node curr=head;

        for (int i = 0; i < k-2; i++)
            curr = curr.next;
        curr.next = curr.next.next;
        return head;
    }
    private static Node deleteKth(Node head) {
       if (head==null) return null;
       if (head.next==head) return null;
        // 1    3       6       7
        // 3    3       6       7

       head.data=head.next.data;
       head.next=head.next.next;
       return head;

    }
}
