package Model;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Tamim
 */
public class ProductItem {
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "T@m10102002";
    public ArrayList <Phone> products = new ArrayList<>();
    public ArrayList <Phone> cart = new ArrayList<>();
    /*private AddProductViewModel aps;
    private ViewProductViewModel vps;*/
    

    /*public ProductItem(AddProductViewModel aps) {
        this.aps = aps;
        this.aps.attachM(this);   
    }
    public ProductItem(ViewProductViewModel vps) {
        this.vps = vps;
        //this.aps.attachM(this);   
    }*/
    public ProductItem(){
        readData();
    }
    public void readData (){
         products.clear();
         try {
            Connection cn = DriverManager .getConnection(url,username,password);
            Statement state = cn.createStatement();
            ResultSet resultSet = state.executeQuery("select * from products");
            while(resultSet.next()) {
                Phone pp = new Phone();
                pp.setId(resultSet.getString(1));
                pp.setName(resultSet.getString(2));
                pp.setPrice(resultSet.getInt(3));
                pp.setImage(resultSet.getString(4));
                pp.setItems(resultSet.getInt(5));
                products.add(pp);
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
            ResultSet resultSet1 = state.executeQuery("select * from products WHERE Id LIKE "+Id);
            PreparedStatement state1 = cn.prepareStatement("insert into cart (Id,Name,price) select Id,Name,price from products where Id IN('" + Id + "')");
            state1.execute();
            int items = 0;
            while(resultSet1.next()) items = resultSet1.getInt(5);
            PreparedStatement state2 = cn.prepareStatement("Update products SET items = "+Integer.toString(--items)+" where Id = "+"'"+Id+"'");
            state2.execute();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
        }
        readData();      
    }
    public void readCart (){
        cart.clear();
         try {
            Connection cn = DriverManager .getConnection(url,username,password);
            Statement state = cn.createStatement();
            ResultSet resultSet = state.executeQuery("select * from cart");
            while(resultSet.next()) {
                Phone pp = new Phone();
                pp.setId(resultSet.getString(1));
                pp.setName(resultSet.getString(2));
                pp.setPrice(resultSet.getInt(3));
                cart.add(pp);
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
        }
    }
    
}
