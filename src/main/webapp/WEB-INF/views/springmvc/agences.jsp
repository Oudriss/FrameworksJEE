<%@ include file="theme/header.jsp" %>
<c:if test ="${ not empty sessionBean.utilisateur}">
<div class="main">
  <div class="main-inner">
      <div class="container">
        <div class="row">
          <div class="span12">         
            <div class="widget ">
              
            	<div class="widget-header">
            	</div> <!-- /widget-header -->
          
         	 	<div class="widget-content">
            
		            <c:if test ="${ not empty agenceModel.message}">
		            	<span>${agenceModel.message}</span>
		            </c:if>
            
            		<div class="tabbable">
			            <ul class="nav nav-tabs">
			              <li>
			                <a href="#formcontrols" data-toggle="tab">Liste des agences</a>
			              </li>
			              <li><a href="#jscontrols" data-toggle="tab">Formulaire</a></li>
			            </ul>
		            	<br>
            
			              <div class="tab-content">
			              
			                <div class="tab-pane active" id="formcontrols">
			                  <div class="content clearfix">
			                  <c:if test="${ agenceModel.newOrModify == true }">
										<f:form modelAttribute="agenceModel" action="/ma/agences/postModify" method="post">
											<h3>Modifier agence</h3>			
											<div class="login-fields">
												<div class="field">
													<label>Ville :</label>
													<f:input path="newAgence.ville" type="text" name="ville" value="${ agenceModel.newAgence.ville}" class="login" />
												</div> <!-- /field -->
												<div class="field">
													<label>Adresse :</label>	
													<f:input path="newAgence.adresse" type="text" name="adresse" value="${ agenceModel.newAgence.adresse}" class="login" />
												</div> <!-- /field -->
											</div>
											<div class="login-actions">	
												<f:input path="newAgence.codeAgence" type="hidden" value="${ agenceModel.newAgence.codeAgence}"  />																	
												<button class="button btn btn-primary btn-large">modifier</button>							
											</div> <!-- .actions -->
										</f:form>
			                   </c:if>  
			                    <table class="table table-striped table-bordered">
			                      <thead>
			                        <tr>
			                          <th> Ville </th>
			                          <th> Adresse </th>
			                          <th class="td-actions"> </th>
			                        </tr>
			                      </thead>
			                      <tbody>
			                      	<c:forEach items="${agenceModel.agences}" var="ag">
			                      		<tr>
				                          <td>${ag.ville}</td>
				                          <td>${ag.adresse}</td>
				                          <td class="td-actions">
				                          	<a href="/ma/agences/modify?ref=${ag.codeAgence}" class="btn btn-small btn-success"><i class="btn-icon-only icon-pencil"> </i></a>
				                          	<a href="/ma/agences/remove?ref=${ag.codeAgence}" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a>
				                          </td>
				                        </tr>
				                     </c:forEach>
			                      </tbody>
			                    </table>
			            	</div>
			             </div>

                
			                <c:if test="${ agenceModel.newOrModify == false }">
				                <div class="tab-pane" id="jscontrols">
				                	<div class="widget-content">
										<f:form modelAttribute="agenceModel" action="/ma/agences/new" method="post">
											<h3>Ajouter une nouvelle agence</h3>			
											<div class="login-fields">
												<div class="field">
													<label>Ville :</label>
													<f:input path="newAgence.ville" type="text" name="ville" value="" placeholder="Ville" class="login" />
												</div> <!-- /field -->
												<div class="field">
													<label>Adresse :</label>	
													<f:input path="newAgence.adresse" type="text" name="adresse" value="" placeholder="Adresse" class="login" />
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

