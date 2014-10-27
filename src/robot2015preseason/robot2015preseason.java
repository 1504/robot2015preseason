/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package robot2015preseason;




import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class robot2015preseason extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    private static CANJaguar front_left_jaguar, back_left_jaguar, back_right_jaguar, front_right_jaguar;
    private static Joystick driver_left_joystick, driver_right_joystick;
    private static drive Drive;
    
    public robot2015preseason()
    {
        try
        {
            Drive = new drive();
            
            driver_left_joystick = new Joystick(1);
            driver_right_joystick = new Joystick(2);
            
            front_left_jaguar = new CANJaguar(10);
            front_left_jaguar.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
            front_left_jaguar.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            front_left_jaguar.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            front_left_jaguar.configEncoderCodesPerRev(250);
            
            back_left_jaguar = new CANJaguar(11);
            back_left_jaguar.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
            back_left_jaguar.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            back_left_jaguar.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            back_left_jaguar.configEncoderCodesPerRev(250);
            
            back_right_jaguar = new CANJaguar(12);
            back_right_jaguar.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
            back_right_jaguar.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            back_right_jaguar.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            back_right_jaguar.configEncoderCodesPerRev(250);
            
            front_right_jaguar = new CANJaguar(13);
            front_right_jaguar.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
            front_right_jaguar.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            front_right_jaguar.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            front_right_jaguar.configEncoderCodesPerRev(250);

        }
        catch (CANTimeoutException ex)
        {
            ex.printStackTrace();
        }
    }
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() 
    {
        while(isOperatorControl() && isEnabled())
        {
            //Tank stuff
            Drive.drive_tank(driver_left_joystick.getY(), driver_right_joystick.getY());
            System.out.println(Drive.get_front_left());
            try
            {
                front_left_jaguar.setX(Drive.get_front_left());
                back_left_jaguar.setX(Drive.get_back_left());
                back_right_jaguar.setX(Drive.get_back_right());
                front_right_jaguar.setX(Drive.get_front_right());
            }
            catch (CANTimeoutException ex)
            {
                ex.printStackTrace();
            }
            //todo: MECANUM
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    // This is a comment guys. #2//
    public void test() {    
    
    }
}
