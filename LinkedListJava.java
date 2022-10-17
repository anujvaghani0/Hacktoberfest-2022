import java.util.LinkedList;

/**
 * @author rajeshp
 * @Date 10/16/22
 */
  //Java Program, for Singly Linked List
public class LinkedListJava {

        Node head; // head of list

        // Linked list Node.
        // This inner class is made static
        // so that main() can access it
        static class Node {

            int data;
            Node next;

            // Constructor
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        // Method to insert a new node
        public static LinkedListJava insert(LinkedListJava list, int data)
        {
            // Create a new node with given data
            Node new_node = new Node(data);


            // If the Linked List is empty,
            // then make the new node as head
            if (list.head == null) {
                list.head = new_node;
            }
            else {
                // Else traverse till the last node
                // and insert the new_node there
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }

                // Insert the new_node at last node
                last.next = new_node;
            }

            // Return the list by head
            return list;
        }

        // Method to print the LinkedList.
        public static void printList(LinkedListJava list)
        {
            Node currNode = list.head;

            System.out.print("Linked List: ");

            // Traverse through the LinkedList
            while (currNode != null) {
                // Print the data at current node
                System.out.print(currNode.data + " ");

                // Go to next node
                currNode = currNode.next;
            }
        }

        // Main Function
        public static void main(String[] args)
        {
            /* Start with the empty list. */
            LinkedListJava list = new LinkedListJava();

            // Insert the values
            list = insert(list, 100);
            list = insert(list, 200);
            list = insert(list, 300);
            list = insert(list, 400);
            list = insert(list, 500);
            list = insert(list, 600);
            list = insert(list, 700);
            list = insert(list, 800);

            // Print the LinkedList
            printList(list);
        }
    }

