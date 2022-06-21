

fun main(){
    //Question 1: Longest Word
//    println(longestWord("fun&!! time"))
//    println(longestWord("time&!! fun"))
//    println(longestWord("time&!! four"))
//    println(longestWord("four&!! time"))
//    println(longestWord("Hello!#$ world123 5#$$67 ejrkejke 3k3k"))

    //Question 2:
//    var revArray = reverseSubArray(arrayOf(1,2,3,4,5, 6, 7, 8, 9, 10), 3)
//    for(a in revArray){
//        print("$a ")
//    }
//    println()

    //Question 3:
//    println("The 3rd smallest element in array[7,10,4,3,20,15] is "+ kthSmallest(arrayOf(7,10,4,3,20,15), 3))


    //Question 4:
//    println("The rotation in array[5, 6, 7, 8, 9, 10, 1, 2, 3] occurred at index "+ rotatedArrayIndex(arrayOf(5, 6, 7, 8, 9, 10, 1, 2, 3)))

    //Question 5:
//    println("Number of pairs where x^y > y^x holds true for x[2,1,6] and y[1,5] are "+ powerPairs(arrayOf(2,1,6), arrayOf(1,5)))

    //Question 6:
//    println("aabbbcdde: "+ repeatedCharacterString("aabbbcdde"))

    //Question 7:
//    println("Number of paths in {{3,0,3,0,0},{3,0,0,0,3},{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}} is "+ numPathsFromSource(
//        arrayOf(arrayOf(3,0,3,0,0), arrayOf(3,0,0,0,3), arrayOf(3,3,3,3,3), arrayOf(0,2,3,0,0), arrayOf(3,0,3,1,3))
//    ))
//
//    println("Number of paths in {{2,3,3}, {3,3,3}, {0,0,1}} is "+ numPathsFromSource(arrayOf(arrayOf(2,3,3), arrayOf(3,3,3), arrayOf(0,0,1))))

    //Question 8:





}

//Question 1
fun longestWord(sen: String): String{

    var regex = Regex("[^[a-z|0-9|\\s]]*")
    var wordsArray = sen.replace(regex, "").split(" ")

//    wordsArray.sortedBy { it.length }.reversed() //didn't work because order not maintained

    var max = wordsArray[0].length
    var word = wordsArray[0]

    for (w in 1..wordsArray.size-1){
        if(max < wordsArray[w].length){
            max = wordsArray[w].length
            word = wordsArray[w]
        }

    }

    return word
}

//Question 2
fun reverseSubArray(arr: Array<Int>, k: Int): Array<Int>{
    var arrRev = arr.copyOf()
    val n = arr.size-1

    for(i in 0..n step k){
        var endSubArray = i+k-1
        if (endSubArray <= n){
            arrRev = reverse(arrRev, i, endSubArray)
        }
        else{
            arrRev = reverse(arrRev, i, n)
        }
    }
    return arrRev
}

private fun reverse(arr: Array<Int>, startRev: Int, stopRev: Int): Array<Int>{
    var start = startRev
    var stop = stopRev
    while (start < stop){
        var temp = arr[start]
        arr[start] = arr[stop]
        arr[stop] = temp
        start++
        stop--
    }
    return arr
}

//Question 3
fun kthSmallest(arr: Array<Int>, k: Int): Int{
    var sortedArr = arr.sortedArray()
    return sortedArr[k-1]
}

//Question 4
fun rotatedArrayIndex(arr: Array<Int>): Int{
    var sortedArr = arr.sortedArray()
    var max = sortedArr.last()

    for (i in 0..arr.size-1){
        if(max == arr[i]){
            return i
        }

    }
    return -1
}

//Question 5
fun powerPairs(xArray: Array<Int>, yArray: Array<Int>): Int{
    var powerPairs = 0
    for(x in xArray){
        for(y in yArray){
            var xpow = Math.pow(x.toDouble(), y.toDouble())
            var ypow = Math.pow(y.toDouble(), x.toDouble())
            if(xpow > ypow){
                powerPairs++
            }
        }
    }
    return powerPairs
}

//Question 6
fun repeatedCharacterString(aString: String): String{
    var firstNonRepeatingChar = aString[0]
    var result = aString[0].toString()
    var repeatedChar = '-'
    for (a in 1..aString.length-1){
        if(aString[a].equals(firstNonRepeatingChar)){
            firstNonRepeatingChar = '#'
            result += "#"
            repeatedChar = aString[a]
        }
        else{
            if(firstNonRepeatingChar.equals('#') && !aString[a].equals(repeatedChar)){
                firstNonRepeatingChar = aString[a]
            }

            result += firstNonRepeatingChar
        }
    }
    return result
}

//Question 7
fun numPathsFromSource(arr: Array<Array<Int>>): Int{
    var n = arr.size-1
    for (x in 0..n){
        for(y in 0..n){
            if(arr[x][y] == 1){
                return numOfPath(arr, x, y)
            }
        }
    }

    return -1
}
private fun numOfPath(arr: Array<Array<Int>>, x: Int, y: Int):Int{
    var xx = x+1
    var yy = y+1
    var xm = x-1
    var ym = y-1
    var n = arr.size

    if (arr[x][y] == 2) return 1

    if (arr[x][y] == -1 || arr[x][y] == 0) return 0

    arr[x].set(y, -1)

    return ((if(xx<n) numOfPath(arr, xx, y) else 0) + (if(yy<n) numOfPath(arr, x, yy) else 0 ) + (if(xm>=0) numOfPath(arr, xm, y) else 0 ) + (if(ym>=0) numOfPath(arr, x, ym) else 0 ))

}





