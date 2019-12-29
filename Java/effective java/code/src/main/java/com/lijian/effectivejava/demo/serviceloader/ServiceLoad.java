package com.lijian.effectivejava.demo.serviceloader;

import java.util.ServiceLoader;

public class ServiceLoad {

    private static final  ServiceLoader<Dance> DANCES
            = ServiceLoader.load(Dance.class);

    public static Dance getDance(String name) {
        for (Dance dance : DANCES) {
            System.out.println(dance.getName());
            if (name.equals(dance.getName())) {
                return dance;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        ServiceLoad serviceLoad = new ServiceLoad();
        Dance dance = serviceLoad.getDance("HipHop");
        if (dance != null) {
            dance.printDescription();
        } else {
            System.out.println("no such dance");
        }
    }
}
