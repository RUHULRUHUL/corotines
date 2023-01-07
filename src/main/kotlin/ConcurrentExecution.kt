import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {

        val time = measureTimeMillis {

            val response1: Deferred<List<String>> = async {
                firstName()
            }
            val response2: Deferred<List<String>> = async {
                secondName()
            }

            val list1 = response1.await()
            val list2 = response2.await()

            for (i in 0..list1.size) {
                println("response 1  $i")
            }

            for (i in 0..list2.size) {
                println("response 2  $i")
            }

        }
        println("Total Time ${time} ms ")


    }


}


suspend fun secondName(): List<String> {
    delay(2000L)

    val list = mutableListOf<String>()

    for (i in 0..100) {
        list.add(i.toString())
    }

    return list
}

suspend fun firstName(): List<String> {
    delay(2000L)
    val list = mutableListOf<String>()
    for (i in 0..100) {
        list.add(i.toString())
    }

    return list
}
