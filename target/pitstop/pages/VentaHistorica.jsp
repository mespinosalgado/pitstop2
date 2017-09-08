<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="page-wrapper">
	<div class="row">
	        <div class="col-lg-12">
	          <h1>Venta Historica</h1>
	          <ol class="breadcrumb">
	            <li><a href="<s:url action="Menu"/>"><i class="fa fa-tachometer"></i> Menú</a></li>
	            <li class="active"><i class="fa fa-wrench fa-lg"></i> Ventas Historicas</li>
	          </ol>
	        </div>
	</div><!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-wrench fa-lg"></i>&nbsp; Lista de Ventas y Cotizaciones
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-hover tablesorter" id="dataTables">
							<thead>
							<tr class="active">
								<th>N° &nbsp;<i class="fa fa-arrow-circle-down" class="icon-sort"></i></th>
								<th>Tipo &nbsp;<i class="fa fa-arrow-circle-down" class="icon-sort"></i></th>
								<th>Fecha &nbsp;<i class="fa fa-arrow-circle-down" class="icon-sort"></i></th>
								<th>Valor &nbsp;<i class="fa fa-arrow-circle-down" class="icon-sort"></i></th>
								<th>Tipo Pago &nbsp;<i class="fa fa-arrow-circle-down" class="icon-sort"></i></th>
								<th width="80px">PDF &nbsp;<i class="fa fa-cogs"></i></th>
							</tr>
							</thead>
							<s:iterator value="#session.ventas" status="ventas">
							<tr>
								<td WIDTH=8% class="info"><s:property value="id" /></td>
								<td class="info"><s:property value="tipo" /></td>
								<td class="info"><s:property value="fecha" /></td>
								<td class="info"><s:property value="valor" /></td>
								<td class="info"><s:property value="tipoPago" /></td>
								<td ><a href="javascript:void(0)" onclick="pdf(<s:property value="id" />)"
								style="width: 80px; text-align: center" class="Boto BotoH49 mTop10" title=""><span><i class="fa fa-file-pdf-o" aria-hidden="true"></i></span></a></td>
							</tr>
							</s:iterator>
						</table>
					</div>
				</div>														
			</div>
		</div>
	</div>
</div>
		


<script type="text/javascript">
function pdf(id) {
	window.open(
				'reportVentaCotiza?'
						+'&ventaId='+id+''
						);
	
}	
</script>






