package org.usfirst.frc.team3461.robot.commands.AutoCommands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {

	double target, reduction;
	
    public AutoTurn(double targetinput, double reductioninput) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	target = targetinput;
    	reduction = reductioninput;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.leftdrive.lDriveEncoder.reset();
    	Robot.rightdrive.rDriveEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.leftdrive.autoTurn(target, reduction);
    	Robot.rightdrive.autoTurn(-target, reduction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.leftdrive.lDriveEncoder.getDistance() >= target - 20 && Robot.leftdrive.lDriveEncoder.getDistance() <= target + 20 /*&&
        		Robot.rightdrive.rDriveEncoder.getDistance() >= -target - 20 && Robot.rightdrive.rDriveEncoder.getDistance() <= -target + 20*/){
        	return true;
        }
        else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
