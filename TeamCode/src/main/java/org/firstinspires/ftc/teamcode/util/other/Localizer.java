package org.firstinspires.ftc.teamcode.util.other;

import com.acmerobotics.roadrunner.Time;
import com.acmerobotics.roadrunner.Twist2dIncrDual;

public interface Localizer {
    Twist2dIncrDual<Time> updateAndGetIncr();
}
