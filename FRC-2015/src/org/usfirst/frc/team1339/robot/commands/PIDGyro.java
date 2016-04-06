package org.usfirst.frc.team1339.robot.commands;


/**
 *
 */
public class PIDGyro extends CommandBase {
	
	double m_speed;
	int m_angle;

    public PIDGyro(double speed, int angle, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(PIDChassis);
    	
    	m_speed = speed;
    	m_angle = angle;
    	
    	setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDChassis.PIDDriveForward(m_speed, m_angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
