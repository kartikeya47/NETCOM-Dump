import java.util.Scanner;

class HammingCode {
    public HammingCode() {
        Scanner sc = new Scanner(System.in);
        int message[] = new int[20];
        int received[] = new int[20];
        int i;
        int c1, c2, c3;
        int error[] = new int[20];
        int count = 0;

        System.out.println("This program would only run properly for message of size: 4 bits!");

        System.out.println();

        System.out.println("Enter the message bits one-by-one in a sequence of D0, D1, D2, D4: ");

        message[0] = sc.nextInt();
        message[1] = sc.nextInt();
        message[2] = sc.nextInt();
        message[4] = sc.nextInt();

        c1 = message[0] ^ message[2] ^ message[4];
        c2 = message[0] ^ message[1] ^ message[4];
        c3 = message[0] ^ message[1] ^ message[2];

        message[6] = c1;
        message[5] = c2;
        message[3] = c3;

        System.out.println("The encoded message is: ");

        for (i = 0; i < 7; i++) {
            System.out.print(message[i]);
        }

        System.out.println();

        System.out.println("Enter the message that you received one-by-one: ");

        for (i = 0; i < 7; i++) {
            received[i] = sc.nextInt();
        }

        for (i = 0; i < 7; i++) {
            if (message[i] != received[i]) {
                error[count] = 7 - i;
                count++;
            }
        }

        if (count == 0)
            System.out.println("No Error!");
        else {
	    System.out.println("There is an error!");
            for (i = 0; i < count; i++)
                System.out.println("The errored bit position is: " + error[i]);
        }
    }
    public static void main(String args[]) {
        HammingCode hc = new HammingCode();
    }
}