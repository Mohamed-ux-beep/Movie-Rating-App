<!DOCTYPE HTML>
<html lang='de' dir='ltr'>
<head>
	<meta charset="utf-8" />
	<title>Movies Rate Application </title>
	<link type="text/css" href="css/style.css" rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />


</head>
	
	<body>
			<form action="persongui?action=Register" method="post">
			    <fieldset id="Register">
					  <div class="container">
					    <h1>Register</h1>
					    <p>Please fill in this form to create an account.</p>
					    <hr>
					    
					    <label for="name"><b>Name</b></label>
					    <input type="text" placeholder="Enter name" name="name" id="name" required>
					
					    <label for="email"><b>Email</b></label>
					    <input type="text" placeholder="Enter Email" name="email" id="email" required>
										    
					    <label for="Age"><b>Age</b></label>
					    <input type="number" placeholder="Enter Age" name="Age" id="Age" required>
					
					
					    <label for="password"><b>Password</b></label>
					    <input type="password" placeholder="Enter Password" name="password" id="password" required>
					
					    
					    <hr>
				</fieldset>
					    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
					    <button type="submit" class="registerbtn" name="register">Register</button>
					  </div>
				
					  <div class="container signin">
					    <p>Already have an account? <a href="/MRapp/usergui?action=signIn">Sign in</a>.</p>
					  </div>
				 
			</form>
		
	</body>

</html>