package org.usfirst.frc.team3461.robot.commands.GearSystemCommands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearSystemClose extends Command {
	
	Timer timer = new Timer();
	int count;

    public GearSystemClose() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	count = 0;
    	Robot.gearSystem.noGear = false;
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearSystem.close();
    	//Timer.delay(.25);
//    	while(Robot.gearSystem.ReedSwitchRetract.get() == true || timer.get() >= 25)
//    	{
//    		if(Robot.gearSystem.ReedSwitchRetract.get() == true)
//    		{
//    			count++;
//    			Robot.gearSystem.open();
//    		}
//    		Timer.delay(.05);
//    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gearSystem.ReedSwitchRetract.get() || count >= 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(count >= 3)
    	{
    		Robot.gearSystem.noGear = true;
    		Robot.gearSystem.sliderUp();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
