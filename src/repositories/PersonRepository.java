package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Person;

public class PersonRepository 
{
    private Connection con;

    public PersonRepository(Connection con)
    {
        this.con = con;
    }


    public ArrayList<Person> selectAll() throws SQLException
    {
        return select("1=1");
    }

    public ArrayList<Person> select(String condition) throws SQLException
    {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM person WHERE ?");
        ps.setString(1, condition);

        ArrayList<Person> res = new ArrayList<>();
        ResultSet rs = ps.executeQuery();

        while(rs.next())
            res.add(convertToPerson(rs));

        return res;
    }

    public Person select(int id) throws SQLException
    {
        return select("id="+id).get(0);
    }

    private Person convertToPerson(ResultSet rs) throws SQLException
    {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setSurname(rs.getString("surname"));

        return p;
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

    public void update(Person p) throws SQLException
    {
        String query = "UPDATE person SET name=?,surname=? WHERE id=?";
        
        PreparedStatement pStatement = con.prepareStatement(query);
        pStatement.setString(1, p.getName());
        pStatement.setString(2, p.getSurname());
        pStatement.setInt(3, p.getId());


        pStatement.execute();
        pStatement.close();
    }

    public void delete(int id) throws SQLException
    {
        String query = "DELETE FROM person WHERE id=?";
        
        PreparedStatement pStatement = con.prepareStatement(query);
        pStatement.setInt(1,id);


        pStatement.execute();
        pStatement.close();
    }

    public void delete(Person p) throws SQLException
    {
        delete(p.getId());
    }
    
    
}
