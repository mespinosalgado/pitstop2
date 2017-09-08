<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<div id="page-wrapper">
		<div class="row">
          <div class="col-lg-12">
            <h1>Servicios</h1>
            <ol class="breadcrumb">
              <li><a href="<s:url action="Menu"/>"><i class="fa fa-tachometer"></i> Menú</a></li>
              <li class="active"><i class="fa fa-wrench fa-lg"></i> Servicios</li>
            </ol>
          </div>
        </div><!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-wrench fa-lg"></i>&nbsp; Lista de Servicios
						</h3>
					</div>
					<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-hover tablesorter" id="dataTables">
									<thead>
									<tr class="active">
										<th>Servicio &nbsp;<i class="fa fa-sort-alpha-asc" class="icon-sort"></i></th>
										<th width="100px">Valor &nbsp;<i class="fa fa-sort-numeric-desc" class="icon-sort"></i></th>
										<th width="150px">Acción &nbsp;<i class="fa fa-cogs"></i></th>
									</tr>
									</thead>
									<s:iterator value="#session.servicios" status="servicios">
									<tr>
										<td class="info"><s:property value="nombreServicio" /></td>
										<td><i class="fa fa-usd">&nbsp;</i><s:property value="valorServicio" /></td>
										<!-- Single button -->
										<td >
										<div class="col-lg-2">
												<button type="button" class="btn btn-info"
													data-toggle="modal" style="margin-left: -15px"
													data-target="#udpServicio<s:property value="id" />"
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
									data-target="#nuevoServicio" data-whatever="@mdo"><i class="fa fa-wrench fa-lg"></i>&nbsp; Nuevo</button>
						 	</div>
					</div>
					
					<!-- Agregar neuevo Servicio -->	
									
					<div class="modal fade" id="nuevoServicio" tabindex="-1" role="dialog" aria-labelledby="nuevoServicio" aria-hidden="true">
  						<div class="modal-dialog">
    						<div class="modal-content">
      							<div class="modal-header">
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        							<h4 class="modal-title" id="nuevoServicio">Nuevo Servicio</h4>
      							</div>
      							<div class="modal-body">
        							<s:form id="crearServicio" action="crearServicio" namespace="/admin">
										<div class="form-group">
											<label for="nombreServicio" class="control-label" class="label">Nombre Servicio</label>
											<input class="form-control validate[required] text-input" name="nombreServicio" id="nombreServicio" />
										</div>
										<div class="form-group">
											<label for="valorServicio" class="control-label" class="valorServicio">Valor</label>
											<input class="form-control validate[required] text-input" type="number" name="valorServicio" id="valorServicio" />
										</div>
										<div class="modal-footer">
					        				<button type="submit" value="Guardar" class="btn btn-primary btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Crear</button>
					      				</div>
									</s:form>										
					      		</div>	  
					    	</div>
					  	</div>
					</div>

					<!-- Fin Agregar neuevo Servicio -->	
					
					
					<!-- Editar Servicio -->	
					<s:iterator value="#session.servicios" status="servicios">				
					<div class="modal fade" id="udpServicio<s:property value="id" />" tabindex="-1" role="dialog" aria-labelledby="udpServicio<s:property value="id" />" aria-hidden="true">
  						<div class="modal-dialog">
    						<div class="modal-content">
      							<div class="modal-header">
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        							<h4 class="modal-title" id="udpServicio<s:property value="id" />">Editar Servicio</h4>
      							</div>
      							<div class="modal-body">
        							<form id="updServicio<s:property value="id" />" action="updServicio" namespace="/admin">
										<div class="form-group">
											<input type="hidden" name="servicioId" value="<s:property value="id" />">
											<label for="nombreServicio" class="control-label" class="label">Nombre Servicio</label>
											<input class="form-control validate[required] text-input" value="<s:property value="nombreServicio" />" name="nombreServicio" id="nombreServicio" />
										</div>
										<div class="form-group">
											<label for="valorServicio"  class="control-label" class="valorServicio">Valor</label>
											<input class="form-control validate[required] text-input" type="number"  value="<s:property value="valorServicio" />" name="valorServicio" id="valorServicio" />
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
					<!-- Fin editar Servicio -->
					</div>
				</div>
			</div>
		</div>
		
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/validationEngine.jquery.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/template.css" />
		<script src="<%=request.getContextPath()%>/resources/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		
		<s:iterator value="#session.servicios" status="servicios">	
			var id = <s:property value="id" />;
				jQuery("#updServicio"+id).validationEngine();
		</s:iterator>
		
		jQuery("#crearServicio").validationEngine();
			
			
		</script>
