/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.constants.*;
import frc.robot.OI;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BallIntake extends Subsystem {
  
	private static BallIntake instance;
	private OI oi;
	private Victor intakeMotor;
	// private DoubleSolenoid deploy;
	
	public static BallIntake getInstance(){
		if(instance == null){
			instance = new BallIntake();
		}
		return instance;
	}
	
	private BallIntake(){
		oi = OI.getInstance();
		intakeMotor = new Victor(ElectricalConstants.INTAKE);
		// deploy = new DoubleSolenoid(ElectricalConstants.INTAKE_BALL_ONE, ElectricalConstants.INTAKE_BALL_TWO);
	}
	
	public void setIntake(double speed){
		intakeMotor.set(speed);
	}
	
	public void run(){
		if(oi.getDriver().getRawButton(Xbox360Constants.BTN_A)){
			
		}
	}
	
	public void deploy(boolean deployed){
    // deploy.set(deployed ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
	}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
