package frc.robot;

public final class Constants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
    public static final double DRIVE_POWER = 0.7;
    public static final double DRIVE_EXPONENT = 1.2;
    public static final int[] LEFT_DRIVE_MOTOR_PORTS = {6,9,10}; //idk what they actually are yet
    // public static final int[] LEFT_DRIVE_MOTOR_PORTS = {3, 4, 5};
    public static final int[] RIGHT_DRIVE_MOTOR_PORTS = {3,4,5}; //need to find out what they are for torpedo
    // public static final int[] RIGHT_DRIVE_MOTOR_PORTS = {6, 9, 10};
    public static final int CURRENT_LIMIT_AMPS = 45;

    public static final int[] PNUEMATIC_PORTS = {2, 3};

    public static final int PIVOT_PORT = 11;
    public static final int LOWER_LIMIT_PORT = 1;

    public static final double PIVOT_KP = 0.6;
    public static final double PIVOT_KI = 0;
    public static final double PIVOT_KD = 4;
    public static final double PIVOT_KF = 0;


    public static final double PIVOT_TELEOP_SPEED = 0.25;
    public static final double PIVOT_AUTO_SPEED = 0.2;
    public static final double PIVOT_ZERO_SPEED = 0.1;

    public static final double PIVOT_ZERO_THRESHOLD = 5;
    public static final double PIVOT_MAX_REVOLUTION = 83;
    public static final double PIVOT_THRESHOLD = 6;

    public static final double TRIGGER_THRESHOLD = 0.3;
}