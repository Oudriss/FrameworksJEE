<%@ include file="theme/header.jsp" %>

<div class="account-container">
	
	<div class="content clearfix">
		
		 <f:form modelAttribute="authentificationModel" action="/ma/connecter" method="post">
		
			<h1>Authentification</h1>		
			
			<div class="login-fields">
				
				<p>Entrez vos codes d'accès, svp.</p>
				
				<div class="field">
					<label for="username">Username</label>
					<f:input path="username" type="text" id="username" name="username" value="" placeholder="Username" class="login username-field" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">Password:</label>
					<f:input path="password" type="password" id="password" name="password" value="" placeholder="Password" class="login password-field"/>
				</div> <!-- /password -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">

									
				<button class="button btn btn-success btn-large">Connecter</button>
				
			</div> <!-- .actions -->
			
			
		</f:form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<%@ include file="theme/footer.jsp" %>
