package Controller;

import Abstract.Leg;
import Interfaces.Animal;
import Interfaces.HandInterface;
import Interfaces.LegInterface;

public class Dog extends Leg implements HandInterface, LegInterface, Animal {

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    @Override
    public void walk() {
        System.out.println("The dog is walking by feet");
    }

    @Override
    public void Hand() {
        System.out.println("Dog uses its paw like a hand");
    }

    @Override
    public void Grap() {
        System.out.println("Grabbed by paw");
    }

    @Override
    public void Leg() {
        System.out.println("Dog has 4 legs");
    }
}
