
<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<div id="page-wrapper">
		<div class="row">
          <div class="col-lg-12">
            <h1>Empleados</h1>
            <ol class="breadcrumb">
              <li><a href="<s:url action="Menu"/>"><i class="fa fa-tachometer"></i> Menú</a></li>
              <li class="active"><i class="fa fa-users"></i> Empleados</li>
            </ol>
          </div>
        </div><!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-users fa-lg"></i>&nbsp; Lista de Empleados
						</h3>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-hover tablesorter" id="dataTables">
								<thead>
								<tr class="active">
									<th width="100px">Rut<i class="icon-sort"></i></th>
									<th width="200px">Nombre &nbsp;<i class="fa fa-sort-alpha-asc"></i><i class="icon-sort"></i></th>
									<th width="200px">Cargo<i class="icon-sort"></i></th>
									<th width="100x">Usuario<i class="icon-sort"></i></th>
									<th width="100px">Jornada<i class="icon-sort"></i></th>
									<th width="100px">Acción &nbsp;<i class="fa fa-cogs"></i><i class="icon-sort"></i></th>
								</tr>
								</thead>
								<s:iterator value="#session.empleados" status="empleados">
								<tr>
									<td class="info"><s:property value="rut" /></td>
									<td><s:property value="nombre" /> <s:property value="apellidos" /></td>
									<td><s:property value="cargo" /></td>
									<td><s:if test="usuario != null">
											<s:property value="usuario.role.roleName" />
										</s:if>
										<s:else>
											No Asignado
										</s:else> 
									</td>
									<td><s:property value="jornada" /></td>
									<!-- Single button -->
									<td >
									 <div class="btn-group" role="group">
									    <button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									    <i class="fa fa-user fa-fw"></i>
									      Opciones
									      <span class="caret"></span>
									    </button>
									    <ul class="dropdown-menu">
											<li><a href="#" data-toggle="modal" data-target="#seeEmpleado<s:property value="id" />" data-whatever="@mdo"><i class="fa fa-binoculars fa-fw"></i>&nbsp;Ver</a></li>
										    <li><a href="#" data-toggle="modal" data-target="#udpEmpleado<s:property value="id" />" data-whatever="@mdo"><i class="fa fa-pencil fa-fw"></i>&nbsp;Editar</a></li>
										    <li><a href="<%=request.getContextPath()%>/intranet/delEmpleado?empleadoId=<s:property value='id' />" ><i class="fa fa-trash-o fa-fw"></i> Eliminar</a></li>
										    <s:if test="usuario != null">
										    	<s:if test="estado == true">
										    		<li><a href="<%=request.getContextPath()%>/intranet/bloqueaEmpleado?empleadoId=<s:property value='id' />" ><i class="fa fa-ban fa-fw"></i> Bloquear</a></li>
										    	</s:if>
										    	<s:else>
										    		<li><a href="<%=request.getContextPath()%>/intranet/desbloqueaEmpleado?empleadoId=<s:property value='id' />" ><i class="fa fa-ban fa-fw"></i> DesBloquear</a></li>
										    	</s:else>
										    </s:if>
										    <li class="divider"></li>
										    <s:if test="usuario == null">
										    	<li><a href="#" data-toggle="modal" data-target="#creaUsuario<s:property value="id" />" data-whatever="@mdo"><i class="i"></i>Hacer usuario</a></li>
										    </s:if>
										    <s:else>
										    	<li><a href="#" data-toggle="modal" data-target="#verUsuario<s:property value="id" />" data-whatever="@mdo"><i class="i"></i>Editar/Ver usuario</a></li>
										    </s:else>
										  </ul>
									  </div>
									</td>
								</tr>
								</s:iterator>
							</table>
						</div>
						<div class="col-lg-2">
								<button type="button" class="btn btn-success" data-toggle="modal" style="margin-left: -15px"
								data-target="#nuevoEmpleado" data-whatever="@mdo"><i class="fa fa-user-plus fa-lg"></i>&nbsp; Nuevo</button>
						</div>
					</div>
					
					<!-- Agregar neuevo Empleado -->	
									
					<div class="modal fade" id="nuevoEmpleado" tabindex="-1" role="dialog" aria-labelledby="nuevoEmpleado" aria-hidden="true">
  						<div class="modal-dialog">
    						<div class="modal-content">
      							<div class="modal-header">
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        							<h4 class="modal-title" id="nuevoEmpleado">Nuevo Empleado</h4>
      							</div>
      							<div class="modal-body">
        							<s:form id="crearEmpleado" action="crearEmpleado" namespace="/intranet">
										<div class="form-group">
											<label for="rut" class="control-label">Rut: </label>
        									<input type="text" class="form-control  validate[required] text-input rut" id="rut" name="rut">
           								</div>
           								<!-- SELECT CONTROL -->
           								<div class="form-group">
           								<label for="sucursal" class="control-label">Sucursal: </label>
										<select class="form-control validate[required] text-input" id="sucursal" name="sucursalId">
											<option value>-- Selecionar --</option>
												<s:iterator value="#session.sucursales" status="sucursales">
													<option value="<s:property value="id" />"><s:property value="nombreSucursal" /></option>
												</s:iterator>
										</select>
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
											<label for="direccion" class="ontrol-label" class="label">Dirección</label>
											<input class="form-control  validate[required] text-input" name="direccion" id="direccion" />
										</div>
										<div class="form-group">
											<label for="cargo" class="control-label" class="label">Cargo</label>
											<input class="form-control  validate[required] text-input" name="cargo" id="cargo" />							
										</div>
										<div class="form-group">
											<label for="celular" class="control-label" class="label">Celular</label>
											<input class="form-control  validate[required] text-input" name="celular" id="celular" />
										</div>
										<div class="form-group">
											<label for="jornada" class="control-label" class="label">Jornada</label>										
											<input class="form-control  validate[required] text-input" name="jornada" id="jornada" />
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
					
					<s:iterator value="#session.empleados" status="empleados">
						<div class="modal fade" id="udpEmpleado<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="udpEmpleado<s:property value="id" />" aria-hidden="true">
	  						<div class="modal-dialog">
	    						<div class="modal-content">
	      							<div class="modal-header">
	        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        							<h4 class="modal-title" id="udpEmpleado">Editar Empleado</h4>
	      							</div>
	      							<div class="modal-body">
	        							<form id="udpEmpleado<s:property value="rutFormat" />" action="updEmpleado" namespace="/intranet">
											<div class="form-group">
												<label for="rut" class="control-label">Rut: </label>
												<input type="hidden"  id="empleadoId" name="empleadoId" value="<s:property value="id" />">
	        									<input type="text" class="form-control validate[required] text-input rut" id="rut" name="rut" value="<s:property value="rut" />">
	           								</div>
	           								<!-- SELECT CONTROL -->
	           								<div class="form-group">
	           								<label for="sucursal" class="control-label">Sucursal: </label>
											<select class="form-control validate[required] text-input" id="sucursal" name="sucursalId" class="form-control">
												<option value>-- Selecionar --</option>
												<s:iterator value="#session.sucursales" status="sucursales">
													<s:if test="sucursal.id == id">
														<option selected="selected" value="<s:property value="id" />"><s:property value="nombreSucursal" /></option>
													</s:if>
													<s:else>
														<option value="<s:property value="id" />"><s:property value="nombreSucursal" /></option>
													</s:else>
												</s:iterator>
											</select>
											</div>
	   										<!-- fin CONTROL -->
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Nombre</label>
												<input class="form-control validate[required] text-input" name="nombre" id="nombre" value="<s:property value="nombre"/>" />
											</div>
											<div class="form-group">
												<label for="apellidos" class="control-label" class="label">Apellidos</label>
												<input class="form-control validate[required] text-input" name="apellidos" id="apellidos" value="<s:property value="apellidos"/>"/>
											</div>
											<div class="form-group">
												<label for="direccion" class="ontrol-label" class="label">Dirección</label>
												<input class="form-control validate[required] text-input" name="direccion" id="direccion" value="<s:property value="direccion"/>" />
											</div>
											<div class="form-group">
												<label for="cargo" class="control-label" class="label">Cargo</label>
												<input class="form-control validate[required] text-input" name="cargo" id="cargo" value="<s:property value="cargo"/>" />							
											</div>
											<div class="form-group">
												<label for="celular" class="control-label" class="label">Celular</label>
												<input class="form-control validate[required] text-input" name="celular" id="celular" value="<s:property value="celular"/>"/>
											</div>
											<div class="form-group">
												<label for="jornada" class="control-label" class="label">Jornada</label>										
												<input class="form-control validate[required] text-input" name="jornada" id="jornada" value="<s:property value="jornada"/>" />
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
				    
				    <!-- Crear Usuario -->	
				    <s:iterator value="#session.empleados" status="empleados">
						<div class="modal fade" id="creaUsuario<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="creaUsuario<s:property value="id" />" aria-hidden="true">
	  						<div class="modal-dialog">
	    						<div class="modal-content">
	      							<div class="modal-header">
	        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        							<h4 class="modal-title" id="creaUsuario">Crear Usuario</h4>
	      							</div>
	      							<div class="modal-body">
	        							<form id="creaUsuario<s:property value="rutFormat" />" action="creaUsuario" namespace="/intranet">
											<div class="form-group">
												<input type="hidden"  id="empleadoId" name="empleadoId" value="<s:property value="id" />">
	        								</div>
	           								<!-- SELECT CONTROL -->
	           								<div class="form-group">
	           								<label for="sucursal" class="control-label">Rol: </label>
											<select class="form-control validate[required] text-input" id="tol" name="rolId" class="form-control">
												<option value>-- Selecionar --</option>
												<s:iterator value="#session.roles" status="roles">
													<option value="<s:property value="id" />"><s:property value="roleName" /></option>
												</s:iterator>
											</select>
											</div>
	   										<!-- fin CONTROL -->
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Usuario</label>
												<input class="form-control validate[required] text-input" name="userName" id="userName"/>
											</div>
											<div class="form-group">
												<label for="apellidos" class="control-label" class="label">* Recordar que la contraseña se crea por defecto a los usuarios Nuevos y es "newUser2016", esta puede ser cambiada desde Administrador/Perfil</label>
											</div>
											<div class="modal-footer">
						        				<button type="submit" value="Crear" class="btn btn-primary btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Crear</button>
						        				
						      				</div>
										</form>										
						      		</div>	  
						    	</div>
						  	</div>
						</div>
					</s:iterator>		
					

					<!-- Fin crear Usuario -->
					
					 <!-- Editar/Ver Usuario -->	
				    <s:iterator value="#session.empleados" status="empleados">
						<div class="modal fade" id="verUsuario<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="verUsuario<s:property value="id" />" aria-hidden="true">
	  						<div class="modal-dialog">
	    						<div class="modal-content">
	      							<div class="modal-header">
	        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        							<h4 class="modal-title" id="verUsuario">Editar/Ver Usuario</h4>
	      							</div>
	      							<div class="modal-body">
	        							<form id="editarUsuario<s:property value="rutFormat" />" action="editarUsuario" namespace="/intranet">
											<div class="form-group">
												<input type="hidden"  id="empleadoId" name="empleadoId" value="<s:property value="id" />">
												<input type="hidden"  id="usuarioId" name="usuarioId" value="<s:property value="usuario.id" />">
	        								</div>
	           								<!-- SELECT CONTROL -->
	           								<div class="form-group">
	           								<label for="sucursal" class="control-label">Rol: </label>
											<select class="form-control validate[required] text-input" id="tol" name="rolId" class="form-control">
												<option value>-- Selecionar --</option>
												<s:iterator value="#session.roles" status="roles">
													<s:if test="usuario.role.id == id">
														<option selected="selected" value="<s:property value="id" />"><s:property value="roleName" /></option>
													</s:if>
													<s:else>
														<option value="<s:property value="id" />"><s:property value="roleName" /></option>
													</s:else>
												</s:iterator>
											</select>
											</div>
	   										<!-- fin CONTROL -->
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Usuario</label>
												<input class="form-control validate[required] text-input" name="userName" id="userName" value="<s:property value="usuario.userName" />"/>
											</div>
											<div class="form-group">
												<label for="apellidos" class="control-label" class="label">* Recordar que la contraseña se crea por defecto a los usuarios Nuevos y es "newUser2016", esta puede ser cambiada desde Administrador/Perfil</label>
											</div>
											<div class="modal-footer">
						        				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						        				<input type="submit" value="Editar" class="btn btn-primary">
						      				</div>
										</form>										
						      		</div>	  
						    	</div>
						  	</div>
						</div>
					</s:iterator>		
					

					<!-- Fin Editar/Ver Usuario -->
					
					<!-- Ver Empleado -->	
					<s:iterator value="#session.empleados" status="empleados">
						<div class="modal fade" id="seeEmpleado<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="seeEmpleado<s:property value="id" />" aria-hidden="true">
	  						<div class="modal-dialog">
	    						<div class="modal-content">
	      							<div class="modal-header">
	        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        							<h4 class="modal-title" id="seeEmpleado">Ver Empleado</h4>
	      							</div>
	      							<div class="modal-body">
	        							<s:form action="seeEmpleado" namespace="/admin">
											<div class="form-group">
												<label for="rut" class="control-label">Rut: </label>
	        									<input type="text" class="form-control" id="rut" name="rut" value="<s:property value="rut" />">
	           								</div>
	           								<!-- SELECT CONTROL -->
	           								<div class="form-group">
	           									<label for="sucursal" class="control-label">Sucursal: </label>
												<input type="text" class="form-control" id="sucursal" name="sucursal" value="<s:property value="sucursal.nombreSucursal" />">
											</div>
	   										<!-- fin CONTROL -->
											<div class="form-group">
												<label for="nombre" class="control-label" class="label">Nombre</label>
												<input class="form-control" name="nombre" id="nombre" value="<s:property value="nombre"/>" />
											</div>
											<div class="form-group">
												<label for="apellidos" class="control-label" class="label">Apellidos</label>
												<input class="form-control" name="apellidos" id="apellidos" value="<s:property value="apellidos"/>"/>
											</div>
											<div class="form-group">
												<label for="direccion" class="ontrol-label" class="label">Direccion</label>
												<input class="form-control" name="direccion" id="direccion" value="<s:property value="direccion"/>" />
											</div>
											<div class="form-group">
												<label for="cargo" class="control-label" class="label">Cargo</label>
												<input class="form-control" name="cargo" id="cargo" value="<s:property value="cargo"/>" />							
											</div>
											<div class="form-group">
												<label for="celular" class="control-label" class="label">Celular</label>
												<input class="form-control" name="celular" id="celular" value="<s:property value="celular"/>"/>
											</div>
											<div class="form-group">
												<label for="jornada" class="control-label" class="label">Jornada</label>										
												<input class="form-control" name="jornada" id="jornada" value="<s:property value="jornada"/>" />
											</div>
	
											<div class="form-group">
												<label for="correo" class="control-label" class="label">Correo</label>											
												<input class="form-control" name="correo" id="correo" value="<s:property value="correo"/>"/>
											</div>
											<div class="modal-footer">
						        				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						      				</div>
										</s:form>										
						      		</div>	  
						    	</div>
						  	</div>
						</div>
					</s:iterator>				
					

					<!-- Fin ver Empleado -->
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
		<s:iterator value="#session.empleados" status="empleados">
			var id = <s:property value="rutFormat" />;
				jQuery("#udpEmpleado"+id).validationEngine();
				jQuery("#creaUsuario"+id).validationEngine();
				jQuery("#editarUsuario"+id).validationEngine();
		</s:iterator>
			jQuery("#crearEmpleado").validationEngine();
			
			$('.rut').Rut({
				on_error: function(){ alert('RUT incorrecto'); },
				format_on: 'keyup'
			});
			
			function delEmpleado(id){
				
			}
		</script>
		
		
		