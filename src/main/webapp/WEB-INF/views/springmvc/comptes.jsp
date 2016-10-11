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
              <li>
                <a href="#formcontrols" data-toggle="tab">Liste des comptes</a>
              </li>
              <li><a href="#jscontrols" data-toggle="tab">Formulaire</a></li>
            </ul>
            <br>

			<c:if test ="${ not empty compteModel.message}">
            	<span>${compteModel.message}</span>
            </c:if>
            
              <div class="tab-content">
                <div class="tab-pane active" id="formcontrols">
                   <div class="content clearfix">
                   
	                   <c:if test="${ compteModel.newOrModify == true }">
								<f:form modelAttribute="compteModel" action="/ma/comptes/postModify" method="post">
									<h3>Ajouter un nouveau compte</h3>			
									<div class="login-fields">
										<div class="field">
											<label>Clients :</label>
											<f:input path="clientsCINs" type="text" name="cins" value="${ clientsCINs }" placeholder="cin;cin;cin" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Code agent :</label>
											<f:input path="newCompte.agent.codeUtilisateur" type="text" name="codeAgent" value="" placeholder="${ newcompte.agent.codeUtilisateur }" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Solde :</label>	
											<f:input path="newCompte.solde" type="text" name="adresse"  placeholder="${ newcompte.solde }" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Activer :</label>
											<f:checkbox path="newCompte.active"  name="active" value="${ newCompte.active }"  class="login" />
										</div> <!-- /field -->
									</div>
									<div class="login-actions">
										<f:input path="type" type="hidden" value="${ newCompte }" />
										<f:input path="newCompte.codeCompte" type="hidden" value="${ newCompte.codeCompte }" />
										<button class="button btn btn-primary btn-large">Valider</button>							
									</div> <!-- .actions -->
								</f:form>
	                	</c:if>
                   
                    <table class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th> Code </th>
                          <th> Agent </th>
                          <th> Signataires </th>
                          <th> Type </th>
                          <th> Solde </th>
                          <th> Activer </th>
                          <th class="td-actions"> </th>
                        </tr>
                        
                      </thead>
                      <tbody>
                       <c:forEach items="${compteModel.comptes}" var="cp">                                       
                        <tr>
                          <td> ${ cp.codeCompte } </td>
                          <td> ${ cp.agent.cin } </td>
                          <td><ul>
                          	<c:forEach items="${cp.clients}" var="client">
                          		<li>${ client.cin } </li>
                          	</c:forEach>
                          </ul></td>
                          <td> ${ cp } </td>
                          <td> ${ cp.solde } </td>
                          <td> ${ cp.active } </td>
                          <td class="td-actions">
                          <a href="/ma/comptes/modify?ref=${ cp.codeCompte }" class="btn btn-small btn-success"><i class="btn-icon-only icon-pencil"> </i></a>
                          <a href="/ma/comptes/remove?ref=${ cp.codeCompte }" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a></td>
                        </tr>
                        </c:forEach>                      
                      </tbody>
                    </table>
                   </div>
                </div>
                
               
               
                <c:if test="${ compteModel.newOrModify == false }">
	                <div class="tab-pane" id="jscontrols">
	                	<div class="widget-content">
								<f:form modelAttribute="compteModel" action="/ma/comptes/new" method="post">
									<h3>Ajouter un nouveau compte</h3>			
									<div class="login-fields">
										<div class="field">
											<label>Clients :</label>
											<f:input path="clientsCINs" type="text" name="cins" value="" placeholder="cin;cin;cin" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Code agent :</label>
											<f:input path="newCompte.agent.codeUtilisateur" type="text" name="codeAgent" value="" placeholder="codeAgent" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Type :</label>
											<f:select path="type">
												<f:option value="courant">Courant</f:option>
												<f:option value="epargne">Epargne</f:option>
											</f:select>
										</div> <!-- /field -->
										<div class="field">
											<label>Solde :</label>	
											<f:input path="newCompte.solde" type="text" name="adresse" value="" placeholder="Adresse" class="login" />
										</div> <!-- /field -->
										<div class="field">
											<label>Activer :</label>
											<f:checkbox path="newCompte.active"  name="active" value=""  class="login" />
										</div> <!-- /field -->										
									</div>
									<div class="login-actions">												
										<button class="button btn btn-primary btn-large">Valider</button>							
									</div> <!-- .actions -->
								</f:form>
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
</c:if>
<%@ include file="theme/footer.jsp" %>
