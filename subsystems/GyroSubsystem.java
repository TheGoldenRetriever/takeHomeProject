package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

public class GyroSubsystem extends SubsystemBase {
  public WPI_PigeonIMU gyro;
  public TalonSRX talon;

  public GyroSubsystem() {
    talon = new TalonSRX(6);
    gyro = new WPI_PigeonIMU(talon);
  }

  public double getAngle(){
    return gyro.getAngle();
  }

  @Override
  public void periodic(){
   SmartDashboard.putNumber("Current Angle: ", gyro.getAngle());
  }
}

