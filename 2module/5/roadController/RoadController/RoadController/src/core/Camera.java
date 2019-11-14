package core;

public class Camera
{
    public static Car getNextCar()
    {
        String randomNumber = Double.toString(Math.random()).substring(2, 5); // перменная типа String
        int randomHeight = (int) (1000 + 3500. * Math.random());              // переменная типа int
        double randomWeight = 600 + 10000 * Math.random();                    // пеерменная типа double

        Car car = new Car();                                                  // переменная типа Car
        car.number = randomNumber;
        car.height = randomHeight;
        car.weight = randomWeight;
        car.hasVehicle = Math.random() > 0.5;
        car.isSpecial = Math.random() < 0.15;

        return car;
    }
}