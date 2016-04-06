package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1339.robot.OI;
import org.usfirst.frc.team1339.robot.subsystems.*;


/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {
    
    Command autonomousCommand;
    SendableChooser autoChooser;

    public static OI oi;
    // Create a single static instance of all of your subsystems
    // "static"  members belong to the class instead of a specific instance, 
    // meaning that you could not need to use the " = new" syntax to use the member
    //public static Chassis chassis = new Chassis();
    public static PIDChassis PIDChassis = new PIDChassis();
    
    public static PIDElevator PIDElevator = new PIDElevator();
    
    public static ElToro ElTotoro = new ElToro();
    public static PneumaticArms Arms = new PneumaticArms();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it
        
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        // This is optional
        
        SmartDashboard.putData(PIDChassis);
        
        SmartDashboard.putData(PIDElevator);
        
        SmartDashboard.putData(Arms);
        SmartDashboard.putData(ElTotoro);
        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
        
    }
}
