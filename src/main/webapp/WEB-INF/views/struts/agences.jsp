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
            
            <c:if test ="${ not empty agenceModel.message}">
            	<span>${agenceModel.message}</span>
            </c:if>
            
            <div class="tabbable">
            <ul class="nav nav-tabs">
              <li>
                <a href="#formcontrols" data-toggle="tab">Liste des agences</a>
              </li>
              <li  class="active"><a href="#jscontrols" data-toggle="tab">Formulaire</a></li>
            </ul>
            
            <br>
            
              <div class="tab-content active">
                <div class="tab-pane" id="formcontrols">
                  <div class="widget-content">
                    <table class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th> Ville </th>
                          <th> Adresse </th>
                          <th class="td-actions"> </th>
                        </tr>
                      </thead>
                      <tbody>
                      	<s:iterator value="agenceModel.agences">
                      		<tr>
	                          <td><s:property value="ville"></s:property></td>
	                          <td><s:property value="addresse"></s:property></td>
	                          <td class="td-actions">
	                          	<s:url namespace="/" action="agences/remove" var="lien1">
									<s:param name="ref">
										<s:property value="codeAgence"/>
									</s:param>
								</s:url>
								<s:url namespace="/" action="agences/modify" var="lien2">
									<s:param name="ref">
										<s:property value="codeAgence"/>
									</s:param>
								</s:url>
	                          	<a href="%{lien1}" class="btn btn-small btn-success"><i class="btn-icon-only icon-pencil"> </i></a>
	                          	<a href="%{lien2}" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a>
	                          </td>
	                        </tr>
	                     </s:iterator>
                      </tbody>
                    </table>
            	</div>
             </div>

                
                <c:if test="${ agenceModel.newOrModify == false }">
	                <div class="tab-pane" id="jscontrols">
	                	<div class="content clearfix">
							<s:form action="agences/new" method="post">
								<h3>Ajouter une nouvelle agence</h3>			
								<div class="login-fields">
									<div class="field">
										<label>Ville :</label>
										<s:textfield path="newAgence.ville"  name="agenceModel.newAgence.ville" value="" placeholder="Ville" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>Adresse :</label>	
										<s:textfield path="newAgence.adresse" name="agenceModel.newAgence.adresse" value="" placeholder="Adresse" class="login" />
									</div> <!-- /field -->
								</div>
								<div class="login-actions">												
									<s:submit value="Valider" class="button btn btn-primary btn-large"></s:submit>							
								</div> <!-- .actions -->
							</s:form>
						</div> <!-- /content -->
	                </div>
                </c:if>

                <c:if test="${ agenceModel.newOrModify == true }">
	                <div class="tab-pane" id="jscontrols">
	                	<div class="content clearfix">
							<s:form action="agences/postModify" method="post">
								<h3>Ajouter une nouvelle agence</h3>			
								<div class="login-fields">
									<div class="field">
										<label>Ville :</label>
										<s:textfield name="agenceModel.newAgence.ville" value="" placeholder="Ville" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>Adresse :</label>	
										<s:textfield name="agenceModel.newAgence.adresse" value="" placeholder="Adresse" class="login" />
									</div> <!-- /field -->
								</div>
								<div class="login-actions">												
									<s:submit value="Modifier" class="button btn btn-primary btn-large"></s:submit>							
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

