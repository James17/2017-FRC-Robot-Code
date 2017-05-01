package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.GearSystemCommands.GearSystemDoNothing;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid 
					TrapDoor = new DoubleSolenoid(RobotMap.gearTrapDoorPortA, RobotMap.gearTrapDoorPortB),
					ClamShell = new DoubleSolenoid(RobotMap.clamShellPortA, RobotMap.clamShellPortB),
					Slider = new DoubleSolenoid(RobotMap.gearSliderPortA, RobotMap.gearSliderPortB);
	public DigitalInput 
				TopSwitch = new DigitalInput(RobotMap.gearSliderLimitSwitchUp),
				BottomSwitch = new DigitalInput(RobotMap.gearSliderLimitSwitchDown),
				ReedSwitchExtend = new DigitalInput(RobotMap.reedSwitchExtend),
				ReedSwitchRetract = new DigitalInput(RobotMap.reedSwitchRetract),
				IRSensor = new DigitalInput(RobotMap.irSensorPort);
	
	public boolean noGear;
	public String trapDoorState = "Nothing";
				

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GearSystemDoNothing());
    }
    public void trapDoorDown(){
    	TrapDoor.set(DoubleSolenoid.Value.kForward);
    	trapDoorState = "Down";
    }
    public void trapDoorUp(){
    	TrapDoor.set(DoubleSolenoid.Value.kReverse);
    	trapDoorState = "Up";
    }
    public void open(){
    	ClamShell.set(DoubleSolenoid.Value.kForward);
    }
    public void close(){
    	ClamShell.set(DoubleSolenoid.Value.kReverse);
    }
    public void sliderUp(){
    	Slider.set(DoubleSolenoid.Value.kForward);
    }
    public void sliderDown(){
    	Slider.set(DoubleSolenoid.Value.kReverse);
    }
}

