/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.battle;

import ihs.apcs.spacebattle.commands.*;
import ihs.apcs.spacebattle.*;
import java.awt.Color;
import java.util.Collections;
import static space.battle.ShipMode.*;

/**
 *
 * @author shirdav18
 */
public class Shirathingal extends BasicSpaceship {
    
    private static ShipMode shipMode = RADARING;
    //THRUSTING, ROTATING, RADARING, STEERING, SHOOTING, IDLING
    private static RadarResults rResults;
    private static Target[] shipTargets = new Target[100];
    private static final int TORPEDO_SPEED = 42;
    
    @Override
    public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight) {
        return new RegistrationData("Shirathingal", new Color(100, 50, 255), 0);
    }
    
    @Override
    public ShipCommand getNextCommand(BasicEnvironment env) {
        ObjectStatus ship = env.getShipStatus();
        switch(shipMode) {
            case THRUSTING : 
                return new ThrustCommand('B',1.0,.5,false);
            case ROTATING : 
                rResults = env.getRadar();
                int index = 0;
                double closest = 10000;
                for (int i = 0; i < rResults.size(); i++) {
                    ObjectStatus current = rResults.get(i);
                    shipTargets[i] = new Target(getDistance(ship.getPosition(),current.getPosition()),current.getMovementDirection(),current.getSpeed(),current.getPosition());
                    if (shipTargets[i].getDist() < closest) {
                        index = i;
                        closest = shipTargets[i].getDist();
                    }
                }
                System.out.println("");
                shipMode = SHOOTING;
                return new RotateCommand(ship.getPosition().getAngleTo(getImpactSpot(shipTargets[index],getImpactTime(shipTargets[index],ship)))-ship.getOrientation());
            case RADARING :
                shipMode = ROTATING;
                return new RadarCommand(5);
            case STEERING : 
                return new SteerCommand(30,false);
            case SHOOTING :
                shipMode = RADARING;
                return new FireTorpedoCommand('F');
            default:
                //won't be reached b/c covered all values
                return new IdleCommand(.1);
        }     
    } 
    
    public double getDistance(Point shipCurrent, Point thing) {
        double yDif = thing.getY() - shipCurrent.getY();
        double xDif = thing.getX() - shipCurrent.getX();
        double distance = Math.sqrt(Math.pow(xDif, 2) + Math.pow(yDif, 2));
        return distance;
    }
    
    public Point getImpactSpot(Target t, double time) {
        Point position = t.getPosition();
        return new Point(position.getX() + Math.cos(t.getDir()) * t.getSp() * time, position.getY() + Math.sin(t.getDir()) * t.getSp() * time);
    }
    
    public double getImpactTime(Target t, ObjectStatus ship) { //a x^2 + b x + c = 0
        double a = Math.pow(t.getSp(), 2) + Math.pow(TORPEDO_SPEED, 2);
        double b = 2*TORPEDO_SPEED*((t.getPosition().getX()-ship.getPosition().getX())*Math.cos(t.getDir())+(t.getPosition().getY()-ship.getPosition().getY())*Math.sin(t.getDir()));
        double c = Math.pow(t.getPosition().getX()-ship.getPosition().getX(), 2) + Math.pow(t.getPosition().getY()-ship.getPosition().getY(), 2);
        return -1 * b / (2 * a); //because it has a double root at the time of impact
    }
}
