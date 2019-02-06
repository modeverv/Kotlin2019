package asia.daemon.lovesaemi


fun main(args: Array<String>) {
    println("Hello World package")
    val name: String = "Taro"
    println("Hlello, ${name}!!!")
    val name2 = "Hoge"
    println("Hello ${name2}")

    if (args.isNotEmpty()) {
        println("Hello ${args[0]}")
    } else {
        println("Hello ななし")
    }
    hello("あああああ")
    println("2 + 5 = ${plus(2, 5)}")
    h2("テスト")
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("${sumRec(list)}")
    // 関数オブジェクト
    val hoge = ::succ
    val r = hoge.invoke(5)
    println(r)
    println(hoge(5))

    // 関数オブジェクトのリテラル表現
    // 1
    fun succ(n: Int): Int = n + 1
    map(list, ::succ)
    // 2
    map(list, fun(n: Int): Int { return n + 1 })
    // 3
    map(list, { n: Int -> n + 1 })


}

/**
 * オレオレmap
 */
fun map(ints: List<Int>, f: (Int) -> Int): List<Int> {
    val newList = java.util.ArrayList<Int>()
    for (e in ints) {
        newList.add(f(e))
    }
    return newList
}

fun succ(n: Int) = n + 1

/**
 * 関数
 */
fun hello(name: String) {
    println("Hello, ${name}")
}

/**
 * 値を返す関数の書き方
 */
fun plus(a: Int, b: Int): Int {
    return a + b
}

/**
 * 関数の書き方2
 */
fun p2(a: Int, b: Int) = a * b

/**
 * if elseは式
 */
fun max(a: Int, b: Int) = if (a < b) b else a

/**
 * デフォルト引数
 * ちなみに引数指定で呼び出し可能
 * 例) h2(exclametion = true,name="Hello")
 */
fun h2(name: String, exclamation: Boolean = false) {
    val suffix = if (exclamation) "!" else ""
    println("Hello, ${name} ${suffix}")
}

/**
 * 再帰
 */
fun sumRec(ints: List<Int>): Int = if (ints.isEmpty()) 0 else ints.first() + sumRec(ints.drop(1))


