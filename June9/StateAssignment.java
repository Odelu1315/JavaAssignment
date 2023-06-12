package Behaviuorpattrn;

interface TrafficLightState {
    void switchOn(TrafficLight trafficLight);
    void switchOff(TrafficLight trafficLight);
    void next(TrafficLight trafficLight);
}

class TrafficLight {
    private TrafficLightState state;
    
    public TrafficLight() {
        state = new RedState();
    }
    
    public void setState(TrafficLightState state) {
        this.state = state;
    }
    
    public void switchOn() {
        state.switchOn(this);
    }
    
    public void switchOff() {
        state.switchOff(this);
    }
    
    public void next() {
        state.next(this);
    }
}

class RedState implements TrafficLightState {
    @Override
    public void switchOn(TrafficLight trafficLight) {
        System.out.println("Traffic light is already on");
    }
    
    @Override
    public void switchOff(TrafficLight trafficLight) {
        System.out.println("Switching traffic light off");
        trafficLight.setState(new OffState());
    }
    
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Switching traffic light to green");
        trafficLight.setState(new GreenState());
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void switchOn(TrafficLight trafficLight) {
        System.out.println("Traffic light is already on");
    }
    
    @Override
    public void switchOff(TrafficLight trafficLight) {
        System.out.println("Switching traffic light off");
        trafficLight.setState(new OffState());
    }
    
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Switching traffic light to yellow");
        trafficLight.setState(new YellowState());
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void switchOn(TrafficLight trafficLight) {
        System.out.println("Traffic light is already on");
    }
    
    @Override
    public void switchOff(TrafficLight trafficLight) {
        System.out.println("Switching traffic light off");
        trafficLight.setState(new OffState());
    }
    
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Switching traffic light to red");
        trafficLight.setState(new RedState());
    }
}

class OffState implements TrafficLightState {
    @Override
    public void switchOn(TrafficLight trafficLight) {
        System.out.println("Switching traffic light on");
        trafficLight.setState(new RedState());
    }
    
    @Override
    public void switchOff(TrafficLight trafficLight) {
        System.out.println("Traffic light is already off");
    }
    
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Cannot switch to next state. Traffic light is off.");
    }
}

public class StateAssignment {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.switchOn();
        trafficLight.next();
        trafficLight.next();
        trafficLight.switchOff();
        trafficLight.switchOff();
        trafficLight.switchOn();
        trafficLight.next();
        trafficLight.switchOn();
    }
}

