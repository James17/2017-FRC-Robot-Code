package org.usfirst.frc.team3461.robot.commands.AutoCommands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RDrive extends Command {
	
	private double setpoint, buffer = 20;
	Timer timer = new Timer();

    public RDrive(double input) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.rightdrive);
    	setpoint = input;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.rightdrive.rDriveEncoder.reset();
    	Robot.rightdrive.setSetpoint(setpoint);
    	Robot.rightdrive.enable();
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.rightdrive.getPosition() >= Robot.rightdrive.getSetpoint() - buffer && Robot.rightdrive.getPosition() <= Robot.rightdrive.getSetpoint() + buffer || timer.get() >= 5){
    		
    		System.out.println("right isFinished " + Robot.rightdrive.getPosition() + " Time " + timer.get());
			return true;
		}
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rightdrive.disable();
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.rightdrive.disable();
    	timer.stop();
		System.out.println("right interrupted " + Robot.rightdrive.getPosition() + " Time " + timer.get());
    }
}
