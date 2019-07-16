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
    println("▓▓  3 - SC                               ▓▓")
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
//    var entryFileQueue = file.processFilter("src\\files\\sc.txt") //0 4 1 4 2 4 3 4 2 4 0 4 1 4 2 4 3 4 -> font : https://www.geeksforgeeks.org/operating-system-second-chance-or-clock-page-replacement-policy/
//    var entryFileQueue = file.processFilter("src\\files\\sc2.txt")//2 5 10 1 2 2 6 9 1 2 10 2 6 1 2 1 6 9 5 1 -> font : https://www.geeksforgeeks.org/operating-system-second-chance-or-clock-page-replacement-policy/
//    var entryFileQueue = file.processFilter("src\\files\\sc3.txt")//1 4 2 3 5 3 5 2 4 1 4 2 4 3 1 2 4 2 3 4 2 3 4 2 -> font : https://github.com/SydneyRaeBlackburn/PageReplacement
//    var entryFileQueue = file.processFilter("src\\files\\sc4.txt")//2 3 2 1 5 2 4 5 3 2 5 2 -> font : https://github.com/SydneyRaeBlackburn/PageReplacement
    var entryFileQueue = file.processFilter("src\\files\\input.txt")//1 1 3 5 2 2 6 8 7 6 2 1 5 5 5 1 4 9 7 7 6 -> Exc da Prova
    val adressQueue = entryFileQueue.map { it.toInt() }.toTypedArray()

    println("Arquivo de entrada : 'input.txt'")
    println(Arrays.toString(adressQueue)) //Printa processo
    println("--------------------------------")
    when (alg.toInt()) {
        1 -> FIFO(adressQueue, frameSize.toInt())
        2 -> LRU(adressQueue, frameSize.toInt())
        3 -> SC(adressQueue, frameSize.toInt())
    }


}

