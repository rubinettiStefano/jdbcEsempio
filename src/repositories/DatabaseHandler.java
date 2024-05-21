package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Person;

public class DatabaseHandler 
{
    private Connection con;
    private PersonRepository pRepo; 

    public DatabaseHandler(String dbName)
    {
        String dbUrl = "jdbc:mysql://localhost:3306/"+dbName;
        try 
        {
            //ne avremo una sola in tutto il programma
            con = DriverManager.getConnection(dbUrl, "jaita", "jaita121");
            pRepo = new PersonRepository(con);

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void insertPerson(Person p)
    {
        try 
        {
            pRepo.insert(p);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }  
        
    }
}
