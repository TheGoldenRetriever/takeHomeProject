// LowerElevatorCommand.java
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class LowerElevatorCommand extends CommandBase {
    private final ElevatorSubsystem m_subsystem;

    public LowerElevatorCommand(ElevatorSubsystem subsystem) {
        m_subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        m_subsystem.lowerElevator();
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.stopElevator();
    }
}
