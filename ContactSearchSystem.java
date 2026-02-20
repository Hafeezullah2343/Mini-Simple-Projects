package SmallProject;

import java.util.Scanner;

// Node class for Linked List (Chaining)
class Node {
    String name;
    String phone;
    Node next;

    Node(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.next = null;
    }
}

public class ContactSearchSystem {

    private Node[] table;
    private int size;

    // Constructor
    public ContactSearchSystem(int size) {
        this.size = size;
        table = new Node[size];
    }

    // Custom Hash Function
    private int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        return hash % size;
    }

    // Insert Contact
    public void addNewContact(String name, String phone) {

        int index = hashFunction(name);

        Node newNode = new Node(name, phone);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node temp = table[index];

            while (temp != null) {
                if (temp.name.equals(name)) {
                    System.out.println("Contact already exists!");
                    return;
                }
                if (temp.next == null)
                    break;
                temp = temp.next;
            }

            temp.next = newNode; // chaining
        }

        System.out.println("Contact added successfully.");
    }

    // Search by Name
    public void searchContactByName(String name) {

        int index = hashFunction(name);

        Node temp = table[index];

        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println("Phone Number: " + temp.phone);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Contact not found.");
    }

    // Delete Contact
    public void deleteContact(String name) {

        int index = hashFunction(name);

        Node temp = table[index];
        Node prev = null;

        while (temp != null) {

            if (temp.name.equals(name)) {

                if (prev == null)
                    table[index] = temp.next;
                else
                    prev.next = temp.next;

                System.out.println("Contact deleted successfully.");
                return;
            }

            prev = temp;
            temp = temp.next;
        }

        System.out.println("Contact not found.");
    }

    // Update Contact
    public void updateContact(String name, String newPhone) {

        int index = hashFunction(name);

        Node temp = table[index];

        while (temp != null) {
            if (temp.name.equals(name)) {
                temp.phone = newPhone;
                System.out.println("Contact updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Contact not found.");
    }

    // Display All Contacts
    public void displayContacts() {

        for (int i = 0; i < size; i++) {
            Node temp = table[i];
            while (temp != null) {
                System.out.println("Name: " + temp.name +
                        ", Phone: " + temp.phone);
                temp = temp.next;
            }
        }
    }

    // Menu Driven
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactSearchSystem system = new ContactSearchSystem(10);

        int choice;

        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display Contacts");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    system.addNewContact(name, phone);
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    system.searchContactByName(name);
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter New Phone: ");
                    phone = sc.nextLine();
                    system.updateContact(name, phone);
                    break;

                case 4:
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    system.deleteContact(name);
                    break;

                case 5:
                    system.displayContacts();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
