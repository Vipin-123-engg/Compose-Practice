package com.example.composepractice.utils


fun main(){

    println(factorial(5))

}

fun factorial(num:Int) : Int{

    val n = num
    if(n<=1) {
        return 1
    }

    val res = n * factorial(n-1)

    return res
}