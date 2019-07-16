import java.util.*
import kotlin.system.exitProcess

fun main() {


    println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓")
    println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓")
    println("▓▓   Welcome to the REPLACER             ▓▓")
    println("▓▓  ----------------------------         ▓▓")
    println("▓▓   CHOOSE YOUR ALGORITHM               ▓▓")
    println("▓▓  ----------------------------         ▓▓")
    println("▓▓  1 - FIFO                             ▓▓")
    println("▓▓  2 - LeastRU                          ▓▓")
    println("▓▓  3 - SecondChance                     ▓▓")
    println("▓▓  4 - Exit                             ▓▓")
    println("▓▓                                       ▓▓")
    println("▓▓                                       ▓▓")
    println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓")
    println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓")


    var input = readLine()!!

    println("Defina a quantidade de frames : ")
    var frameSize = readLine()!!
    //Frame é a quantidade máxima de páginas referenciaveis ao mesmo tempo.

    var file = File()
    var entryFileQueue = file.processFilter("src\\references.txt")
    val referenceQueue = entryFileQueue.map { it.toInt() }.toTypedArray()
//    println(Arrays.toString(referenceQueue))
    FIFO(referenceQueue, frameSize.toInt())

}

