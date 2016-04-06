package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class DriveToro extends CommandBase {
	
	public Joystick toroStick;
	//public Joysick toroStick
	private double toroYaxis;
	private double toroXaxis;
	
    public DriveToro() {
        // Use requires() here to declare subsystem dependencies
        requires(ElTotoro);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	toroStick = oi.getToroStick();
    	//toroStick = oi.getElevStick();
    	toroYaxis = toroStick.getRawAxis(RobotMap.TORO_Y_AXIS);
        toroXaxis = toroStick.getRawAxis(RobotMap.TORO_X_AXIS);
        ElTotoro.driveToro(toroYaxis, toroXaxis);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
