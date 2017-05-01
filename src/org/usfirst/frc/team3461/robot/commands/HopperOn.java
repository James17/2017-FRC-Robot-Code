package org.usfirst.frc.team3461.robot.commands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HopperOn extends Command {

    public HopperOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.hopper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.hopper.running = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.hopper.setSpeed(.5);
    	Robot.hopper.hopperState = "On";
    	//Robot.hopper.running = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.hopper.running = false;
    	Robot.hopper.hopperState = "Off";
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.hopper.running = false;
    	Robot.hopper.hopperState = "Off";
    }
}
