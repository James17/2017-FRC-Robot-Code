
package org.usfirst.frc.team3461.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3461.robot.commands.AutoCommands.AutoDoNothing;
import org.usfirst.frc.team3461.robot.commands.AutoCommands.AutoPlaceGearOnCenter;
import org.usfirst.frc.team3461.robot.commands.AutoCommands.AutoPlaceGearOnLeft;
import org.usfirst.frc.team3461.robot.commands.AutoCommands.AutoPlaceGearOnRight;
import org.usfirst.frc.team3461.robot.commands.AutoCommands.AutoTimeDrive;
import org.usfirst.frc.team3461.robot.commands.AutoCommands.LDrive;
import org.usfirst.frc.team3461.robot.subsystems.Climber;
import org.usfirst.frc.team3461.robot.subsystems.BallIntake;
import org.usfirst.frc.team3461.robot.subsystems.Shooter;
import org.usfirst.frc.team3461.robot.subsystems.ShooterAngleWheels;
import org.usfirst.frc.team3461.robot.subsystems.DriveTrain.LeftDrive;
import org.usfirst.frc.team3461.robot.subsystems.DriveTrain.RightDrive;
import org.usfirst.frc.team3461.robot.subsystems.GearSystem;
import org.usfirst.frc.team3461.robot.subsystems.Hopper;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//creates new instances of subsystems
	public static final LeftDrive leftdrive = new LeftDrive();
	public static final RightDrive rightdrive = new RightDrive();
	public static OI oi;
	public static final Shooter shooter = new Shooter();
	public static final Climber climber = new Climber();
	public static final BallIntake ballintake = new BallIntake();
	public static final GearSystem gearSystem = new GearSystem();
	public static final Hopper hopper = new Hopper();
	public static final ShooterAngleWheels shooterAngleWheels = new ShooterAngleWheels();
	

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		SmartDashboard.putData("Auto modes", chooser);
		chooser.addObject("Do nothing", new AutoDoNothing());
		chooser.addObject("Time Drive", new AutoTimeDrive());
		chooser.addDefault("Place Gear On Center", new AutoPlaceGearOnCenter());
		chooser.addObject("Place Gear On Left (Turn Right)", new AutoPlaceGearOnLeft());
		chooser.addObject("Place Gear On Right (Turn Left)", new AutoPlaceGearOnRight());
		
		
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		displayDashboard();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Robot.ballintake.extendCollector();
		Robot.gearSystem.sliderUp();
		Robot.gearSystem.close();
		
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		displayDashboard();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		Robot.ballintake.extendCollector();
		Robot.gearSystem.sliderUp();
		Robot.gearSystem.close();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		displayDashboard();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	//displays the information about all processes on smart dashboard for debuging purposes
	public void displayDashboard(){
//		SmartDashboard.putData("Left DriveTrain side", leftdrive);
//		SmartDashboard.putData("Right DriveTrain Side", rightdrive);
//		SmartDashboard.putData("Climber", climber);
//		SmartDashboard.putData("Intake", ballintake);
//		SmartDashboard.putData("Shooter", shooter);
//		SmartDashboard.putData("Trap Door", gearSystem);
		
//		SmartDashboard.putData(Scheduler.getInstance());
		
		//SmartDashboard.putNumber("Shooter Position", Robot.shooter.getPosition());
		SmartDashboard.putNumber("Shooter Angle Wheels", Robot.shooterAngleWheels.getEncoderRate());
		SmartDashboard.putNumber("Shooter Rate", Robot.shooter.getEncoderRate());
		
		SmartDashboard.putBoolean("Reed Swtitch Extend", Robot.gearSystem.ReedSwitchExtend.get());
		SmartDashboard.putBoolean("Reed Swtitch Retract", Robot.gearSystem.ReedSwitchRetract.get());
		
		SmartDashboard.putBoolean("Gear in place (IR sensor)", Robot.gearSystem.IRSensor.get());
		
		SmartDashboard.putBoolean("Top Switch", Robot.gearSystem.TopSwitch.get());
		SmartDashboard.putBoolean("Bottom switch", Robot.gearSystem.BottomSwitch.get());
		
		SmartDashboard.putString("Trap Door State", Robot.gearSystem.trapDoorState);
		SmartDashboard.putString("Hopper State", Robot.hopper.hopperState);
		
		SmartDashboard.putNumber("right encoder", Robot.rightdrive.rDriveEncoder.getDistance());
		SmartDashboard.putNumber("left encoder", Robot.leftdrive.lDriveEncoder.getDistance());

		
	}
}
