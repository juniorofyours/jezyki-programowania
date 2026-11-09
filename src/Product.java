import java.util.HashSet;

public class Product {
    private int productId;
    private int costInGroszy;
    private String productName;
    private int productCount;

    public Product(int productId, int costInGroszy, String productName) {
        this.costInGroszy = costInGroszy;
        this.productId = productId;
        this.productName = productName;
        this.productCount = 0;
    }

    /*gettery i settery*/
    public int getProductId() {
        return this.productId;
    }
    public int getCostInGroszy() {
        return this.costInGroszy;
    }
    public int getProductCount() {
        return productCount;
    }
    public String getProductName() {
        return this.productName;
    }

    public void addToProductCount() {
        this.productCount = productCount+1;
    }


    //nadpisywanie metod hashCode i equals
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //jak ma sie wypisywac zbior produktow?
    @Override
    public String toString() {
        //kazdy produkt bedzie wypisywac sie jako jego nazwa i liczba szt
        return productName + "   " + productCount + "szt. ";
    }
}
