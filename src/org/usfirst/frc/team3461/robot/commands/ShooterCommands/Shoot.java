package org.usfirst.frc.team3461.robot.commands.ShooterCommands;

import org.usfirst.frc.team3461.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Shoot extends CommandGroup {

    public Shoot() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
//        addParallel(new ShooterActive(500));
//        addParallel(new ShooterAngleActive(180));
        addParallel(new ShooterActive(800));
        addParallel(new ShooterAngleActive(100));

        //addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
