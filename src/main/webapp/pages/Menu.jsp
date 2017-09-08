<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1>Menú</h1>
			<ol class="breadcrumb">
				<li class="active"><a href="<s:url action="Menu"/>"><i class="fa fa-tachometer"></i> Menú</a></li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			<div class="panel panel-default ">
				<div class="panel-body alert-danger">
					<div class="col-xs-2">
						<i class="fa fa-tags fa-3x"></i>
					</div>
					<div class="col-xs-10 text-right">
						<p class="alerts-heading"><s:property value="session.productoDashBoard.stock" /></p>
						<p class="alerts-text">Hay <s:property value="session.productoDashBoard.stock" /> Productos con bajo Stock</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default ">
				<div class="panel-body alert-info">
					<div class="col-xs-2">
						<i class="fa fa-money fa-3x"></i>
					</div>
					<div class="col-xs-10 text-right">
						<p class="alerts-heading">$<s:property value="session.totalDashBoard" /></p>
						<p class="alerts-text">Venta del Mes</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default ">
				<div class="panel-body alert-success">
					<div class="col-xs-2">
						<i class="fa fa-car fa-3x"></i>
					</div>
					<div class="col-xs-10 text-right">
						<p class="alerts-heading"><s:property value="session.totalRevDashBoard" /></p>
						<p class="alerts-text">Vehículos atendidos del Mes</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-wrench"></i>&nbsp; Revisiones pendientes
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-hover tablesorter" id="dataTables">
							<thead>
								<tr class="active">
									<th width="110px">Cliente<i class="icon-sort"></i></th>
									<th width="110px">Patente<i class="icon-sort"></i></th>
									<th>Mecánico &nbsp;<i class="fa fa-sort-alpha-asc"></i><i class="icon-sort"></i></th>
									<th >Fecha<i class="icon-sort"></i></th>
									<th>Hora<i class="icon-sort"></i></th>
									<th>Aprobación<i class="icon-sort"></i></th>
								</tr>
							</thead>
							<s:iterator value="#session.revListDashBoard" status="revListDashBoard">
							<tr class="info">
								<td><s:property value="vehiculo.cliente.rut" /></td>
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
							</tr>
									</s:iterator>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			<!-- Grafico -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel-heading">
						<h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Estado Venta del Mes </h3>
						</div>
						<div class="panel-body">
							<div id="container"></div>
						</div>
					</div>
				</div>
			</div>				
		</div>

  





