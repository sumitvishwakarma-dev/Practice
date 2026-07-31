public class AbstractClass {
    void main(){
        Car fc = new FuelCar();
        Car ec = new ElectricCar();


        fc.breakCar();
        fc.speed();
        fc.accelerate();

        ec.breakCar();
        ec.speed();
        ec.accelerate();

    }
}

class FuelCar extends Car{
    void speed(){
        System.out.println("Fuel Car Speed");
    }

    @Override
    void accelerate() {
        System.out.println("Fuel Car accelerated");
    }
}

class ElectricCar extends Car{
    void speed(){
        System.out.println("Electric Car Speed");
    }

    @Override
    void accelerate() {
        System.out.println("Electric Car accelerated");
    }
}

abstract class Car{
    abstract void speed();
    abstract void accelerate();
    void breakCar(){
        System.out.println("Car Stopped ");
    }
}