package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThreeToteAutoBin extends CommandGroup {
    
    public  ThreeToteAutoBin() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	/* Toro Starts Closed
    	 * PID Elevator Starts At Height 1
    	 * Resets Gyro
    	 * Drives Forward Spinning Bin Out Of Way
    	 * Toro Sucks In 1st Tote
    	 * Set PID Height To 2/Picks Up Tote
    	 * Set Gyro Value To 10
    	 * 
    	 */
    	//Spin Bin Out Of Way
    	addSequential(new ResetGyro());
    	addSequential(new PIDGyroDriveSpin(.5, -10, 1));
    	//Pick Up First Tote
    	addSequential(new ToroSuckAndOpen());
    	addSequential(new SetElevatorPID(3));
    	addSequential(new CloseToro()); //Close Toro
    	//Spin Bin Out Of Way
    	addSequential(new PIDGyroDriveSpin(.5, -10, 2));
    	//Pick Up Second Tote
    	addSequential(new SetElevatorPID(2));
    	addSequential(new PIDGyroDriveToro(.5, -10, 1));
    	addParallel(new CloseToro()); //Open Toro
    	addSequential(new SetElevatorPID(5));
    	//Spin Bin Out Of Way
    	addParallel(new CloseToro()); //Close Toro
    	addSequential(new PIDGyroDriveSpin(.5, -10, 2));
    	//Pick Up Third Tote
    	addParallel(new SetElevatorPID(3));
    	addSequential(new PIDGyroDriveToro(.5, -10, 1));
    	addSequential(new SetElevatorPID(4));
    	//Strafe Into Auto Zone
    	addSequential(new DriveStrafe(1, 4));
    	//Set Down 3 Tote Stack & Drive Backwards
    	addSequential(new SetPIDTote(1));
    	addSequential(new DriveBackward(1, .5));
    }
}
