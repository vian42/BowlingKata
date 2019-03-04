package fr.lacombe.kata;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FrameTest {


    @Test
    @Parameters({"1,9,true","1,1,false","10,0,false","0,10,true"})
    public void isSpare(int firstRollPin, int secondRollPin, boolean expected) {
        Roll firstRoll = new Roll(firstRollPin);
        Roll secondRoll = new Roll(secondRollPin);
        Frame frame = Frame.FrameBuilder.aFrame(firstRoll).withSecondRoll(secondRoll).build();
        Assertions.assertThat(frame.isSpare()).isEqualTo(expected);
    }
}