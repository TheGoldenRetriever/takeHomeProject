package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import frc.robot.subsystems.ArcadeSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    //private ArcadeSubsystem arcadeSubsystem = new ArcadeSubsystem();

    @Override
    public void robotInit() {
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
    //    double speed = -arcadeSubsystem.joy1.getY();
    //    double rotation = arcadeSubsystem.joy1.getX();

    //    arcadeSubsystem.setSpeed(speed, rotation);
    }

    @Override
    public void testInit() {
  
    }

    @Override
    public void testPeriodic() {

    }

    @Override
    public void simulationInit() {

    }

    @Override
    public void simulationPeriodic() {
    
    }
}
