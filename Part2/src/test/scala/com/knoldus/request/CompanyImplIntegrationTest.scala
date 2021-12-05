package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)


  "Company" should "be correct" in {
    val googleCompany: Company = Company("yogesh", "yogesh@gmail.com", "kosi")
    val result =  companyImpl.createCompany(googleCompany)
    assert(!result.isEmpty)
  }

  "Company" should "be incorrect as it already used in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be incorrect as email id is incorrect" in {
    val googleCompany: Company = Company("yogesh", "yogeshmail.com", "Noida")
    val result =  companyImpl.createCompany(googleCompany)
    assert(result.isEmpty)
  }

  "Company" should "be incorrect as email id is incorrect and company already used in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldusgmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }


}
