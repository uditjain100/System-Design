package DesignPatterns.Structural;

public class DecoratorPattern {
    public static void main(String[] args) {

        BasePizza pizza = new VegDelight();
        System.out.println("Veg Delight pizza: " + pizza.cost());

        pizza = new ExtraCheese(pizza);
        System.out.println("Veg Delight pizza with extra cheese costs: " + pizza.cost());

        pizza = new Mushroom(pizza);
        System.out.println("Veg Delight pizza with extra cheese and mushrooms costs: " + pizza.cost());

        // BasePizza pizza = new Mushroom(new ExtraCheese(new VegDelight()));
    }
}

interface BasePizza {
    int cost();
}

class VegDelight implements BasePizza {
    int baseCost;

    VegDelight() {
        this.baseCost = 130;
    }

    @Override
    public int cost() {
        return baseCost;
    }
}

class Pepperoni implements BasePizza {
    int baseCost;

    Pepperoni() {
        this.baseCost = 130;
    }

    @Override
    public int cost() {
        return baseCost;
    }
}

interface Toppings extends BasePizza {
}

class ExtraCheese implements Toppings {
    BasePizza basePizza;

    ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 30;
    }
}

class Mushroom implements Toppings {
    BasePizza basePizza;

    Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 50;
    }
}