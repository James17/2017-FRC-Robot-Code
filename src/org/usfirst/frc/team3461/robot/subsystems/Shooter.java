package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.ShooterCommands.ShooterIdle;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends PIDSubsystem {
	Victor shooterMotor = new Victor(RobotMap.shooterPort);
	Encoder shooterEncoder1 = new Encoder(RobotMap.shooterEncoderPortA, RobotMap.shooterEncoderPortB);
	//Spark test = new Spark(0); for spark speed controller	
	public boolean running = true;
	//double speed = RobotMap.shooterTargetSpeed;
	static final double 
						Kp = .005,
						Ki = 0,
						Kd = .00001;
    // Initialize your subsystem here
    public Shooter() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(Kp, Ki, Kd);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new ShooterIdle());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return shooterEncoder1.getRate();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
//    	if(running = true){
//    		if(returnPIDInput() < RobotMap.shooterTargetRPM){
//    			speed += .05;
//    			setSpeed(speed);
//    		}else if(returnPIDInput() > RobotMap.shooterTargetRPM){
//    			speed -= .05;
//    			setSpeed(speed);
//    		}
//    	}
    	shooterMotor.set(output);
    }
    public void setSpeed(double speed){
    	shooterMotor.set(speed);
    	//SmartDashboard.putNumber("blue wheels", speed);
    	//shooterMotor.setFeedbackDevice(FeedbackDevice.AnalogEncoder);
    }
    public double getEncoderRate(){
    	return shooterEncoder1.getRate();
    }
    
//    public double canEncoder(){
//    	shooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//    	return shooterMotor.getEncPosition();
//    }
}
