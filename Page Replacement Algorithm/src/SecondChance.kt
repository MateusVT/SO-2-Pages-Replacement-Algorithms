class SecondChance(private val referenceQueue: Array<Int>, private val frameSize: Int) {

   private var ref = -1
   private var secondChance = 0
   private var missPage = 0
   private val pageTable= mutableListOf<Int>()
   private var second = mutableListOf<Int>()


    init {
        for (i in 0 until frameSize) {//Inicializa os frames sem nenhuma página referenciada
            pageTable.add(-1)
            second.add(0)
        }
        println("---> 0 1 2 3 4")
        println("")


        for (i in 0 until referenceQueue.size) {
            var flag = 0
            for (j in 0 until frameSize) {
                if (pageTable[j] == referenceQueue[i]) {//Se a página já estiver referenciada go to 'Hit'
                    flag = 1
                    secondChance = 1
                    second[j] = 1
                    break
                }
            }
            if (flag == 0) {//Não encontrou a página na memória

                var pos = (ref + 1) % frameSize

                for(k in 0 until frameSize){

                    if( second[k] == 1 ){
                        continue
                    }else{
                        pageTable[k]= referenceQueue[i]
                    }
                }

                // pageTable[pos] = referenceQueue[i] //Insere a página
                missPage += 1//Incrementa o pageFault

                print(referenceQueue[i].toString() + " -> ")
                for (j in 0 until frameSize) {//Imprime o pageFault
                    if (pageTable[j] != -1) {
                        print(pageTable[j].toString() + " ")
                    } else {
                        print("- ")
                    }
                }
                println()
            } else {
                println(referenceQueue[i].toString() + " -> Hit (Page Found) ")// Imprime pageFound
            }
        }
        println("Total de falta de páginas : $missPage")


    }

}