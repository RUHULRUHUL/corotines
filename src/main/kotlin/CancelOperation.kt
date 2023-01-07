import kotlinx.coroutines.*

fun main() {

    /*    runBlocking {
            val job: Job = launch {
                for (i in 0..100) {
                    println(i)
                    //delay(10)
                    yield()
                }
            }

            delay(10)
            job.cancelAndJoin()

            println("End Program ")

        }*/

   /* runBlocking {
        val job: Job = GlobalScope.launch {
            for (i in 0..200) {
                println(i)
                //delay(5)
                //yield()
            }
        }

        threadWaitTime(2)
        job.cancelAndJoin()

        println("Program End")
    }*/

}

suspend fun threadWaitTime(time: Long) {
    delay(time)
}