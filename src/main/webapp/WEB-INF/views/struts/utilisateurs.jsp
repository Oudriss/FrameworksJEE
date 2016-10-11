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
            
            <c:if test ="${ not empty utilisateurModel.message}">
            	<span>${utilisateurModel.message}</span>
            </c:if>
            
            <div class="tabbable">
            <ul class="nav nav-tabs">
              <li>
                <a href="#formcontrols" data-toggle="tab">Liste des utilisateurs</a>
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
                        <s:iterator value="utilisateurModel.utilisateurs">                 
                        <tr>
                          <td> <s:property value="cin"></s:property> </td>
                          <td> <s:property value="nom"></s:property> </td>
                          <td> <s:property value="prenom"></s:property> </td>
                          <td> <s:property value="dateNaissance"></s:property> </td>
                          <td> <s:property value="telephone"></s:property> </td>
                          <td> <s:property value="ville"></s:property> </td>
                          <td> <s:property value="addresse"></s:property> </td>
                          <td> <s:property value="username"></s:property> </td>
                          <td> <s:property value="password"></s:property> </td>
                          <td> <s:property value="user"></s:property> </td>
                          <td class="td-actions">
                          <s:url namespace="/" action="comptes/remove" var="lien1">
									<s:param name="ref">
										<s:property value="codeUtilisateur"/>
									</s:param>
								</s:url>
								<s:url namespace="/" action="comptes/modify" var="lien2">
									<s:param name="ref">
										<s:property value="codeUtilisateur"/>
									</s:param>
								</s:url>
                          	<a href="%{lien1}" class="btn btn-small btn-success"><i class="btn-icon-only icon-pencil"> </i></a>
                          	<a href="%{lien2}" class="btn btn-danger btn-small"><i class="btn-icon-only icon-remove"> </i></a></td>
                        </tr>
                        </s:iterator>              
                      </tbody>
                    </table>
                   </div>
                </div>
                



 
                <c:if test="${ utilisateurModel.newOrModify == false }">
	                <div class="tab-pane" id="jscontrols">
	                	<div class="content clearfix">
							<s:form  action="utilisateurs/new" method="post">
								<h3>Ajouter un utilisateur</h3>			
								<div class="login-fields">
									<div class="field">
										<label>CIN :</label>
										<s:textfield name="newUtilisateur.cin" type="text"  placeholder="CIN" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>NOM :</label>
										<s:textfield name="newUtilisateur.nom" type="text"  placeholder="NOM" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PRENOM :</label>
										<s:textfield name="newUtilisateur.prenom" type="text" placeholder="PRENOM" class="login" />
									</div> <!-- /field -->
									<!-- <div class="field">
										<label>DATE DE NAISSANCE :</label>
										<f:input path="newUtilisateur.dateNaissance" type="text" name="dateNaissance" placeholder="DATE DE NAISSANCE" class="login" />
									</div> --> <!-- /field -->
									<div class="field">
										<label>VILLE :</label>
										<s:textfield name="newUtilisateur.ville" type="text" name="ville" placeholder="VILLE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>ADRESSE :</label>
										<s:textfield name="newUtilisateur.adresse" type="text" name="adresse" placeholder="ADRESSE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>EMAIL :</label>
										<s:textfield name="newUtilisateur.email" type="email" name="email" placeholder="EMAIL" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>TELEPHONE :</label>
										<s:textfield name="newUtilisateur.telephone" type="text" name="telephone" placeholder="TELEPHONE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>USERNAME :</label>
										<s:textfield name="newUtilisateur.username" type="text" name="username" placeholder="USERNAME" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PASSWORD :</label>
										<s:textfield name="newUtilisateur.password" type="password" name="password" placeholder="PASSWORD" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PASSWORD CONFIRMATION :</label>
										<s:textfield name="newUtilisateur.password" type="password" name="password" placeholder="PASSWORD" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>SEXE :</label>
										<s:select name="newUtilisateur.genre" list="">

										</s:select>
									</div> <!-- /field -->
									<div class="field">
										<label>RÔLE :</label>
										<s:select path="role" list="">

										</s:select>
									</div> <!-- /field -->
								</div>
								<div class="login-actions">												
									<s:submit value="valider" class="button btn btn-primary btn-large"></s:submit>							
								</div> <!-- .actions -->
							</s:form>
						</div> <!-- /content -->
	                </div>
                </c:if>
                
                 <c:if test="${ utilisateurModel.newOrModify == true }">
	                <div class="tab-pane" id="jscontrols">
	                	<div class="content clearfix">
							<s:form  action="utilisateurs/postModify" method="post">
								<h3>Modifier l'utilisateur</h3>			
								<div class="login-fields">
									<div class="field">
										<label>CIN :</label>
										<s:textfield name="newUtilisateur.cin" type="text"  placeholder="CIN" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>NOM :</label>
										<s:textfield name="newUtilisateur.nom" type="text"  placeholder="NOM" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PRENOM :</label>
										<s:textfield name="newUtilisateur.prenom" type="text" placeholder="PRENOM" class="login" />
									</div> <!-- /field -->
									<!-- <div class="field">
										<label>DATE DE NAISSANCE :</label>
										<f:input path="newUtilisateur.dateNaissance" type="text" name="dateNaissance" placeholder="DATE DE NAISSANCE" class="login" />
									</div> --> <!-- /field -->
									<div class="field">
										<label>VILLE :</label>
										<s:textfield name="newUtilisateur.ville" type="text" name="ville" placeholder="VILLE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>ADRESSE :</label>
										<s:textfield name="newUtilisateur.adresse" type="text" name="adresse" placeholder="ADRESSE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>EMAIL :</label>
										<s:textfield name="newUtilisateur.email" type="email" name="email" placeholder="EMAIL" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>TELEPHONE :</label>
										<s:textfield name="newUtilisateur.telephone" type="text" name="telephone" placeholder="TELEPHONE" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>USERNAME :</label>
										<s:textfield name="newUtilisateur.username" type="text" name="username" placeholder="USERNAME" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PASSWORD :</label>
										<s:textfield name="newUtilisateur.password" type="password" name="password" placeholder="PASSWORD" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>PASSWORD CONFIRMATION :</label>
										<s:textfield name="newUtilisateur.password" type="password" name="password" placeholder="PASSWORD" class="login" />
									</div> <!-- /field -->
									<div class="field">
										<label>SEXE :</label>
										<s:select name="newUtilisateur.genre" list="">

										</s:select>
									</div> <!-- /field -->
									<div class="field">
										<label>RÔLE :</label>
										<s:select path="role" list="">

										</s:select>
									</div> <!-- /field -->
								</div>
								<div class="login-actions">												
									<s:submit value="valider" class="button btn btn-primary btn-large"></s:submit>							
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

