package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class PIDToteDown extends CommandBase {
	
	Joystick stick;
	double control;
	boolean up;

    public PIDToteDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(PIDElevator);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PIDElevator.manual = false;
		PIDElevator.setSetpoint(PIDElevator.groundValueListTote[1]);
		PIDElevator.setStep = 1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	stick = oi.getElevStick();

    	control = (stick.getRawAxis(RobotMap.WINCH_Y_AXIS));
    	
    	if(PIDElevator.onTarget()){
    		PIDElevator.updateLevel(PIDElevator.setStep, true);
    		/*if(!PIDElevator.isBrakeEngaged){
    			if(PIDElevator.currentStep > 1){
    				Timer.delay(0.1);
            		PIDElevator.engageBrake();
    			}
    		}*/
    		if(oi.getUpBtn() || oi.getDownBtn()){
        		if(oi.getUpBtn()) up = true;
        		else up = false;
        		
        		if(up){
        			if(PIDElevator.currentStep == 4){
            			PIDElevator.setSetpoint(PIDElevator.groundValueListTote[1]);
            			PIDElevator.setStep = 1;
        			}
        		}//end if up
        		else{
            		if(PIDElevator.currentStep == 1){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[1]);
            			PIDElevator.setStep = 1;
        		}//end else
        	}
    	} /*else {
    		if(PIDElevator.isBrakeEngaged){
        		PIDElevator.disengageBrake();
    			}
    		}*/
    	}
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
