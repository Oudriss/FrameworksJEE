<%@ include file="theme/header.jsp" %>
<c:if test ="${ not empty sessionBean.utilisateur }">
<div class="main">
  <div class="main-inner">
      <div class="container">
        <div class="row">
          <div class="span12">          
            <div class="widget ">
              <div class="widget-header">

            </div> <!-- /widget-header -->
          <div class="widget-content">
            <div class="tabbable">
            <ul class="nav nav-tabs">
              <li><a href="#historique" data-toggle="tab">Historique des opérations</a></li>
              <li><a href="#retirer" data-toggle="tab">Retrait</a></li>
              <li><a href="#verser" data-toggle="tab">Versement</a></li>
              <li><a href="#virement" data-toggle="tab">Virement</a></li>
            </ul>
            <br>		

			<c:if test ="${ not empty operationModel.message}">
            	<span>${operationModel.message}</span>
            </c:if>
            
              <div class="tab-content">
                <div class="tab-pane active" id="historique">
                   <div class="content clearfix">
	                    <table class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th> ID </th>
                          <th> Date d'operation </th>
                          <th> Type </th>
                          <th> Montant </th>
                          <th> Emetteur </th>
                          <th> Recepteur </th>
                          <th class="td-actions"> </th>
                        </tr>
                        
                      </thead>
                      <tbody>
                       <c:forEach items="${operationModel.operations}" var="op">                                       
                        <tr>
                          <td> ${ op.id } </td>
                          <td> ${ op.dateOperation }</td>
                          <td> ${ op.type } </td>
                          <td> ${ op.montant } </td>
                          <td> ${ op.compteEmetteur.codeCompte } </td>
                          <td> ${ op.compteRecepteur.codeCompte } </td>                         
                          <td class="td-actions">
                          <a href="/ma/operations/remove?ref=${ op.id }" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a></td>
                        </tr>
                        </c:forEach>                      
                      </tbody>
                    </table>                  
                   </div>
                </div>
                
                
                <div class="tab-pane" id="retirer">
                   <div class="content clearfix">
                   			<f:form modelAttribute="operationModel" action="/ma/operations/retirer" method="post">
									<h3>Retrait</h3>			
									<div class="login-fields">
										<div class="field">
											<label>Code de compte recepteur :</label>
											<f:input path="recepteur.codeCompte" type="text" name="cins" value="" placeholder="code" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Montant :</label>
											<f:input path="montant" type="text" name="codeAgent" value="" placeholder="codeAgent" class="login" />
										</div> <!-- /field -->															
									</div>
									<div class="login-actions">												
										<button class="button btn btn-primary btn-large">Valider</button>							
									</div> <!-- .actions -->
								</f:form>                
                   </div>
                </div>
                
                
                <div class="tab-pane" id="verser">
                   <div class="content clearfix">
                   			<f:form modelAttribute="operationModel" action="/ma/operations/verser" method="post">
									<h3>Versement</h3>			
									<div class="login-fields">
										<div class="field">
											<label>Code de compte recepteur :</label>
											<f:input path="recepteur.codeCompte" type="text" name="cins" value="" placeholder="code" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Montant :</label>
											<f:input path="montant" type="text" name="codeAgent" value="" placeholder="codeAgent" class="login" />
										</div> <!-- /field -->															
									</div>
									<div class="login-actions">												
										<button class="button btn btn-primary btn-large">Valider</button>							
									</div> <!-- .actions -->
								</f:form>        
                   
                   </div>
                </div>
                
                
                <div class="tab-pane" id="virement">
                   <div class="content clearfix">
                   			<f:form modelAttribute="operationModel" action="/ma/operations/virement" method="post">
									<h3>Virement</h3>			
									<div class="login-fields">
										<div class="field">
											<label>Code de compte recepteur :</label>
											<f:input path="recepteur.codeCompte" type="text" name="cins" value="" placeholder="code" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Code de compte emetteur :</label>
											<f:input path="emetteur.codeCompte" type="text" name="cins" value="" placeholder="code" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Montant :</label>
											<f:input path="montant" type="text" name="codeAgent" value="" placeholder="codeAgent" class="login" />
										</div> <!-- /field -->															
									</div>
									<div class="login-actions">												
										<button class="button btn btn-primary btn-large">Valider</button>							
									</div> <!-- .actions -->
								</f:form>        
                   
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
