package org.usfirst.frc.team3461.robot.commands.GearSystemCommands;

import org.usfirst.frc.team3461.robot.Robot;
import org.usfirst.frc.team3461.robot.commands.TrapDoorUp;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectGear extends CommandGroup {

    public CollectGear() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	Timer timer = new Timer(),
    			timer2 = new Timer();
    	timer.reset();
    	timer.start();
    	
    	
    	addSequential(new GearSystemOpenAndDown());
    	/*addSequential(new GearSystemDown());*/
    	timer2.reset();
    	timer2.start();
    	//while(timer2.get() > 10)
    	//{
    		addSequential(new GearSystemClose());
    		if(Robot.gearSystem.ReedSwitchRetract.get() == true && Robot.gearSystem.noGear == false)
    		{
    			addSequential(new GearSystemUp());
    			while(Robot.gearSystem.TopSwitch.get() == false || timer.get() >= .5)
    			{
    				addSequential(new TrapDoorUp());
    			}
    		}
    	//}
    	
    }
}
