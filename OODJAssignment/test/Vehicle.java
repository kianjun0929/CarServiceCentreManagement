/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kianjun
 */
public class Vehicle {
    protected int numberOfWheels;
    protected float wheelWeight;
    protected float topSpeed;
    public Vehicle() {
//        numberOfWheels = 0;
//        wheelWeight = 0.0f;
//        topSpeed = 0.0f;
         this(0, 0.0f, 0.0f);
    }
    public Vehicle(int wheels, float weight, float speed) {
        numberOfWheels = wheels;
        wheelWeight = weight;
        topSpeed = speed;
    }
    
    public float computewheelWeights() {
        float totalWeight = wheelWeight * numberOfWheels;
        System.out.println("The total wheel weight is: " + totalWeight);
        return totalWeight;
    }
}

class MultiWheelTruck extends Vehicle {
    private float nightTopSpeed;
    public MultiWheelTruck(int wheels, float weight, float speed, float topSpeedAtNight) {
//        numberOfWheels = wheels;
//        wheelWeight = weight;
//        topSpeed = speed;
//        nightTopSpeed = topSpeedAtNight;
         super(wheels, weight, speed);
         this.nightTopSpeed = topSpeedAtNight;
    }
    
    public MultiWheelTruck(float weight, float speed, float topSpeedAtNight) {
//        numberOfWheels = 10;
//        wheelWeight = weight;
//        topSpeed = speed;
//        nightTopSpeed = topSpeedAtNight;
         this(10, weight, speed, topSpeedAtNight);
    }
    
    @Override
    public float computewheelWeights() {
//        System.out.println("Computing the total wheel weight for a multi-wheel: ");
//        float totalWeight = wheelWeight * numberOfWheels;
//        System.out.println("The total wheel weight is: " + totalWeight);
//        return totalWeight;
         System.out.println("Computing the total wheel weight for a multi-wheel: ");
         return super.computewheelWeights();
    }
}
