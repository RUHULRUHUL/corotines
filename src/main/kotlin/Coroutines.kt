import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main() = runBlocking {
    // runBlocking Thread
    /*coroutinesCreate()*/
    //nonBlocking Main Thread
    /*coroutinesBackgroundThread()*/

    //Concurrent Program run :Parallel
    ConcurrentCoroutines()
}

fun ConcurrentCoroutines() {

    val time = measureTimeMillis {
        val myName: Deferred<String> = GlobalScope.async {
            val FirstName = method1()
            val SecondName = method2()
            FirstName + SecondName
        }

    }

    println("total Execution  time : " + time)


}

fun method2(): String {
    runBlocking {
        delay(1000L)
    }
    return "Ruhul"
}

fun method1(): String {

    runBlocking {
        delayTimeInSec(1000L)

    }
    return "Md"
}

fun coroutinesBackgroundThread() {

    println("Start First Line ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("Start Thread 1 ${Thread.currentThread().name}")

    }

    GlobalScope.launch {
        println("Start Thread 2 ${Thread.currentThread().name}")
    }


    runBlocking {
        delayTimeInSec(10000)

    }

    println("End Line ${Thread.currentThread().name}")

}

suspend fun delayTimeInSec(time: Long) {
    delay(time)
}

fun coroutinesCreate() = runBlocking {

    println("Start First Line =  Thread Name: ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("global scope launch  Line =  Thread Name: ${Thread.currentThread().name}")
    }


    GlobalScope.async {
        println("global scope async  Line =  Thread Name: ${Thread.currentThread().name}")
    }

    println("Start Second Line =  Thread Name: ${Thread.currentThread().name}")


    launch {
        println("Start  Run blocking First Line =  Thread Name: ${Thread.currentThread().name}")
        delay(500)
    }

    async {
        println("Start Second Run blocking First Line =  Thread Name: ${Thread.currentThread().name}")
    }

    println("End Line =  Thread Name: ${Thread.currentThread().name}")


}
