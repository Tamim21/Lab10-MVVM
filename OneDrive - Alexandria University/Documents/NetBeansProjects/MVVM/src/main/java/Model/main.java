package Model;

import View.*;

/**
 *
 * @author Tamim
 */
                            //THIS CLASS IS ONLY FOR TESTING
public class main {
    public static void main(String[] args){
        /*AddProductScreen aps = new AddProductScreen();
        ViewProductScreen vps = new ViewProductScreen();*/
        ProductItem p = new ProductItem();
        p.readData();
        p.readCart();
        
        for(int i = 0 ;i<p.products.size();i++)
        System.out.println(p.products.get(i).getName());
        
        for(int i = 0 ;i<p.cart.size();i++)
        System.out.println(p.cart.get(i).getName());

		
    
}
}
