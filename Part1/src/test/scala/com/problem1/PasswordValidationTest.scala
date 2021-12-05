package com.problem1

import org.scalatest.flatspec.AnyFlatSpec

class PasswordValidationTest extends AnyFlatSpec {
  val password = new PasswordValidation (" ")

  "A Password " should "have all necessary features" in {
    val result = password.correctPassword("Yogesh@077")
    assert(result)

  }

  "A Password" should "be invalid if character are less then 8 " in{
    val result = password.correctPassword("Yogesh@")
    assert(!result)
  }
   "A Password" should "be invalid if it is not contain 8 to 15 characters length" in {
     val result = password.correctPassword(password = "Yogesh")
     assert(!result)
   }
  "A Password" should "be invalid if it is not contain a lowercase letter" in {
    val result = password.correctPassword(password = "YOGESH")
    assert(!result)
  }
  "A Password" should "be invalid if it is not contain a uppercase letter" in {
    val result = password.correctPassword(password = "yogesh")
    assert(!result)
  }
  "A Password" should "be invalid if it is not contain a special character" in {
    val result = password.correctPassword(password = "Yogesh")
    assert(!result)
  }
}
