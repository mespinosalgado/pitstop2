<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/timepicker.css" />

<div id="page-wrapper">
	<div class="row">
        <div class="col-lg-12">
          <h1>Registro de Vehículos</h1>
          	<ol class="breadcrumb">
            	<li><a href="<s:url action="Menu"/>"><i class="fa fa-tachometer"></i> Menú</a></li>
       			<li class="active"><i class="fa fa-car"></i> Registro Vehículo</li>
     		</ol>
   		</div>
 	</div><!-- /.row -->
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-car"></i>&nbsp; Registro de Vehículos
					</h3>
				</div>
			    <!-- Inicio Registro vehículo -->   
			     <div class="panel-body">
					<div class="table-responsive">
							<table class="table table-hover tablesorter" id="dataTables">
								<thead>
									<tr class="active">
										<th width="110px">Rut Cliente<i class="icon-sort"></i></th>
										<th >Patente &nbsp;<i class="fa fa-sort-alpha-asc"></i><i class="icon-sort"></i></th>
										<th >Marca<i class="icon-sort"></i></th>
										<th >Modelo<i class="icon-sort"></i></th>
										<th >Kms<i class="icon-sort"></i></th>
										<th >Año<i class="icon-sort"></i></th>
										<th width="100px">Acción &nbsp;<i class="fa fa-cogs"></i><i class="icon-sort"></i></th>
									</tr>
								</thead>
								<s:iterator value="#session.vehiculos" status="vehiculos">
									<tr>
										<td class="info"><s:property value="cliente.rut" /></td>
										<td><s:property value="patente" /></td>
										<td><s:property value="marca" /></td>
										<td><s:property value="modelo" /></td>
										<td><s:property value="kilometraje" /></td>
										<td><s:property value="ano" /></td>
										<!-- Single button -->
										<td >
											<div class="col-lg-2">
												<button type="button" class="btn btn-info btn-xs"
														data-toggle="modal" style="margin-left: -15px"
														data-target="#udpVehiculo<s:property value="id" />"
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
										data-target="#nuevoVehiculo" data-whatever="@mdo"><i class="fa fa-car fa-lg"></i>&nbsp; Nuevo</button>						
								</div>
								
								
								<s:iterator value="#session.clientes" status="clientes"></s:iterator>
								<s:iterator value="#session.revisiones" status="revisiones"></s:iterator>
									
									
						</div>	
					<!-- Agregar nuevo Vehiculo -->							
					<div class="modal fade" id="nuevoVehiculo" tabindex="-1" role="dialog" aria-labelledby="nuevoVehiculo" aria-hidden="true">
  						<div class="modal-dialog">
    						<div class="modal-content">
      							<div class="modal-header">
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        							<h4 class="modal-title" id="nuevoVehiculo">Nuevo Vehículo</h4>
      							</div>
      							<div class="modal-body">
        							<s:form id="crearVehiculo" action="crearVehiculo" namespace="/intranet">
									   <div class="form-group">
											<label for="rut" class="control-label">Rut Cliente: </label>
        									<input type="text" class="form-control  validate[required] text-input rut" id="rutClienteVehiculo" name="rut">
           								</div>
           								<!-- Select 
           								<div class="form-group">
           								<label for="rut" class="control-label">Rut Cliente: </label>
           								<select class="form-control validate[required] text-input selectpicker rut" id="rutClienteVehiculo" name="rut" data-live-search="true">
										<option >-- Selecionar --</option>
											<s:iterator value="#session.clientes" status="clientes">
											<s:if test="cliente.id == id">
													<option selected="selected" value="<s:property value="id" />"><s:property value="Rut" /></option>
											</s:if>
											<s:else>
													<option value="<s:property value="id" />"><s:property value="Rut" /></option>
											</s:else>
											</s:iterator>
										</select>
										</div> 
           								 fin Select -->
										<div class="form-group">
											<label for="nombre" class="control-label" class="label">Patente</label>
											<input class="form-control  validate[required] text-input" name="patente" id="patenteVehiculo" />
										</div>
										<div class="form-group">
											<label for="apellidos" class="control-label" class="label">Marca</label>
											<input class="form-control  validate[required] text-input" name="marca" id="marca" />
										</div>
										<div class="form-group">
											<label for="direccion" class="ontrol-label" class="label">Modelo</label>
											<input class="form-control  validate[required] text-input" name="modelo" id="modelo" />
										</div>
										<div class="form-group">
											<label for="cargo" class="control-label" class="label">Año</label>
											<input class="form-control  validate[required] text-input" name="ano" id="ano" />							
										</div>
										<div class="form-group">
											<label for="cargo" class="control-label" class="label">Kilometraje</label>
											<input class="form-control text-input" name="kilometraje" id="kilometraje" />							
										</div>
										<div class="modal-footer">
					        				<button type="submit" value="Crear" class="btn btn-primary btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Crear</button>			        				
					      				</div>
									</s:form>										
					      		</div>	  
					    	</div>
					  	</div>
					</div>
					<!-- Fin Agregar nuevo Vehiculo -->
					<!-- Editar nuevo Vehiculo -->	
					<s:iterator value="#session.vehiculos" status="vehiculos">
						<div class="modal fade" id="udpVehiculo<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="udpVehiculo<s:property value="id" />" aria-hidden="true">
	  						<div class="modal-dialog">
	    						<div class="modal-content">
	      							<div class="modal-header">
	        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        							<h4 class="modal-title" id="udpVehiculo<s:property value="id" />">Editar Cliente</h4>
	      							</div>
	      							<div class="modal-body">
	        							<form id="editarVehiculo<s:property value="patenteFormat" />" action="editarVehiculo" namespace="/intranet">
											<div class="form-group">
												<label for="rut" class="control-label">Rut: </label>
												<input type="hidden" value="<s:property value="id" />" id="id" name="id">
	        									<input type="text" value="<s:property value="cliente.rut" />" disabled="disabled" class="form-control  validate[required] text-input rut" id="rut" name="rut">
	           								</div>
	           								<!-- fin CONTROL -->
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Patente</label>
												<input class="form-control validate[required] text-input" disabled="disabled" name="patente" id="patente" value="<s:property value="patente" />"/>
											</div>
											<div class="form-group">
												<label for="apellidos" class="control-label" class="label">Marca</label>
												<input class="form-control  validate[required] text-input" name="marca" id="marca" value="<s:property value="marca" />" />
											</div>
											<div class="form-group">
												<label for="direccion" class="ontrol-label" class="label">Modelo</label>
												<input class="form-control  validate[required] text-input" name="modelo" id="modelo" value="<s:property value="modelo" />" />
											</div>
											<div class="form-group">
												<label for="cargo" class="control-label" class="label">Año</label>
												<input class="form-control  validate[required] text-input" name="ano" id="ano" value="<s:property value="ano" />" />							
											</div>
											<div class="form-group">
												<label for="celular" class="control-label" class="label">Kilometraje</label>
												<input class="form-control  text-input" name="kilometraje" id="kilometraje" value="<s:property value="kilometraje" />" />
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
					<!-- Fin Editar nuevo Vehiculo -->			       
			     </div>
			   </div>
			   <!-- Fin Registro Vehiculo -->		  
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

</script>


				