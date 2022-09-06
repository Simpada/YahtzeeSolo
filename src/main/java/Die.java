public enum Die {

    ONE, TWO, THREE, FOUR, FIVE, SIX;

    public int getValue() {
        return switch (this){
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
        };
    }

}
