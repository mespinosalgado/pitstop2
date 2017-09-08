<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1>Productos</h1>
			<ol class="breadcrumb">
				<li><a href="<s:url action="Menu"/>"><i
						class="fa fa-tachometer"></i> Menú</a></li>
				<li class="active"><i class="fa fa-tags"></i> Productos</li>
			</ol>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-tags fa-lg"></i>&nbsp; Lista de Productos
					</h3>
					<div class="pull-right">
					</div>
				</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-hover" id="dataTables"> 
							<thead>
								<tr class="active">
									<th>Código</th>
									<th>Descripción</th>
									<th>Tipo Producto</th>
									<th>Valor</th>
									<th>Stock</th>
									<th width="100px">Acción &nbsp;<i class="fa fa-cogs"></i><i
										class="icon-sort"></i></th>
								</tr>
							</thead>
								<s:iterator value="#session.productos" status="productos">
									<tr>
										<td class="warning"><s:property value="codigo" /></td>
										<td><s:property value="descripcion" /></td>
										<td><s:property value="tipoProd" /></td>
										<td><s:property value="valor" /></td>
										<td><s:property value="stock" /></td>
										<!-- Single button -->
										<td>
											<div class="col-lg-2">
												<button type="button" class="btn btn-info"
													data-toggle="modal" style="margin-left: -15px"
													data-target="#udpProducto<s:property value="id" />"
													data-whatever="@mdo">
													<i class="fa fa-pencil fa-lg"></i>&nbsp; Editar
												</button>
											</div>
										</td>
									</tr>
								</s:iterator>
							</table>
							<div class="col-lg-2">
								<button type="button" class="btn btn-success"
									data-toggle="modal" data-target="#nuevoProducto"
									data-whatever="@mdo">
									<i class="fa fa-tags fa-lg"></i>&nbsp; Nuevo
								</button>
							</div>
						
					</div>
				</div>

				<!-- Agregar neuevo Producto -->

				<div class="modal fade" id="nuevoProducto" tabindex="-1"
					role="dialog" aria-labelledby="nuevoProducto" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="nuevoProducto">Nuevo Producto</h4>
							</div>
							<div class="modal-body">
								<s:form id="crearProducto" action="crearProducto"
									namespace="/intranet">
									<!-- SELECT CONTROL -->
									<div class="form-group">
										<label for="sucursal" class="control-label">Proveedor:
										</label> <select class="form-control validate[required] text-input"
											id="proveedor" name="proveedorId">
											<option value>-- Selecionar --</option>
											<s:iterator value="#session.proveedores" status="proveedores">
												<option value="<s:property value="id" />"><s:property
														value="nombre" /></option>
											</s:iterator>
										</select>
									</div>
									<!-- fin CONTROL -->
									<!-- SELECT CONTROL -->
									<div class="form-group">
										<label for="sucursal" class="control-label">Sucursal:
										</label> <select class="form-control validate[required] text-input"
											id="sucursal" name="sucursalId">
											<option value>-- Selecionar --</option>
											<s:iterator value="#session.sucursales" status="sucursales">
												<option value="<s:property value="id" />"><s:property
														value="nombreSucursal" /></option>
											</s:iterator>
										</select>
									</div>
									<!-- fin CONTROL -->
									<div class="form-group">
										<label for="codigo" class="control-label" class="label">Código</label>
										<input class="form-control validate[required] text-input"
											name="codigo" id="codigo" />
									</div>
									<div class="form-group">
										<label for="descripcion" class="control-label" class="label">Descripción</label>
										<input class="form-control validate[required] text-input"
											name="descripcion" id="descripcion" />
									</div>
									<div class="form-group">
										<label for="tipoProd" class="control-label" class="label">Tipo
											Producto</label> <input
											class="form-control validate[required] text-input"
											name="tipoProd" id="tipoProd" />
									</div>
									<div class="form-group">
										<label for="valor" class="control-label" class="label">Valor</label>
										<input class="form-control validate[required] text-input"
											name="valor" id="valor" />
									</div>
									<div class="form-group">
										<label for="stock" class="control-label" class="label">Stock</label>
										<input class="form-control validate[required] text-input"
											name="stock" id="stock" />
									</div>
									<div class="modal-footer">
										<button type="submit" value="Crear" class="btn btn-primary btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Crear</button>
									</div>
								</s:form>
							</div>
						</div>
					</div>
				</div>

				<!-- Fin Agregar nuevo Producto -->

				<!-- editar nuevo Producto -->
				<s:iterator value="#session.productos" status="productos">
					<div class="modal fade" id="udpProducto<s:property value="id" />"
						tabindex="-1" role="dialog"
						aria-labelledby="udpProducto<s:property value="id" />"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title"
										id="udpProducto<s:property value="id" />">Nuevo Producto</h4>
								</div>
								<div class="modal-body">
									<form id="editarProducto<s:property value="id" />"
										action="editarProducto" namespace="/intranet">
										<!-- SELECT CONTROL -->
										<div class="form-group">
											<label for="sucursal" class="control-label">Proveedor:
											</label> <select class="form-control validate[required] text-input"
												id="proveedor" name="proveedorId">
												<option value>-- Selecionar --</option>
												<s:iterator value="#session.proveedores"
													status="proveedores">
													<s:if test="proveedor.id == id">
														<option selected="selected"
															value="<s:property value="id" />"><s:property
																value="nombre" /></option>
													</s:if>
													<s:else>
														<option value="<s:property value="id" />"><s:property
																value="nombre" /></option>
													</s:else>
												</s:iterator>
											</select>
										</div>
										<!-- fin CONTROL -->
										<!-- SELECT CONTROL -->
										<div class="form-group">
											<label for="sucursal" class="control-label">Sucursal:
											</label> <select class="form-control validate[required] text-input"
												id="sucursal" name="sucursalId">
												<option value>-- Selecionar --</option>
												<s:iterator value="#session.sucursales" status="sucursales">
													<s:if test="sucursal.id == id">
														<option selected="selected"
															value="<s:property value="id" />"><s:property
																value="nombreSucursal" /></option>
													</s:if>
													<s:else>
														<option value="<s:property value="id" />"><s:property
																value="nombreSucursal" /></option>
													</s:else>
												</s:iterator>
											</select>
										</div>
										<!-- fin CONTROL -->
										<div class="form-group">
											<label for="codigo" class="control-label" class="label">Código</label>
											<input type="hidden" name="id" id="id"
												value="<s:property value="id"/>" /> <input
												disabled="disabled"
												class="form-control validate[required] text-input"
												name="codigo" id="codigo"
												value="<s:property value="codigo"/>" />
										</div>
										<div class="form-group">
											<label for="descripcion" class="control-label" class="label">Descripción</label>
											<input class="form-control validate[required] text-input"
												name="descripcion" id="descripcion"
												value="<s:property value="descripcion"/>" />
										</div>
										<div class="form-group">
											<label for="tipoProd" class="control-label" class="label">Tipo
												Producto</label> <input
												class="form-control validate[required] text-input"
												name="tipoProd" id="tipoProd"
												value="<s:property value="tipoProd"/>" />
										</div>
										<div class="form-group">
											<label for="valor" class="control-label" class="label">Valor</label>
											<input class="form-control validate[required] text-input"
												name="valor" id="valor" value="<s:property value="valor"/>" />
										</div>
										<div class="form-group">
											<label for="stock" class="control-label" class="label">Stock</label>
											<input class="form-control validate[required] text-input"
												name="stock" id="stock" value="<s:property value="stock"/>" />
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
				<!-- Fin editar nuevo Producto -->
			</div>
		</div>
	</div>
</div>

<Script type="text/javascript">

</Script>



