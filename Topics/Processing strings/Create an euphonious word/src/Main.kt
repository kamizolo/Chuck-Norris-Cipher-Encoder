fun main() {
    // write your code here    
    val vowel = mutableListOf('a', 'e', 'i', 'o', 'u', 'y')
    var v = 0
    var c = 0
    var count = 0

    val input = readln()

    for (i in input) {
        if (i in vowel) {
            v++
            c = 0
            if (v == 3) {
                count++    
                v = 1
            }
        } else {
            c++
            v = 0
            if (c == 3) {
                count++    
                c = 1
            }
        }

    }
    print(count)
}
