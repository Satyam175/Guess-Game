package academy.learnprogramming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Getter
public class NumberGeneratorImpl implements NumberGenerator{
//    fields

    private final int maxNumber;
    private final int minNumber;

//    constructor injection

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber,@MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //    public methods
    @Override
    public int next() {
        return ThreadLocalRandom.current().nextInt(minNumber,maxNumber);
    }

}
