<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Rate</title>
	<link type="text/css" href="css/style.css" rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
</head>
<body>
   <h1>Welcome<h1>
   <br>
   <a href="header">Back</a>

   <form action="usergui?action=RateMovie" method="post">
   <p>which movie you would like to rate?</p>
    
  <select name="movietitle" id="availableMovielist">
		     <#list Movies as Mo>
				  <option value="${Mo.title}">${Mo.id}   ${Mo.title}   ${Mo.director}   ${Mo.originalpublishingDate}   ${Mo.actors}</option>

			
			</#list>
	</select>

			
		   <div>
            <label>Rate</label>
            <input type="Number" id="availableMovielist" name="Rate" min="1" max="10" step="1"/>
		  </div>
		  
 <p><input type="submit" value="Submit"></p> 
		
		  
 </form>
</body>
</html>

