import java.sql.*;
public class conn {

    Connection c;
    Statement s;

     
    public conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///Bankmanagementsystem";
            String user = "root";
            String password = System.getenv("DB_PASSWORD");;
            c = DriverManager.getConnection(url,user,password);
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
