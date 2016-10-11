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
                <a href="#formcontrols" data-toggle="tab">Liste des operations</a>
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
                          <th> Date Operation </th>
                          <th> montant </th>
                          <th> Type </th>
                        </tr>
                        
                      </thead>
                      <tbody>
                       <s:iterator value="clientModel.operations">                                       
                        <tr>
                          <td> <s:property value="dateoperation"></s:property></td>
                          <td><s:property value="type"></s:property></td>
                          <td> <s:property value="montant"></s:property></td>
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
