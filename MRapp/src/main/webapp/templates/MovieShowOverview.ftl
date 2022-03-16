<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies Overview</title>
	<link type="text/css" href="css/table.css" rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />


<title>Movie Rate</title>

<body>
   <h1>Welcome</h1>
   <a href="header">Back</a>
   
    

<div class="container">
	
	<div class="table">
		<div class="table-header">
			<div class="header__item"><a id="name" class="filter__link" >Id</a></div>
			<div class="header__item"><a id="wins" class="filter__link filter__link--number" >Title</a></div>
			<div class="header__item"><a id="draws" class="filter__link filter__link--number" >Director</a></div>
			<div class="header__item"><a id="losses" class="filter__link filter__link--number" >Date</a></div>
			<div class="header__item"><a id="total" class="filter__link filter__link--number" >Actors</a></div>
			<div class="header__item"><a id="total" class="filter__link filter__link--number" >Average Rate</a></div>

		</div>
		<div class="table-content">	
		<#list moviesOverview as mo>
			<div class="table-row">		
				<div class="table-data">${mo.id}</div>
				<div class="table-data">${mo.title}</div>
				<div class="table-data">${mo.director}</div>
				<div class="table-data"> ${mo.originalpublishingDate}</div>
				<div class="table-data"> ${mo.actors}</div>
				<div class="table-data"> ${mo.average}</div>
			</div>
	</#list>

		</div>	
	</div>
</div>
</table>
			

</body>
</html>

