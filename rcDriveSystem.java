package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/*

COMMENT BELOW HERE

*/

/*
    VERSION 1.0.0
*/

@TeleOp(name="rcDriveSystem", group="Linear Opmode")
//@Disabled

public class rcDriveSystem extends LinearOpMode{

    private ElapsedTime runTime = new ElapsedTime();


    /*
    HARDWARE MAP
    */

    private DcMotor linear;
    private DcMotor left;
    private DcMotor right;

    public double encodeLeft = 0;
    public double encodeRight = 0;

    public double turn = 0;

    public double powerLeft = 0;
    public double powerRight = 0;
    public double powerDrive = 0;

    public double LX1 = 0; //Left Joystick X
    public double LY1 = 0; //Left Joystick Y
    public double RX1 = 0; //Right Joystick X
    public double RY1 = 0; //Right Joystick Y

    /*

    CONTROLLER 2

    public double LX2 = 0; //Left Joystick X
    public double LY2 = 0; //Left Joystick Y
    public double RX2 = 0; //Right Joystick X
    public double RY2 = 0; //Right Joystick Y

    */

    public void runOpMode() {

        linear = hardwareMap.get(DcMotor.class, "linear");
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");

        /*
        INIT TELEMETRY
        */

        telemetry.addData("Status", "INIT");
        waitForStart();
        runTime.reset();

        while (opModeIsActive()) {

            /*
            CONTROLLER DATA INPUTS; CONTROLLER 1
            */

            LX1 = gamepad1.left_stick_x;
            LY1 = gamepad1.left_stick_y;
            RX1 = gamepad1.right_stick_x;
            RY1 = gamepad1.right_stick_y;

            /*
            CONTROLLER DATA INPUTS; CONTROLLER 2
            */

            //LX2 = gamepad2.left_stick_x;
            //LY2 = gamepad2.left_stick_y;
            //RX2 = gamepad2.right_stick_x;
            //RY2 = gamepad2.right_stick_y;

            /*
            DRIVE SYSTEM
            */

            //CONTAINS TURNING MECHANISM AND BACK WHEEL DRIVE
            //CONTROLS DRIVING AND MOVEMENT "REUSE IN AUTONOMOUS"

            /*
            TURNING MECHANISM
            */



            /*
            BACK WHEEL DRIVE
            */

            powerDrive = -this.gamepad1.left_stick_y;
            linear.setPower(powerDrive);

            turn = this.gamepad1.left_stick_x;
            left.setPower(turn * 0.1);
            right.setPower(turn * 0.1);

            /*
            ARM SYSTEM
            */

            /*
            AUTOMATIC TURNING WRIST
            */

            /*
            LINEAR MOTION
            */

            /*
            ADD TELEMETRY DATA BELOW HERE
            */

            telemetry.addData("runTime : ", runTime);
            telemetry.addData("encodeLeft : ", encodeLeft);
            telemetry.addData("encodeRight : ", encodeRight);
            telemetry.addData("backWheelPower", powerDrive);

            /*
            TELEMETRY UPDATE
            */

            telemetry.update();

            /*
            STOP
            */

            if (isStopRequested()){

                /*
                STOP ALL ACTIONS
                */

                linear.setPower(0);

                /*
                RESET WHEELS TO CENTER
                */

            }
        }
    }
}