<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/timepicker.css" />

<div id="page-wrapper">
	<div class="row">
        <div class="col-lg-12">
          <h1>Registro Cliente y Vehículo</h1>
          	<ol class="breadcrumb">
            	<li><a href="<s:url action="Menu"/>"><i class="fa fa-tachometer"></i> Menú</a></li>
            	<li><a href="#"><i class="fa fa-tachometer"></i> Ingresos</a></li>
       			<li class="active"><i class="fa fa-street-view"></i> Registro Cliente</li>
     		</ol>
   		</div>
 	</div>
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-car"></i>&nbsp; Registro de Clientes
					</h3>
				</div>
			       	<div class="panel-body">			
							<div class="table-responsive">
								<table class="table table-hover tablesorter" id="dataTables">
									<thead>
									<tr class="active">
										<th width="110px">Rut<i class="icon-sort"></i></th>
										<th >Nombre &nbsp;<i class="fa fa-sort-alpha-asc"></i><i class="icon-sort"></i></th>
										<th width="110px">Celular<i class="icon-sort"></i></th>
										<th >Correo<i class="icon-sort"></i></th>
										<th width="100px">Acción &nbsp;<i class="fa fa-cogs"></i><i class="icon-sort"></i></th>
									</tr>
									</thead>
									<s:iterator value="#session.clientes" status="clientes">
									<tr>
										<td class="info"><s:property value="rut" /></td>
										<td><s:property value="nombre" /> <s:property value="apellidos" /></td>
										<td>+569&nbsp;<s:property value="celular" /></td>
										<td><s:property value="correo" /></td>
										<!-- Single button -->
										<td >
										<div class="col-lg-2">
											<button type="button" class="btn btn-info btn-sm"
												data-toggle="modal" style="margin-left: -15px"
												data-target="#udpCliente<s:property value="id" />"
												data-whatever="@mdo">
												<i class="fa fa-pencil fa-lg"></i>&nbsp; Editar
											</button>
										</div>
										</td>
									</tr>
									</s:iterator>
								</table>
							</div>
							<div class="col-lg-2">
								<button type="button" class="btn btn-success" data-toggle="modal" style="margin-left: -15px"
										data-target="#nuevoCliente" data-whatever="@mdo"><i class="fa fa-user-plus fa-lg"></i>&nbsp; Nuevo</button>
							</div>			
						</div>
				
					<!-- Agregar nuevo Cliente -->	
									
					<div class="modal fade" id="nuevoCliente" tabindex="-1" role="dialog" aria-labelledby="nuevoCliente" aria-hidden="true">
  						<div class="modal-dialog">
    						<div class="modal-content">
      							<div class="modal-header">
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        							<h4 class="modal-title" id="nuevoCliente">Nuevo Cliente</h4>
      							</div>
      							<div class="modal-body">
        							<s:form id="crearCliente" action="crearCliente" namespace="/intranet">
										<div class="form-group">
											<label for="rut" class="control-label">Rut </label>
        									<input type="text" class="form-control  validate[required] text-input rut" id="rutCliente" name="rut">
           								</div>
           								<!-- fin CONTROL -->
										<div class="form-group">
											<label for="nombre" class="control-label" class="label">Nombre</label>
											<input class="form-control  validate[required] text-input" name="nombre" id="nombre" />
										</div>
										<div class="form-group">
											<label for="apellidos" class="control-label" class="label">Apellidos</label>
											<input class="form-control  validate[required] text-input" name="apellidos" id="apellidos" />
										</div>
										<div class="form-group">
											<label for="direccion" class="control-label" class="label">Dirección</label>
											<input class="form-control text-input" name="direcciones" id="direcciones" />
										</div>
										<div class="form-group">
											<label for="cargo" class="control-label" class="label">Teléfono</label>
											<input class="form-control text-input" name="telefono" id="telefono" />							
										</div>
										<div class="form-group">
											<label for="celular" class="control-label" class="label">Celular</label>
											<input class="form-control text-input" name="celular" id="celular" />
										</div>
										<div class="form-group">
											<label for="correo" class="control-label" class="label">Correo</label>											
											<input class="form-control  validate[custom[email],required] text-input" name="correo" id="correo" />
										</div>
										<div class="modal-footer">
					 						<button type="submit" value="Crear" class="btn btn-primary btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Crear</button>					
					      				</div>
									</s:form>										
					      		</div>	  
					    	</div>
					  	</div>
					</div>

					<!-- Fin Agregar nuevo Cliente -->
					
					<!-- Editar nuevo Cliente -->	
					<s:iterator value="#session.clientes" status="clientes">
						<div class="modal fade" id="udpCliente<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="udpCliente<s:property value="id" />" aria-hidden="true">
	  						<div class="modal-dialog">
	    						<div class="modal-content">
	      							<div class="modal-header">
	        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        							<h4 class="modal-title" id="udpCliente<s:property value="id" />">Editar Cliente</h4>
	      							</div>
	      							<div class="modal-body">
	        							<form id="editarCliente<s:property value="rutFormat" />" action="editarCliente" namespace="/intranet">
											<div class="form-group">
												<label for="rut" class="control-label">Rut: </label>
												<input type="hidden" value="<s:property value="id" />" id="id" name="id" >
	        									<input type="text" value="<s:property value="rut" />"  class="form-control  validate[required] text-input rut" id="rut" name="rut" disabled>
	           								</div>
	           								<!-- fin CONTROL -->
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Nombre</label>
												<input class="form-control validate[required] text-input" name="nombre" id="nombre" value="<s:property value="nombre" />"/>
											</div>
											<div class="form-group">
												<label for="apellidos" class="control-label" class="label">Apellidos</label>
												<input class="form-control  validate[required] text-input" name="apellidos" id="apellidos" value="<s:property value="apellidos" />" />
											</div>
											<div class="form-group">
												<label for="direccion" class="ontrol-label" class="label">Dirección</label>
												<input class="form-control  text-input" name="direcciones" id="direcciones" value="<s:property value="direcciones" />" />
											</div>
											<div class="form-group">
												<label for="cargo" class="control-label" class="label">Teléfono</label>
												<input class="form-control  text-input" name="telefono" id="telefono" value="<s:property value="telefono" />" />							
											</div>
											<div class="form-group">
												<label for="celular" class="control-label" class="label">Celular</label>
												<input class="form-control  text-input" name="celular" id="celular" value="<s:property value="celular" />" />
											</div>
											<div class="form-group">
												<label for="correo" class="control-label" class="label">Correo</label>											
												<input class="form-control   validate[custom[email],required] text-input" name="correo" id="correo" value="<s:property value="correo" />"/>
											</div>
											<div class="modal-footer">
						        				<button type="submit" value="Editar" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Actualizar</button>					     
						      				</div>
										</form>										
						      		</div>	  
						    	</div>
						  	</div>
						</div>
					</s:iterator>				
					<!-- Fin Editar nuevo Cliente -->	  
			     </div>  
			   </div>
			    <!-- Fin Registro Cliente -->
			</div>		
		</div>


