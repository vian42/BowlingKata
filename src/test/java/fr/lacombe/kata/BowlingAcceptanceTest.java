package fr.lacombe.kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static fr.lacombe.kata.Frame.FrameBuilder.aFrame;

public class BowlingAcceptanceTest {
    @Test
    public void name() {
        Roll rollZero = new Roll(0);
        List<Frame> frames = Arrays.asList(
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build(),
                aFrame(rollZero).withSecondRoll(rollZero).build()
        );
        Game game = new Game(frames);
        Assertions.assertThat(game.score()).isEqualTo(Score.valueOf(0));
    }
}
