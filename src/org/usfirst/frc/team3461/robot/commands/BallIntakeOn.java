package org.usfirst.frc.team3461.robot.commands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallIntakeOn extends Command {

    public BallIntakeOn() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.ballintake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//extends the ball intake collector on start of command
    	//Robot.ballintake.extendCollector();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//sets motor speed to full
    	Robot.ballintake.setSpeed(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
