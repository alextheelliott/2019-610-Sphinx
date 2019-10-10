/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class G_Teleop extends CommandGroup {
  public G_Teleop() {
	  	addParallel(new T_Drivetrain());
		addParallel(new T_Feeder());
		addParallel(new T_Shooter());
		addParallel(new T_GearOuttake());
	}
}
