import java.util.Scanner;

class SupportQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public SupportQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Add customer to queue
    public void enqueue(String customerName) {
        if (isFull()) {
            System.out.println("Queue full! Cannot accept more tickets.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = customerName;
        size++;
        System.out.println("Ticket added for: " + customerName);
    }

    // Serve customer
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("No customers to serve.");
            return;
        }
        String served = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Served customer: " + served);
    }

    // Peek front customer
    public void peek() {
        if (isEmpty()) {
            System.out.println("No tickets in queue.");
            return;
        }
        System.out.println("Next customer to be served: " + queue[front]);
    }

    // Display queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Current queue:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.println((i + 1) + ". " + queue[index]);
        }
    }
}

public class SupportQueueApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SupportQueue supportQueue = new SupportQueue(5); // You can change the capacity
        int choice;
        String name;

        do {
            System.out.println("\n==== Customer Support Queue ====");
            System.out.println("1. Add new ticket");
            System.out.println("2. Serve next customer");
            System.out.println("3. View next customer");
            System.out.println("4. Show full queue");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    name = sc.nextLine();
                    supportQueue.enqueue(name);
                    break;
                case 2:
                    supportQueue.dequeue();
                    break;
                case 3:
                    supportQueue.peek();
                    break;
                case 4:
                    supportQueue.displayQueue();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
