package org.usfirst.frc.team3461.robot.commands.ShooterCommands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterAngleActive extends Command {
	
	double setpoint;

    public ShooterAngleActive(double input) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooterAngleWheels);
        
        setpoint = input;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooterAngleWheels.setSetpoint(setpoint);
    	Robot.shooterAngleWheels.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterAngleWheels.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooterAngleWheels.disable();
    }
}
