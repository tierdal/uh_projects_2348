public class Hw3Ex1 {
    public static void main(String[] args) {

        Car myTruck = new Car(0);
        myTruck.year = 2011;
        myTruck.make = new String("Toyota");
        myTruck.model = new String("Tacoma");

        myTruck.setVin();

        System.out.println("My Vin is: " + myTruck.getVin());
        System.out.println("Year:" + myTruck.year);
        System.out.println("Make:" + myTruck.make);
        System.out.println("Model:" + myTruck.model);

        System.out.println();
        myTruck.sellCar("Me","Someone Else");
        System.out.println();


        int year = 2010;
        String make = "Ford";
        String model = "Ranger";

        modifyYear(year, myTruck);
        modifyMake(make, myTruck);
        modifyModel(model, myTruck);
        System.out.println("New Year:" + myTruck.year);
        System.out.println("New Make:" + myTruck.make);
        System.out.println("New Model:" + myTruck.model);

        Car myCar = new Car(1);
        myCar.setVin();
        System.out.println("My car has the following vin: " + myCar.getVin());

    }

    public static void modifyYear(int year, Car myTruck){
        myTruck.year = year;
    }
    public static void modifyMake(String make, Car myTruck){
        myTruck.make = make;
    }
    public static void modifyModel(String model, Car myTruck){
        myTruck.model = model;
    }

}