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
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <img src="http://localhost/assets/img/logo-invoice.png" />
            </div>
        </div>
         <div class="row ">
               
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                           
                            <div class="panel-body">
                                <form:form action="loginform" method="post" modelAttribute="login">
                                    <hr />
                                    <h5>Enter Details to Login</h5>
                                       <br />
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <form:input path="uemail" class="form-control" placeholder="Your Username " />
                                        </div>
                                                                              <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                            <form:input path="upassword" class="form-control"  placeholder="Your Password" />
                                        </div>
                                    <div class="form-group">
                                           
                                        </div>
                                        
                                     
                                     <form:button class="btn btn-primary ">Login Now</form:button>
                                    <hr />
                                    </form:form>
                                    Not register ? <a href="register" >register here </a> or go to <a href="">Home</a> 
                                    
                            </div>
                           
                        </div>
                
                
        </div>
    </div>

</body>
</html>
