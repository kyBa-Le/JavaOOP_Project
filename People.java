
import java.util.Scanner;

public abstract class People {
    private String name;
    private String email;
    private  long phoneNumber;
    private String address;
    private int age;
    private String gender;
    private String password;


    public abstract void addBill(Bill bill);
    public People(){
    }
    public People(String name, String email, long phoneNumber, String address, int age, String gender, String password){
        boolean checkGender = (gender.equals("male") || gender.equals("female") ||gender.equals("Other"));
        if(name.length()>0 && 99999999<phoneNumber && phoneNumber<1000000000 && address.length()>0 && age>0 && checkGender && password.length() == 4){
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.age = age;
            this.gender = gender;
            this.password = password;
        }
        
    }
    public String getName(){
        return this.name;
    }
    
    public String getEmail(){
        return this.email;
    }

    public long getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getAddress(){
        return this.address;
    }
    
    public int getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }

    public String getPassword(){
        return this.password;
    }

    public void setName(String name){
        if(name.length()>0){
            this.name = name;
            System.out.println("Change name success!");
        }else{
            System.out.println("Invalid!");
        }  
    }

    public void setEmail(String email){
        if(email.length()>0){
            this.email = email;
            System.out.println("Change email success!");
        }else{
            System.out.println("Invalid!");
        }
        
    }

    public void setPhoneNumber(long phoneNumber){
        if(99999999<phoneNumber && phoneNumber<1000000000){
            this.phoneNumber = phoneNumber;
            System.out.println("Change phone number success!");
        }else{
            System.out.println("Invalid!");
        }
        
    }

    public void setAddress(String address){
        if(address.length()>0){
            this.address = address;
            System.out.println("Change address success!");
        }else{
            System.out.println("Invalid!");
        }
        
    }
    
    public void setAge(int age){
        if(age > 15){
            this.age = age;
            System.out.println("Change age success");
        }else{
            System.out.println("Invalid!");
        }
    }

    public void setGender(String gender){
        if(gender.equals("male") || gender.equals("female") ||gender.equals("Other")){
            this.gender = gender;
            System.out.println("Change gender success!");
        }else{
            System.out.println("Invalid!");
        }
        
    }

    public void setPassword(String password){
        if(password.length() > 0){
            this.password = password;
        }else{
            System.out.println("Invalid!");
        }
    }

    public void InformationPrograme(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("\n\t\t_____Information____");
            System.out.print("1.Personal information    2.Edit information    3.Edit account    4.Exit\n-->:");
            int choice = input.nextInt();
            //Xem thông tin cơ bản
            if(choice == 1){
                System.out.println(this.toString());
                while (true) {
                    System.out.println("\nPress enter to exit!");
                    input.nextLine();
                    String exit = input.nextLine();
                    if(exit.equals("")){
                        break;
                    }
                }
                
            }else if(choice == 2){
            // chỉnh sửa thông tin
                System.out.println("__Edit information programe__");
                System.out.println(this.toString());
                System.out.println("0. Exit");
                System.out.println("\n___Choose the information you want to edit (1 - 6)__");
                EditInformation:
                while (true) { 
                    System.out.println("(Type)-->:");
                    choice = input.nextInt();
                    switch (choice) {
                        case 0:
                            System.out.println("Closed edit information!");
                            break EditInformation;
                        case 1:
                            System.out.print("\nEnter new name:");
                            input.nextLine();
                            this.setName(input.nextLine());
                            break EditInformation;
                        case 2:
                            System.out.print("\nEnter new email:");
                            input.nextLine();
                            this.setEmail(input.nextLine());
                            break EditInformation;
                        case 3:
                            System.out.print("\nEnter new phone number (+84):");
                            this.setPhoneNumber(input.nextLong());
                            break EditInformation;
                        case 4:
                            System.out.print("\nEnter new address:");
                            input.nextLine();
                            this.setAddress(input.nextLine());
                            break EditInformation;
                        case 5: 
                            System.out.print("\nEnter new gender (male/female/other)\n-->:");
                            input.nextLine();
                            this.setGender(input.nextLine());
                            break EditInformation;
                        case 6:
                            System.out.println("\nEnter new age (>15):");
                            this.setAge(input.nextInt());
                            break EditInformation;
                        default:
                            System.out.println("Invalid number!\n");
                    }
                }
            }else if(choice == 3){
            //Chỉnh sửa tài khoản
                while(true){
                    System.out.println("____Edit account___");
                    System.out.println("- 1.Phone number:" + this.getPhoneNumber());
                    System.out.println("- 2.Password: " + this.getPassword());
                    System.out.println("- 0. Exit");
                    System.out.print("\n--Choose here:");
                    choice = input.nextInt();
                    if(choice == 1){
                            System.out.print("\nEnter new phone number (+84):");
                            this.setPhoneNumber(input.nextLong());
                            System.out.println("__Change phone number succesfu!__\n");
                    }else if(choice ==2){
                        input.nextLine();
                        System.out.print("\nEnter new password (4 character):");
                        String password1 = input.nextLine();
                        System.out.print("\nEnter again to confirm:");
                        String password2 = input.nextLine();
                        if(password1.equals(password2)){
                            this.setPassword(password2);
                            System.out.println("__Change password successfull!__\n");
                        }else{
                            System.out.println("Incorrect!");
                        }    

                    }else if(choice == 0){
                        System.out.println("Exit __edit account__");
                        break;
                    }else{
                        System.out.println("Invalid number!");
                    }
                }
            }else if(choice == 4){
                System.out.println("Exit information programe!");
                break;
            }
        }
    }
}
