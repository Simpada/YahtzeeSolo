import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    private final Die[] dice;

    public Player(Die[] dice) {
        this.dice = dice;
    }

    public int getScore(Category category) {

        Map<Die, Integer> dieFrequency = new HashMap<>();

        for (Die die : dice) {
            if (!dieFrequency.containsKey(die)) {
                dieFrequency.put(die, 0);
            }
            dieFrequency.put(die, dieFrequency.get(die) + die.getValue());
        }

        switch (category) {
            case ONES -> {return dieFrequency.get(Die.ONE);}
            case TWOS -> {return dieFrequency.get(Die.TWO);}
            case THREES -> {return dieFrequency.get(Die.THREE);}
            case FOURS -> {return dieFrequency.get(Die.FOUR);}
            case FIVES -> {return dieFrequency.get(Die.FIVE);}
            case SIXES -> {return dieFrequency.get(Die.SIX);}
        }


        return 15;
    }
}
