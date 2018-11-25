package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Mecanum", group = "Teleop")
//@Disabled
public class Holonomic_Drive extends LinearOpMode {

    DcMotor mfr;
    DcMotor mfl;
    DcMotor mbl;
    DcMotor mbr;

    int buttons = 0;
    int override;
    double speed = 0;
    int mode = 1;

    @Override
    public void runOpMode(){

        mfr = hardwareMap.dcMotor.get("mfr");
        mfl = hardwareMap.dcMotor.get("mfl");
        mbl = hardwareMap.dcMotor.get("mbl");
        mbr = hardwareMap.dcMotor.get("mbr");

        waitForStart();

        while (opModeIsActive()){

            override = 0;

            if (gamepad1.dpad_up)
                mode = 1;
            if (gamepad1.dpad_right)
                mode = 2;
            if (gamepad1.dpad_down)
                mode = 3;
            if (gamepad1.dpad_left)
                mode = 4;

            if (mode == 1)
                speed = 1;
            if (mode == 2)
                speed = 0.25;
            if (mode == 3)
                speed = 0.1;
            if (mode == 4)
                speed = 0.09;

            if (gamepad1.y && override == 0){
                buttons = 1;
                mfr.setPower(-1 * speed);
                mfl.setPower(1 * speed);
                mbl.setPower(1 * speed);
                mbr.setPower(-1 * speed);
                override = 1;
            }
            if (gamepad1.a && override == 0){
                buttons = 2;
                mfr.setPower(1 * speed);
                mfl.setPower(-1 * speed);
                mbl.setPower(-1 * speed);
                mbr.setPower(1 * speed);
                override = 1;
            }
            if (gamepad1.x && override == 0){
                buttons = 3;
                mfr.setPower(-1 * speed);
                mfl.setPower(-1 * speed);
                mbl.setPower(1 * speed);
                mbr.setPower(1 * speed);
                override = 1;
            }
            if (gamepad1.b && override == 0){
                buttons = 4;
                mfr.setPower(1 * speed);
                mfl.setPower(1 * speed);
                mbl.setPower(-1 * speed);
                mbr.setPower(-1 * speed);
                override = 1;
            }
            if (gamepad1.left_trigger >= 0.5 && override == 0){
                buttons = 5;
                mfr.setPower(1 * speed);
                mfl.setPower(1 * speed);
                mbl.setPower(1 * speed);
                mbr.setPower(1 * speed);
                override = 1;
            }
            if (gamepad1.right_trigger >= 0.5 && override == 0){
                buttons = 6;
                mfr.setPower(-1 * speed);
                mfl.setPower(-1 * speed);
                mbl.setPower(-1 * speed);
                mbr.setPower(-1 * speed);
                override = 1;
            }
            if (override == 0){
                buttons = 0;
                mfr.setPower(0);
                mfl.setPower(0);
                mbl.setPower(0);
                mbr.setPower(0);
            }

            telemetry.addData("Buttons:", buttons);
            telemetry.addData("Override:", override);
            telemetry.addData("Mode:", mode);
            telemetry.update();

        }

    }

}
