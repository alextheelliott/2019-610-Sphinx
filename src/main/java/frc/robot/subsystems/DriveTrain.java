/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.OI;
import frc.robot.constants.ElectricalConstants;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  
  private static DriveTrain instance;

	private Victor leftFront, leftBack, rightFront, rightBack;

	private DoubleSolenoid solLeft;
  private Compressor compressor;

	private OI oi;

	private Encoder leftEnc, rightEnc;
  private DigitalInput gearOptLeft, gearOptRight;


  public static DriveTrain getInstance() {

		if (instance == null) {
			instance = new DriveTrain();
		}
    return instance;
    
	}

	private DriveTrain() {

		solLeft = new DoubleSolenoid(ElectricalConstants.SHIFTER_LEFT_ONE, ElectricalConstants.SHIFTER_LEFT_TWO);
    compressor = new Compressor();
    
		leftFront = new Victor(ElectricalConstants.DRIVE_LEFT_FRONT);
		leftBack = new Victor(ElectricalConstants.DRIVE_LEFT_BACK);
		rightFront = new Victor(ElectricalConstants.DRIVE_RIGHT_FRONT);
    rightBack = new Victor(ElectricalConstants.DRIVE_RIGHT_BACK);
    
    oi = OI.getInstance();
    
		leftEnc = new Encoder(ElectricalConstants.DRIVE_ENC_LEFT_A, ElectricalConstants.DRIVE_ENC_LEFT_B);
		rightEnc = new Encoder(ElectricalConstants.DRIVE_ENC_RIGHT_A, ElectricalConstants.DRIVE_ENC_RIGHT_B);
		leftEnc.setDistancePerPulse(4 * Math.PI / 128.0);
    rightEnc.setDistancePerPulse(4 * Math.PI / 128.0);

    gearOptLeft = new DigitalInput(ElectricalConstants.GEAR_OPTICAL_LEFT);
    gearOptRight = new DigitalInput(ElectricalConstants.GEAR_OPTICAL_RIGHT);
    
	}

  public void shiftUp() {

    solLeft.set(DoubleSolenoid.Value.kForward);
    
	}

	public void shiftDown() {

    solLeft.set(DoubleSolenoid.Value.kReverse);
    
	}

  public double getRightRPM() {

    return rightEnc.getRate();
    
	}

	public double getLeftRPM() {

    return rightEnc.getRate();
    
	}

  public void resetSensors() {

		leftEnc.reset();
    rightEnc.reset();
    
  }
  
  public void setRight(double power) {

		rightFront.set(power);
    rightBack.set(power);
    
	}

	public void setLeft(double power) {

		leftFront.set(power);
    leftBack.set(power);
    
	}

  public void setSpeed(double leftSpeed, double rightSpeed, double speedFactor) {

    setRight(rightSpeed * speedFactor);
		setLeft(leftSpeed * speedFactor);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
