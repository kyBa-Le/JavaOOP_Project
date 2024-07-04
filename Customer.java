
import java.util.ArrayList;



public class Customer extends People{
    private ArrayList<Bill> bills;
    public Customer(){
        super();
    }
    public Customer(String name, String email, long phoneNumber, String address,int age, String gender, String password, ArrayList<Bill> bills){
        super(name, email, phoneNumber, address, age, gender, password);
        this.bills = bills;
    }

    @Override
    public String toString(){
        return String.format("______Personal information_____\n- 1.Name: %s\n- 2.Email: %s\n- 3.Phone number: (+84) %d\n- 4.Address: %s\n- 5.Gender: %s\n- 6.Age: %d", this.getName(), this.getEmail(), this.getPhoneNumber(), this.getAddress(), this.getGender(), this.getAge());
    }

    
    public ArrayList<Bill> getBill(){
        return this.bills;
    }

    @Override
    public void addBill(Bill bill){
        this.bills.add(bill);
    }

    
}