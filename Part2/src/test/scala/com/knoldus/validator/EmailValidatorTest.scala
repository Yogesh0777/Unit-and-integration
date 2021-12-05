package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {
  val emailValidator = new EmailValidator
  "email" should "contain  uppercase and lowercase " in {
    var result: Boolean = emailValidator.emailIdIsValid("yogesh@knoldus.com")
    assert(result == true)
  }

  "Email" should "started with number is valid" in {
    var result: Boolean = emailValidator.emailIdIsValid("077yogesh@knoldus.com")
    assert(result == true)
  }
  "Email" should "valid that contain name has dot and underscore" in {
    var result: Boolean = emailValidator.emailIdIsValid("077yoges.h-sharma@knoldus.com")
    assert(result == true)
  }

  "Email" should "incorrect with missing @" in {
    var result: Boolean = emailValidator.emailIdIsValid("yogeshknoldus.com")
    assert(result == false)
  }

  "Email" should "incorrect with start with special word except underscore and dot" in {
    var result: Boolean = emailValidator.emailIdIsValid("*/yogesh@knoldus.com")
    assert(result == false)
  }

  "Email" should "incorrect with space in between" in {
    var result: Boolean = emailValidator.emailIdIsValid("yogesh @knoldus.com")
    assert(result == false)
  }

  "Email" should "incorrect with missing top domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("yogesh@gmail")
    assert(result == false)
  }

  "Email" should "incorrect with missing main domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("yogesh@.com")
    assert(result == false)
  }

  "Email" should "incorrect when wrong top level domain except .com/.org/.net" in {
    var result: Boolean = emailValidator.emailIdIsValid("yogesh@sharma.live")
    assert(result == false)
  }

  "Email" should "incorrect with more than one top level domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("yogesh@knoldus.com.net")
    assert(result == false)
  }

  "Email" should "incorrect with contain double dots after name" in {
    var result: Boolean = emailValidator.emailIdIsValid("yogesh@knoldus..com")
    assert(result == false)
  }
}
