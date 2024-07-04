
import java.util.ArrayList;

public class Shipper extends People{
    private ArrayList<Bill> bills;
    private int salary;
    public Shipper(){

    }

    public Shipper(String name, String email, long phoneNumber, String address, int age, String gender, String password,ArrayList<Bill> bills, int salary){
        super(name, email, phoneNumber, address, age, gender, password);
        this.bills = bills;
        this.salary = salary;
    }

    public ArrayList<Bill> getBill(){
        return bills;
    }

    public int getSalary(){
        return this.salary;
    }

    @Override
    public String toString(){
        return String.format("______Shipper information_____\n- 1.Name: %s\n- 2.Email: %s\n- 3.Phone number: (+84) %d\n- 4.Address: %s\n- 5.Gender: %s\n- 6.Age: %d", this.getName(), this.getEmail(), this.getPhoneNumber(), this.getAddress(), this.getGender(), this.getAge());
    }

    @Override
    public void addBill(Bill bill){
        if(bill.getShipper() == null){
            bill.setShipper(this);
            this.bills.add(bill);
        }else{
            System.out.println("Can't add this bill!");
        }
        
    }




}
