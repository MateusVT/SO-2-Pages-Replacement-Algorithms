import java.util.Arrays

class SC(val referenceQueue: Array<Int>, val frameSize: Int) {

//    var ref = -1
//    var missPage = 0
//    val pageTable: MutableList<Int> = mutableListOf()


    init {

        var pointer: Int
        var i: Int
        val l: Int
        var x: Int
        var pf: Int

        //initially we consider frame 0 is to be replaced
        pointer = 0

        //number of page faults
        pf = 0

        //Create a array to hold page numbers
        val arr = IntArray(frameSize)

        //No pages initially in frame,
        //which is indicated by -1
        Arrays.fill(arr, -1)

        //Create second chance array.
        //Can also be a byte array for optimizing memory
        val second_chance = BooleanArray(frameSize)

        //Split the string into tokens,
        //that is page numbers, based on space
        //referenceQueue

        //get the length of array

        i = 0
        while (i < referenceQueue.size) {

            x = referenceQueue[i]

            //Finds if there exists a need to replace
            //any page at all
            if (!findAndUpdate(x, arr, second_chance, frameSize)) {
                //Selects and updates a victim page
                pointer = replaceAndUpdate(
                    x, arr,
                    second_chance, frameSize, pointer
                )

                //Update page faults
                pf++
            }
            i++
        }



        println()
//        println("Total de falta de páginas : " + missPage)
        println("Total de falta de páginas : " + pf)
    }

    //If page found, updates the second chance bit to true
    fun findAndUpdate(
        x: Int, arr: IntArray,
        second_chance: BooleanArray, frames: Int
    ): Boolean {
        var i: Int

        i = 0
        while (i < frames) {

            if (arr[i] == x) {
                //Mark that the page deserves a second chance
                second_chance[i] = true

                //Return 'true', that is there was a hit
                //and so there's no need to replace any page
                return true
            }
            i++
        }

        //Return 'false' so that a page for replacement is selected
        //as he reuested page doesn't exist in memory
        return false

    }


    //Updates the page in memory and returns the pointer
    fun replaceAndUpdate(
        x: Int, arr: IntArray,
        second_chance: BooleanArray, frames: Int, pointer: Int
    ): Int {
        var pointer = pointer
        while (true) {

            //We found the page to replace
            if (!second_chance[pointer]) {
                //Replace with new page
                arr[pointer] = x

                //Return updated pointer
                return (pointer + 1) % frames
            }

            //Mark it 'false' as it got one chance
            // and will be replaced next time unless accessed again
            second_chance[pointer] = false

            //Pointer is updated in round robin manner
            pointer = (pointer + 1) % frames
        }
    }


}