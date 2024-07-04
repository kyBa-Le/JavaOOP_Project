

public class Bill {
    private Food foods;
    private Customer customers;
    private Seller sellers;
    private Shipper shippers = new Shipper();
    private int quantyties;
    private int totalPrice;
    public Bill(){
    
    }

    public Bill(Food foods, Customer customers, int quantyties){
        this.foods = foods;
        this.customers = customers;
        this.quantyties = quantyties;
        this.totalPrice = this.quantyties * foods.getPrice();
        this.sellers = foods.getSeller();
    } 

    public Bill(Food foods, Customer customers, Shipper shippers, int quantyties){
        this(foods,customers,quantyties);
        this.shippers = shippers;
    }


    @Override
    public String toString(){
        return "_________Bill_________\n" + String.format("- Food name:%s\n- Ordered Person: %s\n- Seller: %s\n- Delivery person: %s\n- Quantities: %d\n- Total price: %d VND", foods.getName(),customers.getName(),foods.getSeller().getName(),shippers.getName(),this.quantyties, this.totalPrice);
    }

    public String shortBill(int i){
        return String.format("%d. %s : %d VND",i,this.foods.getName(), this.totalPrice);
    }

    public Food getFood(){
        return this.foods;
    }

    public Customer getCustomer(){
        return this.customers;
    }

    public Seller getSeller(){
        return this.sellers;
    }
    
    public int getQuantities(){
        return this.quantyties;
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }

    public Shipper getShipper(){
        return this.shippers;
    }

    public void setShipper(Shipper shipper){
        if(this.shippers.getName() == null){
            this.shippers = shipper;
        }
    }

}
