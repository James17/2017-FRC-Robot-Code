package org.usfirst.frc.team3461.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3461.robot.Robot;

/**
 *
 */
public class LDrive extends Command {
	
	private double setpoint, buffer = 20;
	public double percent;
	Timer timer = new Timer();
	
	public LDrive(double input) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.leftdrive);
		setpoint = input;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.leftdrive.lDriveEncoder.reset();
//		System.out.println("reset");
		Robot.leftdrive.setSetpoint(setpoint);
//		System.out.println("setpoint");
		Robot.leftdrive.enable();
//		System.out.println("enableing");
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
//		Robot.leftdrive.setSetpoint(setpoint);
//		System.out.println(Robot.leftdrive.getSetpoint());
//		System.out.println("setpoint execute");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(Robot.leftdrive.getPosition() >= Robot.leftdrive.getSetpoint() - buffer && Robot.leftdrive.getPosition() <= Robot.leftdrive.getSetpoint() + buffer || timer.get() >= 5){
//			System.out.println(Robot.leftdrive.getPosition());
//			System.out.println(Robot.leftdrive.getSetpoint());
//			System.out.println("returning true");
			System.out.println("Left isFinished " + Robot.leftdrive.getPosition() + " Time " + timer.get());
			return true;
			
		}
		else return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.leftdrive.disable();
		timer.stop();
//		System.out.println("end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.leftdrive.disable();
		timer.stop();
		System.out.println("Left interrupted " + Robot.leftdrive.getPosition() + " Time " + timer.get());
//		System.out.println("interrupted");
	}
}
