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

    @Test void testOnes() {

        var player = new Player(new Die[]{
                Die.ONE,
                Die.TWO,
                Die.ONE,
                Die.ONE,
                Die.FIVE
        });

        assertEquals(3, player.getScore(Category.ONES));

    }


}
