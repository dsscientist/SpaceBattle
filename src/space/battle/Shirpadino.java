package space.battle;

import java.awt.Color;
import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shirdav18
 */
public class Shirpadino extends BasicSpaceship { //find the middle code
    
    private static Point center;
    private static boolean checkSlope = true;
    private static PrintStream shipDataCommands;
    private static int commandNum = 0;
    
    @Override
    public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight) {
        center = new Point(worldWidth / 2.0, worldHeight / 2.0);
        return new RegistrationData("Shirpadino", new Color(255, 255, 255), 0);
    }

    @Override
    public ShipCommand getNextCommand(BasicEnvironment env) {
        ObjectStatus ship = env.getShipStatus();
        if (commandNum == 0) {
            commandNum++;
            return new RotateCommand(ship.getPosition().getAngleTo(center)-ship.getOrientation());
        } else if (commandNum == 1) {
            commandNum++;
            return new ThrustCommand('B',5.0,1.0,false);
        } else {
            commandNum++;
            if (getDistance(ship.getPosition()) < 50) {
                return new BrakeCommand(0);
            } else {
                return new IdleCommand(.1);
            }
        }
    }
    
    public double getDistance(Point current) {
        double yDif = center.getY() - current.getY();
        double xDif = center.getX() - current.getX();
        double distance = Math.sqrt(Math.pow(xDif, 2) + Math.pow(yDif, 2));
        return distance;
    }
}
