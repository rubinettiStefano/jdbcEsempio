package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Person;

public class PersonRepository 
{
    private Connection con;

    public PersonRepository(Connection con)
    {
        this.con = con;
    }


    //Eccezioni Checked e Unchecked
    //Unchecked sono quelle che abbiamo visto fino ad ora
    //Le Checked vi obbligano a dichiarare una gestione ESPLICITA dell'eccezione

    public void insert(Person p) throws SQLException
    {
        String query = "INSERT INTO person (name,surname) VALUES ( ?,  ?);";
        
        PreparedStatement pStatement = con.prepareStatement(query);
        pStatement.setString(1, p.getName());
        pStatement.setString(2, p.getSurname());


        pStatement.execute();
        pStatement.close();
    }
    
}
