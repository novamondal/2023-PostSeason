package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public final class DriveTrain {
    private DifferentialDrive drivetrain;
    public DriveTrain() {
        final CANSparkMax Left1 = new CANSparkMax(Constants.LEFT_DRIVE_MOTOR_PORTS[0], MotorType.kBrushless);
        final CANSparkMax Left2 = new CANSparkMax(Constants.LEFT_DRIVE_MOTOR_PORTS[1], MotorType.kBrushless);
        final CANSparkMax Left3 = new CANSparkMax(Constants.LEFT_DRIVE_MOTOR_PORTS[2], MotorType.kBrushless);
        final CANSparkMax Right1 = new CANSparkMax(Constants.RIGHT_DRIVE_MOTOR_PORTS[0], MotorType.kBrushless);
        final CANSparkMax Right2 = new CANSparkMax(Constants.RIGHT_DRIVE_MOTOR_PORTS[1], MotorType.kBrushless);
        final CANSparkMax Right3 = new CANSparkMax(Constants.RIGHT_DRIVE_MOTOR_PORTS[2], MotorType.kBrushless);
       
        Left1.setIdleMode(IdleMode.kBrake);
        Left2.setIdleMode(IdleMode.kBrake);
        Left3.setIdleMode(IdleMode.kBrake);
        Right1.setIdleMode(IdleMode.kBrake);
        Right2.setIdleMode(IdleMode.kBrake);
        Right3.setIdleMode(IdleMode.kBrake);

        Left1.setSmartCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Left1.setSecondaryCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Left2.setSmartCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Left2.setSecondaryCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Left3.setSmartCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Left3.setSecondaryCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Right1.setSmartCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Right1.setSecondaryCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Right2.setSmartCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Right2.setSecondaryCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Right3.setSmartCurrentLimit(Constants.CURRENT_LIMIT_AMPS);
        Right3.setSecondaryCurrentLimit(Constants.CURRENT_LIMIT_AMPS);


        final MotorControllerGroup leftMotors = new MotorControllerGroup(Left1, Left2, Left3);
        final MotorControllerGroup rightMotors = new MotorControllerGroup(Right1, Right2, Right3);
        drivetrain = new DifferentialDrive(leftMotors, rightMotors);
    }

    public void run(){
        final double rSpeed = Math.signum(Robot.driverController.getRightY())*Constants.DRIVE_POWER*Math.pow(Math.abs(Robot.driverController.getRightY()), Constants.DRIVE_EXPONENT);
       //(sign of input) * (drive power) * (absolute value of input)^(drive exponent)
       final double lSpeed = Math.signum(Robot.driverController.getLeftY())*Constants.DRIVE_POWER*Math.pow(Math.abs(Robot.driverController.getLeftY()), Constants.DRIVE_EXPONENT);
       //(sign of input) * (drive power) * (absolute value of input)^(drive exponent)
        drivetrain.tankDrive(lSpeed, rSpeed);
    }
}