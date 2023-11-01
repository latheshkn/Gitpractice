fun main() {

    val sample = Sample()

    sample.lambda.invoke(7878)


}

class Sample {
    lateinit var lambda: (Int) -> Int
    var clickListener = object : MyInterface {
        override fun printSum(sum: Int) {
            print(sum)
            lambda = {
                it
            }
        }
    }


    fun addTwo(a: Int, b: Int, action: (Int) -> Unit) {
        clickListener.printSum(a + b)

        action(a + b)
    }


}

interface MyInterface {
    fun printSum(sum: Int)
}
