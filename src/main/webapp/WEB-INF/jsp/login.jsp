<%-- 
    Document   : login
    Created on : Apr 17, 2016, 7:50:41 PM
    Author     : rakeshshrestha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
  </head>
  <body>
    <section>
      <div class="jumbotron">
        <div class="container">
          <h1>Gateway to the webstore </h1>
          <p>The one and only amazing webstore</p>
        </div>
      </div>
    </section>
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <div class="panel-heading">
            <h3 class="panel-title">Please sign in</h3>
          </div>
          <div class="panel-body">
              <form action='<c:url value="/login"/>'
                  method="post">
              <fieldset>
                <div class='form-group'>
                  <input class="form-control" placeholder="User Name"
                         name='userId' type="text"/>
                </div>
                <div class="form-group">
                  <input class='form-control' placeholder="Password"
                         name='password' type="password" value="">
                </div>
                <input class="btn btn-lg btn-success btn-block"
                       type="submit" value="login">
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
