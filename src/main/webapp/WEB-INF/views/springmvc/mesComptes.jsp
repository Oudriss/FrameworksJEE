<%@ include file="theme/header.jsp" %>
<c:if test ="${ not empty sessionBean.utilisateur }">
<div class="main">
  <div class="main-inner">
      <div class="container">
        <div class="row">
          <div class="span12">          
            <div class="widget ">
              <div class="widget-header">
                <i class="icon-user"></i>
                <h3>Your Account</h3>
            </div> <!-- /widget-header -->
          <div class="widget-content">
            <div class="tabbable">
            <ul class="nav nav-tabs">
              <li>
                <a href="#formcontrols" class="active" data-toggle="tab">Liste des comptes</a>
              </li>
            </ul>
            <br>

			<c:if test ="${ not empty clientModel.message}">
            	<span>${clientModel.message}</span>
            </c:if>
            
              <div class="tab-content">
                <div class="tab-pane active" id="formcontrols">
                   <div class="widget-content">
                    <table class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th> Code </th>
                          <th> Signataires </th>
                          <th> Type </th>
                          <th> Solde </th>
                          <th> Active </th>
                        </tr>
                        
                      </thead>
                      <tbody>
                       <c:forEach items="${clientModel.comptes}" var="cp">                                       
                        <tr>
                          <td> ${ cp.codeCompte } </td>
                          <td>
                          	<c:forEach items="${cp.clients}" var="client">
                          		<li>${ client.cin } </li>
                          	</c:forEach>
                          </td>
                          <td> ${ cp } </td>
                          <td> ${ cp.solde } </td>
                          <td> ${ cp.active } </td>
                        </tr>
                        </c:forEach>                      
                      </tbody>
                    </table>
                   </div>
                </div>
               
              </div>
              
              
            </div>

          </div> <!-- /widget-content -->
            
        </div> <!-- /widget -->
            
        </div> <!-- /span8 -->
          
          
          
          
        </div> <!-- /row -->
  
      </div> <!-- /container -->
      
  </div> <!-- /main-inner -->
    
</div> <!-- /main -->
</c:if>
<%@ include file="theme/footer.jsp" %>
