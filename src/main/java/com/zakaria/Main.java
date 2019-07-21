package com.zakaria;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * package com.zakaria;
 * <b> Class Main</b>
 * @author Zakaria
 * @version  1.0
 * @see DriverTest
 */

public class Main {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void main (String[] args) {
            LOGGER.info("démarage de mastermind");
            new StartGame().choicGameAndParameters();

    }
}