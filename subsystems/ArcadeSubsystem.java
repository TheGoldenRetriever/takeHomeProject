// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
public class ArcadeSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  public static final CANSparkMax frontLeft = new CANSparkMax(0, MotorType.kBrushless);
  public static final CANSparkMax frontRight = new CANSparkMax(1, MotorType.kBrushless);
  public static final CANSparkMax backLeft = new CANSparkMax(2, MotorType.kBrushless);
  public static final CANSparkMax backRight = new CANSparkMax(3, MotorType.kBrushless);
  public Joystick joy1 = new Joystick(0);
  MotorControllerGroup rightMotors = new MotorControllerGroup(frontRight, backRight);
  MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeft, backLeft);

  public ArcadeSubsystem() {
        frontLeft.setInverted(false);
        backLeft.setInverted(false);
        frontRight.setInverted(true);
        backRight.setInverted(true);
  }
  private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  
  @Override
  public void periodic() {
    
  }
  public void setSpeed(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
