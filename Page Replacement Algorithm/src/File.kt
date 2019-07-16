import java.io.BufferedReader
import java.io.FileReader

class File {

    private var reader: FileReader? = null
    private var buff: BufferedReader? = null


    private fun readFile(path: String): String {

        var line = ""
        return try {
            reader = FileReader(path)
            buff = BufferedReader(reader!!)

            while (buff!!.ready()) line += buff!!.readLine() + "\n"
            buff!!.close()
            line

        } catch (e: Exception) {
            e.printStackTrace()
            println("Arquivo não encontrado!")
            line // return
        }
    }

    fun processFilter(path: String): Array<String> {  // splita as linhas e retorna um array

        val list: String = readFile(path)
        return list.split("\n".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
    }
}