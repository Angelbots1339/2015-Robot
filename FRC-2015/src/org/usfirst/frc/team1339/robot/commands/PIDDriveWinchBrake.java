package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class PIDDriveWinchBrake extends CommandBase {
	
	Joystick stick;
	double control;
	boolean up;

    public PIDDriveWinchBrake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(PIDElevator);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PIDElevator.manual = false;
		PIDElevator.setSetpoint(PIDElevator.groundValueList[1]);
		PIDElevator.setStep = 1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	stick = oi.getElevStick();

    	control = (stick.getRawAxis(RobotMap.WINCH_Y_AXIS));
    	
    	if(PIDElevator.isOnTarget()){
    		PIDElevator.updateLevel(PIDElevator.setStep, true);
    		if(oi.getUpBtn() || oi.getDownBtn()){
        		if(oi.getUpBtn()) up = true;
        		else up = false;
        		
        		if(up){
        			if(PIDElevator.currentStep == 1){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[2]);
            			PIDElevator.setStep = 2;
        			}
        			else if(PIDElevator.currentStep == 2){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[3]);
            			PIDElevator.setStep = 3;
        			}
        			else if(PIDElevator.currentStep == 3){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[4]);
            			PIDElevator.setStep = 4;
        			}
        			else if(PIDElevator.currentStep == 4){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[5]);
            			PIDElevator.setStep = 5;
        			}
        		}//end if up
        		else{
            		if(PIDElevator.currentStep == 2){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[1]);
            			PIDElevator.setStep = 1;
            		}
            		else if(PIDElevator.currentStep == 3){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[2]);
            			PIDElevator.setStep = 2;
        			}
        			else if(PIDElevator.currentStep == 4){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[3]);
            			PIDElevator.setStep = 3;
        			}
        			else if(PIDElevator.currentStep == 5){
            			PIDElevator.setSetpoint(PIDElevator.groundValueList[4]);
            			PIDElevator.setStep = 4;
        		}//end else
        	}
    	}
    	
    	/*if(PIDElevator.brakeIsOnTarget()){
    		if(!PIDElevator.isBrakeEngaged){
    			if(PIDElevator.currentStep > 1){
    				Timer.delay(0.1);
            		PIDElevator.engageBrake();
    			}
    		}
    	} else{
			if(PIDElevator.isBrakeEngaged){
        		PIDElevator.disengageBrake();
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
