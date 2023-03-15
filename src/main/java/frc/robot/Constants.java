// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final int PDH_ID = 55;
  public static final PowerDistribution PDH = new PowerDistribution(Constants.PDH_ID, ModuleType.kRev);

  public static class IOConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OP_CONTROLLER_PORT = 1;
  }

  public static final class SwerveConstants{
    //Drivetrain motor/encoder IDs
    public static final int LEFT_FRONT_DRIVE_ID = 11;
    public static final int RIGHT_FRONT_DRIVE_ID = 1;
    public static final int LEFT_BACK_DRIVE_ID = 20;
    public static final int RIGHT_BACK_DRIVE_ID = 31;
    
    public static final int LEFT_FRONT_TURN_ID = 10;
    public static final int RIGHT_FRONT_TURN_ID = 2;
    public static final int LEFT_BACK_TURN_ID = 21;
    public static final int RIGHT_BACK_TURN_ID = 30;
    
    public static final int LEFT_FRONT_CANCODER_ID_threncID = 0;
    public static final int RIGHT_FRONT_CANCODER_ID_threncID = 1;
    public static final int LEFT_BACK_CANCODER_ID_threncID = 2;
    public static final int RIGHT_BACK_CANCODER_ID_threncID = 3;

    //public static final SerialPort PIGEON_ID = SerialPort();

    //Drivetrain characteristics
    public static final double LEFT_FRONT_OFFSET = 0; //2.9
    public static final double RIGHT_FRONT_OFFSET = 0; //118.8
    public static final double LEFT_BACK_OFFSET = 0; //163.9
    public static final double RIGHT_BACK_OFFSET = 0; //97.1

    public static final double WHEEL_DIAMETER = Units.inchesToMeters(4);
    public static final double DRIVE_MOTOR_GEAR_RATIO = 6.75;
    public static final double TURN_MOTOR_GEAR_RATIO = 150.0/7;
    public static final double DRIVE_MOTOR_PCONVERSION = WHEEL_DIAMETER * Math.PI / DRIVE_MOTOR_GEAR_RATIO;
    public static final double TURN_MOTOR_PCONVERSION = 2 * Math.PI / TURN_MOTOR_GEAR_RATIO;
    public static final double DRIVE_MOTOR_VCONVERSION = DRIVE_MOTOR_PCONVERSION / 60.0;
    public static final double TURN_MOTOR_VCONVERSION = TURN_MOTOR_PCONVERSION / 60.0;
    public static final double KP_TURNING = 0.5;

    public static final double DRIVETRAIN_MAX_SPEED = 4.0;
    public static final double DRIVETRAIN_MAX_ANGULAR_SPEED = 3.5 * Math.PI;

    //Teleop constraints
    public static final double TELE_DRIVE_MAX_SPEED = DRIVETRAIN_MAX_SPEED / 1;
    public static final double TELE_DRIVE_MAX_ANGULAR_SPEED = DRIVETRAIN_MAX_ANGULAR_SPEED / 1.75;
    public static final double TELE_DRIVE_MAX_ACCELERATION = 3;
    public static final double TELE_DRIVE_MAX_ANGULAR_ACCELERATION = 3;

    //Auton constraints
    public static final double AUTO_DRIVE_MAX_SPEED = DRIVETRAIN_MAX_SPEED / 1.5;
    public static final double AUTO_DRIVE_MAX_ANGULAR_SPEED = DRIVETRAIN_MAX_ANGULAR_SPEED / 2.0;
    public static final double AUTO_DRIVE_MAX_ACCELERATION = 3;
    public static final double AUTO_DRIVE_MAX_ANGULAR_ACCELERATION = Math.PI;

    public static final double AUTO_kP_FRONT = 0.4;
    public static final double AUTO_kP_SIDE = 0.4;
    public static final double AUTO_kP_TURN = 2.4;

    //Swerve Kinematics
    public static final double TRACK_WIDTH = Units.inchesToMeters(16.75);
    public static final double WHEEL_BASE = Units.inchesToMeters(24.75);
    public static final SwerveDriveKinematics DRIVE_KINEMATICS = new SwerveDriveKinematics(
        new Translation2d(WHEEL_BASE / 2, TRACK_WIDTH / 2),
        new Translation2d(WHEEL_BASE / 2, -TRACK_WIDTH / 2),
        new Translation2d(-WHEEL_BASE / 2, TRACK_WIDTH / 2),
        new Translation2d(-WHEEL_BASE / 2, -TRACK_WIDTH / 2)
    );

    public static final double kS_PERCENT = 0.035;
    public static final double kP_PERCENT = 0.009;
  }

  // public static final class IntakeConstants{
  //   public static final int INTAKE_DRIVER_ID = 50;
  //   public static final int INTAKE_PIVOT_ID = 51;

  //   public static final double PIVOT_kP = 0.15;
  //   public static final double PIVOT_kI = 0;
  //   public static final double PIVOT_kD = 0;
  //   public static final double PIVOT_MIN_OUTPUT = -0.25;
  //   public static final double PIVOT_MAX_OUTPUT = 0.25;

  //   public static final double DEPLOYED_ROT = 10.2;
  // }

  public static final class ArmConstants{
    public static final int ARM_DRIVER_ID = 50;
    public static final int ARM_INTAKE_ID = 51;

    public static final double ARM_kP = 0.1;
    public static final double ARM_kI = 0.0;
    public static final double ARM_kD = 0.0;

    public static final double ENCODER_DEG_UP = -57;
    public static final double ENCODER_DEG_MID = -23.5;
    // public static final int ARM_PIVOT_ID = 24;
  }

  public static final class ShooterConstants{
    public static final int TOP_SHOOTER_ID = 52;
    public static final int BOT_SHOOTER_ID = 53;
    public static final int FEEDER_ID = 54;

    public static final int IR_SENSOR_ID = 0;

    public static final double TOP_SHOOTER_kS = 0.062786;
    public static final double TOP_SHOOTER_kV = 0.12905;
    public static final double TOP_SHOOTER_kA = 0.011404;

    public static final double TOP_SHOOTER_kP = 0.00035813;
    public static final double TOP_SHOOTER_kI = 0;
    public static final double TOP_SHOOTER_kD = 0.0005;

    public static final double BOT_SHOOTER_kS = 0.11635;
    public static final double BOT_SHOOTER_kV = 0.1291;
    public static final double BOT_SHOOTER_kA = 0.012424;

    public static final double BOT_SHOOTER_kP = 0.00036422;
    public static final double BOT_SHOOTER_kI = 0;
    public static final double BOT_SHOOTER_kD = 0;

    public static final double SHOOTER_MIN_OUTPUT = -1.0;
    public static final double SHOOTER_MAX_OUTPUT = 1.0;

  }

  public static final class BigStickConstants{
    public static final int BIG_STICK_ID = 40;

    public static final double PIVOT_kP = 0.1;
    public static final double PIVOT_kI = 0;
    public static final double PIVOT_kD = 0;
    public static final double PIVOT_MIN_OUTPUT = -0.5;
    public static final double PIVOT_MAX_OUTPUT = 0.5;

    public static final double DEPLOYED_ROT = 7.4;
  }
}
