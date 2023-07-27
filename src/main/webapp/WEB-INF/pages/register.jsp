<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Spring-MVC project</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="http://localhost/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="http://localhost/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>
<body style="background-color: #E2E2E2;">
    <div class="container">
       <!-- <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                 <img src="http://localhost/assets/img/logo-invoice.png" /> 
            </div>
        </div>-->
         <div class="row ">
               
                <div>
                  <div class="panel-body">
                                <form:form role="form" action="registerform" method="post" modelAttribute="register">
                                    <hr />
                                    <h4>Enter Details to Register</h4>
                                       <br />
                                       <table class="table table-hover table-responsive">
                                       <tr>
                                       <td>
                                       
                                       <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="uname"  id= "uname" class="form-control" placeholder="Enter the Name " />
                                        </div>
                                       </td>
                                        <td>
                                       
                                       <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="uemail" id="uemail" class="form-control" placeholder="Enter the Email " />
                                        </div>
                                       </td>
                                       </tr>
                                       
                                       <tr>
                                       <td>
                                       
                                       <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="ucontact" id="ucontact" class="form-control" placeholder="Enter the Contact " />
                                        </div>
                                       </td>
                                        <td>
                                       
                                       <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="upassword" id="upassword" class="form-control" placeholder="Enter the Password " />
                                        </div>
                                       </td>
                                       </tr>
                                       
                                       <tr>
                                       <td>
                                       
                                       <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="uprofession" id="uprofession" class="form-control" placeholder="Enter the Profession " />
                                        </div>
                                       </td>
                                        <td>
                                       
                                       <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="uaddress" id="uaddress" class="form-control" placeholder="Enter the Address " />
                                        </div>
                                       </td>
                                       </tr>
                                       
                                       <tr>
                                       <td>
                                       
                                       <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="ucity" id="ucity" class="form-control" placeholder="Enter the City " />
                                        </div>
                                       </td>
                                        <td>
                                       
                                       <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="ucountry" id="ucountry" class="form-control" placeholder="Enter the Country " />
                                        </div>
                                       </td>
                                       </tr>
                                       
                                       </table>
                                    <form:button class="btn btn-primary ">Register</form:button>
                                        
                                    </form:form>
                            </div>
                           
               </div>
                
                
        </div>
    </div>

</body>
</html>
<script>
$("document").ready(function(){
	$("#uname").val("");
	$("#uemail").val("");
	$("#ucontact").val("");
	$("#upassword").val("");
	$("#uprofession").val("");
	$("#uaddress").val("");
	$("#ucity").val("");
	$("#ucountry").val("");
});

</script>
