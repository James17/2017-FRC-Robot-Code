package org.usfirst.frc.team3461.robot.subsystems;

import org.usfirst.frc.team3461.robot.RobotMap;
import org.usfirst.frc.team3461.robot.commands.BallIntakeOff;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallIntake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark intakeMotor = new Spark(RobotMap.intakePort);
	DoubleSolenoid extender = new DoubleSolenoid(RobotMap.extenderPortA, RobotMap.extenderPortB);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new BallIntakeOff());
    }
    //Sets the speed of the motor. Called in the commands
    public void setSpeed(double speed){
    	intakeMotor.set(speed);
    }
    //Extends the ball intake on call. 
    public void extendCollector(){
    	extender.set(DoubleSolenoid.Value.kForward);
    }
}

