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
    // 高階関数に渡す特殊な記法
    map(listOf(1, 2, 3)) {
        it + 1
    }

    val obj = MyClass()
    println(obj)
    obj.name = "S"
    println(obj.greet())

    var u = User(1,"hoge")
    u.name = "feef"
    u.out()

    val bar = Bar()
    bar.foo()
    bar.bar()

    val jG = JapaneseGreeter("私")
    jG.greet()

    val gCs = GreetableCharSeq("me")
    gCs.hello()

    fun String.hello(){
        println("Hello $this")
    }
    "World".hello()
}

// クラス
class MyClass {
    var name = ""

    fun greet(){
        println("Hello MyClass! ${name}")
    }
}

class User(val id:Long,var name:String) {
    fun out(){
        println("${id} - ${name}")
    }
}
// 継承
open class Foo{
    fun foo() {
        println("Foo")
    }
}

class Bar:Foo() {
    fun bar(){
        println("Bar")
    }
}

// 抽象クラス
abstract class Greeter{
    abstract val name:String
    abstract fun greet()
}
class JapaneseGreeter(override val name:String):Greeter(){
    override fun greet() {
        println("こんにちは ${name}です")
    }
}

// interface
interface Ge {
    val name:String
    fun greet()
}

// 移譲
class GreetableCharSeq(val cs:CharSequence):CharSequence by cs {
    fun hello(){
        println("Hello $cs")
    }
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
tailrec fun sumRec(ints: List<Int>): Int = if (ints.isEmpty()) 0 else ints.first() + sumRec(ints.drop(1))


