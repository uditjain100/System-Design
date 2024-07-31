package SOLID;

public class InterfaceSegregated {
    public static void main(String[] args) {

    }
}

interface Work {
    void washDishes();

    void cookDinner();

    void serverFood();
}

class Waiter implements Work {
    @Override
    public void washDishes() {
        System.out.println("Waiter washes dishes.");
    }

    @Override
    public void cookDinner() {
        System.out.println("Waiter cooks dinner.");
    }

    @Override
    public void serverFood() {
        System.out.println("Waiter serves food.");
    }
}

interface DishWork {
    void washDishes();
}

interface CookWork {
    void cookFood();
}

interface ServeWork {
    void serveFood();
}

class DishWasher implements DishWork {
    @Override
    public void washDishes() {
        System.out.println("Dishwasher washes dishes.");
    }
}

class FoodCooker implements CookWork {
    @Override
    public void cookFood() {
        System.out.println("Food cooker cooks food.");
    }
}

class FoodServer implements ServeWork {
    @Override
    public void serveFood() {
        System.out.println("Food server serves food.");
    }
}