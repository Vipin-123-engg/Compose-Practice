package com.example.composepractice.utils

fun main() {
    println("Hello, world!!!")
    val nums = arrayListOf(2, 3, 4, 3, 5)
    println(nums.size)
    findTargetValue(nums,7)

}

fun findTargetValue(numbs: List<Int>,targetValue: Int){

    val hashSet = mutableSetOf<Int>()

    for (i in numbs.indices){
        val complement = targetValue - numbs[i]
        if(hashSet.contains(complement)){
            println("Values are : $complement, ${numbs[i]}")
        }
        hashSet.add(numbs[i])
    }
}

fun findDuplicateUsingHasMap(numbs: List<Int>): Map<String,Int> {

    val resList = hashMapOf<String,Int>()
    for (i in numbs) {
        if (i in numbs) {
//            println("Duplicate element :" + numbs[i])
            resList["$i"] = (resList["$i"] ?: 0) +1
        }else{
            resList["$i"] = 1
        }
    }

    for ((key,value) in resList){
        if(value>1){
            println("Duplicate element : $key")
        }
    }
    return resList
}

fun findLargestElement(numbs:List<Int>) : Int{

    var res = numbs[0]

    for(element in numbs){
        if(element>res){
            res = element
        }
    }

    return res
}

fun findDuplicateUsingHasSet(numbs: List<Int>): Set<Int> {

    val resList = mutableSetOf<Int>()
    for (i in numbs) {
        if (!resList.add(i)) {
            println("Duplicate element :" + numbs[i])
        }
    }
    return resList
}

fun findDuplicate(nums: List<Int>): List<Int> { // Brute Force
    val resList = mutableListOf<Int>()
    for (i in nums.indices) {
        for (j in (i + 1)..(nums.size - 1)) {
            if (nums[i] == nums[j]) {
                println("Duplicate element $j :" + nums[i])
                resList.add(nums[i])
            }
        }
    }

    return resList
}