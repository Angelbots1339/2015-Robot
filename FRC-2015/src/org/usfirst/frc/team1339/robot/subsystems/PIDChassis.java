//ok google now start robot
//siri start robot program
package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.AnalogGyro;
//import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class PIDChassis extends PIDSubsystem {	
	private static final double Kp = 0.05;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    //private static int tolerance = 3;
    private AnalogGyro gyro; 
    
    //private BuiltInAccelerometer accel;
    CANTalon leftFront, leftBack, rightFront, rightBack;
    
    RobotDrive mecDrive;
    
    private double leftSpeed, rightSpeed;
    
    public boolean forward = false;
    public boolean turn = false;
    
    // Initialize your subsystem here
    public PIDChassis() {
        super("PIDChassis", Kp, Ki, Kd);
        
        setAbsoluteTolerance(3);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
       
        
        leftFront = new CANTalon(RobotMap.LEFT_FRONT_SRX);
        //leftTop = new CANTalon(RobotMap.LEFT_TOP_SRX);
        leftBack = new CANTalon(RobotMap.LEFT_BACK_SRX);
        rightFront = new CANTalon(RobotMap.RIGHT_FRONT_SRX);
        //rightTop = new CANTalon(RobotMap.RIGHT_TOP_SRX);
        rightBack = new CANTalon(RobotMap.RIGHT_BACK_SRX);
        
        mecDrive = new RobotDrive(leftFront, leftBack, rightBack, rightFront);//API is wrong
        //API said it was FLeft, Bleft, Fright, Bight
        //mecDrive.setSafetyEnabled(false);
        
        /*int count = enc.get();
        double raw = enc.getRaw();
        double distance = enc.getDistance();
        double period = enc.getPeriod();
        double rate = enc.getRate();*/
        //enc.setMaxPeriod(.1);
        //enc.setMinRate(20);
        //enc.setDistancePerPulse(10);
        
        //ai = new AnalogInput(RobotMap.POTENTIOMETER_PORT);
        //pot = new AnalogPotentiometer(ai,3600);
        
        
        gyro = new AnalogGyro(RobotMap.GYRO_PORT); //JOE CHANGE 3-6-15
        gyro.reset(); //JOE CHANGE 3-6-15
        
        
        //accel = new BuiltInAccelerometer();
        //enc.setReverseDirection(true);   
        //enc.getDistance();
        //enc.getRaw();
        //hallEffect = new DigitalInput(0);
        
        //RobotDrive mecDrive = new RobotDrive(leftFront, leftBack, rightFront, rightBack);
        /*
      
        
        
        */
        enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    public void driveStraight(double speed){
    	//setLeftRight(speed, speed);
    	// X, Y, Rotation
    	mecDrive.mecanumDrive_Cartesian(0, 0, -speed, 0);// (x, rotation, y, gyro)??????? for auton.
    	//mecDrive.mecanumDrive_Cartesian(speed, 0, 0, 0);
    }
    
    public void driveStrafe(double speed){
    	mecDrive.mecanumDrive_Cartesian(-speed, 0, 0, 0);
    }
    
    public void turnLeft(double speed){
    	mecDrive.mecanumDrive_Cartesian(0, -speed, 0, 0);
    }
    
    public void turnRight(double speed){
    	mecDrive.mecanumDrive_Cartesian(0, speed, 0, 0);
    }
    
    
    
    public void driveWithJoystick(double yValue, double xValue, double zValue) {
    	
    	
    	
    	mecDrive.mecanumDrive_Cartesian(xValue, zValue, yValue, 0);
    	
    	//Talon Temps
    	//SmartDashboard.putNumber("Left Front Temp", leftFront.getTemp());
    	//SmartDashboard.putNumber("Left Back Temp", leftBack.getTemp());
    	//SmartDashboard.putNumber("Right Front Temp", rightFront.getTemp());
    	//SmartDashboard.putNumber("Right Back Temp", rightBack.getTemp());
    	
    	SmartDashboard.putNumber("X-Value Joystick", xValue);
    	SmartDashboard.putNumber("Y-Value Joystick", yValue);
    	SmartDashboard.putNumber("Z-Value Joystick", zValue);
    	
    	//Sensors
    	//SmartDashboard.putNumber("Encoder Distance", enc.getDistance());
    	//SmartDashboard.putNumber("PotTest", pot.get());
    	
    	//SmartDashboard.putNumber("Gyro Value", Math.round(gyro.getAngle())); JOE CHANGE 3-6-15
    	
    	//SmartDashboard.putNumber("Accel X Value", accel.getX()*100);
    	//SmartDashboard.putNumber("Accel Y Zalue", accel.getY()*100);
    	//SmartDashboard.putNumber("Accel Z Zalue", accel.getZ()*100);
    	//SmartDashboard.putBoolean("Hall Effect", hallEffect.get());
    }
    
    public void chill(){
    	forward = false;
    	turn = false;
    	leftFront.set(0);
    	leftBack.set(0);
    	rightFront.set(0);
    	rightBack.set(0);
    }
    
    public void PIDDriveForward(double speed, int angle){
    	speed *= -1;
    	turn = false;
    	forward = true;
    	setSetpoint(angle);
    	leftSpeed = speed;
    	rightSpeed = speed;
    }
    
    public void PIDDriveTurn(double speed, int angle){
    	speed *= -1;
    	forward = false;
    	turn = true;
    	setSetpoint(angle);
    	leftSpeed = speed;
    	rightSpeed = speed;
    }
    
    private void PIDSet(double output){
    	if(forward){
    		leftFront.set(leftSpeed + output);
    		leftBack.set(leftSpeed + output);
    		rightFront.set(-rightSpeed + output);
    		rightBack.set(-rightSpeed + output);
    	}
    	else if(turn){
    		output *= 0.5;
    		leftFront.set(leftSpeed + output);
    		leftBack.set(leftSpeed + output);
    		rightFront.set(rightSpeed + output);
    		rightBack.set(rightSpeed + output);
    	}
    }
    
   /* public void arcadeDrive(double throttle, double turn){
    	double left = 0;
    	double right = 0;
    	
    	if(throttle > 0){
    		left = throttle + turn;
    		right = throttle - turn;
    	}
    	else if(throttle < 0){
    		left = throttle - turn;
    		right = throttle + turn;
    	}

    	setLeftRight(left, right);
    }
    */
    /*private void setLeftRight(double leftSpeed, double rightSpeed){
    	leftFront.set(leftSpeed);
    	leftBack.set(leftSpeed);
    	rightFront.set(rightSpeed);
    	rightBack.set(rightSpeed);
    	
    	
    }*/
    
    public double getGyro(){
    	return gyro.getAngle();
    }
    
    public void resetGyro(){
    	gyro.reset();
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	SmartDashboard.putNumber("Gyro", gyro.getAngle());
    	double angle = gyro.getAngle();
    	if(angle > 20 || angle < -20) angle = 0;
    	return angle;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	//SmartDashboard.putNumber("PIDChassis Output",output);
    	
    	PIDSet(output);
    }
    
}



   

   