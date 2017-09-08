<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1>Ventas y Cotizaciones</h1>
			<ol class="breadcrumb">
				<li><a href="<s:url action="Menu"/>"><i
						class="fa fa-tachometer"></i> Menú</a></li>
				<li class="active"><i class="fa fa-shopping-cart"></i> Ventas y Cotizaciones</li>
			</ol>
		</div>
	</div>

	<!-- Fin panel titulo -->
	<div class="row">
		<div class="panel-body col-lg-12">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr class="active">
							<th>Cliente<i class="icon-sort"></i></th>
							<th>Fecha</th>
							<th rowspan="2"><a id="add_row" class="btn btn-primary center-block fa fa-cart-plus"> Agregar</a></th>
						</tr>
					</thead>
						<tr class="active">
							<td WIDTH=50%><select class="form-control validate[required] text-input selectpicker" id="cliente" name="cliente" data-live-search="true">
								<option value>-- Selecionar --</option>
									<s:iterator value="#session.clientes" status="clientes">
										<option value="<s:property value="id" />">Rut : <s:property value="rut" /> - Nombre : <s:property value="nombre" /> <s:property value="apellidos" /></option>
									</s:iterator>
								</select>
							</td>		
							<td><input style="text-align: center;" id="theDate"  disabled></td>
							<td></td>
						</tr>
					</table>		
			   <!-- segunda tabla -->	
			<table class="table table-hover" id="tab_logic">
				<thead>
					<tr class="active">
						<th>Productos y Servicios</th>
						<th>Cantidad</th>
						<th>Precio</th>
						<th>Total</th>
						<th class="text-center"></th>
					</tr>
				</thead>
				<tbody>
					<tr  id='addr0' data-id="0" class="hidden">
						<td  data-name="name" class="col-sm-6 col-md-5">
							<div class="media-body">
								<select class="form-control" id="producto" name="producto" onchange="onchangeProducto(this)"  data-live-search="true">
								<option value>-- Selecionar --</option>
									<optgroup label="Productos" data-max-options="1">
									<s:iterator value="#session.productos" status="productos">
										<option value="producto-<s:property value="id" />">						
										<s:property value="descripcion" /></option>
									</s:iterator>
									</optgroup>
									<optgroup label="Servicios" data-max-options="1">
									<s:iterator value="#session.servicios" status="servicios">
										<option value="servicio-<s:property value="id" />"><s:property value="nombreServicio" /></option>
									</s:iterator>
									</optgroup>
								</select> 
								<%-- <span>Status: </span><span class="text-success"><strong>En Stock</strong></span> --%>
							</div>
						</td>
						<td data-name="mail" class="col-sm-1 col-md-1"
							style="text-align: center"><input type="number"
							name='cantidad' class="form-control" id="cantidad" value='1'
							onchange="onchangeCantidad(this)"></td>
						<td data-name="desc" class="col-sm-1 col-md-1 text-center">
							<input name="precio" type="number" id="precio"
							class="form-control" value="0">
						</td>
						<td data-name="sel"><strong id="totalProducto">$0</strong>
						</td>
						<td data-name="del">
							<button
								nam"del0" class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>
						</td>
					</tr>
					</tbody>
				</table>
				<!--  tercera tabla -->
				<table>
					<tbody>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td WIDTH=100% colspan="2">
								<div class="form-group">
									<label for="cargo" class="control-label" class="label">Observación</label>
									<textarea class="form-control text-input"
										 name="observacion" id="observacion"></textarea>
								</div>
							</td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td width="30%">
								<div class="form-group">
									<label for="sucursal" class="control-label">Tipo Pago
									</label> 
									<select class="form-control validate[required] text-input selectpicker"	id="tipoPago" name="tipoPagoId">
										<option value>-- Selecionar --</option>
										<option data-icon="fa fa-credit-card" value="Tarjeta">&nbsp; Tarjeta</option>
										<option data-icon="fa fa-wpforms" value="Cheque">&nbsp; Cheque</option>
										<option data-icon="fa fa-money" value="Efectivo">&nbsp; Efectivo</option>
										<option data-icon="fa fa-money" value="Efectivo">&nbsp; Otro medio de pago</option>
									</select>
								</div>
							</td>
						</tr>						
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td class="success"><h3>Total</h3></td>
							<td class="text-right">
								<h3> $<strong id="total">0</strong></h3>
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<button type="button" class="btn btn-warning" onclick="guardar(2)"> 
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Cotización
								</button>
							</td>
							<td>
								<button type="button" class="btn btn-success"
									onclick="guardar(1)">
									Generar Venta <span class="glyphicon glyphicon-play"></span>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script src="<%=request.getContextPath()%>/resources/js/jquery.js"	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function calculateTotal() {
		var total = 0;
		for (var i = 1; i < 100; i++) {
			var div = $("#tab_logic").find("#addr" + i);
			if (div) {
				var totalProducto = div.find("#totalProducto");
				var totalPrev = totalProducto.text();
				if (!totalPrev) {
					break;
				}
				total = total + parseInt(totalPrev);
				;
			}

		}
		document.getElementById('total').innerHTML = total;
	}

	function onchangeProducto(sel) {
		var obj = $(sel).parent().parent().parent();
		var precio = obj.find("#precio");

		var idSeleccionado = $(sel).val();
		var itemsSeleccionado = idSeleccionado.split("-");
		var valor = 0;
		if (itemsSeleccionado[0] == "servicio") {
			<s:iterator value="#session.servicios" status="servicios">
			if (parseInt(itemsSeleccionado[1]) == <s:property value="id" />) {
				valor = <s:property value="valorServicio" />;
			}
			</s:iterator>
		}

		if (itemsSeleccionado[0] == "producto") {
			<s:iterator value="#session.productos" status="productos">
			if (parseInt(itemsSeleccionado[1]) == <s:property value="id" />) {
				valor = <s:property value="valor" />;
			}
			</s:iterator>
		}

		obj.find("#cantidad").val(0);
		obj.find("#totalProducto").text(0);
		$(precio).val(valor);
	}

	function onchangeCantidad(sel) {
		var cantidad = $(sel).val();
		var obj = $(sel).parent().parent();
		var valor = obj.find("#precio");
		var totalProducto = obj.find("#totalProducto");
		var total = parseInt(cantidad) * parseInt(valor.val());
		totalProducto.text(total);

		calculateTotal();
	}

	function guardar(id) {
		var tipo="Venta";
		if(id == 2){
			tipo="Cotización";
		}
		
		var venta = "";
		for (var i = 1; i < 100; i++) {
			var div = $("#tab_logic").find("#addr" + i);
			if (div) {
				var producto = div.find("#producto");
				var cantidad = div.find("#cantidad");
				var productoId = producto.val();
				console.log(productoId);
				var cantidadText = cantidad.val();
				console.log(cantidadText);
				if (!productoId) {
					break;
				}
				venta = venta + productoId + ":" + cantidadText + ":::";
			}

		}
		
		$.post('ingresarVenta', {
			clienteId : $('#cliente').val(),
			tipo : tipo,
			ventaBag : venta,
			tipoPago : $('#tipoPago').val(),
			observacion: $('#observacion').val(),
			fecha : $("#theDate").val(),
			total : $("#total").html()
		}, function(json) {
			alert(json);
		}, "json");
	}
</script>
<script type="text/javascript">
$(document).ready(function() {
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day;       
    $("#theDate").attr("value", today);
});
</script>

<script src="<%=request.getContextPath()%>/resources/js/agregartabla.js" type="text/javascript" charset="utf-8"></script> 
