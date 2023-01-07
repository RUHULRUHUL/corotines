import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
fun main() {

    println("Start First Line ${Thread.currentThread().name}")
    CoroutineScope(Dispatchers.IO).launch {
        println("CoroutineScope  Line ${Thread.currentThread().name}")
    }
    println("End line Line ${Thread.currentThread().name}")


}