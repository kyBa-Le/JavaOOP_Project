import java.util.ArrayList;

public class Seller extends People{
    private ArrayList<Food> foods;
    private ArrayList<Bill> bills;
    public Seller(){

    }
    public Seller(String name, String email, long phoneNumber, String address, int age, String gender, String password, ArrayList<Food> foods, ArrayList<Bill> bills){
        super(name, email, phoneNumber, address, age, gender, password);
        this.foods = foods;
        this.bills = bills;
    }

    public String toString(){
        return String.format("______Seller information_____\n- 1.Name: %s\n- 2.Email: %s\n- 3.Phone number: (+84) %d\n- 4.Address: %s\n- 5.Gender: %s\n- 6.Age: %d", this.getName(), this.getEmail(), this.getPhoneNumber(), this.getAddress(), this.getGender(), this.getAge());

    }

    @Override
    public void addBill(Bill bill){
        this.bills.add(bill);
    }

    public void addFood(Food food){
        this.foods.add(food);
    }

    public void removeFood(Food food){
        this.foods.remove(food);
    }

    public ArrayList<Food> getFoods(){
        return this.foods;
    }

    public ArrayList<Bill> getBills(){
        return this.bills;
    }

}