<script src="<%=request.getContextPath()%>/resources/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.Rut.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/timepicker.js" type="text/javascript"></script>

<script type="text/javascript">
<s:iterator value="#session.clientes" status="clientes">
var id = '<s:property value="rutFormat" escapeJavaScript="true" />';
	jQuery("#editarCliente"+id).validationEngine();
</s:iterator>
<s:iterator value="#session.vehiculos" status="vehiculos">
var id2 = '<s:property value="patenteFormat" escapeJavaScript="true" />';
	jQuery("#editarVehiculo"+id2).validationEngine();
</s:iterator>
<s:iterator value="#session.revisiones" status="revisiones">
var id3 = '<s:property value="id" escapeJavaScript="true" />';
	jQuery("#editarRevision"+id3).validationEngine();
</s:iterator>
jQuery("#crearCliente").validationEngine();
jQuery("#crearVehiculo").validationEngine();
jQuery("#crearRevision").validationEngine();
$("#fecha").datepicker();
$("#hora").timepicker({});
$(".fecha").datepicker();
$(".hora").timepicker({});
	
$('.rut').Rut({
	on_error: function(){ alert('RUT incorrecto'); },
	format_on: 'keyup'
});

$('#rutCliente').blur(function(event){
	$.post('buscarClientePorRut', {
		rut : $('#rutCliente').val()
	}, function(json) {
		if(json == "OK"){
			alert("Ya existe un Cliente para el rut Ingresado");
		}
	}, "json");
	
});

$('#rutClienteVehiculo').blur(function(event){
	$.post('buscarClientePorRut', {
		rut : $('#rutClienteVehiculo').val()
	}, function(json) {
		if(json != "OK"){
			alert("No existe un Cliente para el rut ingresaro, primero ingrese el Cliente");
		}
	}, "json");
	
});

$('#patenteVehiculo').blur(function(event){
	$.post('buscarVehiculoPorPatente', {
		patente : $('#patenteVehiculo').val()
	}, function(json) {
		if(json == "OK"){
			alert("Ya existe un Vehiculo para la Patente ingresada");
		}
	}, "json");
	
});

$('#patenteVehiculo2').blur(function(event){
	$.post('buscarVehiculoPorPatente', {
		patente : $('#patenteVehiculo2').val()
	}, function(json) {
		if(json != "OK"){
			alert("No existe la Patente ingresa en la Base de datos. Antes tiene que ingresarla o probar con otra");
		}
	}, "json");
	
});

function pdf(id) {
	window.open(
				'fichaServicioReport?'
						+'&revisionId='+id+''
						);
	
}

</script>
				