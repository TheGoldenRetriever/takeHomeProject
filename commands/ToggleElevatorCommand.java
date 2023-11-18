// ToggleElevatorCommand.java
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ElevatorSubsystem;

public class ToggleElevatorCommand extends InstantCommand {
    private final ElevatorSubsystem m_subsystem;

    public ToggleElevatorCommand(ElevatorSubsystem subsystem) {
        m_subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        if (m_subsystem.isRaised()) {
            new LowerElevatorCommand(m_subsystem).schedule();
        } else {
            new RaiseElevatorCommand(m_subsystem).schedule();
        }
    }
}
