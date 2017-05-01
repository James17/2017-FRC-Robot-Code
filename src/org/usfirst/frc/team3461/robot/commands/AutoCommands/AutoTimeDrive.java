package org.usfirst.frc.team3461.robot.commands.AutoCommands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTimeDrive extends Command {
	
	Timer timer = new Timer();

    public AutoTimeDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.leftdrive);
        requires(Robot.rightdrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.leftdrive.setSpeed(.70);
    	Robot.rightdrive.setSpeed(.75);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= 1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.leftdrive.setSpeed(0);
    	Robot.rightdrive.setSpeed(0);
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.leftdrive.setSpeed(0);
    	Robot.rightdrive.setSpeed(0);
    	timer.stop();
    }
}
