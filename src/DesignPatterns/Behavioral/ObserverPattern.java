package DesignPatterns.Behavioral;

import java.util.*;

public class ObserverPattern {
    public static void main(String[] args) {

    }
}

interface Youtube {

    List<Channel> subscribers = new ArrayList<Channel>();

    void register(Channel channel);

    void deRegister(Channel channel);
}

interface Channel {
    void showNotification();
}

class SonyTV implements Channel {
    @Override
    public void showNotification() {
        System.out.println("Sony TV received a notification");
    }
}

class BlueBrown implements Channel {
    @Override
    public void showNotification() {
        System.out.println("Sony TV received a notification");
    }
}

class Weather implements Youtube, Channel {

    @Override
    public void register(Channel channel) {
        // channel are SonyTv, BlueBrown
        subscribers.add(channel);
    }

    @Override
    public void deRegister(Channel channel) {
        subscribers.remove(channel);
    }

    @Override
    public void showNotification() {
        System.out.println("Weather Channel received a notification");
    }

    public void addNewVideo() {
        // new video added

        for (Channel channel : subscribers)
            channel.showNotification();
    }
}