package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabBins extends CommandGroup {
    
    public  GrabBins() {
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
    	
    	addParallel(new ArmsDown());
    	addSequential(new DriveBackward(0.4, 0.35));
    	addSequential(new Wait(1));
    	addSequential(new DriveForward(0.75, 1.2));
    	addSequential(new ArmsUp());
    	
    }
}
