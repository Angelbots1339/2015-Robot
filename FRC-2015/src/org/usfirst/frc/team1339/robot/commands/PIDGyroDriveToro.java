package org.usfirst.frc.team1339.robot.commands;


/**
 *
 */
public class PIDGyroDriveToro extends CommandBase {
	
	double m_speed;
	double n_speed;
	int m_angle;

    public PIDGyroDriveToro(double speed, int angle, double speedN) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(PIDChassis);
    	requires(ElTotoro);
    	
    	m_speed = speed;
    	n_speed = speedN;
    	m_angle = angle;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDChassis.PIDDriveForward(m_speed, m_angle);
    	ElTotoro.toroSuck(n_speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!ElTotoro.elToroLeftSwitch.get() || !ElTotoro.elToroRightSwitch.get());
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
