package services;
import DAO.MessageDAO;
import model.MessageApp;
import java.util.Scanner;

public class MessageService {

    public static void createMessage(){
        System.out.println("Write your message");
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        System.out.println("Write your name");
        String author = sc.nextLine();

        MessageApp recordMessage;
        recordMessage = new MessageApp();
        recordMessage.setMensaje(message);
        recordMessage.setAutorMensaje(author);

        MessageDAO.createMessage(recordMessage);

    }

    public static void listMessages(){
        MessageDAO.readMessage();
    }

    public static void updateMessage(){
        MessageApp recordMessage;
        Scanner sc = new Scanner(System.in);
        String message;
        String author;

        listMessages();
        System.out.println("Select message to update:");
        String idMessage = sc.nextLine();

        System.out.println("Write your message");
        message = sc.nextLine();

        System.out.println("Write your name");
        author = sc.nextLine();

        recordMessage = new MessageApp();
        recordMessage.setIdMensaje(Integer.parseInt(idMessage));
        recordMessage.setMensaje(message);
        recordMessage.setAutorMensaje(author);
        MessageDAO.updateMessage(recordMessage);
    }

    public static void deleteMessage(){
        listMessages();
        System.out.println("Select message to delete: ");

        Scanner sc = new Scanner(System.in);
        int idMessage = sc.nextInt();

        MessageDAO.deleteMessage(idMessage);


    }
}
