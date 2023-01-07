import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    //println("First LIne Start")
    println("Global Scope  LIne Start Thread Name: ${Thread.currentThread().name} ")

    /*    println("First LIne Start")
       val job = launch {
            println("Global Scope  LIne Start Thread Name: ${Thread.currentThread().name} ")
            for (i in 0..100){
                println(i)
            }
        }
        delay(1000)
        job.cancelAndJoin()
        print("End Line ")*/

    /*    val time = measureTimeMillis {

            val firstName: Deferred<String> = async {
                getFirstName()
            }

            val lastName: Deferred<String> = async {
                getLastName()

            }
            println("Fist Name" + firstName + " " + lastName);
        }

        println("total time: $time ms ")*/

/*    val time = measureTimeMillis {
        val job = GlobalScope.launch {
            val firstName = getFirstName()
            yield()
        }
        val job1 = GlobalScope.launch {
            val lastName = getLastName()
            yield()
        }

        runBlocking {
            delay(1000)
            job.cancelAndJoin()
            job1.cancelAndJoin()

        }
    }

    println("total time $time ms ")*/


    GlobalScope.launch(Dispatchers.Main) {
        println("Global Scope  Thread Name: ${Thread.currentThread().name} ")
    }

    Thread.sleep(100)


    println("End Program ")


}

suspend fun getLastName(): String {
    delay(1000L)
    return "Ruhul"
}

suspend fun getFirstName(): String {
    delay(1000L)
    return "Md "
}
