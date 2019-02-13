package fr.lacombe.kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static fr.lacombe.kata.Frame.FrameBuilder.aFrame;

public class BowlingAcceptanceTest {
    @Test
    public void given_a_game_with_only_zero_score_should_be_zero() {
        Roll rollZero = new Roll(0);
        Game game = new Game();
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        Assertions.assertThat(game.score()).isEqualTo(Score.valueOf(0));
    }

    @Test
    public void name() {
        Roll rollOne = new Roll(1);
        Game game = new Game();
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build());
        Assertions.assertThat(game.score()).isEqualTo(Score.valueOf(20));
    }
}
