package org.usfirst.frc.team3461.robot.subsystems.DriveTrain;

import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.AutoCommands.RDrive;
import org.usfirst.frc.team3461.robot.commands.DriveCommands.DriveCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class RightDrive extends PIDSubsystem {

    // Initialize your subsystem here
	public static final double
		Kp = .002,
		Ki = .000001,
		Kd = 0;
	public Encoder rDriveEncoder = new Encoder(RobotMap.rDriveEncoderPortA, RobotMap.rDriveEncoderPortB);
	
	CANTalon rightDriveMotors = new CANTalon(RobotMap.rDrivePort);
	CANTalon rightDriveMotors2 = new CANTalon(RobotMap.rDrivePort2);
    public RightDrive() {
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
        return rDriveEncoder.getDistance();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	rightDriveMotors.set(-output*.25);
    	rightDriveMotors2.set(-output*.25);
}
    public void setSpeed(double speed){
    	rightDriveMotors.set(speed);
    	rightDriveMotors2.set(speed);
    }
    
    public void autoTurn(double target, double reduction){
    	
    	rightDriveMotors.set(-target*.002*reduction);
    	rightDriveMotors2.set(-target*.002*reduction);
}
    
}
