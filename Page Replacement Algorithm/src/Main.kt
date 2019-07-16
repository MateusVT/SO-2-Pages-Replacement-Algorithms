import java.util.*

fun main() {


    println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓")
    println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓")
    println("▓▓   Welcome to the REPLACER             ▓▓")
    println("▓▓  ----------------------------         ▓▓")
    println("▓▓   CHOOSE YOUR ALGORITHM               ▓▓")
    println("▓▓  ----------------------------         ▓▓")
    println("▓▓  1 - FIFO                             ▓▓")
    println("▓▓  2 - LRU                              ▓▓")
    println("▓▓  3 - SecondChance                     ▓▓")
    println("▓▓  4 - Exit                             ▓▓")
    println("▓▓                                       ▓▓")
    println("▓▓                                       ▓▓")
    println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓")
    println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓")


    var alg = readLine()!!

    println("Defina a quantidade de frames : ")
    var frameSize = readLine()!!
    //Frame é a quantidade máxima de páginas referenciaveis ao mesmo tempo.

    var file = File()
    var entryFileQueue = file.processFilter("src\\input.txt")
    val adressQueue = entryFileQueue.map { it.toInt() }.toTypedArray()

    println("Arquivo de entrada : 'input.txt'")
    println(Arrays.toString(adressQueue)) //Printa processo
    println("--------------------------------")
    when (alg.toInt()) {
        1 -> FIFO(adressQueue, frameSize.toInt())
        2 -> LRU(adressQueue, frameSize.toInt())
//        3 ->
    }


}

