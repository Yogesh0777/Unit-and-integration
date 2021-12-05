package com.knoldus.db

import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec

class CompanyReadDtoTest extends AnyFlatSpec {

  "Company" should "used" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Knoldus")
    assert(!result.isEmpty)
  }

  it should "not used" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Amazon")
    assert(result.isEmpty)
  }

}
