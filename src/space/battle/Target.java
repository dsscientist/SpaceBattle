/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.battle;

public class Target {
    private double distance;
    private double direction; //in degrees
    private double speed;
    
    public Target(double dist, double dir, double sp) {
        distance = dist;
        direction = dir;
        speed = sp;
    }
    
    public void setDist(double dist) {
        distance = dist;
    }
    
    public void setDir(double dir) {
        direction = dir;
    }
    
    public void setSp(double sp) {
        speed = sp;
    }
    
    public double getDist() {
        return distance;
    }
    
    public double getDir() {
        return direction;
    }
    
    public double getSp() {
        return speed;
    }
}
