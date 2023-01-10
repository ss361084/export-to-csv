<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix = "form" %>
<html>
    <head>
    	<%@include file="includes/Header.jsp" %>
        <title>Create Employee</title>
    </head>
    <body>
    	<section>
    		<div class="row">
    			<h4>Create Employee</h4>
    			<a href="${pageContext.request.contextPath}/Home" class="btn btn-primary">Back To Home</a>
    		</div>
   			<div class="row">
				<c:if test="${success}">
					<p class="alert-success">Successfully saved</p>
				</c:if>
				<c:if test="${error}">
					<p class="alert-danger"><c:out value="${errorMsg}"/></p>
				</c:if>
		    	<form:form action="create-employee" method="post" modelAttribute="employee">
				  <div class="form-group">
				    <label for="name">Name</label>
				    <form:input path="name" type="text" class="form-control" id="name" aria-describedby="name" placeholder="Enter Name"/>
				    <form:errors path="name" cssClass="alert-danger">Error</form:errors>
				    <form:hidden path="id"/>
				  </div>
				  <div class="form-group">
				    <label for="City">City</label>
				    <form:input path="address.city" type="text" class="form-control" id="city" placeholder="City"/>
				    <form:errors path="address.city" cssClass="alert-danger">Error</form:errors>
				  </div>
				  <div class="form-group">
				    <label for="Pincode">Pincode</label>
				    <form:input path="address.pincode" type="text" class="form-control" id="pincode" placeholder="Pincode"/>
				    <form:errors path="address.pincode" cssClass="alert-danger">Error</form:errors>
				  </div>
				  <form:button type="submit" id="formSubmit" class="btn btn-primary">Submit</form:button>
				</form:form>
    		</div>
    	</section>
    </body>
    <script type="text/javascript">
    	$(document).ready(function() {
    		$("#formSubmit").on("click",function() {
    			console.log("Submit called");
    			return true;
    		});
    	});
    </script>
</html>