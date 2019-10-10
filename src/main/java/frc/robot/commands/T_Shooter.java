/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.constants.LogitechF310Constants;
import frc.robot.constants.PIDConstants;
import frc.robot.constants.Xbox360Constants;
import frc.robot.PID;
import frc.robot.OI;
import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class T_Shooter extends Command {

  private Shooter shooter;
	private OI oi;

	private PID shooterPID;
  private double shooterPower;
  private double shooterRPM;
  private double setShooterRPM;
  
  private double turretSpeed;

  public T_Shooter() {

    shooterPID = new PID(PIDConstants.SHOOTER_P, PIDConstants.SHOOTER_I, PIDConstants.SHOOTER_D, 0, 1);
    shooter = Shooter.getInstance();

		oi = OI.getInstance();
		shooterPower = 0;
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    shooterPID.updatePID(PIDConstants.SHOOTER_P, PIDConstants.SHOOTER_I, PIDConstants.SHOOTER_D);
    shooterPower = 0;
    shooterRPM = 0;
    setShooterRPM = 0;
    turretSpeed = 0;
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    PIDConstants.Update();
    shooterPID.updatePID(PIDConstants.SHOOTER_P, PIDConstants.SHOOTER_I, PIDConstants.SHOOTER_D);

    shooterRPM = shooter.getRPM();
    System.out.print(shooterRPM);

    //Set shooter rpm
    // setShooterRPM = oi.getDriver().getRawButton(LogitechF310Constants.BTN_X) ? 1200 : 0;

    //Set turret speed
    turretSpeed = oi.getDriver().getRawButton(LogitechF310Constants.BTN_LB) ? -0.4 : 
      oi.getDriver().getRawButton(LogitechF310Constants.BTN_RB) ? 0.4 : 0;

    //Changes the power of the shooter.
    // shooterPower = shooterPID.getValue(shooterRPM, setShooterRPM, shooter.getFeedForward(setShooterRPM));
    // shooter.setPower(shooterPower);

    shooter.setPower(oi.getDriver().getRawButton(LogitechF310Constants.BTN_X) ? 0.65 : 0);
    
    //Changes the rotation of the turret.
    shooter.setTurret(turretSpeed);

    SmartDashboard.putNumber("Shooter RPM", shooter.getRPM());
    SmartDashboard.putNumber("Shooter Pow", oi.getDriver().getRawButton(LogitechF310Constants.BTN_X) ? 0.65 : 0);
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

}
