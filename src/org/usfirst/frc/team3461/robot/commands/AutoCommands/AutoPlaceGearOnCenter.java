package org.usfirst.frc.team3461.robot.commands.AutoCommands;

import org.usfirst.frc.team3461.robot.Robot;
import org.usfirst.frc.team3461.robot.commands.GearSystemCommands.GearSystemOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceGearOnCenter extends CommandGroup {

    public AutoPlaceGearOnCenter() {
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
//    	Robot.leftdrive.lDriveEncoder.reset();
//    	Robot.rightdrive.rDriveEncoder.reset();
    	addParallel(new LDrive(-1500));
    	addSequential(new RDrive(-1500));
    	
//    	addSequential(new GearSystemOpen());
//    	
//    	addParallel(new LDrive(200));
//    	addSequential(new RDrive(200));
    }
}
