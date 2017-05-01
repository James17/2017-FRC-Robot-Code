package org.usfirst.frc.team3461.robot.commands.GearSystemCommands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearSystemOpenAndDown extends Command {
	
	Timer timer = new Timer();

    public GearSystemOpenAndDown() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.gearSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearSystem.open();
    	while(Robot.gearSystem.ReedSwitchExtend.get() == true){
    		
    	}
    	Robot.gearSystem.sliderDown();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gearSystem.BottomSwitch.get() || timer.get() > 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(timer.get() > 5)
    	{
    		Robot.gearSystem.sliderUp();
    		Robot.gearSystem.close();
    	}
    	timer.stop();
    	//timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	timer.stop();
    	//timer.reset();
    }
}
