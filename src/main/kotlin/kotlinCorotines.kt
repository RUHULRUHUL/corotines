import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {

    //backgroundThread()
    //coroutinesThread()
    coroutinesCancel()

}

fun coroutinesCancel() = runBlocking() {
    println("This is First Line: Thread Name: ${Thread.currentThread().name}")

    val job: Job = launch {
        println("This is Coroutines Scope : Thread Name: ${Thread.currentThread().name}")

        try {
            for (i in 0..200) {
                println(i)
                yield()
            }
        } catch (ex: CancellationException) {
            println("get the Cancelable Exception")
        } finally {
            println("Finally execute again ")
        }

    }

    delay(15)
    job.cancelAndJoin()

    println("This is End Line: Thread Name: ${Thread.currentThread().name}")


}

fun coroutinesThread() = runBlocking {
//Create a Coroutines Main Thread //We Can block Main Thread

    println("This is First Line: Thread Name: ${Thread.currentThread().name}")

    GlobalScope.launch {
        //Create Child Coroutines Background thread
        println("This is Middle Line: Thread Name: ${Thread.currentThread().name}")
        println("This is Middle Line: Thread Name: ${Thread.currentThread().name}")
    }

    println("This is Run Blocking Line: Thread Name: ${Thread.currentThread().name}")

    //Main Coroutines Thread Block
    delayTime(1000)
    println("This is Last Line: Thread Name: ${Thread.currentThread().name}")

}


suspend fun delayTime(time: Long) {
    delay(time)
}


fun backgroundThread() {

    println("This is First Line: Thread Name: ${Thread.currentThread().name}")

    thread {
        println("This is Middle Line: Thread Name: ${Thread.currentThread().name}")
        Thread.sleep(500)
    }


    println("This is Last Line: Thread Name: ${Thread.currentThread().name}")

}
