import java.util.HashMap;
import java.util.Map;

public class Player {

    private final Die[] dice;

    public Player(Die[] dice) {
        this.dice = dice;
    }

    public int getScore(Category category) {

        Map<Die, Integer> dieFrequency = new HashMap<>();

        for (Die die : Die.values()) {
            if (!dieFrequency.containsKey(die)) {
                dieFrequency.put(die, 0);
            }
        }
        for (Die die : dice) {
            dieFrequency.put(die, dieFrequency.get(die) + 1);
        }

        int result = 0;

        if (category == Category.ONEPAIR) {
            for (Die dieValue : dieFrequency.keySet()) {
                if (dieFrequency.get(dieValue) >= 2 && result < dieValue.getValue() * 2) {
                    result = dieValue.getValue() * 2;
                }
            }
            return result;
        }

        switch (category) {
            case ONES -> {return dieFrequency.get(Die.ONE);}
            case TWOS -> {return dieFrequency.get(Die.TWO) * 2;}
            case THREES -> {return dieFrequency.get(Die.THREE) * 3;}
            case FOURS -> {return dieFrequency.get(Die.FOUR) * 4;}
            case FIVES -> {return dieFrequency.get(Die.FIVE) * 5;}
            case SIXES -> {return dieFrequency.get(Die.SIX) * 6;}
        }

        if (category == Category.CHANCE) {
            for(Die die : dice) {
                result += die.getValue();
            }
            return result;
        }

        return -1;
    }
}
