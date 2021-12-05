package com.problem2
trait FactPal{
  def isPalindrome(number: Int): Boolean
  def isFact(digit: Int): Int


}

class FactAndPalindrome {
  def isPalindrome(number: Int): Boolean = {


    var copy_number: Int = number
    var remainder = 0
    var reverse = 0

    while (copy_number > 0) {
      remainder = copy_number % 10
      reverse = reverse * 10 + remainder
      copy_number = copy_number / 10
    }

    if (reverse == number)
      true
    else
      false

  }
  def isFact(number: Int): Int={



    var result: Int = 1
    for (increment <- 2 to number) {
      result *= increment
    }
    result
  }
}
