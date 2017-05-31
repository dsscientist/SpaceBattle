/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.battle;

import ihs.apcs.spacebattle.Point;



public class Target {
    private double distance;
    private double direction; //in degrees
    private double speed;
    private Point position;
    
    public Target(double dist, double dir, double sp, Point p) {
        distance = dist;
        direction = dir;
        speed = sp;
        position = p;
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
    
    public void setPosition(Point p) {
        position = p;
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
    
    public Point getPosition() {
        return position;
    }
}
