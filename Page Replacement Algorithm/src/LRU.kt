class LRU(val referenceQueue: Array<Int>, val frameSize: Int) {

    var leastUsed = 0 //Armazena o endereço menos utilizado
    var pageFault = 0 //Contador de PageFault
    val pageTable: MutableList<Int> = mutableListOf()//Tabela de Páginas

    init {

        for (i in 0 until frameSize) {//Inicializa o frame/tabela de páginas sem nenhuma página referenciada
            pageTable.add(-1)
        }

        for (i in 0 until referenceQueue.size) {// referenceQueue.size == tamanho do processo
            var flag = 0
            for (j in 0 until frameSize) {
                if (pageTable[j] == referenceQueue[i]) {// Se o endereço i já está no frame na posição j
                    flag = 1
                    break
                }
            }
            if (flag == 0) {
                if (pageTable[leastUsed] != -1) { // Se flag = 0 && no frame[leastUsed] estiver vazio, busca a posição menos utilizada na tabela de páginas
                    var min = 999
                    for (k in 0 until frameSize) {
                        flag = 0
                        var aux = i
                        while (aux >= 0) {
                            aux -= 1
                            if (pageTable[k] == referenceQueue[aux]) { // Se o endereço j estiver no frame[k] seta flag = 1
                                flag = 1
                                break
                            }
                        }
                        if (flag == 1 && (min > aux)) {// Se flag = 1 e j < min, troca o min para min = j e leastUsed = k
                            min = aux
                            leastUsed = k
                        }
                    }

                }
                pageTable[leastUsed] = referenceQueue[i] //Armazena o endereço no frame[leastUsed]
                leastUsed = ((leastUsed + 1) % frameSize)
                pageFault += 1
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
            } else {

                println(referenceQueue[i].toString() + " ->            | Hit (Page Found) ")// Imprime pageFound

            }

        }
        println()
        println("Total de falta de páginas : " + pageFault)
    }

}