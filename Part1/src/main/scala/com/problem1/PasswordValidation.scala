package com.problem1

class PasswordValidation (Pass:String){
  def correctPassword(password: String): Boolean ={
    var regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.\\S)(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$"
    return password.matches(regex)

  }
}
