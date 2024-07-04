public class Food {
    private String name;
    private int price;
    private int quantity;
    private Seller seller;

    public Food(){

    }

    public Food(String name, int price, int quantity, Seller seller){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller = seller;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public Seller getSeller(){
        return this.seller;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("-Food name: %s\n-Food price: %d\n-Quantities in stock: %d\n-Seller: ",this.name,this.price,this.quantity,this.seller.getName());
    }

    
}
