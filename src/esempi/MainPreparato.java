package esempi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Person;

public class MainPreparato 
{
    public static void main(String[] args) 
    {
         String dbUrl = "jdbc:mysql://localhost:3306/jdbcesempio";
        try 
        {
            //ne avremo una sola in tutto il programma
            Connection con = DriverManager.getConnection(dbUrl, "jaita", "jaita121");

            //tramite la connessione, possiamo creare uno STATEMENT, una ISTRUZIONE DA MANDARE AL DB

            // Statement statement = con.createStatement();//aprire una query bianca su mysqlWorkbench

            Person p = new Person();
            p.setName("Alfonso");
            p.setSurname("Niceforo");
                        //                                             1   2
            String query = "INSERT INTO person (name,surname) VALUES ( ?,  ?);";
            
            PreparedStatement pStatement = con.prepareStatement(query);
            pStatement.setString(1, p.getName());
            pStatement.setString(2, p.getSurname());


            pStatement.execute();
            pStatement.close();
           
            if(true) System.out.println("ciao");



        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }    
    }
}
