package org.usfirst.frc.team1339.robot.commands;


/**
 *
 */
public class TurnLeftGyro extends CommandBase {
	
	double m_speed;
	int m_angle;
	double m_setpoint;

    public TurnLeftGyro(double speed, int angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(PIDChassis);
    	
    	m_speed = speed;
    	m_angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDChassis.PIDDriveTurn(m_speed, m_angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return PIDChassis.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
