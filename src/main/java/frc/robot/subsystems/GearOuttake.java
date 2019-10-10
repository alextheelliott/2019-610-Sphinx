/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.constants.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class GearOuttake extends Subsystem {
  
  private static GearOuttake instance;
  private DoubleSolenoid outtake;
  private boolean isOuttake = false;

  public static GearOuttake getInstance() {
		if (instance == null)
			instance = new GearOuttake();
		return instance;
	}

	public GearOuttake() {
		outtake = new DoubleSolenoid(ElectricalConstants.GEAR_SCORER_ONE, ElectricalConstants.GEAR_SCORER_TWO);
  }
  
  public void toggleOuttake() {
    isOuttake = !isOuttake;
    outtake.set(isOuttake ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
