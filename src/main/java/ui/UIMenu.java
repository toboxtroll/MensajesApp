package ui;
import java.util.Scanner;
import services.MessageService;

public class UIMenu {

    public static void showMenu(){
        System.out.println("Welcome Messages App");
        System.out.println("Select a desired option");
        int response;

        do {
            System.out.println("--------------------------------------");
            System.out.println("1. Create Message");
            System.out.println("2. List Message");
            System.out.println("3. Update Message");
            System.out.println("4. Delete Message");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    System.out.println("Create Message");
                    MessageService.createMessage();
                    break;

                case 2:
                    System.out.println("List Message");
                    MessageService.listMessages();
                    break;

                case 3:
                    System.out.println("Update Message");
                    MessageService.updateMessage();
                    break;

                case 4:
                    System.out.println("Delete Message");
                    MessageService.deleteMessage();
                    break;

                case 0:
                    System.out.println("Thank you for you visit");

                    break;
                default:
                    System.out.println("Please select a correct answer");
            }

        }while (response != 0);
    }
}
