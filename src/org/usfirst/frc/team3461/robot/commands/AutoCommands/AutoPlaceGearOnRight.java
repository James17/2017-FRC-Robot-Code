package org.usfirst.frc.team3461.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceGearOnRight extends CommandGroup {

    public AutoPlaceGearOnRight() {
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
    	addParallel(new LDrive(-1750));
    	addSequential(new RDrive(-1750));
    	
    	//Timer.delay(10);
    	
//    	Timer timer = new Timer();
//    	timer.reset();
//    	timer.start();
//    	while(timer.get()<10){}
    	
    	System.out.println("Starting to turn");
    	addSequential(new AutoTurn(-220, 0.80));
    	//addSequential(new AutoTurn(-300, 60));
    	System.out.println("Ending to turn");
    	
    	addParallel(new LDrive(-500));
    	addSequential(new RDrive(-500));
    }
}
