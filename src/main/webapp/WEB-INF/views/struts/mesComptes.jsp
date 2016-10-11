<%@ include file="theme/header.jsp" %>
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

			<c:if test ="${ not empty clientModel.message}">
            	<span>${clientModel.message}</span>
            </c:if>
            
              <div class="tab-content">
                <div class="tab-pane" id="formcontrols">
                   <div class="widget-content">
                    <table class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th> Agence </th>
                          <th> Signataires </th>
                          <th> Type </th>
                          <th> Solde </th>
                          <th class="td-actions"> </th>
                        </tr>
                        
                      </thead>
                      <tbody>
                       <s:iterator value="clientModel.comptes">                                       
                        <tr>
                          <td> <s:property value="ville"></s:property> </td>
                          <td> <s:property value="clients"></s:property> </td>
                          <td><s:property value=""></s:property> </td>
                          <td> <s:property value="solde"></s:property></td>
                        </tr>
                        </s:iterator>                      
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
<%@ include file="theme/footer.jsp" %>
