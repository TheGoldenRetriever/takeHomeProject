
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class RaiseElevatorCommand extends CommandBase {
    private final ElevatorSubsystem m_subsystem;

    public RaiseElevatorCommand(ElevatorSubsystem subsystem) {
        m_subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        m_subsystem.raiseElevator();
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.stopElevator();
    }
}
