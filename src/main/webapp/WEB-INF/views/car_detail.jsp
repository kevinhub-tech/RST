<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<!--  Enable Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<!--  Access the Static Resources without using spring URL -->
<link href="/ABC_Car_Portal/css/style.css" rel="stylesheet" />


</head>

<body>

	<!-- Test My JS -->
	<!-- <input type="button" class="button" onclick="sayHello();" value="Click me!">  -->

	<%@ include file="header.jsp"%>


	<!-- First Container -->
	<div class="container-fluid bg-1 text-center">
		<h3 class="margin">Detail Car Information </h3>

		<div class="row">

			<div class="col-md-4"></div>

			<div class="col-md-4">

				<form:form class="form-horizontal">

					<div class="form-group">
						<label for="id" class ="control-label col-sm-4">ID: </label> 
						<div class="col-sm-8">${car.id}</div>
					</div>
					
					
					<div class="form-group">
						<label for="make" class ="control-label col-sm-4">Car Make: </label> 
						<div class="col-sm-8">${car.make}</div>
					</div>
					
				 <div class="form-group">
						<label for="model" class ="control-label col-sm-4">Car Model: </label> 
						<div class="col-sm-8">${car.model}</div>
				</div>
					
				<div class="form-group">
						<label for="reg" class ="control-label col-sm-4">Reg No: </label> 
						<div class="col-sm-8">${car.registeration}</div>
				</div>

				<div class="form-group">
						<label for="price" class ="control-label col-sm-4">Price: </label> 
						<div class="col-sm-8">${car.price}</div>
				</div>
				
				<input type="submit" value="Bit Car" class="btn btn-primary">
				<input type="button" class="btn btn-primary" style="background-color:black;"value="Go Back" onclick="goBack()"/>

					<script>
						function goBack() {
							window.history.back();
						}
					</script>

				
		</form:form>
	</div>


			<div class="col-md-4"></div>

		</div>

	</div>


	<%@ include file="footer.jsp"%>

</body>
</html>
	