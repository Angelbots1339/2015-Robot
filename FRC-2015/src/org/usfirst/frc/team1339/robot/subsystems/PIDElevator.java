package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.DriveWinch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDElevator extends PIDSubsystem {
	
	//A p of 0.001 begins lowering at 1000 with a setpoint of 2000
	//A p of 0.005 begins lowering at 1800 with a setpoint of 2000
	private static double Kp = 0.02;//.04
    private static double Ki = 0.0;
    private static double Kd = 0.0;
    
    private static int tolerance = 40;
    //NERD
	private CANTalon elevMotor;
	private DigitalInput top_limitSwitch;
	public DigitalInput bottom_hallEffect;
	
	//private DigitalOutput outputOne;
	//private DigitalOutput outputTwo;
	//private DigitalOutput outputThree;
	//private DigitalInput button;
	//private static I2C wire;
	private Encoder enco;
	
	//0 is weird value, 1 = 10, 2 = 15, 3 = 20, etc.
	public int currentStep = 0;
	public int setStep = 0;
	//public final int groundValueList[] = {0, 180, 620, 1030, 1160};
	//public final int groundValueList[] = {0, 385, 1065, 1700, 2005, 2160}; // old values from 2/25/2015
	//public final int groundValueList[] = {0, 140, 500, 855, 985, 1170}; //Competition Bot
	public final int groundValueList[] = {0, -165, -517, -860, -1005, -1185};
	public final int groundValueListBin[] = {0, -278, -1185};
	public final int groundValueListTote[] = {0, -610};
	public final int groundValueListAuto[] = {165, 0, -352, -695, -840, -1020};
	public final int groundValueListToteAuto[] = {0, -435};
	public boolean manual = false;
	public boolean isBrakeEngaged = false;
	
	private Solenoid BrakeEngaged, BrakeDisengaged;
	
    // Initialize your subsystem here
    public PIDElevator() {
    	super("PIDElevator", Kp, Ki, Kd);
    	enco = new Encoder(RobotMap.ENCODER_A_CHANNEL, RobotMap.ENCODER_B_CHANNEL, true);
        enco.reset();
        
        //outputOne = new DigitalOutput(RobotMap.ARDUINO_PIN_ONE);
        //outputTwo = new DigitalOutput(RobotMap.ARDUINO_PIN_TWO);
        //outputThree = new DigitalOutput(RobotMap.ARDUINO_PIN_THREE);

    	
    	setAbsoluteTolerance(10);
    	getPIDController().setContinuous(false);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	elevMotor = new CANTalon(RobotMap.ELEV_TALON);
    	
        //button = new DigitalInput(0); 
    	bottom_hallEffect = new DigitalInput(RobotMap.HALL_EFFECT_PORT);
    	top_limitSwitch = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH);
    	
    	//wire = new I2C(Port.kOnboard, 4);
    	
    	BrakeEngaged = new Solenoid(1, RobotMap.BRAKE_IN);
    	BrakeDisengaged = new Solenoid(1, RobotMap.BRAKE_OUT);
    	enable();
    }
     
    
    //public  double getPot(){
    //	return pot.get();
    //}
    //SmartDashboard.putNumber("PotResistance" pot.getvoltage);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWinch());
    }
    
    
    //public void winchDrive(double speed){
    		//elevMotor.set(speed);	
		
