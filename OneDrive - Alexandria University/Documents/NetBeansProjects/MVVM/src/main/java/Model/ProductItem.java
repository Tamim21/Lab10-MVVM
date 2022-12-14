package Model;
import java.sql.*;
/**
 *
 * @author Tamim
 */
public class ProductItem {
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    String password = "";
    
    public ProductItem(){
        
        try {
            Connection cn = DriverManager .getConnection(url,username,password);
            Statement state = cn.createStatement();
            ResultSet resultSet = state.executeQuery("select * from testTable1");
            while(resultSet.next()) System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
        }
    }
    
}
