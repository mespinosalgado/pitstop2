<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta charset="utf-8">
<!-- Title and other stuffs -->
<title>Login - PitStop</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap/css/bootstrap.min.css" />
<link href="<%=request.getContextPath()%>/resources/img" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap/css/login.css" />
</head>
<body>
	<div class="container">
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row-fluid user-row">
							<img src="<%=request.getContextPath()%>/resources/img/pitstop.png"
								class="img-responsive" alt="Conxole Admin" />
						</div>
					</div>
					<div class="panel-body">
						<form accept-charset="UTF-8" action="<%=request.getContextPath()%>/intranet/login" role="form"
							class="form-signin" method="post">
							<fieldset>
								<label style="margin-bottom: 25px" class="panel-login">
									<div class="login_result"></div>
								</label>
								<div style="margin-bottom: 25px" class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<i class="glyphicon glyphicon-user"></i>
										</span>
									<s:textfield id="txtLogin" class="form-control"
										placeholder="username" type="text" name="userName" />
									</div>
									<s:property value="error"/> 
									
								</div>
							
								<div style="margin-bottom: 25px" class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<i class="glyphicon glyphicon-lock"></i>
										</span>
									<s:textfield id="txtPassword" name="password"
										class="form-control" type="password" placeholder="Password"
										value="" />
									</div>	
								</div>
								<%
									if (request.getAttribute("error") != null) {
								%>
								<div style="margin-right: 8PX; margin-top: 10px;">
									<span><strong class="alert alert-danger" ><%=request.getAttribute("error")%></strong></span>
								</div>
								<%
									} ;
								%>
								<br></br> 
								<span class="group-btn">
								<input class="btn btn-lg btn-success btn-block"
									type="submit" id="loginSubmit" value="Login >>">
							
								</span>
								<s:actionerror />
								
							</fieldset>
						</form>
					</div>
					<div class="panel-footer ">
					 <table style="width: 100%;">
					<tbody>
						<tr>
							<td style="text-align: center;">
								<span>
									<a href="https://www.mozilla.org/es-CL/firefox/new/">
										<img src="<%=request.getContextPath()%>/resources/img/firefox.png" style="height: 30px;width: 30px;" title="Mozilla Firefox" alt="Mozilla Firefox"/>
									</a>
								</span>
							</td>
							<td style="text-align: center;">
								<span>
									<a href="https://www.microsoft.com/es-cl/windows/microsoft-edge">
										<img src="<%=request.getContextPath()%>/resources/img/edge.png" style="height: 30px;width: 30px;" title="Microsoft Edge" alt="Microsoft Edge"/>
									</a>
								</span>
							</td>
							<td style="text-align: center;">
								<span>
									<a href="http://windows.microsoft.com/es-cl/internet-explorer/ie-11-worldwide-languages">
										<img src="<%=request.getContextPath()%>/resources/img/ie11.png" style="height: 30px;width: 30px;" title="Internet Explorer 11" alt="Internet Explorer 11"/>
									</a>
								</span>
							</td>
							<td style="text-align: center;">
								<span>
									<a href="https://www.google.com/chrome/browser/desktop/index.html">
										<img src="<%=request.getContextPath()%>/resources/img/chrome.png" style="height: 30px;width: 30px;" title="Google Chrome" alt="Google Chrome"/>
									</a>
								</span>
							</td>
						
						</tr>
					</tbody>
				</table>

					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#loginSubmit').click(function(e) {
				var msg = "";
				if ($.trim($('#txtLogin').val()) == '')
					msg += '"User" no debe ser vacio\n';
				if ($.trim($('#txtPassword').val()) == '')
					msg += '"Password" no debe ser vacia\n';
				if (msg != "") {
					alert(msg);
					e.preventDefault();
					return false;
				}
			});
		});
	</script>
	<script src="<%=request.getContextPath()%>/resources/js/login.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>