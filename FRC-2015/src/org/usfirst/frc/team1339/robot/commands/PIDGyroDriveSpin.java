package org.usfirst.frc.team1339.robot.commands;


/**
 *
 */
public class PIDGyroDriveSpin extends CommandBase {

	
	double m_speed;
	//double n_speed;
	int m_angle;
	
	double timeout;
	
	
	
    public PIDGyroDriveSpin(double speed, int angle, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(PIDChassis);
    	requires(ElTotoro);
    	
    	m_speed = speed;
    	m_angle = angle;
    	setTimeout(timeout);
    	//n_speed = speedN;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDChassis.PIDDriveForward(m_speed, m_angle);
    	ElTotoro.toroSpin();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	ElTotoro.chill();
    	PIDChassis.chill();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
