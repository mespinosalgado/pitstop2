<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menú Principal</title>
<!-- Bootstrap -->

<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/css/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/css/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/css/css/local.css" />
<link rel="stylesheet" type="text/css" 	href="<%=request.getContextPath()%>/resources/css/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/dataTables.bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-select-1.10.0/dist/css/bootstrap-select.min.css"/>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator/template.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/timepicker.css" />
<style type="text/css">
.hiddenUl{
display:none;
}
</style>
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">

					<!-- Vertical Menu -->
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<s:url action="Menu"/>"><img
					src="<%=request.getContextPath()%>/resources/img/logo_03.png"
					class="img-responsive" alt="Conxole Admin" /></a>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="menu">
						<a href="<s:url action="Menu"/>"><i class="fa fa-tachometer fa-fw"></i>&nbsp; Menú</a></li>
					<s:if test="session.systemParameter.seeIngresos">					
						<li class="toggle">
						<a  onClick="return false" href="#"><i class="fa fa-street-view fa-fw"></i>&nbsp; Ingresos &nbsp;<i class="fa fa-chevron-right" aria-hidden="true"></i></a>
						</li>
						<ul class="hiddenUl">
							<li>
							<a  href="<s:url action="Ingresos"/>"><i class="fa fa-users" aria-hidden="true"></i>&nbsp; Clientes </a>
							</li>
							<li>
							<a  href="<s:url action="Vehiculos"/>"><i class="fa fa-car" aria-hidden="true"></i>&nbsp; Vehículos </a>
							</li>
							<li>
							<a  href="<s:url action="Revisiones"/>"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp; Revisiones </a>
							</li>
						</ul>
						
						 
					</s:if>
					<s:if test="session.systemParameter.seeVenta">
						<li class="menu">
						<a class="menu" href="<s:url action="CotizaMenu"/>"><i class="fa fa-shopping-cart"></i>&nbsp; Venta</a></li>
					</s:if>
					<s:if test="session.systemParameter.seeEmpleados">
						<li class="menu">
						<a href="<s:url action="Empleados"/>"><i class="fa fa-users fa-fw"></i>&nbsp; Empleados</a></li>
					</s:if>
					<s:if test="session.systemParameter.seeProductos">
						<li class="menu">
						<a href="<s:url action="Productos"/>"><i class="fa fa-tags fa-fw"></i>&nbsp; Productos</a></li>
					</s:if>
					<s:if test="session.systemParameter.seeServicios">
						<li class="menu">
						<a href="<s:url action="Servicios"/>"><i class="fa fa-wrench fa-fw"></i>&nbsp; Servicios</a></li>
					</s:if>
					<s:if test="session.systemParameter.seeProveedores">
						<li class="menu">
						<a href="<s:url action="Proveedores"/>"><i class="fa fa-truck fa-fw"></i>&nbsp; Proveedores</a></li>
					</s:if>
					<s:if test="session.systemParameter.seeVentaHistorica">
						<li class="menu">
						<a href="<s:url action="VentaHisto"/>"><i class="fa fa-money fa-fw"></i>&nbsp; Venta Histórica</a></li>
					</s:if>
					
				</ul>
				<!-- Fin Vertical Menu -->
				<ul class="nav navbar-nav navbar-right navbar-user">
					<li class="dropdown messages-dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<i class="fa fa-question-circle"></i>&nbsp; Ayuda <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="message-preview"><a href="#"> <span
									class="avatar"><i class="fa fa-envelope"></i></span> <span
									class="message">Contacto</span></a>
							</li>
							<li class="divider"></li>
							<li class="message-preview"><a href="#"> 
							<span class="avatar"><i class="fa fa-file-pdf-o"></i></span> 
							<span class="message">Descargar manual PDF</span>
							</a>
							</li>			
						</ul></li>
					<li class="dropdown user-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-user"></i>&nbsp; <s:property value="session.activeRole" />&nbsp;<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<s:url action="CambioPassword"/>"><i class="fa fa-user"></i>&nbsp; Perfil</a></li>
							<li class="divider"></li>
							<li><a href="<s:url action="logout"/>"><i
									class="fa fa-power-off"></i>&nbsp; Salir</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		
			<div class="jumbotron">
			<div style="width: 100%;height: 1px;border-bottom: 1px solid grey;"></div>
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12">
	                <p style="text-align: right;color: white">
					PitStop <a href="Versiones.action">v1.5.0 <small>23/06/2016</small></a>
					&copy; PitStop 2015 - 2016&nbsp;&nbsp;
					|&nbsp;&nbsp;&nbsp;<a href="http://www.pitstopchile.com">www.pitstopchile.com</a>&nbsp;&nbsp;
					</p>	                
					</div>
	            </div>
  			</div>
    	</div>
		</div>
		
		
		<script src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resources/css/bootstrap/js/bootstrap.min.js"  type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/dataTables.bootstrap.min.js"/></script> 
	 	
		<script src="<%=request.getContextPath()%>/resources/css/bootstrap-select-1.10.0/dist/js/bootstrap-select.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resources/css/bootstrap-select-1.10.0/dist/js/i18n/defaults-es_CL.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine-es.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.Rut.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resources/Highcharts-4.2.6/js/highcharts.js"></script>
		<script src="<%=request.getContextPath()%>/resources/Highcharts-4.2.6/js/modules/exporting.js"></script>
	
		<script type="text/javascript">	
			$(document).ready(function(){
				$(".toggle").click(function(){
					if ($(this).next().is(":hidden")) {
						$(this).next().slideDown("fast");
					} else {
						$(this).next().hide();
					}
				});
			});
		</script>
		<script  type="text/javascript">
		$('#dataTables').dataTable( {
			"language": {
				"sProcessing":     "Procesando...",
				"sLengthMenu":     "Mostrar _MENU_ registros",
				"sZeroRecords":    "No se encontraron resultados",
				"sEmptyTable":     "Ningún dato disponible en esta tabla",
				"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
				"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
				"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
				"sInfoPostFix":    "",
				"sSearch":         "Buscar:",
				"sUrl":            "",
				"sInfoThousands":  ",",
				"sLoadingRecords": "Cargando...",
				"oPaginate": {
					"sFirst":    "Primero",
					"sLast":     "Último",
					"sNext":     "Siguiente",
					"sPrevious": "Anterior"
				},
				"oAria": {
					"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
					"sSortDescending": ": Activar para ordenar la columna de manera descendente"
				}
			}
			} );
		</script>	
		<script type="text/javascript">
			$(function () {
			    $('#container').highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			   			text: 'Venta servicios y productos últimos tres Meses'
			        },
			        xAxis: {
			            categories: <s:property value="session.graficoMeses" />
			        },
			        yAxis: {
			            min: 0,
			            title: {
			                text: 'Total Venta'
			            },
			            stackLabels: {
			                enabled: true,
			                style: {
			                    fontWeight: 'bold',
			                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
			                }
			            }
			        },
			        legend: {
			            align: 'right',
			            x: -30,
			            verticalAlign: 'top',
			            y: 25,
			            floating: true,
			            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
			            borderColor: '#CCC',
			            borderWidth: 1,
			            shadow: false
			        },
			        tooltip: {
			            headerFormat: '<b>{point.x}</b><br/>',
			            pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
			        },
			        plotOptions: {
			            column: {
			                stacking: 'normal',
			                dataLabels: {
			                    enabled: true,
			                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
			                    style: {
			                        textShadow: '0 0 3px black'
			                    }
			                }
			            }
			        },
			        series: [{
			           name: 'Productos',
			           data: <s:property value="session.graficoProductos" />
			       }, {
			           name: 'Servicios',
			           data: <s:property value="session.graficoServicios" />
			       }
			
			        ]
			    });
			}); 
	</script> 
</body>
</html>
