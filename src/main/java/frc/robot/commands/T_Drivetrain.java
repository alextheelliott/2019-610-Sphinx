/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import frc.robot.constants.*;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class T_Drivetrain extends Command {

  private DriveTrain driveTrain;
	private boolean atMax = false;
	private double leftEncValue, rightEncValue;
	private OI oi;
	private boolean dtShift;

  public T_Drivetrain() {
    
    driveTrain = DriveTrain.getInstance();
    oi = OI.getInstance();
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    driveTrain.resetSensors();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double x = oi.getDriver().getRawAxis(1);
		// System.out.println(x);
		if (x < 0.1 && x > -0.1)
			x = 0;
		double y = oi.getDriver().getRawAxis(4);
		// System.out.println(y);
		if (y < 0.1 && y > -0.1)
			y = 0;
		y = y * y * y;
		x = x * x * x;
		
		double leftSpeed, rightSpeed;
		leftSpeed = y - x;
    rightSpeed = y + x;
    
    driveTrain.setSpeed(leftSpeed, rightSpeed, 1);

    SmartDashboard.putNumber("DT RS", rightSpeed);
    SmartDashboard.putNumber("DT LS", leftSpeed);
    SmartDashboard.putNumber("DT RPM", driveTrain.getRightRPM());

    if(leftSpeed != 0 && rightSpeed != 0){
		  if(driveTrain.getRightRPM() > -110) {
        dtShift = false;
      } else if(driveTrain.getRightRPM() < -110) {
        dtShift = true;
      }
    }

    if(dtShift) {
      driveTrain.shiftUp();
    } else {
      driveTrain.shiftDown();
    }
    
    SmartDashboard.putNumber("GetRightRPM", driveTrain.getRightRPM());
    SmartDashboard.putBoolean("Drive Train Shift", dtShift);

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
