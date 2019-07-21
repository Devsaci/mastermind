package com.zakaria;

import java.io.IOException;

public class GameReadConfigMain {

    public static void main (String[] args) throws IOException {
        GameGetPropertyValues properties = new GameGetPropertyValues();
        System.out.println(properties.getPropValues());
    }
}
