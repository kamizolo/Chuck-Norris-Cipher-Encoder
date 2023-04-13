fun main() {  
    val beyondTheWall = readLine()!!.split(", ").map { it }.toMutableList()
    val backToTheWall = readLine()!!.split(", ").map { it }.toMutableList()   
    // do not touch the lines above
    // write your code here
    var back = true
    var temp = false
    loop@ for (i in beyondTheWall) {
       // println("i: $i")
        for (j in backToTheWall) {
           // println("j $j")
            if (i == j){
                temp = true
                break
            } else temp = false
        }
        if (temp == false) {
            back = false
            break
        } else {
            temp = false
        }
    }
    println(back)
}
