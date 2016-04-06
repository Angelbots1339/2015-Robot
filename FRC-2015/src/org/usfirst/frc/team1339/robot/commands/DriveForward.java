package org.usfirst.frc.team1339.robot.commands;


/**
 *
 */
public class DriveForward extends CommandBase {
	
	double m_speed;

    public DriveForward(double speed, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requiCres(chassis);
    	requires(PIDChassis);
    	
    	m_speed = speed;
    	
    	setTimeout(timeout);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDChassis.driveStraight(m_speed);
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
