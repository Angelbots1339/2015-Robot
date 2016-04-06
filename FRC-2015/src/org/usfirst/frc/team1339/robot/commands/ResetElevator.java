package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class ResetElevator extends CommandBase {

    public ResetElevator() {
        // Use requires() here to declare subsystem dependencies
        requires(PIDElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDElevator.resetElevator();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !PIDElevator.bottom_hallEffect.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
