<%@ include file="theme/header.jsp" %>

<div class="account-container">
	
	<div class="content clearfix">
		
		 <s:form action="authentification" method="post">
		
			<h1>Authentification</h1>		
			
			<div class="login-fields">
				
				<p>Entrez vos codes d'accès, svp.</p>
				
				<div class="field">
					<label for="username">Username</label>
					<s:textfield id="username" name="authModel.username" value="" placeholder="Username" class="login username-field" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">Password:</label>
					<s:textfield  id="password" name="authModel.password" value="" placeholder="Password" class="login password-field"/>
				</div> <!-- /password -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">

									
				<s:submit value="Connecter" class="button btn btn-success btn-large"></s:submit>
				
			</div> <!-- .actions -->
			
			
		</s:form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<%@ include file="theme/footer.jsp" %>
