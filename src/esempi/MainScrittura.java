package esempi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Person;

public class MainScrittura 
{
    public static void main(String[] args) 
    {
        String dbUrl = "jdbc:mysql://localhost:3306/jdbcesempio";
        try 
        {
            //ne avremo una sola in tutto il programma
            Connection con = DriverManager.getConnection(dbUrl, "jaita", "jaita121");

            //tramite la connessione, possiamo creare uno STATEMENT, una ISTRUZIONE DA MANDARE AL DB

            Statement statement = con.createStatement();//aprire una query bianca su mysqlWorkbench

            String query = "INSERT INTO person (name,surname) VALUES ('Eva','Lopez');";

            statement.execute(query);

            statement.close();



        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
