import java.sql.*;
import java.util.ArrayList;
public class NamesAndSurnames {



    final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
    final String USER = "root";
    final String PASS = "admin";
    Connection connection = null;
    ArrayList<String> surnames = new ArrayList<>();
    public void getNames(){
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String queryTakeNameAndSurname = ""
                    + "SELECT last_name, first_name FROM newdb.students;";
            ResultSet resultSet = statement.executeQuery(queryTakeNameAndSurname);
            while (resultSet.next()){
                String last_name = resultSet.getString("last_name");
                String first_name = resultSet.getString("first_name");

                System.out.println(last_name);

                surnames.add(first_name);
            }
            surnames.forEach(System.out::println);

            statement.close();
            resultSet.close();
            connection.close();
            System.out.println("eseguito con successo");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
