package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterAngleWheels extends PIDSubsystem {
	Encoder shooterEncoder2 = new Encoder(RobotMap.shooterAngleEncoderPortA, RobotMap.shooterAngleEncoderPortB);
	CANTalon shooterAngleMotor = new CANTalon(RobotMap.shooterAngleWheels);
    // Initialize your subsystem here
	public static final double 
								Kp = .003,
								Ki = 0,
								Kd = 0;
    public ShooterAngleWheels() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(Kp, Ki, Kd);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return shooterEncoder2.getRate();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	shooterAngleMotor.set(-output);
    }
    public void setSpeed(double speed){
    	shooterAngleMotor.set(speed);
    	//SmartDashboard.putNumber("green wheels", speed);

    }
    public double getEncoderRate(){
    	return shooterEncoder2.getRate();
    }
}
