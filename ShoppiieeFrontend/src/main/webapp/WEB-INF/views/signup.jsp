<!DOCTYPE html>
<html lang="en">
<head>
  <title>SignUp</title>
    
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  
  
  function formRegister() {
		// Make quick references to our fields
		
		var username = document.getElementById('username');
		var email = document.getElementById('email');
		var password = document.getElementById('pass');
		var age = document.getElementById('age');
		var phone = document.getElementById('contactnumber');
		var address = document.getElementById('address');
		var zipcode = document.getElementById('zipcode');
		// Check each input in the order that it appears in the form!
		
					if (notEmpty(username, "Username Should not be empty")) {
							if (isAlphabet(username,
									"Please enter only letters for Username")) {
								if (notEmpty(email,
								"EmailId Should not be empty")) {
									if(emailValidator(email, "Please Enter a valid Email id")){
								if (notEmpty(password,
										"password Should not be empty")) {
									if (isAlphanumeric(password,
											"Numbers and Letters Only for Passwords")) {
										if (notEmpty(age,
												"Age should not be empty")) {
											if(isNumeric(age,
													"Please enter only number for age"))
										      if (notEmpty(phone,
												"PhoneNumber Should not be empty")) {
											    if (isNumeric(phone,
													"Please enter only number for PhoneNumber")) {
													if (notEmpty(address,
															"Address Should not be empty")) {
														if (notEmpty(zipcode,
																"Zipcode Should not be empty")) {
															if (isNumeric(
																	zipcode,
																	"Please enter a valid zip code")) {
																return true;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
				     }
  }
		return false;
	}
  
  function notEmpty(elem, helperMsg) {
		if (elem.value.length == 0) {
			alert(helperMsg);
			elem.focus(); // set the focus to this input
			return false;
		}
		return true;
	}
  
	function isNumeric(elem, helperMsg) {
		var numericExpression = /^[0-9]+$/;
		if (elem.value.match(numericExpression)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function isAlphabet(elem, helperMsg) {
		var alphaExp = /^[a-z A-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function isAlphanumeric(elem, helperMsg) {
		var alphaExp = /^[0-9a-zA-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function emailValidator(elem, helperMsg) {
		var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		if (elem.value.match(emailExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
  
	
  </script>
  <style>
  #Reg{
  width:60%;
  height:100%;
  border-style: double;
 
  }
  
  #table{
  width:60%;
  length:70%;
  align: justify;
  
  }
  
  </style>
</head>
<body>



<form action="signup">
  <div class="containers">
  <table>
  <br>
  <tr>
    <td><label><b>UserId</b></label></td><td>
    <input type="text" placeholder="Enter UserID" name="uid" required><td>
    </tr><tr>
    <td><br>
    <label><b>Name</b></label></td><td>
    <input type="text" placeholder="Enter Name" name="username" required><td>
   </tr>
    <tr>
    <td><br>
    <label><b>Password</b></label></td><td>
    <input type="password" placeholder="Enter Password" name="userpass" required><td>
	</tr>
    <tr>
    <td><br>
    <label><b>Repeat Password</b></label></td><td>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" required><td>
    </tr>
    <tr>
    <td><br>
    <label><b>Age</b></label></td><td>
    <input type="text" placeholder="Enter Age" name="age" required><td>
    </tr>
    <tr>
    <td><br>
    <label><b>Gender</b></label></td><td>
    <input type="radio" name="gen" required/>Male<br><input type="radio" name="gen" required/>Female</td>
    </tr>
    <tr>
    <td><br>
    <label><b>Email</b></label></td><td>
    <input type="text" placeholder="Enter Email" name="email" required><td>
	</tr>
    <tr>
    <td><br>
    <label><b>Phone</b></label></td>
	<td><input type="text" placeholder="Enter Address" name="userphone" required></td>
	</tr>
    <tr>
    <td><br>
    <label><b>City</b></label></td>
	<td><input type="text" placeholder="Enter Address" name="useraddress" required></td>
	</tr>
    
  
   </table>

    <div class="clearfix">
     <br> <button type="button" class="loginbtn" >Cancel</button>
      <button type="submit" class="loginbtn" >SignUp</button>
    </div>
  </div>

</form>
    </body>
      
</html>