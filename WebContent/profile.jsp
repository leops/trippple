<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:root>
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <form class="form-horizontal" role="form">
        <fieldset>

          
          <legend>Profile Details</legend>

          <div class="form-group dede">
            <label class="col-sm-2 control-label" for="textinput">Email</label>
            <div class="col-sm-10">
              <input type="text" placeholder="email" class="form-control">
            </div>
          </div>

          
          <div class="form-group">
            <label class="col-sm-2 control-label dede" for="textinput">Nom</label>
            <div class="col-sm-4 dede">
              <input type="text" placeholder="nom" class="form-control">
            </div>

            <label class="col-sm-2 control-label dede" for="textinput">Prenom</label>
            <div class="col-sm-4 dede">
              <input type="text" placeholder="prenom" class="form-control">
            </div>
          </div>


         
          <div class="form-group dede">
            <label class="col-sm-2 control-label dede" for="textinput">Password</label>
            <div class="col-sm-10 dede">
              <input type="text" placeholder="password" class="form-control">
            </div>
          </div>

        
          <div class="form-group">
            <label class="col-sm-2 control-label dede" for="textinput">Réécrire Password</label>
            <div class="col-sm-10 dede">
              <input type="text" placeholder="password" class="form-control">
            </div>
          </div>

         
          


        
          <div class="form-group dede">
            <div class="col-sm-offset-2 col-sm-10">
              <div class="pull-right">
                <button type="submit" class="btn btn-default"><A href="profile.html" >Cancel</A></button>
                <button type="submit" class="btn btn-primary">Save</button>
              </div>
            </div>
          </div>

        </fieldset>
      </form>
    </div>
</div>
    

 </t:root>