<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix = "form" %>
<html>
    <head>
    	<%@include file="includes/Header.jsp" %>
        <title>Employees</title>
    </head>
    <body>
        <section>
            <div class="row">
                <div class="col-md-6">
                    <h3> Employees </h3>
                </div>
                <div class="col-md-6">
                	<button class="btn btn-primary" id="refresh">Refresh</button>&nbsp;&nbsp;
                	<a href="${pageContext.request.contextPath}/employee-page" class="btn btn-primary">Add Employee</a>
                </div>
            </div>
            <div>
            <table class="table" id="empTable">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">City</th>
			      <th scope="col">Pincode</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody id="empTableBody">
				  <c:forEach var="emp" items="${employees}">
	   				<tr>
	   					<td scope="row">${emp.name}</td>
	   					<td>${emp.address.city}</td>
	   					<td>${emp.address.pincode}</td>
	   					<td>
	   						<a class="btn btn-secondary">Edit</a>
	   						<a class="btn btn-secondary">Delete</a>
	   					</td>
	   				</tr>
	   			  </c:forEach>
			  </tbody>
			</table>
            </div>
        </section>
    </body>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$('#refresh').on('click',function(){
    			$.ajax({
    				type: "GET",
    				url: 'employees',
    				dataType: "json",
    				cache: false,
    				success: function(data) {
    					$('#empTableBody').html('');
    					var tableHtml = '';
    					data.forEach(emp => {
    						tableHtml = tableHtml 
    						+ '<tr>'
    						+'<td>'+emp.name+'</td>'
    						+'<td>'+emp.city+'</td>'
    						+'<td>'+emp.pincode+'</td>'
    						+'</tr>';
    					});
    					$('#empTableBody').append(tableHtml);
    				},
    				error: function(data) {
    					console.log(data);
    				}
    			});
    		});
    	});
    </script>
</html>