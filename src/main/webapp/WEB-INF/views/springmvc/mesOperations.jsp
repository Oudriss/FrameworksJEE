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
                <a href="#formcontrols" data-toggle="tab">Liste des comptes</a>
              </li>
              <li  class="active"><a href="#jscontrols" data-toggle="tab">Formulaire</a></li>
            </ul>
            <br>


            
              <div class="tab-content">
                <div class="tab-pane" id="formcontrols">
                   <div class="widget-content">
                    <table class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th> Date Operation </th>
                          <th> montant </th>
                          <th> Type </th>
                        </tr>
                        
                      </thead>
                      <tbody>
                       <c:forEach items="${operationModel.operations}" var="op">                                       
                        <tr>
                          <td> ${ op.dateOperation } </td>
                          <td> ${ op.type } </td>
                          <td> ${ op.montant } </td>
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
