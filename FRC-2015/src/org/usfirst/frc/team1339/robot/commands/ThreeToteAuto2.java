package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThreeToteAuto2 extends CommandGroup {
    
    public  ThreeToteAuto2() {
    	/* Set Tote pid to 3
    	 * Closes toro
    	 * Drives forward
    	 * Drive forward and spin bin
    	 * drive to tote
    	 * lower elevator 1 PID
    	 * suck tote
    	 * lift to max
    	 * spin bin out of the way
    	 * drive forwards
    	 * lower elevator
    	 * Suck in tote
    	 * Drive into auto
    	 */
    	
    	/*
    	 * 
    	 * 
    	 * 
    	 */
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	//addSequential(new SetElevToOne());
    	//addSequential(new ResetGyro());
    	addSequential(new CloseToro());//Close Toro
    	addSequential(new ToroSpin(-.4, .15));
    	addSequential(new ToroSuck(.6, .4));

    	addParallel(new ToroSuck(.4, .2));
    	addSequential(new SetElevatorPID(2));
    	addSequential(new SetElevatorPID(3));
    	addSequential(new TurnRight(.4, .16));
    	// move RC
    	//addSequential(new ResetGyro());
    	addParallel(new ToroSpin(1, 2.2));    	
    	addSequential(new DriveForward(.3, 2));
    	
    	addSequential(new SetElevatorPID(2));
    	//addSequential(new Wait(.2));
    	addParallel(new DriveForward(.3, .45));
    	
    	// pick up tote #2
    	//addSequential(new ToroSuck(.4, .6));    	
    	addSequential(new ToroSuckButton(.75));
    	addParallel(new ToroSuck(.4, .2));
    	addSequential(new SetElevatorPID(5));
    	// move RC
    	//addParallel(new ToroSpin(1, 2.4));
    	addSequential(new DriveForward(.3, 1.65));
    	//addSequential(new PIDGyro(.3, 0, 2.5)); // this isn't proven to work
    	
    	// pick up tote #3
    	
    	addSequential(new SetElevatorPID(3));
    	//Timer.delay(.2);
    	addSequential(new Wait(.4));
    	addParallel(new DriveForward(.3, 0.47)); //was sequentia.'l
    	addSequential(new ToroSuckButton(.75));
    	addParallel(new ToroSuck(.75, .2));
    	addSequential(new SetElevatorPID(5));

    	addSequential(new OpenToro());
    	addSequential(new DriveStrafe(1, 1.6));
    	addSequential(new DriveStrafe(.5, .2));
    	//addSequential(new DriveStrafe(.75, .5));
    	//addSequential(new DriveStrafe(.5, .2));
    	addSequential(new Wait(.1));
    	addSequential(new SetPIDTote(1));
    	addSequential(new Wait(.6));
    	addSequential(new DriveBackward(.3, .55));
    	//addSequential(new TurnRight(.2, .08));
    	//addSequential(new ResetGyro());
    	//addSequential(new PIDGyroDriveSpin(.5, 0, 2));
    	//addSequential(new SetElevatorPID(2));
    	//addSequential(new PIDGyroDriveToro(.5, 0, .75));
    	//addSequential(new OpenToro());
    	//addSequential(new SetElevatorPID(4));
    	//addSequential(new PIDGyroDriveSpin(.5, 0, 2));
    	//addSequential(new SetElevatorPID(3));
    	//addSequential(new PIDGyroDriveToro(.5, 0, .75));
    	
    	//addSequential(new PIDGyroDriveToro(.1, 0, 1));
    	//addParallel(new ToroSuckAndOpen());
    	//addSequential(new SetElevatorPID(2));
    	//addSequential(new ResetGyro());
    	//addSequential(new SetElevatorPID(3));
    	
    	//addParallel(new DriveForward(0.3, 2));
    	//addSequential(new ToroSpin(2.6));
    	
    	/*addParallel(new SetElevatorPID(2));
    	addSequential(new PIDGyroDriveToro(.5, 0, 1));
    	
    	addParallel(new ToroSuck(1, .3));
    	addSequential(new DriveBackward(.5, .1));
    	//addParallel(new ToroSuckAndOpen());
    	//addSequential(new SetElevatorPID(6));
    	addParallel(new CloseToro()); //Open Toro
    	addSequential(new SetElevatorPID(5));
    	addSequential(new CloseToro()); // Close Toro
    	
    	addParallel(new ToroSpin(3.5));
    	addSequential(new PIDGyro(0.35, 0, 1.5));
    	addSequential(new SetElevatorPID(3));
    	addSequential(new PIDGyroDriveToro(.5, 0, 1));
    	
    	addParallel(new ToroSuckAndOpen()); //Open Toro
    	addSequential(new SetElevatorPID(4));
    	addSequential(new DriveStrafe(1, 2));
    	addSequential(new Wait(0.5)); //Skipper changed from .25, so sue me
    	addSequential(new SetPIDTote(1));
    	addSequential(new DriveBackward(1, .1));*/
    	
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
    }
}
