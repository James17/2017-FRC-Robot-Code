
package org.usfirst.frc.team3461.robot.commands.ShooterCommands;

import org.usfirst.frc.team3461.robot.Robot;
import org.usfirst.frc.team3461.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterActive extends Command {

	double setpoint;	
	
    public ShooterActive(double input) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
        //input is set when button is pressed
    	setpoint = input;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//pid loop logic
    	Robot.shooter.setSetpoint(setpoint);
    	Robot.shooter.enable();
    	//Robot.shooter.running = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if pid loop fails uncomment this line to allow speed to be set.
    	//Robot.shooter.setSpeed(RobotMap.shooterTargetSpeed);
    	//Robot.shooter.running = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//ends pid loop prosses
    	Robot.shooter.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.disable();
    }
}
