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
            result += findSame(dieFrequency, 2);
            return result;
        }

        if (category == Category.TWOPAIRS) {
            result += findSame(dieFrequency, 2);
            result += findSame(dieFrequency, 2);
            return result;
        }

        if (category == Category.THREEKIND){
            result += findSame(dieFrequency, 3);
            return result;
        }

        if (category == Category.FOURKIND){
            result += findSame(dieFrequency, 4);
            return result;
        }

        if (category == Category.YAHTZEE){
            result += findSame(dieFrequency, 5);
            if (result != 0) {
                return 50;
            } else {
                return 0;
            }
        }

        if (category == Category.FULLHOUSE) {

            int valueOne = findSame(dieFrequency, 3);

            int valueTwo = findSame(dieFrequency, 2);

            if ( valueOne/3 == valueTwo/2 || valueOne == 0 || valueTwo == 0) {
                return 0;
            }
            return valueOne + valueTwo;
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

    private int findSame(Map<Die, Integer> dieFrequency, int numOfKind) {
        int result = 0;
        Die largestDie = null;
        for (Die dieValue : dieFrequency.keySet()) {
            if (dieFrequency.get(dieValue) >= numOfKind && result < dieValue.getValue()) {
                result = dieValue.getValue();
                largestDie = dieValue;
            }
        }
        if (largestDie != null) {
            dieFrequency.put(largestDie, dieFrequency.get(largestDie) - numOfKind);
        }
        return result * numOfKind;
    }
}
