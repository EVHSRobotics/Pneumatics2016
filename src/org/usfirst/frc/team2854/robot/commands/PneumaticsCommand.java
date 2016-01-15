package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.Button;
import org.usfirst.frc.team2854.robot.Robot;
import org.usfirst.frc.team2854.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PneumaticsCommand extends Command {

	private Pneumatics p;
	private Button out; 
	private Button in;
	
    public PneumaticsCommand(Pneumatics pneumatics, Button aOut, Button aIn) {
    	p = pneumatics;
    	out = aOut;
    	in = aIn;
    	requires(p);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	p.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(out.get()){
    		p.enableForwardChannel();
    	} else if(in.get()) {
    		p.enableBackwardChannel();
    	} else {
    		p.disableSolenoidOutput();
    	}

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	p.disableSolenoidOutput();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	p.disableSolenoidOutput();
    }
}
