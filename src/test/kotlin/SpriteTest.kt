import org.testng.annotations.Test
import kotlin.test.assertEquals

class SpriteTest {

    @Test
    fun calcBounds() {
        val sprite = Sprite(
            listOf(
                Pixel(),
                Pixel(10, 5)
            )
        )

        assertEquals(0, sprite.rectangle.x)
        assertEquals(0, sprite.rectangle.y)
        assertEquals(11, sprite.rectangle.width)
        assertEquals(6, sprite.rectangle.height)
        assertEquals(10, sprite.rectangle.maxX)
        assertEquals(5, sprite.rectangle.maxY)
    }

    @Test
    fun calcBoundsWithOffset() {
        val sprite = Sprite(
            listOf(
                Pixel(-1, -2),
                Pixel(10, 5)
            )
        )

        assertEquals(-1, sprite.rectangle.x)
        assertEquals(-2, sprite.rectangle.y)
        assertEquals(12, sprite.rectangle.width)
        assertEquals(8, sprite.rectangle.height)
        assertEquals(10, sprite.rectangle.maxX)
        assertEquals(5, sprite.rectangle.maxY)
    }

    @Test
    fun move() {
        val sprite = Sprite(
            listOf(
                Pixel(0, 0),
                Pixel(10, 5)
            )
        )

        val moved = sprite.moveTo(3, 4)

        assertEquals(3, moved.rectangle.x)
        assertEquals(4, moved.rectangle.y)
        assertEquals(3, moved.pixels.first().x)
        assertEquals(4, moved.pixels.first().y)
        assertEquals(13, moved.pixels.last().x)
        assertEquals(9, moved.pixels.last().y)
    }

    @Test
    fun moveNegative() {
        val sprite = Sprite(
            listOf(
                Pixel(20, 20),
                Pixel(22, 21)
            )
        )

        val moved = sprite.moveTo(0, 0)

        assertEquals(0, moved.rectangle.x)
        assertEquals(0, moved.rectangle.y)
        assertEquals(0, moved.pixels.first().x)
        assertEquals(0, moved.pixels.first().y)
        assertEquals(2, moved.pixels.last().x)
        assertEquals(1, moved.pixels.last().y)
    }

}