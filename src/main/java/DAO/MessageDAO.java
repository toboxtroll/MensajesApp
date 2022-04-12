package DAO;
import model.MessageApp;
import database.ConnecctionPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {

    public static void createMessage(MessageApp messageApp){
            PreparedStatement preparedStatement;
            try {
                Connection connection = ConnecctionPostgres.getConnectionPostgres();
                String query;
                query = "INSERT INTO public.mensajes(mensaje, autor_mensaje, fecha_mensaje)VALUES (?, ?, current_timestamp)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, messageApp.getMensaje());
                preparedStatement.setString(2, messageApp.getAutorMensaje());
                preparedStatement.executeUpdate();
                System.out.println("Message Create Successfully");
            } catch (Exception e){
                System.out.println("Error: " + e);
            }
    }

    public static void readMessage(){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            Connection connection = ConnecctionPostgres.getConnectionPostgres();
            String query;
            query = "SELECT * FROM mensajes";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id_mensaje"));
                System.out.println("Mensaje: " + resultSet.getString("mensaje"));
                System.out.println("Autor: " + resultSet.getString("autor_mensaje"));
                System.out.println("Fecha: " + resultSet.getString("fecha_mensaje"));
                System.out.println("-----------------------------------");
            }
        }catch (Exception exception){
            System.out.println(exception);
        }

    }

    public static void updateMessage(MessageApp messageApp){
        PreparedStatement preparedStatement;
        try {
            Connection connection = ConnecctionPostgres.getConnectionPostgres();

            String query = "UPDATE public.mensajes SET mensaje = ?, autor_mensaje = ?, fecha_mensaje = current_timestamp WHERE id_mensaje = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, messageApp.getMensaje());
            preparedStatement.setString(2, messageApp.getAutorMensaje());
            preparedStatement.setInt(3, messageApp.getIdMensaje());

            int countRowsUpdated = preparedStatement.executeUpdate();

            if (countRowsUpdated > 0){
                System.out.println("Message Update Successfully");
            } else {
                System.out.println("Error updating");
            }
        } catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static void deleteMessage(int idMensaje){
        PreparedStatement preparedStatement;
        try {
            Connection connection = ConnecctionPostgres.getConnectionPostgres();
            String query;
            query = "DELETE FROM public.mensajes WHERE id_mensaje = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idMensaje);
            int countRowsUpdated = preparedStatement.executeUpdate();

            if (countRowsUpdated > 0){
                System.out.println("Message Delete Successfully");
            } else {
                System.out.println("Error deleting: Record not exist");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
}
