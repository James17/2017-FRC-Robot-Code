package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.Robot;
import org.usfirst.frc.team3461.robot.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Hopper extends Subsystem {
	Encoder hopperEncoder = new Encoder(RobotMap.hopperEncoderPortA, RobotMap.hopperEncoderPortB);
	CANTalon hopperMotor = new CANTalon(RobotMap.hopperPort);
	public boolean running = false;
	double tooSlow = 100;
	public String hopperState = "Nothing";

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(double speed){
    	hopperMotor.set(speed);
    	double encoderVal = hopperEncoder.getRate();
    	SmartDashboard.putNumber("hopper value", encoderVal);
    	
    	if(running == true){
    		if(encoderVal < tooSlow){
    			hopperMotor.set(-speed);
    			Robot.hopper.hopperState = "Jam";
    			Timer.delay(.25);
    			hopperMotor.set(speed);
    			Robot.hopper.hopperState = "On";
    			//Timer.delay(1);
    			running = false;
    		}
    	}
    	if(running == false){
    		Timer.delay(.2);
    		running = true;
    	}
    	
    }
    public void off(){
    	hopperMotor.set(0);
    }
}

