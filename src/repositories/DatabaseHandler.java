package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Person> selectAll()
    {
        try 
        {
            return pRepo.selectAll();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }  
    }

    public ArrayList<Person> select(String condition)
    {
        try 
        {
            return pRepo.select(condition);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }  
    }

    public Person select(int id)
    {
        try 
        {
            return pRepo.select(id);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
            return null;
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

    public void updatePerson(Person p)
    {
        try 
        {
            pRepo.update(p);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }  
    }

    public void deletePerson(Person p)
    {
        try 
        {
            pRepo.delete(p);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }  
    }

    public void deletePerson(int id)
    {
        try 
        {
            pRepo.delete(id);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }  
    }
}
