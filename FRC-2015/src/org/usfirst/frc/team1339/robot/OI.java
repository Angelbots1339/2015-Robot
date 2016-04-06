package org.usfirst.frc.team1339.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI{
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public Joystick drivestick = new Joystick(RobotMap.JOYSTICK_PORT);
    public Joystick elevStick = new Joystick(RobotMap.JOY_1_PORT);
    public Joystick toroStick = new Joystick(RobotMap.JOY_2_PORT);
    public Joystick razerStick = new Joystick(RobotMap.JOY_3_PORT);
    
    private JoystickButton PIDBinOverride = new JoystickButton(elevStick, 4);
    private JoystickButton PIDToteOverride = new JoystickButton(elevStick, 5);
    private JoystickButton PIDToteDown = new JoystickButton(toroStick, 3);
    private JoystickButton BrakeToggle = new JoystickButton(elevStick, 1);
    private JoystickButton upBtn = new JoystickButton(elevStick, 3);
    private JoystickButton downBtn = new JoystickButton(elevStick, 2);
    
    @SuppressWarnings("unused")
	private JoystickButton OpenToro = new JoystickButton(toroStick, 2);
    private JoystickButton CloseToro = new JoystickButton(toroStick, 1);
    
    private JoystickButton  BothToggle = new JoystickButton(drivestick, 2);
    private JoystickButton  RightToggle = new JoystickButton(drivestick, 5);
    private JoystickButton  LeftToggle = new JoystickButton(drivestick, 6);
    private JoystickButton  DeLimiter1 = new JoystickButton(drivestick, 1);
    private JoystickButton  Delimiter0 = new JoystickButton(drivestick, 7);
    private JoystickButton  InvertBtn = new JoystickButton(drivestick, 3);
    
    public OI(){
    	
    	
    	//System.out.println("Stick: " + drivestick.toString());
    	//System.out.println("El Stick: " + elevStick.toString());
    	//System.out.println("Toro Stick: " + toroStick.toString());
    	
    	PIDBinOverride.whenPressed(new PIDDriveWinchBin());
    	PIDToteOverride.whenPressed(new PIDDriveWinch());
    	PIDToteDown.whenPressed(new PIDToteDown());
    	CloseToro.whenPressed(new CloseToro());
    	
    	BothToggle.whenPressed(new ToggleBoth());
    	LeftToggle.whenPressed(new ToggleLeftArm());
    	RightToggle.whenPressed(new ToggleRightArm());
    	
    	BrakeToggle.whenPressed(new EngageBrake());
    	BrakeToggle.whenReleased(new DisengageBrake());
    }
	
	
    public Joystick getJoystick() {
        return drivestick;	
    }
    
    public Joystick getElevStick() {
        return elevStick;
    }
    
    public Joystick getToroStick() {
        return toroStick;
    }
    
    public Joystick getRazerStick() {
        return razerStick;
    }
    public boolean getUpBtn(){
    	return upBtn.get();
    }
    public boolean getDownBtn(){
    	return downBtn.get();
    }
    public boolean getDeLimiter1() {
    	return DeLimiter1.get();
    }
    public boolean getDeLimiter0() {
    	return Delimiter0.get();
    }
    public boolean getInvertBtn(){
    	return InvertBtn.get();
    }
}

//nerdscrublord