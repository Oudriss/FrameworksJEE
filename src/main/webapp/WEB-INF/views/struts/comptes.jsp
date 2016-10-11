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

			<c:if test ="${ not empty compteModel.message}">
            	<span>${compteModel.message}</span>
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
                       <s:iterator value="compteModel.comptes">                                       
                        <tr>
                          <td><s:property value="ville"></s:property></td>
                          <td><s:property value="clients"></s:property> </td>
                          <td><s:property value="cp"></s:property> </td>
                          <td><s:property value="solde"></s:property></td>
                          <td class="td-actions">
                          <s:url namespace="/" action="comptes/remove" var="lien1">
									<s:param name="ref">
										<s:property value="codeCompte"/>
									</s:param>
								</s:url>
								<s:url namespace="/" action="comptes/modify" var="lien2">
									<s:param name="ref">
										<s:property value="codeCompte"/>
									</s:param>
								</s:url>
                          <a href="%{lien1}" class="btn btn-small btn-success"><i class="btn-icon-only icon-ok"> </i></a>
                          <a href="%{lien2}" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a></td>
                        </tr>
                        </s:iterator>                      
                      </tbody>
                    </table>
                   </div>
                </div>
               
               
                <c:if test="${ agenceModel.newOrModify == false }">
	                <div class="tab-pane" id="jscontrols">
	                	<div class="content clearfix">
							<s:form  action="comptes/new" method="post">
								<h3>Ajouter un nouveau compte</h3>			
								<div class="login-fields">
									<div class="field">
										<label>Clients :</label>
										<s:textfield name="newCompte.clients" value="" placeholder="Ville" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>Type de compte  :</label>	
										<s:textfield type="text" name="newCompte.adresse" value="" placeholder="Adresse" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>Solde :</label>	
										<s:textfield name="newAgence.solde" type="text"  value="" placeholder="Adresse" class="login" />
									</div> <!-- /field -->
								</div>
								<div class="login-actions">												
									<s:submit value="Valider" class="button btn btn-primary btn-large"></s:submit>							
								</div> <!-- .actions -->
							</s:form>
						</div> <!-- /content -->
	                </div>
                </c:if>
               
           
                
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
