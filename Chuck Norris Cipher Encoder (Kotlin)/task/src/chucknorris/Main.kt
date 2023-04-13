package chucknorris

fun main() {
    fun decode() {
        println("Input encoded string:")
        //val a = Integer.parseInt(readln()
        val inn = readln().trimEnd()
        //println(inn.trim())
        val a = inn.split(" ")
        for ( i in inn){
            if (i != '0' && i != ' ') {
                println("Encoded string is not valid")
                return
            }
        }

        if ((a.lastIndex+1) % 2 != 0) {
            println("Encoded string is not valid")
            return
        }
        var t = 0
        for (i in 1..a.lastIndex step 2){
            t += a[i].length
        }
        if (t % 7 != 0) {
            println("Encoded string is not valid")
            return
        }
        for (i in 0..a.lastIndex step 2){
            if (a[i].length > 2) {
                println("Encoded string is not valid")
                return
            }
        }
        /*println(a.lastIndex+1)
        println((a.lastIndex+1) / 2)
        println(((a.lastIndex+1) / 2) % 7)*/
       /* if ((a.lastIndex+1) % 7 != 0) {
            println("Encoded string is not valid")
            return
        }*/
        //println("The result:")
        //  println(a)
        var res = ""
        var d = 0
        var skipp = false
        for (i in a.indices) {
            if (skipp){
                skipp = false
                continue
            }

            if (a[i] == "0") {
                d = 1
            } else d = 0

            for (j in 1..a[i+1].length) {
                res += d
            }
            skipp = true
        }
        //   println(res)
        var b = 64
        var x = 0
        var r = ""
        for (i in res) {
            if (i == '1') x += b
            b /= 2
            if (b == 0) {
                b = 64
                r += x.toChar()
                x = 0
            }
        }
        println("Decoded string:")
        println(r)
    }
    fun encode(){
        println("input string:")
        val a = readln()
        println("Encoded string:")
        var ind = -1
        var str = ""
        for (i in a) {
            var s = Integer.toBinaryString(i.code)
            if (s.toInt() <= 111111) s = "0" + s
            for (j in s){
                //println("j: $j")
                if (ind != -1) {
                    if (j.digitToInt() == ind) {
                        str+= "0"
                    } else {
                        ind = -1
                        str += " "
                    }
                }
                if (ind == -1) {
                    if (j.digitToInt() == 1) {
                        str += "0 0"
                        ind = 1
                    } else if (j.digitToInt() == 0) {
                        str += "00 0"
                        ind = 0
                    }
                }
            }
        }
        println(str)
    }

    var op = ""
    do {
        println("Please input operation (encode/decode/exit):")
        op = readln()
        if (op == "encode") encode()
        else if (op == "decode") decode()
        else if (op == "exit") println("Bye!")
        else println("There is no '$op' operation")
    } while (op != "exit")
}