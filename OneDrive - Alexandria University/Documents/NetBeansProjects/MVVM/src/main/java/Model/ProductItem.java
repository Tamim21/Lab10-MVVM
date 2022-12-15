package Model;
import java.sql.*;
import ViewModel.*;
import java.util.ArrayList;

/**
 *
 * @author Tamim
 */
public class ProductItem {
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "T@m10102002";
    private ArrayList <String> name = new ArrayList<String>();
    private ArrayList <String> Id = new ArrayList<String>();;
    private ArrayList <Integer> price= new ArrayList<Integer>();
    private ArrayList <String> image= new ArrayList<String>();
    private ArrayList <Integer> item= new ArrayList<Integer>();
    
    public ProductItem(){
       
    }
    public void read (){
         name.clear();
         Id.clear();
         image.clear();
         price.clear();
         item.clear();
         try {
            Connection cn = DriverManager .getConnection(url,username,password);
            Statement state = cn.createStatement();
            ResultSet resultSet = state.executeQuery("select * from products");
            while(resultSet.next()) {
                Id.add(resultSet.getString(1));
                name.add(resultSet.getString(2));
                price.add(resultSet.getInt(3));
                image.add(resultSet.getString(4));
                item.add(resultSet.getInt(5));
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
        }
    }
    public void purchaseCompleted (String Id){
         try {
            Connection cn = DriverManager .getConnection(url,username,password);
            Statement state = cn.createStatement();
            ResultSet resultSet = state.executeQuery("select * from products WHERE Id LIKE "+Id);
            int items = 0;
            while(resultSet.next()) items = resultSet.getInt(5);
            PreparedStatement state1 = cn.prepareStatement("Update products SET items = "+Integer.toString(--items)+" where Id = "+"'"+Id+"'");
            state1.execute();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
        }
        read();
        
    }
    
}
