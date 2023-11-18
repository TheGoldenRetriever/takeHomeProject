package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeSubsystem;

import java.util.function.DoubleSupplier;

public class TeleopCommand extends CommandBase {
    private final ArcadeSubsystem m_subsystem;
    private final DoubleSupplier m_forwardSupplier;
    private final DoubleSupplier m_rotationSupplier;

    public TeleopCommand(DoubleSupplier forwardSupplier, DoubleSupplier rotationSupplier, ArcadeSubsystem subsystem) {
        m_subsystem = subsystem;
        m_forwardSupplier = forwardSupplier;
        m_rotationSupplier = rotationSupplier;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {}
    
    public void execute() {
        double forward = m_forwardSupplier.getAsDouble();
        double rotation = m_rotationSupplier.getAsDouble();
        m_subsystem.setSpeed(forward, rotation);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
