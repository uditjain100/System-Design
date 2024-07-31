package SOLID;

public class DependencyInversion {
    public static void main(String[] args) {

    }
}

interface Keyboard {

}

interface Mouse {

}

class WiredKeyboard implements Keyboard {

}

class WiredMouse implements Mouse {

}

class WirelessKeyboard implements Keyboard {

}

class WirelessMouse implements Mouse {

}

class MacBook {

    private Keyboard keyboard;
    private Mouse mouse;

    // Not this way
    // private WiredKeyboard wiredKeyboard;
    // private WiredMouse wiredMouse;

    public MacBook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}