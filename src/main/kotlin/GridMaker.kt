import java.awt.Rectangle
// TODO - increments of 8
// TODO - variable sizes
// TODO - store image width
fun calculateGrid(sprites: List<Sprite>): Rectangle {
    val width = sprites.maxByOrNull { it.rectangle.width }?.rectangle?.width ?: 0
    val height = sprites.maxByOrNull { it.rectangle.height }?.rectangle?.height ?: 0
    return Rectangle(0,0, width, height)
}