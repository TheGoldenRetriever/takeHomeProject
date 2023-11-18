// ElevatorSubsystem.java
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.*;

public class ElevatorSubsystem extends SubsystemBase {
    private final CANSparkMax elevatorMotor1 = new CANSparkMax(4, MotorType.kBrushless);
    private final CANSparkMax elevatorMotor2 = new CANSparkMax(5, MotorType.kBrushless);
    private final GyroSubsystem gyroSubsystem = new GyroSubsystem();

    private boolean isRaised = false;

    public ElevatorSubsystem() {
        elevatorMotor1.setInverted(false);
        elevatorMotor2.setInverted(true);
    }

    public void raiseElevator() {
        elevatorMotor1.set(Constants.defaultSpeed);
        elevatorMotor2.set(Constants.defaultSpeed);
        isRaised = true;
    }

    public void lowerElevator() {
        elevatorMotor1.set(-Constants.defaultSpeed);
        elevatorMotor2.set(-Constants.defaultSpeed);
        isRaised = false;
    }

    public void stopElevator() {
        elevatorMotor1.set(0.0);
        elevatorMotor2.set(0.0);
    }

    public boolean isRaised() {
        return isRaised;
    }
    @Override
    public void periodic() {
      if (gyroSubsystem.getAngle()==Constants.certainAngle) {
        SmartDashboard.putString("Certain Angle: ", "True");
        new RaiseElevatorCommand().schedule();
      } else SmartDashboard.putString("Certain Angle: ", "False");
    }
}
