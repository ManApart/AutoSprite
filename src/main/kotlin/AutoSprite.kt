import java.io.File
import java.lang.IllegalArgumentException

fun main() {
    File("./input").listFiles()!!.forEach {
        println("Converting ${it.name}")
        convertImage(it.path)
    }
//    File("./input").listFiles()!!.filter { it.path.contains("Flying") }.forEach {
//        convertImage(it.path)
//    }
}

fun convertImage(path: String, minPixels: Int = 100, minAlpha: Int = 20, createBoundingBoxes: Boolean = false) {
    val imageTools = ImageTools()
    val fileName = path.substring(1 + path.lastIndexOf("\\"), path.length)
    val image = imageTools.loadImage(path)
    val backgroundColor = findBackgroundColor(image)
    val sprites = findSprites(image, backgroundColor, minPixels, minAlpha)

    if (sprites.isEmpty()){
        throw IllegalArgumentException("No sprites found for $path.")
    }

    if (createBoundingBoxes) {
        imageTools.writeBoundingBoxes("./converted/bounding-$fileName", sprites, image.width, image.height)
    }

    val grid = calculateGrid(sprites)

    val converted = createSpriteSheet(grid, sprites)
    imageTools.writeImage("./converted/$fileName", converted)
}

fun findBackgroundColor(image: SpriteSheet): Int {
    val pixelsByColor = image.pixels.values.groupBy { it.color }
    return pixelsByColor.entries.maxByOrNull { it.value.size }?.key?.rgb ?: 0
}





