package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.DriveToro;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElToro extends Subsystem {
	
    CANTalon leftWheel, rightWheel;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DigitalInput elToroLeftSwitch;
    public DigitalInput elToroRightSwitch;
    
    private Solenoid leftOutToro, leftInToro, rightOutToro, rightInToro;
    
    public ElToro(){
    	
    	leftWheel = new CANTalon(RobotMap.LEFT_WHEEL);
    	rightWheel = new CANTalon(RobotMap.RIGHT_WHEEL);
    	elToroRightSwitch = new DigitalInput(RobotMap.EL_TORO_RIGHT_SWITCH);
    	elToroLeftSwitch = new DigitalInput(RobotMap.EL_TORO_LEFT_SWITCH);
    	
    	leftOutToro = new Solenoid( RobotMap.LEFT_OUT_SOLENOID_TORO);
		leftInToro = new Solenoid( RobotMap.LEFT_IN_SOLENOID_TORO);
		rightOutToro = new Solenoid(RobotMap.RIGHT_OUT_SOLENOID_TORO);
		rightInToro = new Solenoid(RobotMap.RIGHT_IN_SOLENOID_TORO);
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveToro());
    }
    /*
    public void suck(double speed){
    	leftWheel.set(speed);
    	rightWheel.set((speed)*-1);
    }
    
    public void spin(double speed){
    	leftWheel.set(speed);
    	rightWheel.set(speed);
    }
    
    public void spit(double speed){
    	leftWheel.set((speed)*-1);
    	rightWheel.set(speed);
    }
    */
    public void chill(){
    	leftWheel.set(0);
    	rightWheel.set(0);
    }
    
    public void openPneumatics(){
    	rightOutToro.set(true);
    	leftOutToro.set(true);
    	rightInToro.set(false);
    	leftInToro.set(false);
    	Timer.delay(.05);
    	rightOutToro.set(false);
    	leftOutToro.set(false);
    	
    }
    
    public void closePneumatics(){
    	rightOutToro.set(false);
    	leftOutToro.set(false);
    	rightInToro.set(true);
    	leftInToro.set(true);
    	Timer.delay(.05);
    	rightInToro.set(false);
    	leftInToro.set(false);
    }
    
    public void toroSuck(double speed){
    	leftWheel.set(-speed);
    	rightWheel.set(speed);
    }
    
    public void toroSpin(){
    	leftWheel.set(1);
    	rightWheel.set(1);
    }
    
    public void spinSpeed(double speed){
    	leftWheel.set(speed);
    	rightWheel.set(speed);
    }
    
    public void toroSpit(double speed){
    	leftWheel.set(speed);
    	rightWheel.set(-speed);
    }
    
    public void driveToro(double toroYaxis, double toroXaxis){
    	//toroYaxis = toroYaxis*.5;
    	//toroXaxis = toroXaxis*.5;
    	SmartDashboard.putBoolean("Left Bumper", elToroLeftSwitch.get());
    	SmartDashboard.putBoolean("Right Bumper", elToroRightSwitch.get());
    	
    	if (elToroLeftSwitch.get() == false && elToroRightSwitch.get() == false &&(toroYaxis>0)){ //&& (toroXaxis<0)){
    		toroXaxis *= 0.15;
    		toroYaxis *= 0.15;
    		leftWheel.set(toroYaxis*-1+toroXaxis);
        	rightWheel.set(toroYaxis+toroXaxis);
    	}
    	else if (!elToroLeftSwitch.get() && elToroRightSwitch.get() && toroYaxis > 0){
    		leftWheel.set((toroYaxis*-1+toroXaxis) * 0.75);
    		rightWheel.set((toroYaxis+toroXaxis));
    		
    	}
    	else if (!elToroRightSwitch.get() && elToroLeftSwitch.get() && toroYaxis > 0){
    		leftWheel.set((toroYaxis*-1+toroXaxis));
    		rightWheel.set((toroYaxis+toroXaxis) * 0.75);
    		
    	}
    	else {
    		leftWheel.set(toroYaxis*-1+toroXaxis);
        	rightWheel.set(toroYaxis+toroXaxis);
    	}
    }
}

