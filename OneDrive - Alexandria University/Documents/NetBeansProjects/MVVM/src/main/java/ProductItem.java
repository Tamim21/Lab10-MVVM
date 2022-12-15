
/**
 *
 * @author Tamim
 */
public class ProductItem {
    private String Id;
    private String name;
    private int price;
    private String image;
    private int items;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = (price>0)?(price):0;;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = (items>0)?(items):0;
    }  
}
