<!DOCTYPE HTML>
<html lang='de' dir='ltr'>
<head>
	<meta charset="utf-8" />
	<title>Movies Rate Application </title>
	<link type="text/css" href="css/style.css" rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />


</head>
	
	<body>
            <a href="header">Back</a>
			<form action="usergui?action=AddMovie" method="post">
			    <fieldset id="AddMovie">
					  <div class="container">
					    <h1>Add New Movie</h1>
					    <p>Please fill in this form to Add New Movie.</p>
					    <hr>
					    
					    <label for="movietitle"><b>Movie title</b></label>
					    <input type="text" placeholder="Enter Movie title" name="movietitle" id="movietitle" required>
					
					    <label for="director"><b>Director</b></label>
					    <input type="text" placeholder="Enter Movie director" name="director" id="director" required>
										    
					    <label for="originalpublishingDate"><b>Original publishing Date</b></label>
					    <input type="Date" placeholder="Enter Date" name="originalpublishingDate" id="originalpublishingDate" required>
					
					
					    <label for="actors"><b>Actors</b></label>
					    <input type="text" placeholder="Enter actors" name="actors" id="actors" required>
					
					    
					    <hr>
				</fieldset>
					    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
					    <button type="submit" class="registerbtn">Add</button>
					  </div>
				
		
			</form>
		
	</body>

</html>