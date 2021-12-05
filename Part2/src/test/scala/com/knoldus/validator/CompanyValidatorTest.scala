package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmailValidator = mock[EmailValidator]

  "Company" should "be correct" in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)
    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)
  }

  "Company" should "incorrect as it already in the DB" in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)
    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be correct as the email id is incorrect" in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)
    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be incorrect if email id invalid and already used " in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)
    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

}
