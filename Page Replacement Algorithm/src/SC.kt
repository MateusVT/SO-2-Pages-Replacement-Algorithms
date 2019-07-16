class SC(private val referenceQueue: Array<Int>, private val frameSize: Int) {

    private var ref = -1
    private var secondChance = 0
    private var pageFault = 0
    private val pageTable = mutableListOf<Int>()
    private var second = mutableListOf<Int>()
    private var pointer = 0


    init {

        for (i in 0 until frameSize) {//Inicializa os frames sem nenhuma página referenciada
            pageTable.add(-1)
            second.add(0)
        }


        for (i in 0 until referenceQueue.size) {

            var adress = referenceQueue[i]

            if (!findAndUpdate(adress, pageTable, second, frameSize)) {

                pointer = replaceAndUpdate(adress, pageTable, second, frameSize, pointer)

                print(referenceQueue[i].toString() + " -> ")
                for (l in 0 until frameSize) {
                    if (pageTable[l] != -1) {
                        print(pageTable[l].toString() + " ")

                    } else {
                        print("X ")
                    }
                }
                print(" | Miss (Page Not Found)") //Imprime o pageFault
                println()
                pageFault += 1

            } else {
                println(referenceQueue[i].toString() + " ->            | Hit (Page Found) ")// Imprime pageFound
            }


        }
        println("Total de falta de páginas : $pageFault")
    }

    fun findAndUpdate(x: Int, pageTable: MutableList<Int>, second: MutableList<Int>, frameSize: Int): Boolean {
        for (i in 0 until frameSize) {

            if (pageTable[i] == x) {
                second[i] = 1
                return true
            }
        }

        return false

    }

    fun replaceAndUpdate(
        adress: Int, pageTable: MutableList<Int>,
        second: MutableList<Int>, frameSize: Int, pointer: Int
    ): Int {
        var pointerHere = pointer
        while (true) {

            if (second[pointerHere] != 1) {

                pageTable[pointerHere] = adress

                return ((pointerHere + 1) % frameSize)
            }

            second[pointerHere] = 0

            pointerHere = ((pointerHere + 1) % frameSize)
        }
    }

}
