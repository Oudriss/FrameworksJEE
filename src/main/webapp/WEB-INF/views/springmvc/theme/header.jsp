<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Gestion banque</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
        rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/font-awesome.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/pages/dashboard.css" rel="stylesheet">
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<c:if test ="${ not empty sessionBean.utilisateur}">
<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                    class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="index.html">Exemple gestion des comptes bancaire </a>
      <div class="nav-collapse">
        <ul class="nav pull-right">
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="icon-user"></i>  ${sessionBean.role} <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="javascript:;"> ${sessionBean.utilisateur.nom}</a></li>
              <li><a href="/ma/deconnecter">Deconnecter</a></li>
            </ul>
          </li>
        </ul>
      </div>
      <!--/.nav-collapse --> 
    </div>
    <!-- /container --> 
  </div>
  <!-- /navbar-inner --> 
</div>
<!-- /navbar -->
<div class="subnavbar">
  <div class="subnavbar-inner">
    <div class="container">
      <ul class="mainnav">
        <li class="active"><a href="index.html"><i class="icon-home"></i><span>Accueil</span> </a> </li>
        <c:if test ="${ sessionBean.role == 'Adminstrateur' }"><li><a href="/ma/agences"><i class="icon-map-marker"></i><span>Agences</span> </a></li></c:if>
        <c:if test ="${ sessionBean.role == 'Agent' }"><li><a href="/ma/comptes"><i class="icon-list-alt"></i><span>Comptes</span> </a> </li></c:if>
        <c:if test ="${ sessionBean.role == 'Adminstrateur' or sessionBean.role == 'Agent'}"><li><a href="/ma/utilisateurs"><i class="icon-user"></i><span>Utilisateurs</span> </a></li></c:if>
        <c:if test ="${ sessionBean.role == 'Agent' }"><li><a href="/ma/operations"><i class="icon-bar-chart"></i><span>Opérations</span> </a> </li></c:if>
      	<c:if test ="${ sessionBean.role == 'Client' }"><li><a href="/ma/client/mesComptes"><i class="icon-bar-chart"></i><span>Mes Comptes</span> </a> </li></c:if>
      	<c:if test ="${ sessionBean.role == 'Client' }"><li><a href="/ma/client/mesOperations"><i class="icon-bar-chart"></i><span>Historiques des opérations</span> </a> </li></c:if>	
      </ul>
    </div>
    <!-- /container --> 
  </div>
  <!-- /subnavbar-inner --> 
</div>
</c:if>
<c:if test ="${ empty sessionBean}">
	<H3>Vous devez se connecter :</H3>
	<a href=""></a>
</c:if>