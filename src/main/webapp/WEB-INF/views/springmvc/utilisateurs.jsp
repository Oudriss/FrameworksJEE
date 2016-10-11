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
            
            <c:if test ="${ not empty utilisateurModel.message}">
            	<span>${utilisateurModel.message}</span>
            </c:if>
            
           <div class="tabbable">
			    <ul class="nav nav-tabs">
			            <li>
			                <a href="#formcontrols" data-toggle="tab">Liste des utilisateurs</a>
			              </li>
			              <li><a href="#jscontrols" data-toggle="tab">Formulaire</a></li>
			            </ul>
            
            <br>

              <div class="tab-content">
                <div class="tab-pane active" id="formcontrols">
              		<c:if test="${ utilisateurModel.newOrModify == true }">
	                <div class="tab-pane" id="jscontrols">
	                	<div class="content clearfix">
							<f:form modelAttribute="utilisateurModel" action="/ma/utilisateurs/postModify" method="post">
								<h3>Modifier l'utilisateur</h3>			
								<div class="login-fields">
									<div class="field">
										<label>CIN :</label>
										<f:input path="newUtilisateur.cin" type="text" name="cin" value="${newUtilisateur.cin }" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>NOM :</label>
										<f:input path="newUtilisateur.nom" type="text" name="nom" value="${newUtilisateur.cin }" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PRENOM :</label>
										<f:input path="newUtilisateur.prenom" type="text" name="prenom" value="${newUtilisateur.prenom}" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>DATE DE NAISSANCE :</label>
										<f:input path="dateNaissance" type="date" name="dateNaissance" value="${newUtilisateur.dateNaissance}" class="login" />
									</div>  <!-- /field -->
									<div class="field">
										<label>VILLE :</label>
										<f:input path="newUtilisateur.ville" type="text" name="ville" value="${newUtilisateur.ville}" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>ADRESSE :</label>
										<f:input path="newUtilisateur.adresse" type="text" name="adresse" value="${newUtilisateur.adresse}" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>EMAIL :</label>
										<f:input path="newUtilisateur.email" type="email" name="email" value="${newUtilisateur.email}" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>TELEPHONE :</label>
										<f:input path="newUtilisateur.telephone" type="text" name="telephone" value="${newUtilisateur.telephone}" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>USERNAME :</label>
										<f:input path="newUtilisateur.username" type="text" name="username" value="${newUtilisateur.username}" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PASSWORD :</label>
										<f:input path="newUtilisateur.password" type="password" name="password" value="${newUtilisateur.password}" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>RÔLE :</label>
										<f:input path="role" type="text" name="text" value="${role}" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<f:input path="newUtilisateur.codeUtilisateur" type="hidden" name="text" value="${newUtilisateur.codeUtilisateur}" class="login" />
									</div> <!-- /field -->
								</div>
								<div class="login-actions">												
									<button class="button btn btn-primary btn-large">Modifier</button>							
								</div> <!-- .actions -->
							</f:form>							
						</div> <!-- /content -->
	                </div>
                </c:if>
                
                   <div class="content clearfix">
                    <table class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th> CIN </th>
                          <th> NOM </th>
                          <th> PRENOM </th>
                          <th> DATE DE NAISSANCE </th>
                          <th> TELEPHONE </th>
                          <th> VILLE </th>
                          <th> ADRESSE </th>
                          <th> USERNAME </th>
                          <th> PASSWORD </th>
                          <th> RÔLE </th>
                          <th class="td-actions"> </th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${utilisateurModel.utilisateurs}" var="user">                 
                        <tr>
                          <td> ${ user.cin } </td>
                          <td> ${ user.nom } </td>
                          <td> ${ user.prenom } </td>
                          <td> ${ user.dateNaissance } </td>
                          <td> ${ user.telephone } </td>
                          <td> ${ user.ville } </td>
                          <td> ${ user.adresse } </td>
                          <td> ${ user.username } </td>
                          <td> ${ user.password } </td>
                          <td> ${ user } </td>
                          <td class="td-actions">
                          	<a href="/ma/utilisateurs/modify?ref=${ user.codeUtilisateur}" class="btn btn-small btn-success"><i class="btn-icon-only icon-pencil"> </i></a>
                          	<a href="/ma/utilisateurs/remove?ref=${ user.codeUtilisateur}" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a></td>
                        </tr>
                        </c:forEach>              
                      </tbody>
                    </table>
                   </div>
                </div>
                



 
                <c:if test="${ utilisateurModel.newOrModify == false }">
	                <div class="tab-pane" id="jscontrols">
	                	<div class="widget-content">
							<f:form modelAttribute="utilisateurModel" action="/ma/utilisateurs/new" method="post">
								<h3>Ajouter un utilisateur</h3>			
								<div class="login-fields">
									<div class="field">
										<label>CIN :</label>
										<f:input path="newUtilisateur.cin" type="text" name="cin" placeholder="CIN" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>NOM :</label>
										<f:input path="newUtilisateur.nom" type="text" name="nom" placeholder="NOM" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PRENOM :</label>
										<f:input path="newUtilisateur.prenom" type="text" name="prenom" placeholder="PRENOM" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>DATE DE NAISSANCE :</label>
										<f:input path="dateNaissance" type="text"  name="dateNaissance" placeholder="DATE DE NAISSANCE" class="login" />
									</div>  <!-- /field -->
									<div class="field">
										<label>VILLE :</label>
										<f:input path="newUtilisateur.ville" type="text" name="ville" placeholder="VILLE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>ADRESSE :</label>
										<f:input path="newUtilisateur.adresse" type="text" name="adresse" placeholder="ADRESSE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>EMAIL :</label>
										<f:input path="newUtilisateur.email" type="email" name="email" placeholder="EMAIL" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>TELEPHONE :</label>
										<f:input path="newUtilisateur.telephone" type="text" name="telephone" placeholder="TELEPHONE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>USERNAME :</label>
										<f:input path="newUtilisateur.username" type="text" name="username" placeholder="USERNAME" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PASSWORD :</label>
										<f:input path="newUtilisateur.password" type="password" name="password" placeholder="PASSWORD" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>SEXE :</label>
										<f:select path="newUtilisateur.genre">
											<f:option value="H">HOMME</f:option>
											<f:option value="F">FEMME</f:option>
										</f:select>
									</div> <!-- /field -->
									<div class="field">
										<label>RÔLE :</label>
										<f:select path="role">
											<f:option value="admin">admin</f:option>
											<f:option value="client">client</f:option>
											<f:option value="agent">agent</f:option>
										</f:select>
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

