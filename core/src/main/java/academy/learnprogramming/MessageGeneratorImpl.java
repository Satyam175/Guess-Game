package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;
    private final String MainMessage = "Hello  Spring";
    private final String ResultMessage = "Hello Result";
    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void setLog() {
        log.info("Game is :{}", game);
    }

    @PreDestroy
    public void destroy() {
        log.info("Inside message Destroyer");
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                " .Can you guess it ?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You Lost! The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid Number Range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your First Guess";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
