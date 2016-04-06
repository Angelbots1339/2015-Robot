package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class SetPIDTote extends CommandBase {
	int m_level;

    public SetPIDTote(int level) {
        // Use requires() here to declare subsystem dependencies
        requires(PIDElevator);
    	m_level = level;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PIDElevator.manual = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		PIDElevator.setSetpoint(PIDElevator.groundValueListToteAuto[m_level]);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return PIDElevator.isOnTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
