/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.constants.*;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HopperFeeder extends Subsystem {
  
  	private Victor feeder, agitator;
	private boolean isRunning;
	static HopperFeeder instance;
	
	public static HopperFeeder getInstance(){
		if(instance == null)
			instance = new HopperFeeder();
		return instance;
	}
	
	public HopperFeeder(){
		feeder = new Victor(ElectricalConstants.FEEDER);
		agitator = new Victor(ElectricalConstants.VIBRATOR);
		isRunning = false;
	}
	
	public void setSpeed(double speed){
		feeder.set(speed);
		// if(speed==0){
		// 	isRunning = false;
		// 	agitator.set(0);
		// } else {
		// 	isRunning = true;
		// 	agitator.set(-0.4);
		// }
	}
	
	public void setAgitator(boolean run){
    	agitator.set(run ? -0.4 : 0);
	}
	
	public boolean isRunning(){
		return isRunning;
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
