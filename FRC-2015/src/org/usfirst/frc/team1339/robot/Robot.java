//SPACE GAME CONFIRMED!!!
package org.usfirst.frc.team1339.robot;



import org.usfirst.frc.team1339.robot.commands.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import org.usfirst.frc.team1339.robot.subsystems.PIDElevator;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
    Command autonomousCommand;
    SendableChooser autoChooser;
    Command resetEnc;
    Command openBrake;
    Command resetGyro;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("robotInit()\n");
		CommandBase.init();
		//autonomousCommand = new ThreeToteAuto();
		//autonomousCommand = new ThreeToteAuto2();
		//autonomousCommand = new DriveForward(.5, .2);
		//autonomousCommand = new DriveBackward(.5, .2);
		//autonomousCommand = new GrabBins();
		autonomousCommand = new GrabBinsStrafe();
		//autonomousCommand = new GrabBinPlatform();
		autoChooser = new SendableChooser();
        
        autoChooser.addObject("Drive Backward", new DriveBackward(.4, 2));
        autoChooser.addDefault("Three Tote Autonomous", new ThreeToteAuto());
        
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
		
		SmartDashboard.putData("Drive Backward", new DriveBackward(0.3, 3));
		SmartDashboard.putData("PIDDriveTurn", new TurnLeftGyro(.2, 90));
		SmartDashboard.putData("Reset Gyro", new ResetGyro());
		
		resetEnc = new ResetEncoder();
		openBrake = new DisengageBrake();
		resetGyro = new ResetGyro();
		
		// initialize commands and the OI (created by Netbeans)
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
    }	
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	//Scheduler.getInstance().add(resetGyro);
    	
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	System.out.println("teleopInit()\n");
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        Scheduler.getInstance().add(resetEnc);
        Scheduler.getInstance().add(openBrake);
        Scheduler.getInstance().add(resetGyro);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	// Keep the line below, it's required to start the Java Scheduler
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
