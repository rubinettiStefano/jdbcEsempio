package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Person;

public class Main 
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

            String query = "SELECT * FROM person";


            ResultSet rs = statement.executeQuery(query);//qui mandiamo la query al db che ci risponde con un resultSet

            //il metodo che fa avanzare il puntatore viene detto next

            //next in realtà, è questo è veramente brutto e obsoleto
            //fa 2 cose
            //manda avanti il cursore
            //ci dice se abbiamo ancora righe da leggere
            ArrayList<Person> people = new ArrayList<>();
            
            while (rs.next()) 
            {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int id = Integer.parseInt(rs.getString("id"));

                people.add(new Person(id, name, surname));
            }

            statement.close();
            for(Person p : people)
                System.out.println(p);








        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
