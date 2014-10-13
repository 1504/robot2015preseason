/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robot2015preseason;

/**
 *
 * @author Eashwar
 */
public class drive {
    
    private double front_left_val;//Hello, this is a comment!
    private double back_left_val;
    private double front_right_val;
    private double back_right_val;
    
    public drive() {
        front_left_val = 0;
        back_left_val = 0;
        front_right_val = 0;
        back_right_val = 0;
    }
    
    public double get_front_left(){return front_left_val;}
    public double get_back_left(){return back_left_val;}
    public double get_back_right(){return back_right_val;}
    public double get_front_right(){return front_right_val;}

    public void drive_tank(double y_left, double y_right)
    {
        front_right_val = y_right;
        back_right_val = (y_right * -1);
        front_left_val = y_left;
        back_left_val = (y_left * -1);
    }
   
}