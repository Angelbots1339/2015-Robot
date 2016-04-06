package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class EngageBrake extends CommandBase {

    public EngageBrake() {
        // Use requires() here to declare subsystem dependencies
        requires(PIDElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PIDElevator.manual = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDElevator.engageBrake();
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
