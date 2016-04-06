package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.ChillArms;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticArms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public boolean leftUp = true, rightUp = true;
	
	private Solenoid leftOut, leftIn, rightOut, rightIn;
	
	public PneumaticArms(){
		leftOut = new Solenoid(1, RobotMap.LEFT_OUT_SOLENOID);
		leftIn = new Solenoid(1, RobotMap.LEFT_IN_SOLENOID);
		rightOut = new Solenoid(1, RobotMap.RIGHT_OUT_SOLENOID);
		rightIn = new Solenoid(1, RobotMap.RIGHT_IN_SOLENOID);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ChillArms());
    }	
    
    public void chill(){}
    
    public void setLeftArmOut(){
        leftIn.set(false);
        leftOut.set(true);
        Timer.delay(.05);
        leftOut.set(false);
        leftUp = false;
        System.out.println("Setting left arm out...");
    }
    
    public void setLeftArmIn(){
    	leftOut.set(false);
        leftIn.set(true);
        Timer.delay(.05);
        leftIn.set(false);
        leftUp = true;
        System.out.println("Setting left arm in...");
    }
    
    public void setRightArmOut(){
    	rightIn.set(false);
        rightOut.set(true);
        Timer.delay(.05);
        rightOut.set(false);
        rightUp = false;
        System.out.println("Setting right arm out...");
    }
    
    public void setRightArmIn(){
    	rightOut.set(false);
        rightIn.set(true);
        Timer.delay(.05);
        rightIn.set(false);
        rightUp = true;
        System.out.println("Setting right arm in...");
    }
}