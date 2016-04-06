/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team1339.robot.RobotMap;

/**
 *
 * @author Chad
 */


public class DriveWithJoystick extends CommandBase {
    private double yAxis, xAxis, zAxis, speed;
    private Joystick stick;
    private double xLimit, yLimit, zLimit;
    private boolean Inverted = true;
    private int invertCooldown = 0;
    
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(PIDChassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PIDChassis.forward = false;
    	PIDChassis.turn = false;
    }

    // Called repeatedly when this Command is scheduled to run
	protected void execute() {
        stick = oi.getJoystick();
        
        yAxis = stick.getRawAxis(RobotMap.JOY_Y_AXIS);
        xAxis = stick.getRawAxis(RobotMap.JOY_X_AXIS);
        zAxis = stick.getRawAxis(RobotMap.JOY_Z_AXIS);
        //speed = stick.getRawAxis(RobotMap.JOY_TRIM_AXIS);
        
        //Deadzone
        //if(zAxis < 1 && zAxis > -1) zAxis = 0;
        
        //Exponential Gain
        yAxis = (yAxis)*(yAxis)*(yAxis);
        xAxis = (xAxis)*(xAxis)*(xAxis);
        //zAxis = (zAxis)*(zAxis)*(zAxis);
        
        //DeExponential Gain
        //zAxis = Math.pow(zAxis, 1/3);
        
        //Limit Speed
        //speed = (speed-1)*-.5;
        speed = 1; // Speed limiter option - optional
        yAxis *= speed;
        xAxis *= speed;
        zAxis *= speed;
        
        //Invert X-Axis
        xAxis *= -1;
        
        if(oi.getDeLimiter0() && oi.getDeLimiter1()){
        	xLimit = 1;
        	yLimit = 1;
        	zLimit = 1;
        }
        else{
        	xLimit = 0.6;
        	yLimit = 0.32;
        	zLimit = 0.27;
        }
        
        xAxis *= xLimit;  // Left-Right
    	yAxis *= yLimit;  // Forward-Back
    	zAxis *= zLimit;  // Rotate!
    	
        if(invertCooldown < 0){
            if(oi.getInvertBtn()){
            	Inverted = !Inverted;
            	invertCooldown = 20;
            }
        }
        else{
        	invertCooldown--;
        }
        
        if(!Inverted){
            xAxis *= -1;
           	yAxis *= -1;
           	//zAxis *= -1;
        }
    	
        PIDChassis.driveWithJoystick(yAxis, xAxis, zAxis);
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
