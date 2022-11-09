import java.util.InputMismatchException;
import java.util.Scanner;

class Booking {
    int amount = (int) (Math.random() * (5000 - 1000 + 1) + 1000);
    int bookingid;

    void authorization(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Email:- ");
        String email = sc.next();
        System.out.println("Enter Password:- ");
        String pass = sc.next();
        System.out.println("Loggin......");
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    void bookTickets(String pname,int age,String source,String destination){
        System.out.println("The tickets has been booked for "+pname+", age "+age+" from "+source+" to "+destination);
    }

    void status(){
        System.out.println("The booking id is "+bookingid+" and the amount is "+amount);
    }

    void discounts(int age){
        if (age <= 25){
            System.out.println("Congratulations you are eligible for student discount of 10%");
            int dis = 100-10;
            amount = (dis*amount)/100;
        }
        if (age >= 60){
            System.out.println("Congratulations you are eligible for senior citizen discount of 25%");
            int dis = 100-25;
            amount = (dis*amount)/100;
        }
    }

    void card(int cd){
        if (cd==1){
            System.out.println("Congatulations you can avail an additional discount of 15% using your HDFC Card");
            int dis = 100-15;
            amount = (dis*amount)/100;
        }
        if (cd==2){
            System.out.println("Congatulations you can avail an additional discount of 20% using your AXIS Card");
            int dis = 100-20;
            amount = (dis*amount)/100;
        }
        if (cd==3){
            System.out.println("Congatulations you can avail an additional discount of 10% using your SBI Card");
            int dis = 100-10;
            amount = (dis*amount)/100;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter 1 to start, 0 to exit");
        Scanner s = new Scanner(System.in);
        try {
            int i = s.nextInt();

            switch (i) {
                case 1 -> {
                    Booking p1 = new Booking();
                    p1.authorization();

                    System.out.println("Enter name");
                    String pname = s.next();
                    System.out.println("Enter age");
                    int age = s.nextInt();
                    System.out.println("Enter source");
                    String source = s.next();
                    System.out.println("Enter destination");
                    String destination = s.next();

                    p1.setBookingid(1);
                    p1.discounts(age);

                    System.out.println("You can avail additional discounts on HDFC, AXIS and SBI cards\nPress 1 for HDFC, 2 for AXIS, 3 for SBI");
                    try {
                        int cd = s.nextInt();
                        p1.card(cd);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Enter valid value!");
                    }
                    System.out.println("Do you want to proceed?...Press 1 to proceed, 0 to exit");
                    try {
                        int j = s.nextInt();
                        switch (j) {
                            case 1:
                                p1.bookTickets(pname, age, source, destination);
                                p1.status();
                                break;
                            case 0:
                                break;
                        }
                    }
                    catch (InputMismatchException e){
                        System.out.println("Enter valid value!");
                    }
                }
                case 0 -> System.out.println("Booking closed, Come Back Later");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Enter valid value!");
        }
    }
}