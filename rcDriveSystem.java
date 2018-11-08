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

 */

@TeleOp(name="rcDriveSystem", group="Linear Opmode")
//@Disabled

public class rcDriveSystem extends LinearOpMode{

    private ElapsedTime runTime = new ElapsedTime();

    /*
        HARDWARE MAP
     */

    private DcMotor left;
    private DcMotor right;

    public double speed = 0.75; // Must Be Less Than 1!!!

    public double encodeLeft = 0;
    public double encodeRight = 0;

    public double powerLeft = 0;
    public double powerRight = 0;
    public double powerDrive = 0;
    public double powerTurn = 0;

    public void runOpMode() {

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
                DRIVE SYSTEM
             */

            /*
                TURN
             */
            if (gamepad1.x == true){
                powerTurn = speed;
            }

            if (gamepad1.b == true){
                powerTurn = -speed;
            }

            if (gamepad1.b == false && gamepad1.x == false){
                powerTurn = 0;
            }

            /*
                DRIVE
             */

            powerDrive = -gamepad1.left_stick_y; // Y Value Is Negated

            /*
                DRIVE SYSTEM COMPILER "TURN AND DRIVE"
             */

            powerLeft = powerDrive + powerTurn;
            powerRight = powerDrive - powerTurn;

            left.setPower(powerLeft * speed);
            right.setPower(-powerRight * speed);

            /*
                ADD TELEMETRY DATA
             */

            telemetry.addData("Drive_Power", powerDrive);
            telemetry.addData("Drive_Turn", powerTurn);
            telemetry.addData("Left_Power", powerLeft);
            telemetry.addData("Right_Power", powerRight);

            telemetry.update();

        }

    }

}
