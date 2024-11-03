package org.example.week5;
import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String modelName;
    private int mileage;
    private int health;

    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
    }

    public Vehicle(String modelName, int mileage, int health) {
        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
    }

    public String getModelName() {
        return modelName;
    }

    public int getMileage() {
        return mileage;
    }

    public int getHealth() {
        return health;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract String service();

    public abstract int expectedLifespan();

    public boolean needsMaintenance() {
        return health < 70;
    }

    public int calculateRemainingLifespan() {
        int lifespan = expectedLifespan();
        if (health < 50) {
            lifespan -= lifespan * (100 - health) / 100;
        }
        return lifespan - mileage;
    }

    public void simulateYear() {
        if (mileage > expectedLifespan() / 2) {
            health -= 5;
        }
    }

    public void performMaintenance(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.println(car.repair());
            car.drive(100);
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            System.out.println(truck.repair());
            truck.haul(6000);
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle;
            motorcycle.race(50);
        }
    }
}

interface Repairable {
    String repair();
}

class Car extends Vehicle implements Repairable {
    public Car(String modelName) {
        super(modelName);
    }

    public Car(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine tuned and oil changed for " + getModelName();
    }

    @Override
    public String service() {
        return "Service for " + getModelName() + ": Check engine and change oil. Mileage: " + getMileage() + ", Health: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 150000;
    }

    public void drive(int miles) {
        setMileage(getMileage() + miles);
        setHealth(getHealth() - miles / 100);
        if (getHealth() < 30) {
            setMileage(getMileage() - 10000);
        }
    }
}

class Truck extends Vehicle implements Repairable {
    public Truck(String modelName) {
        super(modelName);
    }

    public Truck(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine overhauled and tires replaced for " + getModelName();
    }

    @Override
    public String service() {
        return "Service for " + getModelName() + ": General truck maintenance. Mileage: " + getMileage() + ", Health: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 300000;
    }

    public void haul(int loadWeight) {
        if (loadWeight > 5000) {
            setHealth(getHealth() - 10);
        }
        if (getHealth() < 30) {
            setMileage(getMileage() - 20000);
        }
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String modelName) {
        super(modelName);
    }

    public Motorcycle(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String service() {
        return "Service for " + getModelName() + ": Lubricate chain and tune engine. Mileage: " + getMileage() + ", Health: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 50000;
    }

    public void race(int raceMiles) {
        setMileage(getMileage() + raceMiles);
        setHealth(getHealth() - raceMiles / 10);
        if (getHealth() < 40) {
            setMileage(getMileage() - 5000);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota Corolla"));
        vehicles.add(new Truck("Ford F-150", 50000, 80));
        vehicles.add(new Motorcycle("Yamaha R1", 20000, 90));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.service());
            vehicle.simulateYear();

            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                car.drive(150);
                System.out.println("Car drove 150 miles.");
            } else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                truck.haul(7000);
                System.out.println("Truck hauled 7000 pounds.");
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                motorcycle.race(100);
                System.out.println("Motorcycle raced for 100 miles.");
            }
        }

        System.out.println();
        System.out.println("Performing maintenance on all vehicles:");
        for (Vehicle vehicle : vehicles) {
            vehicle.performMaintenance(vehicle);
        }
    }
}
