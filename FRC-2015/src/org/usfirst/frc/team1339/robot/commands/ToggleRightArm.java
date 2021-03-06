package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class ToggleRightArm extends CommandBase {

    public ToggleRightArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Arms.rightUp){
    		Arms.setRightArmOut();
    	}
    	else{
    		Arms.setRightArmIn();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