//}
    
    public boolean getButton(){
    	return false;//button.get();
    }
    
   /* public static void sendI2C(String data){
    	
    	System.out.println("Sending I2C data...");
    	char[] charArray = data.toCharArray();
    	byte[] writeData = new byte[charArray.length];
    	for (int i = 0; i < charArray.length; i++) {
    		writeData[i] = (byte) charArray[i];
    	}
    	
    	wire.transaction(writeData, writeData.length, null, 0);
    }
    */
    public void reset(){
    	elevMotor.set(-0.8);
    }
    
    public void stop(){
    	elevMotor.set(0);
    }
    
    public void encReset(){
    	enco.reset();
    }
    
    public void engageBrake(){
    	BrakeEngaged.set(true);
    	BrakeDisengaged.set(false);
    	Timer.delay(0.05);
    	BrakeEngaged.set(false);
    	isBrakeEngaged = true;
    }
    
    public void disengageBrake(){
    	BrakeEngaged.set(false);
    	BrakeDisengaged.set(true);
    	Timer.delay(.05);
    	BrakeDisengaged.set(false);
    	isBrakeEngaged = false;
    }
    
    public void resetElevator(){
    	if (bottom_hallEffect.get()){
    		elevMotor.set(0.5);
    	}
    	else{
    		elevMotor.set(0);
    	}
    }
    
    public boolean isOnTarget(){
    	if(onTarget()){
    		return true;
    	}
    	else if(!top_limitSwitch.get()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public void updateLevel(int level, boolean PID){
    	if(PID){
    		currentStep = level;
    	}
    	
    	/*if(level == 0){
    		outputOne.set(true);
    		outputTwo.set(true);
    		outputThree.set(true);
    	}
    	else if(level == 1){
    		outputOne.set(false);
    		outputTwo.set(false);
    		outputThree.set(false);
    	}
    	else if(level == 2){
    		outputOne.set(true);
    		outputTwo.set(false);
    		outputThree.set(false);
    	}
    	else if(level == 3){
    		outputOne.set(false);
    		outputTwo.set(true);
    		outputThree.set(false);
    	}
    	else if(level == 4){
    		outputOne.set(false);
    		outputTwo.set(false);
    		outputThree.set(true);
    	}
    	else if(level == 5){
    		outputOne.set(false);
    		outputTwo.set(false);
    		outputThree.set(true);
    	}
    	else if(level == 6){
    		outputOne.set(true);
    		outputTwo.set(true);
    		outputThree.set(false);
    	}
    	else if(level == 7){
    		outputOne.set(false);
    		outputTwo.set(true);
    		outputThree.set(true);
    	}
    	else if(level == 8){
    		outputOne.set(true);
    		outputTwo.set(false);
    		outputThree.set(true);
    	}*/
    }
    
    private void PIDDrive(double output){
        //System.out.println("******************in pid for drive");
        if(!manual){
        	if (top_limitSwitch.get() == false && (output<0)){
        		elevMotor.pidWrite(0);
        		currentStep = 4;
        	}
        	else if (bottom_hallEffect.get() == false && (output>0)){
        		elevMotor.set(0);
        		encReset();
        	}
        	else {
        		elevMotor.pidWrite(output);
        	}
        }
    }
    
    public boolean brakeIsOnTarget(){
    	if((enco.get() > (getSetpoint() - tolerance)) && (enco.get() < (getSetpoint() + tolerance))){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    protected double returnPIDInput() {
    	SmartDashboard.putData("PID Controller", getPIDController()); //#SpaceError
    	SmartDashboard.putNumber("Encoder Value", enco.get());
    	SmartDashboard.putNumber("Current Step", currentStep);
    	
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return enco.get();
    }
    
    protected void usePIDOutput(double output) {
    	SmartDashboard.putNumber("output", output);
    	SmartDashboard.putNumber("setpoint", getSetpoint());
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	//output *= 0.9;
    	//if(onTarget()) output = 0;
    	
    	SmartDashboard.putNumber("formatted output", output);
    	PIDDrive(output);
    	//elevMotor.pidWrite(output);
    }
    
public void winchDrive(double speed){
	
    	SmartDashboard.putData("Hall Effect", bottom_hallEffect);
    	if (top_limitSwitch.get() == false && (speed>0)){
    		(speed) = 0; 
    		elevMotor.set(-speed);
    	}
    	else if (bottom_hallEffect.get() == false && (speed<0)){	
    		(speed) = 0;
    		elevMotor.set(speed);
    		encReset();
    	}
    	else if(isBrakeEngaged){
    		speed = 0;
    		elevMotor.set(speed);
    	}
    	else {
    		elevMotor.set(-speed);
    	}
    }


    
}
