package org.usfirst.frc.team3461.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3461.robot.commands.BallIntakeOn;
import org.usfirst.frc.team3461.robot.commands.HopperBack;
import org.usfirst.frc.team3461.robot.commands.HopperOff;
import org.usfirst.frc.team3461.robot.commands.HopperOn;
import org.usfirst.frc.team3461.robot.commands.TrapDoorDown;
import org.usfirst.frc.team3461.robot.commands.TrapDoorUp;
import org.usfirst.frc.team3461.robot.commands.AutoCommands.LDrive;
import org.usfirst.frc.team3461.robot.commands.DriveCommands.DriveBackwardsCommand;
import org.usfirst.frc.team3461.robot.commands.DriveCommands.DriveCommand;
import org.usfirst.frc.team3461.robot.commands.DriveCommands.DriveHalf;
import org.usfirst.frc.team3461.robot.commands.DriveCommands.DriveStop;
import org.usfirst.frc.team3461.robot.commands.GearSystemCommands.CollectGear;
import org.usfirst.frc.team3461.robot.commands.GearSystemCommands.GearSystemClose;
import org.usfirst.frc.team3461.robot.commands.GearSystemCommands.GearSystemDown;
import org.usfirst.frc.team3461.robot.commands.GearSystemCommands.GearSystemOpen;
import org.usfirst.frc.team3461.robot.commands.GearSystemCommands.GearSystemUp;
import org.usfirst.frc.team3461.robot.commands.ShooterCommands.Shoot;
import org.usfirst.frc.team3461.robot.commands.ShooterCommands.ShooterActive;
import org.usfirst.frc.team3461.robot.commands.ShooterCommands.ShooterAngleActive;
import org.usfirst.frc.team3461.robot.commands.ShooterCommands.ShooterIdle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//joysticks
	public Joystick 
	joy1 = new Joystick(0),
	joy2 = new Joystick(1),
	joy3 = new Joystick(2);
	
	//buttons
	JoystickButton 
	/* Buttons ID's
	 * A = 1
	 * B = 2
	 * X = 3
	 * Y = 4
	 * LB = 5
	 * RB = 6
	 * BACK = 7
	 * LStick = 9
	 * RStick = 10
	 */
//					shootCloseButton = new JoystickButton(joy3, 1),
//					shootFarButton = new JoystickButton(joy3, 2),
					//gearSystemButton = new JoystickButton(joy3, 6),
					driveBackButton = new JoystickButton(joy2, 1),
					driveStopButton = new JoystickButton(joy2, 2),
					driveHalfButton = new JoystickButton(joy2, 4),
	
					hopperButton = new JoystickButton(joy3, 5),
					//hopperBackButton = new JoystickButton(joy3, 6),
					
					trapDoorDownButton = new JoystickButton(joy3, 2),
					trapDoorUpButton = new JoystickButton(joy3, 4),
					
					runBallIntakeButtin = new JoystickButton(joy3, 7),
					
					clamShellButton = new JoystickButton(joy3, 1),
					
					collectGearButton = new JoystickButton(joy3, 3),
					
					shootButton = new JoystickButton(joy3, 6);
	
	public OI(){
		//shooter for close
//		shootCloseButton.whileHeld(new ShooterActive(RobotMap.shootRPMClose));
//		shootCloseButton.whenReleased(new ShooterIdle());
		//shooter for far
//		shootFarButton.whileHeld(new ShooterActive(RobotMap.shootRPMFar));
//		shootFarButton.whenReleased(new ShooterIdle());
		//gear system
		//gearSystemButton.whileHeld(new GearsSystemDown());
		//gearSystemButton.whenReleased(new GearsSystemUp());
		//hopper control
		driveBackButton.whenPressed(new DriveBackwardsCommand());
		driveBackButton.whenReleased(new DriveCommand());
		
		driveStopButton.whenPressed(new DriveStop());
		driveStopButton.whenReleased(new DriveCommand());
		
		driveHalfButton.whenPressed(new DriveHalf());
		driveHalfButton.whenReleased(new DriveCommand());
		
		hopperButton.whenPressed(new HopperOn());
		hopperButton.whenReleased(new HopperOff());
//		hopperBackButton.whileHeld(new HopperBack());
//		hopperBackButton.whenReleased(new HopperOff());
		
		trapDoorDownButton.whenPressed(new TrapDoorDown());
		trapDoorUpButton.whenPressed(new TrapDoorUp());
		
		runBallIntakeButtin.whileHeld(new BallIntakeOn());
	
		clamShellButton.whenPressed(new GearSystemOpen());
		clamShellButton.whenReleased(new GearSystemClose());
		
		collectGearButton.whenPressed(new GearSystemDown());
		collectGearButton.whenReleased(new GearSystemUp());
		
		shootButton.whenPressed(new Shoot());
		shootButton.whenReleased(new ShooterIdle());
		
//		if(joy3.getRawAxis(2) >= .75) new Shoot();
//		else if(joy3.getRawAxis(2) <= .75) new ShooterIdle();
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
