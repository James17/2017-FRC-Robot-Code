package org.usfirst.frc.team3461.robot.subsystems.DriveTrain;

import org.usfirst.frc.team3461.robot.Robot;
import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.AutoCommands.LDrive;
import org.usfirst.frc.team3461.robot.commands.DriveCommands.DriveCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class LeftDrive extends PIDSubsystem {

    // Initialize your subsystem here
	CANTalon leftDriveMotor = new CANTalon(RobotMap.lDrivePort);
	CANTalon leftDriveMotor2 = new CANTalon(RobotMap.LDrivePort2);
	
	private static final double 
			Kp = .002,
			Ki = .000001,
			Kd = 0;
	
	public Encoder lDriveEncoder = new Encoder(RobotMap.lDriveEncoderPortA, RobotMap.lDriveEncoderPortB);
    public LeftDrive() {
    	super(Kp, Ki, Kd);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return lDriveEncoder.getDistance();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	leftDriveMotor.set(output*.25);
    	leftDriveMotor2.set(output*.25);

    }
    public void setSpeed(double speed){
    	leftDriveMotor.set(-speed);
    	leftDriveMotor2.set(-speed);
    }
    
    public void autoTurn(double target, double reduction){
    	
    		leftDriveMotor.set(target*.002*reduction);
    		leftDriveMotor2.set(target*.002*reduction);
    }
}
