class FIFO(val referenceQueue: Array<Int>, val frameSize: Int) {

    var ref = -1
    var missPage = 0
    val pageTable: MutableList<Int> = mutableListOf()


    init {

        for (i in 0 until frameSize) {//Inicializa os frames sem nenhuma página referenciada
            pageTable.add(-1)
        }

//        println("---> 0 1 2 3 4");
//        println("")
        for (i in 0 until referenceQueue.size) {// referenceQueue.size == tamanho do processo
            var flag = 0
            for (j in 0 until frameSize) {
                if (pageTable[j] == referenceQueue[i]) {//Se a página já estiver referenciada go to 'Hit'
                    flag = 1
                    break
                }

            }
            if (flag == 0) {//Não encontrou a página na memória
                ref = (ref + 1) % frameSize
                pageTable[ref] = referenceQueue[i] //Insere a página
                missPage += 1//Incrementa o pageFault
                print(referenceQueue[i].toString() + " -> ")
                for (j in 0 until frameSize) {//Imprime o pageFault
                    if (pageTable[j] != -1) {
                        print(pageTable[j].toString() + " ")
                    } else {
                        print("X ")
                    }
                }
                print(" | Miss (Page Not Found)")
                println()
            } else {
                println(referenceQueue[i].toString() + " ->            | Hit (Page Found) ")// Imprime pageFound

            }
        }
        println()
        println("Total de falta de páginas : " + missPage)
    }

}