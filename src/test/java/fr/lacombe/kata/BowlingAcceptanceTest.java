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
    public void given_a_game_with_only_one_should_return_twenty() {
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

    @Test
    public void given_a_game_with_spares_should_add_next_roll_score_to_total_score() {
        Roll rollZero = new Roll(0);
        Roll rollOne = new Roll(1);
        Roll rollNine = new Roll(9);
        Game game = new Game();
        game.addFrame(aFrame(rollOne).withSecondRoll(rollNine).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollNine).build());
        game.addFrame(aFrame(rollOne).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        Assertions.assertThat(game.score()).isEqualTo(Score.valueOf(22));
    }

    @Test
    public void given_a_game_with_strikes_should_add_two_next_rolls_scores_to_total_score() {
        Roll rollZero = new Roll(0);
        Roll rollOne = new Roll(1);
        Roll rollTen = new Roll(10);
        Game game = new Game();
        game.addFrame(aFrame(rollTen).build()); // 10 +1
        game.addFrame(aFrame(rollOne).withSecondRoll(rollZero).build());// 1-0
        game.addFrame(aFrame(rollTen).build()); // 10 +1+1
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build()); // 1-1
        game.addFrame(aFrame(rollTen).build()); // 10 +10+1
        game.addFrame(aFrame(rollTen).build()); // 10 +1+1
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build()); // 1-1
        game.addFrame(aFrame(rollZero).withSecondRoll(rollZero).build());
        game.addFrame(aFrame(rollTen).build()); // 10 +1+1
        game.addFrame(aFrame(rollOne).withSecondRoll(rollOne).build()); // 1-1
        Assertions.assertThat(game.score()).isEqualTo(Score.valueOf(75));
    }

    @Test
    public void given_a_game_ending_with_spare_should_have_bonus_roll() {
        Roll rollZero = new Roll(0);
        Roll rollOne = new Roll(1);
        Roll rollNine = new Roll(9);
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
        game.addFrame(aFrame(rollOne).withSecondRoll(rollNine).build());
        game.addFrame(aFrame(rollNine).build());
        Assertions.assertThat(game.score()).isEqualTo(Score.valueOf(28));
    }
}
