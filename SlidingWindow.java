import java.util.Scanner;

class SlidingWindow {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        String sender_buffer;
        String receiver_buffer = "";
        char sender_arr[] = new char[50];
        char receiver_arr[] = new char[50];
        int window;

        System.out.println("Enter the Window Size: ");
        window = sc.nextInt();
        System.out.println("The sender's window has been expanded for the purpose of sending the data.");
        System.out.println();
        System.out.println("Enter the data that you want to send: ");
        sc.nextLine();
        sender_buffer = sc.nextLine();

        sc.close();

        int i;
        int count = 0;
        try {
            for (i = 0; i < window; i++) {
                sender_arr[i] = sender_buffer.charAt(i);
                count = count + 1;
            }
        } catch (StringIndexOutOfBoundsException siobe) {
            System.out.println("Window Size that has been defined is more than the length of data entered.");
        }

        for (i = 0; i < window; i++) {
            receiver_arr[i] = sender_arr[i];
        }
        receiver_arr[i] = '0';

        sender_buffer = "";

        for (i = 0; i < window; i++) {
            receiver_buffer = receiver_buffer + receiver_arr[i];
            sender_buffer = sender_buffer + sender_arr[i];
        }

        System.out.println("The message that has been sent from the sender is: " + sender_buffer);
        System.out.println();

        System.out.println("The receiver's window has been expanded for the purpose of receiving the data.");
        System.out.println();

        System.out.println("The Acknowledgement from the receiver is: ");
        for (i = 0; i < count; i++)
            ;

        System.out.println("Ack: " + i);
        System.out.println();

        System.out.println("The message that has been received by the receiver is: " + receiver_buffer);
        System.out.println();

        System.out.println("The Window Size of the receiver has been shrinked.");

    }
}