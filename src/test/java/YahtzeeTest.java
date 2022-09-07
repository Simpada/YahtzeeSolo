import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YahtzeeTest {

    @Test
    public void testChance() {

        var player = new Player(new Die[]{
          Die.ONE,
          Die.TWO,
          Die.THREE,
          Die.FOUR,
          Die.FIVE
        });


        assertEquals(15, player.getScore(Category.CHANCE));
    }

    @Test
    void testOnes() {

        var player = new Player(new Die[]{
                Die.ONE,
                Die.TWO,
                Die.ONE,
                Die.ONE,
                Die.FIVE
        });

        assertEquals(3, player.getScore(Category.ONES));
    }
    @Test
    void testNoOnes() {

        var player = new Player(new Die[]{
                Die.THREE,
                Die.TWO,
                Die.SIX,
                Die.FIVE,
                Die.FIVE
        });

        assertEquals(0, player.getScore(Category.ONES));
    }
    @Test
    void testTwos() {

        var player = new Player(new Die[]{
                Die.ONE,
                Die.TWO,
                Die.TWO,
                Die.ONE,
                Die.FIVE
        });

        assertEquals(4, player.getScore(Category.TWOS));

    }

    @Test
    void testOtherChance() {

        var player = new Player(new Die[]{
                Die.ONE,
                Die.TWO,
                Die.SIX,
                Die.SIX,
                Die.FIVE
        });

        assertEquals(20, player.getScore(Category.CHANCE));

    }

    @Test
    void testPair() {
        var player = new Player(new Die[]{
                Die.ONE,
                Die.TWO,
                Die.SIX,
                Die.SIX,
                Die.FIVE
        });

        assertEquals(12, player.getScore(Category.ONEPAIR));
    }

    @Test
    void testTwoPairs() {

        var player = new Player(new Die[]{
                Die.ONE,
                Die.TWO,
                Die.SIX,
                Die.SIX,
                Die.TWO
        });

        assertEquals(16, player.getScore(Category.TWOPAIRS));

        player = new Player(new Die[]{
                Die.FOUR,
                Die.ONE,
                Die.FOUR,
                Die.FIVE,
                Die.ONE
        });

        assertEquals(10, player.getScore(Category.TWOPAIRS));
    }

    @Test
    public void testThreeOfKind () {

        var player = new Player(new Die[]{
                Die.FOUR,
                Die.ONE,
                Die.FOUR,
                Die.FOUR,
                Die.ONE
        });

        assertEquals(12, player.getScore(Category.THREEKIND));

        player = new Player(new Die[]{
                Die.ONE,
                Die.ONE,
                Die.FOUR,
                Die.FOUR,
                Die.ONE
        });

        assertEquals(3, player.getScore(Category.THREEKIND));

    }

    @Test
    public void testFourOfKind() {

        var player = new Player(new Die[]{
                Die.FOUR,
                Die.ONE,
                Die.FOUR,
                Die.FOUR,
                Die.FOUR
        });

        assertEquals(16, player.getScore(Category.FOURKIND));

        player = new Player(new Die[]{
                    Die.TWO,
                    Die.TWO,
                    Die.TWO,
                    Die.TWO,
                    Die.FOUR
        });

        assertEquals(8, player.getScore(Category.FOURKIND));

        player = new Player(new Die[]{
                    Die.TWO,
                    Die.TWO,
                    Die.ONE,
                    Die.TWO,
                    Die.FOUR
        });

        assertEquals(0, player.getScore(Category.FOURKIND));
    }

    @Test
    public void testYahtzee() {

        var player = new Player(new Die[]{
                Die.SIX,
                Die.SIX,
                Die.SIX,
                Die.SIX,
                Die.SIX
        });

        assertEquals(50, player.getScore(Category.YAHTZEE));
    }

    @Test
    public void testFullHouse() {
        var player = new Player(new Die[]{
                Die.FOUR,
                Die.ONE,
                Die.FOUR,
                Die.FOUR,
                Die.ONE
        });

        assertEquals(14, player.getScore(Category.FULLHOUSE));

        player = new Player(new Die[]{
                Die.FOUR,
                Die.FOUR,
                Die.FOUR,
                Die.FOUR,
                Die.FOUR
        });

        assertEquals(0, player.getScore(Category.FULLHOUSE));

        player = new Player(new Die[]{
                Die.FOUR,
                Die.FOUR,
                Die.ONE,
                Die.TWO,
                Die.FOUR
        });

        assertEquals(0, player.getScore(Category.FULLHOUSE));

    }

    @Test
    public void testSmallStraight() {

        var player = new Player(new Die[]{
                Die.TWO,
                Die.ONE,
                Die.THREE,
                Die.FIVE,
                Die.FOUR
        });

        assertEquals(15, player.getScore(Category.SMALLSTRAIGHT));

        player = new Player(new Die[]{
                Die.FOUR,
                Die.ONE,
                Die.FOUR,
                Die.FOUR,
                Die.ONE
        });

        assertEquals(0, player.getScore(Category.SMALLSTRAIGHT));

        player = new Player(new Die[]{
                Die.TWO,
                Die.ONE,
                Die.THREE,
                Die.FOUR,
                Die.SIX
        });

        assertEquals(0, player.getScore(Category.SMALLSTRAIGHT));


    }

    @Test
    public void testLargeStraight() {

        var player = new Player(new Die[]{
                Die.TWO,
                Die.SIX,
                Die.THREE,
                Die.FIVE,
                Die.FOUR
        });

        assertEquals(20, player.getScore(Category.LARGESTRAIGHT));

        player = new Player(new Die[]{
                Die.FOUR,
                Die.ONE,
                Die.FOUR,
                Die.FOUR,
                Die.ONE
        });

        assertEquals(0, player.getScore(Category.LARGESTRAIGHT));

        player = new Player(new Die[]{
                Die.TWO,
                Die.ONE,
                Die.THREE,
                Die.FOUR,
                Die.SIX
        });

        assertEquals(0, player.getScore(Category.LARGESTRAIGHT));


    }

}
