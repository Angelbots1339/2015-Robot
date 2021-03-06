package org.usfirst.frc.team1339.robot.commands;


/**
 *
 */
public class ToroSuckButton extends CommandBase {
	
	private double m_speed;

    public ToroSuckButton(double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(ElTotoro);
        
        m_speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ElTotoro.toroSuck(m_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!ElTotoro.elToroLeftSwitch.get() || !ElTotoro.elToroRightSwitch.get());
    }

    // Called once after isFinished returns true
    protected void end() {
    	ElTotoro.chill();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
