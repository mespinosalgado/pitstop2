<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/timepicker.css" />

<div id="page-wrapper">
	<div class="row">
        <div class="col-lg-12">
          <h1>Registro Revisiones</h1>
          	<ol class="breadcrumb">
            	<li><a href="<s:url action="Menu"/>"><i class="fa fa-tachometer"></i> Menú</a></li>
       			<li class="active"><i class="fa fa-street-view"></i> Revisión</li>
     		</ol>
   		</div>
 	</div>
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-car"></i>&nbsp; Registro de Revisiones
					</h3>
				</div>
			       	<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-hover tablesorter" id="dataTables">										
								<thead>
									<tr class="active">
										<th width="110px">Cliente<i class="icon-sort"></i></th>
										<th width="110px">Patente<i class="icon-sort"></i></th>
										<th >Mecánico &nbsp;<i class="fa fa-sort-alpha-asc"></i><i class="icon-sort"></i></th>
										<th >Fecha<i class="icon-sort"></i></th>
										<th >Hora<i class="icon-sort"></i></th>
										<th >Aprobación<i class="icon-sort"></i></th>
										<th >Ficha<i class="icon-sort"></i></th>
										<th width="100px">Acción &nbsp;<i class="fa fa-cogs"></i><i class="icon-sort"></i></th>
									</tr>
									</thead>
									<s:iterator value="#session.revisiones" status="revisiones">
									<tr>
										<td class="info"><s:property value="vehiculo.cliente.rut" /></td>
										<td><s:property value="vehiculo.patente" /></td>
										<td><s:property value="empleado.rut" /></td>
										<td><s:property value="Fecha" /></td>
										<td><s:property value="Hora" /></td>
										<td><s:if test="aprobacion">
											SI
											</s:if>
											<s:else>
											NO
											</s:else>
										<!-- Single button -->
										<td><a href="javascript:void(0)" onclick="pdf(<s:property value="id" />)"
											style="width: 100px; text-align: center" class="Boto BotoH49 mTop10" title=""><span><i class="fa fa-file-pdf-o" aria-hidden="true"></i></span></a></td>
										<td >
										<div class="col-lg-2">
											<button type="button" class="btn btn-info"
												data-toggle="modal" style="margin-left: -15px"
												data-target="#udpRevision<s:property value="id" />"
												data-whatever="@mdo">
												<i class="fa fa-binoculars fa-fw"></i>&nbsp; Editar
											</button>
										</div>									 
										</td>
									</tr>
									</s:iterator>
								</table>
							</div>
							<!-- Vehiculo id -->
							<s:iterator value="#session.clientes" status="clientes"></s:iterator>
							<s:iterator value="#session.vehiculos" status="vehiculos"></s:iterator>
							<!-- Fin Vehiculo id -->
							<div class="col-lg-2">
									<button type="button" class="btn btn-success" data-toggle="modal" style="margin-left: -15px"
								data-target="#nuevoRevision" data-whatever="@mdo"><i class="fa fa-cog fa-lg"></i>&nbsp; Nuevo</button>
							</div>	
						</div>
					
				<!-- Agregar nuevo Revision -->	
								
				<div class="modal fade" id="nuevoRevision" tabindex="-1" role="dialog" aria-labelledby="nuevoRevision" aria-hidden="true">
  						<div class="modal-dialog">
    						<div class="modal-content">
      							<div class="modal-header">
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        							<h4 class="modal-title" id="nuevoRevision">Nueva Revisión</h4>
      							</div>
      							<div class="modal-body">
        							<s:form id="crearRevision" action="crearRevision" namespace="/intranet">
										<div class="form-group">
											<label for="nombre" class="control-label" class="label">Patente</label>
											<input class="form-control  validate[required] text-input" name="patente" id="patenteVehiculo2" />
										</div>
										<div class="form-group">
											<label for="nombre" class="control-label" class="label">Mecánico</label>
											<select class="form-control validate[required] text-input" id="mecanico" name="mecanicoId">
												<option value>-- Seleccionar --</option>
													<s:iterator value="#session.mecanicos" status="mecanicos">
														<option value="<s:property value="id" />"><s:property value="Rut" /> | Nombre: <s:property value="nombre" /> <s:property value="apellidos" /></option>
													</s:iterator>
											</select>
										</div>
										<div class="form-group">
											<label for="direccion" class="ontrol-label" class="label">Fecha</label>
											<input class="form-control  validate[required] text-input" name="fecha" id="fecha" />
										</div>
										<div class="form-group">
											<label for="cargo" class="control-label" class="label">Hora</label>
											<input class="form-control  validate[required] text-input timepicker" type="time" name="hora" id="hora" />							
										</div>
										<div class="form-group">
											<label for="cargo" class="control-label" class="label">Observación</label>
											<textarea class="form-control  validate[required] text-input" name="observacion" id="observacion"></textarea>
										</div>
										<div class="modal-footer">
					        				<button type="submit" value="Crear" class="btn btn-primary btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Crear</button>				  
					      				</div>
									</s:form>										
					      		</div>	  
					    	</div>
					  	</div>
					</div>

					<!-- Fin Agregar nuevo Revision -->
					
					<!-- Editar nuevo Revision -->	
					<s:iterator value="#session.revisiones" status="revisiones">
						<div class="modal fade" id="udpRevision<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="udpRevision<s:property value="id" />" aria-hidden="true">
		  					<div class="modal-dialog">
	    						<div class="modal-content">
	      							<div class="modal-header">
	        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        							<h4 class="modal-title" id="editarRevision">Editar Revision</h4>
	      							</div>
	      							<div class="modal-body">
	        							<form id="editarRevision<s:property value="id" />" action="editarRevision" namespace="/intranet">
	        								<div class="form-group">
												<label for="nombre" class="control-label" class="label">Cliente</label>
												<input type="hidden" value="<s:property value="id" />" id="id" name="id">
												<input readonly="readonly" class="form-control  validate[required] text-input" name="patente" id="patenteVehiculo2" value="Rut: <s:property value="vehiculo.cliente.rut" />  | Nombre: <s:property value="vehiculo.cliente.nombre" /> <s:property value="vehiculo.cliente.apellidos" />"/>
											</div>
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Vehículo</label>
												<input readonly="readonly" class="form-control  validate[required] text-input" name="patente" id="patenteVehiculo2" value="Patente : <s:property value="vehiculo.patente" /> | Marca: <s:property value="vehiculo.marca" /> | Modelo: <s:property value="vehiculo.modelo" />"/>
											</div>
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Mecánico</label>
												<select class="form-control validate[required] text-input selectpicker" id="mecanico" name="mecanicoId" data-live-search="true">
													<option value>-- Seleccionar --</option>
														<s:iterator value="#session.mecanicos" status="mecanicos">
															<s:if test="empleado.id == id">
																	<option selected="selected" value="<s:property value="id" />">Rut: <s:property value="Rut" /> | Nombre: <s:property value="nombre" /> <s:property value="apellidos" /></option>
															</s:if>
															<s:else>
																	<option value="<s:property value="id" />">Rut: <s:property value="Rut" /> | Nombre: <s:property value="nombre" /> <s:property value="apellidos" /></option>
															</s:else>
														</s:iterator>
												</select>
											</div>
											<div class="form-group">
											<label for="direccion" class="ontrol-label" class="label">Aprobación</label>
												<select class="form-control validate[required] text-input" id="aprobacion" name="aprobacion">
													<s:if test="aprobacion">
														<option selected="selected" value="true">SI</option>
														<option  value="false">NO</option>
													</s:if>
													<s:else>
														<option  value="true">SI</option>
														<option selected="selected" value="false">NO</option>
													</s:else>
												</select>
											</div>
											<div class="form-group">
												<label for="direccion" class="ontrol-label" class="label">Fecha</label>
												<input class="form-control  validate[required] text-input fecha" name="fecha" id="fecha" value="<s:property value="fecha" />"/>
											</div>
											<div class="form-group">
												<label for="cargo" class="control-label" class="label">Hora</label>
												<input class="form-control  validate[required] text-input timepicker hora" name="hora" id="hora" value="<s:property value="hora" />"/>							
											</div>
											<div class="form-group">
												<label for="cargo" class="control-label" class="label">Observación</label>
												<textarea class="form-control  validate[required] text-input" name="observacion" id="observacion"><s:property value="observacion" /></textarea>
											</div>
											<div class="modal-footer">
						        				<button type="submit" value="Editar" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Actualizar </button>
						      				</div>
										</form>										
						      		</div>	  
						    	</div>
						  	</div>
						</div>
					</s:iterator>				

					<!-- Fin Editar nuevo Revision -->
						
      		</div>
    	</div>
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
				