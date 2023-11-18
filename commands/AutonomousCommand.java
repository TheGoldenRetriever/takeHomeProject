package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArcadeSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class AutonomousCommand extends CommandBase {
    private final ArcadeSubsystem arcadeSubsystem;
    private final GyroSubsystem gyroSubsystem;
    private double startTime;
    private double origAngle;

    public AutonomousCommand(ArcadeSubsystem arcadeSub, GyroSubsystem gyroSub) {
        arcadeSubsystem = arcadeSub;
        gyroSubsystem = gyroSub;
        addRequirements(arcadeSub, gyroSub);
    }

    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        double elapsedTime = Timer.getFPGATimestamp() - startTime;

        if (elapsedTime < Constants.autonomousStraightLine) {
            arcadeSubsystem.setSpeed(Constants.defaultSpeed, 0);
            origAngle = gyroSubsystem.getAngle();
        } else {
            arcadeSubsystem.setSpeed(0, Constants.arcadeRotationSpeed);
        }
    }

    @Override
    public void end(boolean interrupted) {
        arcadeSubsystem.setSpeed(0, 0);
    }

    @Override
    public boolean isFinished() {
        return gyroSubsystem.getAngle() >= (origAngle + Constants.angleToTurnFor);
    }
}
