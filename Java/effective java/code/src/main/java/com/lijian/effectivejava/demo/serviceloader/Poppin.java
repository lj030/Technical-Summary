package com.lijian.effectivejava.demo.serviceloader;

public class Poppin implements Dance {

    @Override
    public String getName() {
        return "Poppin";
    }

    @Override
    public void printDescription() {
        System.out.println("Well, I am not only a robot :), Poppin is me");
    }
}
