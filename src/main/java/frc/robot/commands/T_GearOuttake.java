/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.GearOuttake;
import frc.robot.constants.*;
import frc.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class T_GearOuttake extends Command {

  private GearOuttake gearOuttake;
  private OI oi;
  private boolean clicking = false;

  public T_GearOuttake() {
    
    gearOuttake = GearOuttake.getInstance();
    oi = OI.getInstance();

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    if(oi.getDriver().getRawButton(LogitechF310Constants.BTN_B) && clicking == false) {
      gearOuttake.toggleOuttake();
      clicking = true;
    } 
    if(!oi.getDriver().getRawButton(LogitechF310Constants.BTN_B)) {
      clicking = false;
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
