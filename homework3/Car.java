import java.util.Random;
public class Car {
    //properties
    public int year;
    public String make;
    public String model;

    private int vin;
    private String oldOwner;
    private String currentOwner;

    public Car(int i) {
    }


    //get vin
    public int getVin(){
        return vin;
    }

    //set vin
    public void setVin(){
        Random rnd = new Random();
        vin = rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100) + rnd.nextInt(100);
    }

    public void sellCar(String seller, String buyer){
        oldOwner = seller;
        currentOwner = buyer;
        System.out.println("Seller: " + oldOwner);
        System.out.println("Buyer: " + currentOwner);
    }
}

