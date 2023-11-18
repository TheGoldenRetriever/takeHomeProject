package frc.robot;

import frc.robot.subsystems.ArcadeSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
//import frc.robot.commands.LowerElevatorCommand;
//import frc.robot.commands.RaiseElevatorCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {
    private final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();
    private final ArcadeSubsystem m_arcadeSubsystem = new ArcadeSubsystem();
    private final Joystick m_driverJoystick = new Joystick(0);
    private final GyroSubsystem m_gyroSubsystem = new GyroSubsystem();

    public RobotContainer() {
        m_arcadeSubsystem.setDefaultCommand( new TeleopCommand(() -> -m_driverJoystick.getY(), () -> m_driverJoystick.getX(), m_arcadeSubsystem));
        configureBindings();
    }

    private void configureBindings() {
        Trigger joystickButtonOne = new JoystickButton(m_driverJoystick, 1);
        joystickButtonOne.onTrue((new ToggleElevatorCommand(m_elevatorSubsystem).withTimeout(Constants.elevatorTime))); //assuming it takes 5 seconds to raise
    }
    

    public Command getAutonomousCommand() {
        return new AutonomousCommand(m_arcadeSubsystem, m_gyroSubsystem); 
    }
    
}
