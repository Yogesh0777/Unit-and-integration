package com.problem2

import org.scalatest.flatspec.AnyFlatSpec

class FactAndPalindromeTest extends AnyFlatSpec {
  val obj= new FactAndPalindrome
  "Factorial " should "be Positive" in{
    val result: Int= obj.isFact(7)
    assert(result==5040)
  }
  "Factorial" should "not contain a null value" in {
    val result: Int = obj.isFact(number = 6)
    assert(result == 720)

  }
  "Palindrome " should "return true if the user input is palindrome" in{
    val result= obj.isPalindrome(101)
    assert(result==true)
  }
  "Palindrome" should "return false if the user input is not a palindrome " in{
    val result= obj.isPalindrome(123)
    assert(result==false)
  }



}
