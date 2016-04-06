package org.usfirst.frc.team1339.robot.commands;


import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWinch extends CommandBase {	
    private double control;
    public Joystick elevstick;
    
    public DriveWinch() {
        // Use requires() here to declare subsystem dependencies
    	requires(PIDElevator);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PIDElevator.manual = true;
    	PIDElevator.currentStep = 0;
    	//PIDElevator.disengageBrake();          CHANGED TO WORK
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevstick = oi.getElevStick();
        control = (elevstick.getRawAxis(RobotMap.WINCH_Y_AXIS));
        control *= 1;
        SmartDashboard.putNumber("Manual Control", control);
        
        PIDElevator.winchDrive(control);
        /*
    	if (control != 0 && PIDElevator.isbrakeengaged == false){
    	PIDElevator.winchDrive(control);
    	}
    	else if (control != 0 && PIDElevator.isbrakeengaged){
    		PIDElevator.disengageBrake();
    		
    	}
    	else{
    		PIDElevator.engageBrake();
    	}
    	*/
    	//SmartDashboard.putBoolean("Button", PIDElevator.getButton());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
	
    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
