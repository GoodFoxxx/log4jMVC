package com.company;

import com.company.model.World;
import com.company.view.Screen;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Main {
    public static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

//        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\lib\\log4j.properties");
        System.out.println(System.getProperty("user.dir")+"\\src\\com\\company\\log4j.xml");
        DOMConfigurator.configure(System.getProperty("user.dir") + "\\src\\com\\company\\log4j.xml");

        logger.info(System.getProperty("user.name")+" logged");
        World world = new World();
        logger.info(System.getProperty("user.name")+" world created");
        Screen screen = new Screen();
        logger.info(System.getProperty("user.name")+" screen created");
        screen.show(world.getScene());
        logger.debug(System.getProperty("user.name")+" screen rendered");
        world.produceChild("Stikly");
        world.produceChild("Beckly");
        world.produceChild("Mogly");
        logger.debug(System.getProperty("user.name")+" children produced");
        screen.show(world.getScene());
        logger.debug(System.getProperty("user.name")+" screen rendered");
        logger.info(System.getProperty("user.name")+" exit completed");
    }
}
