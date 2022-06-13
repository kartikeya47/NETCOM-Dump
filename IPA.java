import java.util.Scanner;

class IPA {
    int checkNumberOfDots(String ip) {
        int i;
        int count = 0;
        for (i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') {
                count++;
            }
        }
        if (count == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    int convertToInt(String ip_part) {
        return Integer.parseInt(ip_part);
    }

    String extractFirstPartOfTheIP(String ip) {
        int i;
        String new_ip = "";
        for (i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') {
                new_ip = ip.substring(0, i);
                break;
            }
        }
        return new_ip;
    }

    int checkClassOfIp(int ip) {
        if (ip >= 0 && ip <= 127)
            return 0;
        else if (ip >= 128 && ip <= 191)
            return 1;
        else if (ip >= 192 && ip <= 223)
            return 2;
        else if (ip >= 224 && ip <= 239)
            return 3;
        else if (ip >= 240 && ip <= 255)
            return 4;
        else
            return -1;
    }

    void nameOfClasses(int class_number) {
        if (class_number == 0)
            System.out.println("Class A IP Address");
        if (class_number == 1)
            System.out.println("Class B IP Address");
        if (class_number == 2)
            System.out.println("Class C IP Address");
        if (class_number == 3)
            System.out.println("Class D IP Address");
        if (class_number == 4)
            System.out.println("Class E IP Address");
        if (class_number == -1)
            System.out.println("Invalid IP Address (Out of Range of Classes)");
    }

    void display(String ipa) {
        System.out.println("IP Address is: " + ipa);
    }
}

class Main {
    public static void main(String args[]) {
        IPA ob = new IPA();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP Address in the format (XXX.XXX.XXX.XXX): ");
        String ipa;
        ipa = sc.nextLine();
        ob.display(ipa);
        sc.close();
        if (ob.checkNumberOfDots(ipa) == 0) {
            System.out.println("Invalid IP4 Address");
        } else {
            String first_part = ob.extractFirstPartOfTheIP(ipa);
            int num_ip = ob.convertToInt(first_part);
            int ip_class = ob.checkClassOfIp(num_ip);
            ob.nameOfClasses(ip_class);
            
        }

    }

}