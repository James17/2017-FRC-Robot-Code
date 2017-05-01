package org.usfirst.frc.team3461.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int 
	//CAN ID's 
	shooterAngleWheels = 1,
	hopperPort = 4,
	lDrivePort = 5,
	LDrivePort2 = 6,
	rDrivePort = 7,
	rDrivePort2 = 8,
	climberPort = 9,
	
	//PWM Ports
	shooterPort = 0,
	intakePort = 1,
	
	//PCM Ports
	clamShellPortA = 0,
	clamShellPortB = 1,
	gearTrapDoorPortA = 2,
	gearTrapDoorPortB = 3,
	extenderPortA = 4,
	extenderPortB = 5,
	gearSliderPortA = 6,
	gearSliderPortB = 7,
	
	//DI/O Ports
	lDriveEncoderPortA = 0,
	lDriveEncoderPortB = 1,
	rDriveEncoderPortA = 2,
	rDriveEncoderPortB = 3,
	shooterEncoderPortA = 4,
	shooterEncoderPortB = 5,
	shooterAngleEncoderPortA = 6,
	shooterAngleEncoderPortB = 7,
	hopperEncoderPortA = 8,
	hopperEncoderPortB = 9,
	gearSliderLimitSwitchUp = 10,
	gearSliderLimitSwitchDown = 11,
	reedSwitchExtend = 12,
	reedSwitchRetract = 13,
	irSensorPort = 14;
			
	
	public static final double
	//speeds:
	shooterTargetSpeed = .85,
	shooterTargetRPM = 800,
	shootRPMClose = 0,
	shootRPMFar = 0;
	

	
	//map the left and right motors, you could define the
	
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
