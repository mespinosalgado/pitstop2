<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 
 <!-- <link rel="stylesheet" href="style/prettyPhoto.css"> -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/validationEngine.jquery.css" />

<!-- Sliding box starts -->
<div id="page-wrapper">
	<div class="row">
         <div class="col-lg-12">
             <h1>Perfil <small><s:property value="session.activeRole" /></small></h1>
             <div class="alert alert-info alert-dismissable">
                 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                 Politicas Contraseña <strong>Su Contraseña debe:
				        * Contener al menos una letra mayúscula. 
						* Contener al menos una letra minúscula. 
						* Contener al menos un numero 
						* Longitud como mínimo 8 caracteres.</strong>!
             </div>   
         </div>
     </div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-warning">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa fa-user fa-lg"></i>&nbsp; Cambiar Contraseña
					</h3>
				</div>
				<div class="panel-body">
              			<h5><i class="icon-list-alt"></i>Cambiar Contraseña</h5>
                 		<p>El siguiente formulario muestra los campos necesarios para el cambio, es necesario que complete todos los campos antes de continuar.</p>
                  		<hr />      
                    <div class="col-lg-10">
                   		<form action="" id="contact-form" class="form-horizontal">
                       		<div class="form-group">
	                        	<label class="control-label" for="name">Contraseña Actual</label>
	                         	<input type="password" name="actual" id="actual" class="validate[required]">	                   
                       		</div>
	                       	<div class="form-group">
	                        	<label class="control-label" for="name">Contraseña Nueva</label>	
	                         	<input type="password" name="nueva" id="nueva" onblur="validatePass(this)" class="validate[required]">	                         	
	                       	</div>
                       		<div class="form-group">
                         		<label class="control-label" for="name">Repetir Contraseña Nueva</label>
                         		<input type="password" name="rnueva" id="rnueva" onblur="validatePass(this)" class="validate[required]">
                       		</div>   		
                       		<div class="form-group">
					        	<button type="submit" id="guardar" value="guardar" class="btn btn-primary" ><span class="glyphicon glyphicon-ok-sign"></span> Guardar</button>
					   		</div>                                 		       
                   		</form>
                 	</div>
                 	<div id="mensaje"></div>        			
				</div>
			</div>
		</div>
	</div>
</div>


<!-- JS -->
<script src="<%=request.getContextPath()%>/resources/js/jquery.js" type="text/javascript" charset="utf-8"></script> 
<script src="<%=request.getContextPath()%>/resources/js/bootbox.min.js" type="text/javascript" charset="utf-8"></script><!--  Bootbox -->
<script src="<%=request.getContextPath()%>/resources/js/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script><!-- prettyPhoto -->
<script src="<%=request.getContextPath()%>/resources/js/md5.js" type="text/javascript" charset="utf-8"></script><!-- ecryptar pass -->
<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8"></script>
<%--
<script src="js/filter.js"></script> <!-- Filter JS -->
<script src="js/jquery.carouFredSel-6.1.0-packed.js"></script> <!-- CarouFredSel -->
<script src="js/jquery.flexslider-min.js"></script> <!-- Flexslider -->
<script src="js/jquery.tweet.js"></script> <!-- Tweet -->
<script src="js/custom.js"></script> <!-- Main js file -->
--%>

<script type="text/javascript">

$(inicializarPagina());

function inicializarPagina(){
    if($("#mensaje").val() != ""){
    	var mensaje = $("#mensaje").val();
    	bootbox.alert(mensaje);
    }
 }

var result = false;
function validatePass(campo) {
    var RegExPattern = /(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$/;
    if ((campo.value.match(RegExPattern)) && (campo.value!='')) {
        result = true;
    } else {
        result = false;
    } 
}

$("#guardar").click(function(event) {	
	event.preventDefault();
	alert("entra");
			if($("#nueva").val() != $("#rnueva").val()){
				alert("Las contraseñas ingresadas no coinciden!");
			}else{
				if(!result){
				 alert("Su contraseña no cumple las politicas de seguridad exigidas!");
				}else{
				var pass = $("#actual").val();
		   		var salt = calcMD5(pass).substring(0,3);
		   		pass = calcMD5(pass+salt);
		   		$("#actual").val(pass);
		   		
		   		var pass2 = $("#nueva").val();
		   		var salt2 = calcMD5(pass2).substring(0,3);
		   		pass2 = calcMD5(pass2+salt2);
		   		$("#nueva").val(pass2);
		   		
		   		var pass3 = $("#rnueva").val();
		   		var salt3 = calcMD5(pass3).substring(0,3);
		   		pass3 = calcMD5(pass3+salt3);
		   		$("#rnueva").val(pass3);
		   		
			   		var r = confirm("Esta seguro de cambiar su Contraseña?");
			   		if (r == true) {
			   			alert("entra2");
		   				$('#mensaje').load('Cuenta_cambiaContrasena_mensaje.action',
		   					{
		   						passActual:  $("#actual").val(),
		   						passNueva:  $("#nueva").val(),
		   						passNuevaRep: $("#rnueva").val()
		   					});
		   				}
			   		}
				}			
});
</script>
