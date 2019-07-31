var turn : Char = 'X'
var col : Int = 4
var row : Int = 4
var table = arrayOf(
    arrayOf('-','-','-'),
    arrayOf('-','-','-'),
    arrayOf('-','-','-'))
var count : Int = 1
fun main(){

    while (count<=9){
        showTable()
        println("Turn pf player $turn")
        input()
        while(!checkRepeatIndex()){
            println("Please enter new index")
            input()
        }
        val player = setTable()
        if(isWins()){
            println("Player $player win!")
            break
        }
        count++
        if(count > 9){
            println("Draw")
        }
    }
}
val showTable : () -> Unit = {
    println("  1 2 3")
    for(col in table.indices){
        print("${col+1} ")
        for(row in table[col]){
            print("$row ")
        }
        println()
    }
}
val inputCol : () -> Unit = {
    while (true){
        try {
            print("Enter Col : ")
            val enter: String? = readLine()
            col = enter?.toInt()!!
            if(col > 3 || col < 1){
                println("Please enter correct index.")
                continue
            }
            break
        }catch (e:Throwable){
            println("Please enter number value.")
            continue
        }
    }
}
val inputRow : () -> Unit = {
    while (true){
        try {
            print("Enter Row : ")
            val enter: String? = readLine()
            row = enter?.toInt()!!
            if(row > 3 && row < 1){
                println("Please enter correct index.")
                continue
            }
            break;
        }catch (e:Throwable){
            println("Please enter number value.")
            continue
        }
    }
}
val input:()->Unit ={
    inputCol()
    inputRow()
}
val checkRepeatIndex:() -> Boolean = {
    table[row-1][col-1].equals('-')
}
val setTable : () -> Char = {
    table[row-1][col-1] = turn
    if(turn.equals('X')){
        turn='O'
    }else{
        turn='X'
    }
    table[row-1][col-1]
}
val isWins:() -> Boolean = {
    var flag:Boolean = false
    for(i in 0..2){
        if(table[i][0].equals(table[i][1]) && table[i][1].equals(table[i][2])&& !(table[i][1].equals('-'))){
            flag=true
            break
        }
        if(table[0][i].equals(table[1][i]) && table[1][i].equals(table[2][i])&& !(table[i][1].equals('-'))){
            flag=true
            break
        }
    }
    if(table[0][0].equals(table[1][1]) && table[1][1].equals(table[2][2])&& !(table[1][1].equals('-'))){
        flag = true
    }
    if(table[0][2].equals(table[1][1]) && table[1][1].equals(table[2][0])&& !(table[1][1].equals('-'))){
        flag = true
    }
    
    flag
}
