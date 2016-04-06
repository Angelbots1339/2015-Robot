package org.usfirst.frc.team1339.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.  
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    
	
	
	public static int JOYSTICK_PORT = 0;
	public static int JOY_1_PORT = 1;
	public static int JOY_2_PORT = 2;
	public static int JOY_3_PORT = 3;
	public static int JOY_5_PORT = 5;
	public static int BUTTON_A = 1;
	public static int BUTTON_B = 2;
	public static int BUTTON_X = 3;
	public static int BUTTON_Y = 4;
	public static int TRIGGER = 1;
	
	
	
	//1 is left stick x-axis, 2 is left stick y-axis
    //3 is right stick x-axis, 4 is right stick y-axis
	public static int LEFT_X_AXIS = 0;
	public static int LEFT_Y_AXIS = 1;
	public static int RIGHT_X_AXIS = 4;
	public static int RIGHT_Y_AXIS = 5;
	public static int RIGHT_TRIGGER = 3;
	public static int LEFT_TRIGGER = 2;
	
	//These are for the drive joystick
	public static int JOY_Y_AXIS = 1;
	public static int JOY_X_AXIS = 0;
	public static int JOY_Z_AXIS = 3;
	
	//These are for the winch joystick
	public static int WINCH_Y_AXIS = 1;
	public static int WINCH_X_AXIS = 0;
	public static int WINCH_Z_AXIS = 2;
	public static int JOY_TRIM_AXIS = 2;
	
	public static int RAZER_LY_AXIS = 1;
	public static int RAZER_LX_AXIS = 0;
	public static int RAZER_RY_AXIS = 5;
	public static int RAZER_RX_AXIS = 4;
	
	public static int TORO_X_AXIS = 0;
	public static int TORO_Y_AXIS = 1;
	
	//CAN ID's
	public static int PCM_PORT_0 = 0;
	public static int PCM_PORT_1 = 1;
	public static int LEFT_FRONT_SRX = 7;
	public static int LEFT_BACK_SRX = 5;
	public static int RIGHT_FRONT_SRX = 4;
	public static int RIGHT_BACK_SRX = 1;
	public static int ELEV_TALON = 2;
	public static int LEFT_WHEEL = 6;
	public static int RIGHT_WHEEL = 3;
	public static int ARM_MOTOR = 8;
	
	//Analog Ports
	public static int HALL_PORT = 0;
	public static int GYRO_PORT = 1;
	
	
	public static int ENCODER_A_CHANNEL = 8;
	public static int ENCODER_B_CHANNEL = 9;
	public static int ARM_ENCODER_A = 1;
	public static int ARM_ENCODER_B = 0;
	
	//Solenoids
	public static int LEFT_OUT_SOLENOID = 7;//pcm 2
	public static int LEFT_IN_SOLENOID = 6;//pcm 2
	public static int RIGHT_OUT_SOLENOID = 2;//pcm 2
	public static int RIGHT_IN_SOLENOID = 3;//pcm 2
	
	public static int LEFT_IN_SOLENOID_TORO = 1;//pcm 1
	public static int LEFT_OUT_SOLENOID_TORO = 2;//pcm 1
	public static int RIGHT_IN_SOLENOID_TORO = 3;//pcm 1
	public static int RIGHT_OUT_SOLENOID_TORO = 0;//pcm 1
	
	public static int BRAKE_IN = 5;//PCM 2
	public static int BRAKE_OUT = 4;//PCM 2
	
	
	
	//Limit Switches
	public static int HALL_EFFECT_PORT_2 = 3;
	public static int EL_TORO_LEFT_SWITCH = 4;
	public static int EL_TORO_RIGHT_SWITCH = 5;
	public static int HALL_EFFECT_PORT = 6;
	public static int TOP_LIMIT_SWITCH = 7;
	
	public static boolean istoroclosed = false;
	
	//Arduino output pins
	//public static int ARDUINO_PIN_ONE = 0;
	//public static int ARDUINO_PIN_TWO = 1;
	//public static int ARDUINO_PIN_THREE = 2;

	
}
