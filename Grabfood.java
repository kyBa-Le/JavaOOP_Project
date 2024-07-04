import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Grabfood {
    public static void main(String[] args) {
        RunData();
        Scanner input = new Scanner(System.in);
        Customer user1;
        Shipper user2;
        Seller user3;
        int choice;
        Home: while (true) {
            while (true) {
                try {
                    System.out.println("---------- Grab food ----------");
                    System.out.println("           Welcome!");
                    System.out.println("1. Sign in     2.Sign up    3.Close");
                    System.out.println("\n  Please choose! ");
                    System.out.print("-->:");
                    choice = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    input.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    ChangePage();
                    long phoneNumber;
                    String passWord;
                    System.out.println("-".repeat(55));
                    System.out.println("________________________Log in______________________________");
                    System.out.println("-Enter your phone number:______\n-Enter your password:______");
                    System.out.println("\n-Which is your role? ?\n");
                    System.out.println("1. Customer     2. Shipper      3. Seller");
                    System.out.println("\n_________________________Type___________________________");

                    // Nhập số điện thoại để đăng nhập
                    while (true) {
                        while (true) {
                            try {
                                System.out.print("\n--> Phone number (9 numbers)       (+84):");
                                phoneNumber = input.nextLong();
                                break;
                            } catch (InputMismatchException e) {
                                input.nextLine();
                            }
                        }
                        if (99999999 < phoneNumber && phoneNumber < 1000000000) {
                            break;
                        } else {
                            System.out.print("You entered the invalid number!");
                        }
                    }
                    // Nhập mật khâu để đăng nhập
                    while (true) {
                        input.nextLine();
                        System.out.print("\n--> Password (4 character):");
                        passWord = input.nextLine();
                        if (passWord.length() != 4) {
                            System.out.println("Invalid password!\n->:");
                        } else {
                            break;
                        }
                    }

                    // Xác định đối tượng đang sử dụng chương trình để cho ra chương trình phù hợp

                    while (true) {
                        try {
                            System.out.print("\n-->Role                   :");
                            choice = input.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            input.nextLine();
                        }
                    }
                    // Chương trình của customer
                    if (choice == 1) {
                        if (findCustomer(phoneNumber, passWord) != null) {
                            user1 = (Customer) findCustomer(phoneNumber, passWord);
                            ChangePage();
                            System.out.println("Sign in success!");
                            System.out.println("Welcome " + user1.getName() + " !");
                            OUTER: while (true) {
                                while (true) {
                                    try {
                                        System.out.println("______Customer programe____");
                                        System.out.println("\n1. Information      2.Order     3.Log out");
                                        System.out.print("\nType here ->:");
                                        choice = input.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        input.nextLine();
                                    }
                                }
                                // Vào chương trình xem thông tin
                                switch (choice) {
                                    case 1:
                                        ChangePage();
                                        user1.InformationPrograme();
                                        break;
                                    case 2:
                                        // Chương trình mua hàng
                                        ChangePage();
                                        while (true) {
                                            while (true) {
                                                try {
                                                    System.out.println("______________Order food____________");
                                                    System.out.println("1. Order      2.Check bills      3.Exit");
                                                    System.out.println("__________________________________________");
                                                    System.out.print("-->:");
                                                    choice = input.nextInt();
                                                    break;
                                                } catch (InputMismatchException e) {
                                                    input.nextLine();
                                                }
                                            }
                                            if (choice < 0 && choice > 3) {
                                                System.out.println("Invalid number!");
                                            } else if (choice == 1) {

                                                while (true) {
                                                    while (true) {
                                                        try {
                                                            System.out.println("______Menu_____");
                                                            for (int i = 0; i < foods.size(); i++) {
                                                                System.out.printf("%s. %s - price: %d\n", i + 1,
                                                                        foods.get(i).getName(),
                                                                        foods.get(i).getPrice());
                                                            }
                                                            System.out.println("\n0. Exit order food");
                                                            System.out.print("Choose the food :");
                                                            choice = input.nextInt();
                                                            break;
                                                        } catch (InputMismatchException e) {
                                                            input.nextLine();
                                                        }
                                                    }
                                                    if (choice < 0 || choice > foods.size() + 1) {
                                                        System.out.println("Invalid number!");
                                                    } else if (choice == 0) {
                                                        System.out.println("Exit menu! ");
                                                        break;
                                                    } else {
                                                        System.out.println("____Verify____");
                                                        System.out.println(foods.get(choice - 1));
                                                        Food choiceFood = foods.get(choice - 1);
                                                        System.out.println("\n1. Order   2.Exit");
                                                        while (true) {
                                                            while (true) {
                                                                try {
                                                                    System.out.println("-->:");
                                                                    choice = input.nextInt();
                                                                    break;
                                                                } catch (InputMismatchException e) {
                                                                    input.nextLine();
                                                                }
                                                            }
                                                            if (choice == 1) {
                                                                System.out.print("\nEnter the quantities: ");
                                                                int quantities = input.nextInt();
                                                                if (quantities < 0
                                                                        || quantities > choiceFood.getQuantity()) {
                                                                    System.out.println("Invalid quantity!");
                                                                } else {
                                                                    Bill bill = new Bill(choiceFood, user1,
                                                                            shippers.get(0), quantities);
                                                                    user1.addBill(bill);
                                                                    System.out.println("\n____Order completed!____");
                                                                    System.out.println("Press any key to exit!");
                                                                    input.nextLine();
                                                                    String exit = input.nextLine();
                                                                    break;

                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            } else if (choice == 2) {
                                                while (true) {
                                                    System.out.println("___Check bill programe___\n");
                                                    for (int i = 0; i < user1.getBill().size(); i++) {
                                                        System.out.printf("\n%d. %s _: %d VND", i + 1,
                                                                user1.getBill().get(i).getFood().getName(),
                                                                user1.getBill().get(i).getTotalPrice());
                                                    }
                                                    System.out.println("\n0. Exit check bill \n");
                                                    while (true) {
                                                        try {
                                                            System.out.println("-->:");
                                                            choice = input.nextInt();
                                                            break;
                                                        } catch (InputMismatchException e) {
                                                            input.nextLine();
                                                        }
                                                    }
                                                    if (choice < 0 || choice > user1.getBill().size() + 1) {
                                                        System.out.println("Invalid number!");
                                                    } else if (choice == 0) {
                                                        System.out.println("Exit Check bill programe!");
                                                        break;
                                                    } else {
                                                        if (user1.getBill().size() != 0) {
                                                            System.out.println(user1.getBill().get(choice - 1));
                                                        }

                                                        System.out.println("\nPress any key to exit!");
                                                        input.nextLine();
                                                        String exit = input.nextLine();
                                                        System.out.println("\nExit check bill !");
                                                        break;
                                                    }
                                                }

                                            } else if (choice == 3) {
                                                System.out.println("Exit order programe!");
                                                break;
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Exit customer programe!");
                                        break OUTER;
                                    default:
                                        ChangePage();
                                        System.out.println("Invalid number!!");
                                        break;
                                }
                            }
                            break;
                        } else {
                            ChangePage();
                            System.out.println("The phone number or password are incorrect!\n");
                        }
                    }
                    // Chương trình của shipper
                    else if (choice == 2) {
                        if (findShipper(phoneNumber, passWord) != null) {
                            user2 = (Shipper) findShipper(phoneNumber, passWord);
                            while (true) {
                                while (true) {
                                    try {
                                        ChangePage();
                                        System.out.println("______Shipper programe_____");
                                        System.out.println("______Welcome " + user2.getName() + "_____");
                                        System.out.println("\n1. Information    2.Manage your orders    3.Log out");
                                        System.out.print("-->:");
                                        choice = input.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        input.nextLine();
                                    }
                                }
                                if (choice > 3 || choice < 1) {
                                    System.out.println("Invalid number!");
                                } else if (choice == 1) {
                                    // Chương trình xem thông tin của Shipper
                                    user2.InformationPrograme();
                                } else if (choice == 2) {
                                    while (true) {
                                        while (true) {
                                            try {
                                                System.out.println("_____Manage your orders_____");
                                                System.out.println(
                                                        "1. Check orders & Income     2.Add order    3.Exit\n-->");
                                                choice = input.nextInt();
                                                break;
                                            } catch (InputMismatchException e) {
                                                input.nextLine();
                                            }
                                        }
                                        if (choice == 1) {
                                            System.out.println("_____Check orders & your income____\n");
                                            System.out.printf("--Your salary: %d VND \n--Orders fee: %d VND",
                                                    user2.getSalary(), user2.getBill().size() * 6000);
                                            System.out.println("--\n____Your received orders____");
                                            for (int i = 0; i < user2.getBill().size(); i++) {
                                                Bill billNow = user2.getBill().get(i);
                                                System.out.printf("\n%d. %s : %d VND\n", i + 1,
                                                        billNow.getFood().getName(), billNow.getTotalPrice());
                                            }
                                            System.out.println("\n0.Exit");
                                            System.out.println("Choose for more: ");
                                            while (true) {
                                                while (true) {
                                                    try {
                                                        System.out.print("-->:");
                                                        choice = input.nextInt();
                                                        break;
                                                    } catch (InputMismatchException e) {
                                                        input.nextLine();
                                                    }
                                                }
                                                if (choice < 0 || choice > user2.getBill().size() + 1) {
                                                    System.out.println("Invalid number!");
                                                } else if (choice == 0) {
                                                    System.out.println("Exit check orders and income programe!");
                                                    break;
                                                } else {
                                                    if (user2.getBill().size() != 0) {
                                                        System.out.println("__The full information:");
                                                        System.out.println(user2.getBill().get(choice - 1));
                                                    }

                                                    System.out.println("______\nPress any key to exit.");
                                                    input.nextLine();
                                                    String exit = input.nextLine();
                                                    break;
                                                }
                                            }

                                        } else if (choice == 2) {
                                            System.out.println("____Add order programe____");
                                            System.out.println("-- The orders you can add:");
                                            for (int i = 0; i < bills.size(); i++) {
                                                if (bills.get(i).getShipper().getName() == null) {
                                                    Bill billNow = bills.get(i);
                                                    System.out.printf("\n%d. %s - %s : %d", i + 1,
                                                            billNow.getFood().getName(),
                                                            billNow.getCustomer().getAddress(),
                                                            billNow.getTotalPrice());
                                                }
                                            }
                                            System.out.println("\n0.Exit \n");
                                            while (true) {
                                                while (true) {
                                                    try {
                                                        System.out.printf("Choose number to add :");
                                                        choice = input.nextInt();
                                                        break;
                                                    } catch (InputMismatchException e) {
                                                        input.nextLine();
                                                    }
                                                }
                                                if (choice < 0 || choice > bills.size()) {
                                                    System.out.println("Invalid number!");
                                                } else if (choice == 0) {
                                                    System.out.println("Exit add orders programe!");
                                                    break;
                                                } else {
                                                    System.out.println("____Full order information____");
                                                    System.out.println(bills.get(choice - 1));
                                                    while (true) {
                                                        if (bills.get(choice - 1).getShipper().getName() == null) {
                                                            System.out.println("Add order complete!");
                                                            user2.addBill(bills.get(choice - 1));
                                                        } else {
                                                            System.out.println("Can't add this order!");
                                                        }
                                                        System.out.println("Press any key to exit!");
                                                        input.nextLine();
                                                        String exit = input.nextLine();
                                                        break;
                                                    }
                                                    break;

                                                }
                                            }

                                            break;
                                        } else if (choice == 3) {
                                            System.out.println("Exit manager order!");
                                            break;
                                        } else {
                                            System.out.println("Invalid number!");
                                        }
                                    }
                                } else {
                                    System.out.println("Logged out!");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("The account is not found!");
                        }
                    }
                    // Chương trình của người bán
                    else if (choice == 3) {
                        if (findSeller(phoneNumber, passWord) != null) {
                            user3 = (Seller) findSeller(phoneNumber, passWord);
                            while (true) {
                                while (true) {
                                    try {
                                        ChangePage();
                                        System.out.println("_____________Seller programe__________");
                                        System.out.println("________Welcome " + user3.getName() + "________");
                                        System.out.print(
                                                "1. Information     2. Manage food     3. Manage orders    4.Log out\n-->:");
                                        choice = input.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        input.nextLine();
                                    }
                                }
                                if (choice < 0 || choice > 4) {
                                    System.out.println("Invalid number!");
                                } else if (choice == 1) {
                                    while (true) {
                                        System.out.println("_____Information programe_____");
                                        user3.InformationPrograme();
                                        break;
                                    }
                                } else if (choice == 2) {
                                    OUTER_1: while (true) {
                                        while (true) {
                                            try {
                                                System.out.println("____Food manager____");
                                                System.out.println("_____Your menu____\n");
                                                for (int i = 0; i < user3.getFoods().size(); i++) {
                                                    Food foodNow = user3.getFoods().get(i);
                                                    System.out.printf("%d. %s : %d VND\n", i + 1, foodNow.getName(),
                                                            foodNow.getPrice());
                                                }
                                                System.out.println("-".repeat(30));
                                                System.out.println(
                                                        "1.Add food    2.Remove food    3.Edit price    4. Exit");
                                                System.out.println("-->:");
                                                choice = input.nextInt();
                                                break;
                                            } catch (InputMismatchException e) {
                                                input.nextLine();
                                            }
                                        }
                                        if (choice < 1 || choice > 4) {
                                            System.out.println("Invalid number!");
                                        } else {
                                            switch (choice) {
                                                case 1:
                                                    String foodName;
                                                    int foodPrice;
                                                    int foodQuantity;
                                                    System.out.println("__Add food to your menu!");
                                                    do {
                                                        input.nextLine();
                                                        System.out.print("Enter the food name:");
                                                        foodName = input.nextLine();
                                                    } while (foodName.equals(""));
                                                    do {
                                                        System.out.print("Enter the price (VND): ");
                                                        foodPrice = input.nextInt();
                                                    } while (foodPrice < 0);
                                                    do {
                                                        System.out.print("Enter the quantity:");
                                                        foodQuantity = input.nextInt();
                                                    } while (foodQuantity < 0);
                                                    while (true) {
                                                        user3.addFood(
                                                                new Food(foodName, foodPrice, foodQuantity, user3));
                                                        System.out.println("Add food successful!");
                                                        System.out.println("Press any key to exit");
                                                        input.nextLine();
                                                        String exit = input.nextLine();
                                                        break;
                                                    }
                                                    break;
                                                case 2:
                                                    while (true) {
                                                        while (true) {
                                                            try {
                                                                System.out
                                                                        .print("Choose the food you want to remove: ");
                                                                choice = input.nextInt();
                                                                break;
                                                            } catch (InputMismatchException e) {
                                                                input.nextLine();
                                                            }
                                                        }
                                                        if (choice < 0 || choice > user3.getFoods().size()) {
                                                            System.out.println("Invalid number!");
                                                            break;
                                                        } else if (choice == 0) {
                                                            System.out.println("Closed remove food programe!");
                                                            break;
                                                        } else {
                                                            while (true) {
                                                                user3.removeFood(user3.getFoods().get(choice - 1));
                                                                System.out.println("Remove successful!!");
                                                                System.out.println("Press any key to exit!");
                                                                input.nextLine();
                                                                String exit = input.nextLine();
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    while (true) {
                                                        while (true) {
                                                            try {
                                                                System.out.println("_____Edit price____");
                                                                System.out
                                                                        .print("Enter food number you want to edit: ");
                                                                choice = input.nextInt();
                                                                break;
                                                            } catch (InputMismatchException e) {
                                                                input.nextLine();
                                                            }
                                                        }
                                                        if (choice < 0 || choice > user3.getFoods().size()) {
                                                            System.out.println("Invalid number!");
                                                            break;
                                                        } else if (choice == 0) {
                                                            System.out.println("Closed edit price programe");
                                                            break;
                                                        } else {
                                                            int newPrice;
                                                            do {
                                                                System.out.print("Enter new price (>= 0 VND):");
                                                                newPrice = input.nextInt();
                                                            } while (newPrice < 0);
                                                            user3.getFoods().get(choice - 1).setPrice(newPrice);
                                                            System.out.println("Change price successful!");
                                                            System.out.println("Press any key to exit!");
                                                            input.nextLine();
                                                            String exit = input.nextLine();
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Closed food manager!");
                                                    break OUTER_1;
                                            }
                                        }
                                    }
                                } else if (choice == 3) {
                                    while (true) {
                                        while (true) {
                                            try {
                                                System.out.println("________Manager orders_______");
                                                System.out.println("-- Your orders and total income --   ");
                                                int income = 0;
                                                for (int i = 0; i < user3.getBills().size(); i++) {
                                                    Bill billNow = user3.getBills().get(i);
                                                    income += billNow.getTotalPrice();
                                                    System.out.println(billNow.shortBill(i + 1));
                                                }
                                                System.out.println("0. Close");
                                                System.out.println(
                                                        "_______\n-Your total income: " + income + " VND" + "\n______");
                                                System.out.println("-Choose for more: ");
                                                choice = input.nextInt();
                                                break;
                                            } catch (InputMismatchException e) {
                                                input.nextLine();

                                            }
                                        }
                                        if (choice < 0 || choice > user3.getBills().size()) {
                                            System.out.println("Invalid number!");
                                        } else if (choice == 0) {
                                            System.out.println("Closed manager order!");
                                            break;
                                        } else {
                                            System.out.println("_____Full bill information____");
                                            System.out.println(user3.getBills().get(choice - 1));
                                            System.out.println("_".repeat(30));
                                            System.out.println("Press any key to exit");
                                            input.nextLine();
                                            String exit = input.nextLine();
                                        }
                                    }
                                } else {
                                    System.out.println("Logged out!");
                                    break;
                                }
                            }

                        } else {
                            ChangePage();
                            System.out.println("Pass word or phone number are incorect!");
                            System.out.println("__________________________________________");

                        }
                    } else {
                        System.out.println("Invalid number!");
                        break;
                    }

                    break;
                // Dùng cho đăng ký
                case 2:
                    ChangePage();
                    System.out.println("________Sign up________");
                    while (true) {
                        while (true) {
                            try {
                                System.out.println("--Who are you?");
                                System.out.println("1. Customer    2.Shipper    3.Seller    4.Exit");
                                choice = input.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                input.nextLine();
                            }
                        }
                        if (choice < 1 & choice > 4) {
                            System.out.println("Invalid number!");
                        } else if (choice == 4) {
                            System.out.println("Closed sign up!");
                            break;
                        } else {
                            String newName;
                            long newPhoneNumber;
                            String newEmail;
                            String newAddress;
                            String newGender;
                            int newAge;
                            String newPassWord;
                            System.out.println("____New user___");
                            while (true) {
                                System.out.print("Enter your name:");
                                input.nextLine();
                                newName = input.nextLine();
                                if (newName.length() > 0) {
                                    break;
                                }
                            }
                            while (true) {
                                while (true) {
                                    try {
                                        System.out.print("Enter your phone number (9 numbers) \n--> (+84) :");
                                        newPhoneNumber = input.nextLong();
                                        break;
                                    } catch (Exception e) {
                                        input.nextLine();
                                    }
                                }
                                if (String.valueOf(newPhoneNumber).length() == 9) {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Enter your email:");
                                input.nextLine();
                                newEmail = input.nextLine();
                                if (newEmail.length() > 5) {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Enter your address:");
                                newAddress = input.nextLine();
                                if (newAddress.length() > 0) {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("Enter your age (>15):");
                                newAge = input.nextInt();
                                if (newAge > 15) {
                                    break;
                                }
                            }
                            while (true) {
                                int genderChoice;
                                while (true) {
                                    try {
                                        System.out.print("Your gender?\n1.male    2.female    3.other\n-->:");
                                        genderChoice = input.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        input.nextLine();
                                    }
                                }
                                if (genderChoice < 1 || genderChoice > 3) {
                                    System.out.println("Invalid number!");
                                } else if (genderChoice == 1) {
                                    newGender = "male";
                                    break;
                                } else if (genderChoice == 2) {
                                    newGender = "female";
                                    break;
                                } else {
                                    newGender = "other";
                                    break;
                                }
                            }
                            while (true) {
                                while (true) {
                                    System.out.print("Enter your password (4 characters):");
                                    newPassWord = input.nextLine();
                                    if (newPassWord.length() != 4) {
                                        System.out.println("Invalid password!");
                                    } else {
                                        break;
                                    }
                                }
                                System.out.print("Confirm your password:");
                                if (newPassWord.equals(input.nextLine())) {
                                    System.out.println("Completed!");
                                    break;
                                } else {
                                    System.out.println("The password does not match!");
                                }
                            }
                            if (choice == 1) {
                                customers.add(new Customer(newName, newEmail, newPhoneNumber, newAddress, newAge,
                                        newGender, newPassWord, new ArrayList<>()));
                            } else if (choice == 2) {
                                shippers.add(new Shipper(newName, newEmail, newPhoneNumber, newAddress, newAge,
                                        newGender, newPassWord, new ArrayList<>(), 0));
                            } else {
                                sellers.add(new Seller(newName, newEmail, newPhoneNumber, newAddress, newAge, newGender,
                                        newPassWord, new ArrayList<>(), new ArrayList<Bill>()));
                            }
                            System.out.println("Sign in successful!");
                            System.out.println("Press any key to exit");
                            String exit = input.nextLine();
                            break;
                        }
                    }
                    break;
                case 3:
                    ChangePage();
                    System.out.println("Press enter to close the programe!");
                    input.nextLine();
                    String exit = input.nextLine();
                    if (exit.equals("")) {
                        ChangePage();
                        System.out.println("__Good bye__\n__See you!__");
                        break Home;
                    }
                    break;
                default:
                    ChangePage();
                    System.out.println("Please enter the valid number!\n");
                    ;
            }
        }
    }

    // Dữ liệu mẫu
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static ArrayList<Shipper> shippers = new ArrayList<Shipper>();
    private static ArrayList<Seller> sellers = new ArrayList<Seller>();
    private static ArrayList<Food> foods = new ArrayList<Food>();
    private static ArrayList<Food> foods1 = new ArrayList<Food>();
    private static ArrayList<Bill> bills = new ArrayList<Bill>();
    private static ArrayList<Bill> bills1 = new ArrayList<Bill>();

    // Customer
    public static void RunData() {
        // Dữ liệu mẫu của khách hàng
        Customer customer1 = new Customer("Le Ky Ba", "bale@gmail.com", 100000000, "Binh Dinh", 19, "male", "1504",
                new ArrayList<>());
        Customer customer2 = new Customer("Do Thanh Binh", "binh.do@gmail.com", 1000000001, "Kon Tum", 19, "male",
                "1000", new ArrayList<>());
        Customer customer3 = new Customer("To Ngol Thi Loc", "loc@gmail.com", 100000002, "Quang Nam", 19, "female",
                "0605", new ArrayList<>());
        Customer customer4 = new Customer("Hoang Thanh Binh", "binh.hoang@gmail.com", 100000003, "Quang Tri", 19,
                "male", "2409", new ArrayList<>());

        // Dữ liệu mẫu của Shipper.
        Shipper shipper1 = new Shipper("Xom Dang Vai", "vai.xom@gmail.com", 869000012, "Quang Tri", 24, "male", "vai1",
                bills, 12000000);

        // Dữ liệu mẫu của người bán
        Seller seller1 = new Seller("Vo Duc Tai", "tai.duc@gmail.com", 869007671, "Quang Tri", 19, "male", "1234",
                foods, bills);
        Seller seller2 = new Seller("Doan Minh Hoang", "hoang@gmail.com", 112345679, "Binh Dinh", 19, "male", "2345",
                foods, bills1);

        // Dữ liệu mẫu của món ăn
        Food food1 = new Food("Pizza", 30000, 20, seller1);
        Food food2 = new Food("Sandwich", 30000, 20, seller1);
        Food food3 = new Food("Salad", 10000, 30, seller1);
        Food food4 = new Food("Pho", 15000, 100, seller1);
        Food food5 = new Food("Banh canh", 10000, 10, seller1);

        // Đơn hàng mẫu
        Bill bill1 = new Bill(food1, customer1, shipper1, 3);
        Bill bill3 = new Bill(food4, customer2, shipper1, 2);
        Bill bill2 = new Bill(food5, customer4, 0);
        seller1.addBill(bill1);
        seller1.addBill(bill2);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        shippers.add(shipper1);

        sellers.add(seller1);
        sellers.add(seller2);

        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);
        foods.add(food5);

        bills.add(bill1);
        bills.add(bill3);

    }

    // Phương thức trả về dữ liệu của Customer tuong ứng với sdt và mật khẩu tương
    // ứng nếu không thì trả về giá trị null
    public static Object findCustomer(long phoneNumber, String password) {
        for (Customer i : customers) {
            if (i.getPhoneNumber() == phoneNumber && i.getPassword().equals(password)) {
                return i;
            }
        }

        return null;
    }

    public static Object findShipper(long phoneNumber, String password) {
        for (Shipper i : shippers) {
            if (i.getPhoneNumber() == phoneNumber && i.getPassword().equals(password)) {
                return i;
            }
        }
        return null;
    }

    public static Object findSeller(long phoneNumber, String password) {
        for (Seller i : sellers) {
            if (i.getPhoneNumber() == phoneNumber && i.getPassword().equals(password)) {
                return i;
            }
        }
        return null;
    }

    public static void ChangePage() {
        System.out.print("\033\143");
    }
}