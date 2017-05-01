package org.usfirst.frc.team3461.robot.commands.ShooterCommands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterIdle extends Command {

    public ShooterIdle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	requires(Robot.shooterAngleWheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.running = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.shooter.setSpeed(.2);
//    	Robot.shooter.setSpeed(Robot.oi.joy1.getZ()*.5+.5);
//    	Robot.shooterAngleWheels.setSpeed(Robot.oi.joy2.getZ());
    	Robot.shooter.setSpeed(0);
    	Robot.shooterAngleWheels.setSpeed(0);
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
