
<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<div id="page-wrapper">
		<div class="row">
          <div class="col-lg-12">
            <h1>Proveedores</h1>
            <ol class="breadcrumb">
              <li><a href="<s:url action="Menu"/>"><i class="fa fa-tachometer"></i> Menú</a></li>
              <li class="active"><i class="fa fa-truck fa-fw"></i> Proveedores</li>
            </ol>
          </div>
        </div><!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-truck fa-lg"></i>&nbsp; Lista de Proveedores
						</h3>
					</div>
					<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-hover tablesorter" id="dataTables">
									<thead>
									<tr class="active">
										<th width="150px">Rut<i class="icon-sort"></i></th>
										<th >Nombre &nbsp;<i class="fa fa-sort-alpha-asc"></i><i class="icon-sort"></i></th>
										<th >Teléfono<i class="icon-sort"></i></th>
										<th >Correo<i class="icon-sort"></i></th>
										<th width="100px">Acción &nbsp;<i class="fa fa-cogs"></i><i class="icon-sort"></i></th>
									</tr>
									</thead>
									<s:iterator value="#session.proveedores" status="proveedores">
									<tr>
										<td class="info"><s:property value="rutEmpresa" /></td>
										<td><s:property value="nombre" /></td>
										<td><s:property value="telefono" /></td>
										<td><s:property value="correo" /></td>
										<!-- Single button -->
										<td >
										<div class="col-lg-2">
											<button type="button" class="btn btn-info" data-toggle="modal" style="margin-left: -15px"
											data-target="#udpProveedor<s:property value="id" />" data-whatever="@mdo"><i class="fa fa-pencil fa-lg"></i>&nbsp; Editar</button>
										</div>			 
										</td>
									</tr>
									</s:iterator>
								</table>
							</div>
							<div class="col-lg-2">
									<button type="button" class="btn btn-success" data-toggle="modal" style="margin-left: -15px"
									data-target="#nuevoProveedor" data-whatever="@mdo"><i class="fa fa-truck fa-lg"></i>&nbsp; Nuevo</button>
							</div>
					</div>
					
					<!-- Agregar neuevo Proveedor -->	
									
					<div class="modal fade" id="nuevoProveedor" tabindex="-1" role="dialog" aria-labelledby="nuevoProveedor" aria-hidden="true">
  						<div class="modal-dialog">
    						<div class="modal-content">
      							<div class="modal-header">
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        							<h4 class="modal-title" id="nuevoProveedor">Nuevo Proveedor</h4>
      							</div>
      							<div class="modal-body">
        							<s:form id="crearProveedor" action="crearProveedor" namespace="/intranet">
										<div class="form-group">
											<label for="rut" class="control-label">Rut: </label>
        									<input type="text" class="form-control  validate[required] text-input rut" id="rut" name="rutEmpresa">
           								</div>
										<div class="form-group">
											<label for="nombre" class="control-label" class="label">Nombre</label>
											<input class="form-control  validate[required] text-input" name="nombre" id="nombre" />
										</div>
										<div class="form-group">
											<label for="apellidos" class="control-label" class="label">Teléfono</label>
											<input class="form-control  validate[required] text-input" name="telefono" id="telefono" />
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

					<!-- Fin Agregar neuevo Empleado -->	
					
					
					<!-- Editar Empleado -->	
					
					<s:iterator value="#session.proveedores" status="proveedores">
						<div class="modal fade" id="udpProveedor<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="udpProveedor<s:property value="id" />" aria-hidden="true">
	  						<div class="modal-dialog">
	    						<div class="modal-content">
	      							<div class="modal-header">
	        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        							<h4 class="modal-title" id="udpProveedor">Editar Proveedor</h4>
	      							</div>
	      							<div class="modal-body">
	        							<form id="udpProveedor<s:property value="rutFormat" />" action="udpProveedor" namespace="/intranet">
											<div class="form-group">
												<label for="rut" class="control-label">Rut: </label>
												<input type="hidden" name="id" value="<s:property value="id" />">
												<input type="text" class="form-control validate[required] text-input rut" id="rutEmpresa" name="rutEmpresa" value="<s:property value="rutEmpresa" />">
	           								</div>
	           								
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Nombre</label>
												<input class="form-control validate[required] text-input" name="nombre" id="nombre" value="<s:property value="nombre"/>" />
											</div>
											<div class="form-group">
												<label for="apellidos" class="control-label" class="label">Teléfono</label>
												<input class="form-control validate[required] text-input" name="telefono" id="telefono" value="<s:property value="telefono"/>"/>
											</div>
											<div class="form-group">
												<label for="correo" class="control-label" class="label">Correo</label>											
												<input class="form-control validate[custom[email],required] text-input" name="correo" id="correo" value="<s:property value="correo"/>"/>
											</div>
											<div class="modal-footer">
						        				<button type="submit" value="Actualizar" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Actualizar</button>											
						      				</div>
										</form>										
						      		</div>	  
						    	</div>
						  	</div>
						</div>
					</s:iterator>
					
					<!-- Fin editar Empleado -->
				    
				  </div>
				</div>
			</div>
		</div>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/validationEngine.jquery.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/template.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/font-awesome/css/font-awesome.min.css" />
		<script src="<%=request.getContextPath()%>/resources/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.Rut.js" type="text/javascript"></script>
		<script type="text/javascript">
		<s:iterator value="#session.proveedores" status="proveedores">
			var id = <s:property value="rutFormat" />;
				jQuery("#udpProveedor"+id).validationEngine();
		</s:iterator>
			jQuery("#crearProveedor").validationEngine();
			
			$('.rut').Rut({
				on_error: function(){ alert('RUT incorrecto'); },
				format_on: 'keyup'
			});
		</script>
		