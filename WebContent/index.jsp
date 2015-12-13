<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:root>
	<ul>
		<c:forEach items="${trips}" var="trip">
			<li>
				<c:out value="${trip.origin.name}" />
				 <div class="tutut col-md-5">

        <div class="omb_login">
      <h3 class="omb_authTitle">Login ou <a href="creation.html">Sign up</a></h3>
    

    <div class="row omb_row-sm-offset-3 omb_loginOr">
      <div class="col-xs-12 ">
        <hr class="omb_hrOr">
        
      </div>
    </div>

    <div class="row omb_row-sm-offset-3">
      <div class="col-xs-12 ">  
          <form class="omb_loginForm" action="" autocomplete="off" method="POST">
          <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="number" class="form-control" name="username" placeholder="Campus id">
          </div>
          <span class="help-block"></span>
                    
          <div class="input-group dede">
            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
            <input  type="password" class="form-control " name="password" placeholder="Password">
          </div>
                    <span class="help-block">Password error</span>

          <button class="btn btn-lg btn-primary btn-block dede" type="submit">Login</button>
        </form>
      </div>
      </div>
    <div class="row omb_row-sm-offset-3">
      <div class="col-xs-12 che">
        <label class="checkbox">
          <input type="checkbox" value="remember-me">Remember Me
        </label>
      </div>
      <div class="col-xs-12">
        <p class="omb_forgotPwd">
          <a href="#">Password perdu?</a>
        </p>
      </div>
    <div class="col-xs-12">
      <h1>Benvenue</h1>
      Consultez le guide touristique de cette agence de voyage en ligne vous donnant des informations par destination !<br>
      Ici vous trouverez la liste des voyages pas campus.<br>
      Si vous avez un compte il suffit de vous logger juste au dessus.<br>
      Sinon cliqué sur "Signup" et creer votre propre compte !<br>
    </div>
  </div>        
</div>


      </div>
      
  <div class="col-md-5 col-md-offset-1 mama">
    <div id="wrapper">
  <div id="header">
    <p id="txt_title">Statistiques voyages</p>
    <p id="txt_subtitle">Top 5 des destinations par année.</p>
  </div>

  <div id="q2_2010">
  <div id="q1_2010">
  <div id="q4_2009">
  <div id="q3_2009">
  <div id="q2_2009">
  <div id="q1_2005">
    <div id="labels">
      <ul>
        <li><span></span>Paris</li>
        <li><span></span>Londre</li>
        <li><span></span>Lyon</li>
        <li><span></span>Grenoble</li>
        <li><span></span>Reims</li>
      </ul>
    </div>
    
    <div id="percentage_wrapper">
      <div id="percentage">
        <ul>
          <li><p>60.14%</p><p>61.79%</p><p>63.90%</p><p>67.02%</p><p>68.28%</p><p>89.68%</p></li>
          <li><p>24.98%</p><p>24.56%</p><p>24.39%</p><p>23.28%</p><p>23.22%</p><p>6.83%</p></li>
          <li><p>7.14%</p><p>6.03%</p><p>4.27%</p><p>3.08%</p><p>2.35%</p><p>0%</p></li>
          <li><p>5.10%</p><p>4.91%</p><p>4.64%</p><p>4.35%</p><p>3.89%</p><p>2.36%</p></li>
          <li><p>2.66%</p><p>2.73%</p><p>2.52%</p><p>2.29%</p><p>2.27%</p><p>1.15%</p></li>
        </ul>
      </div>
    </div>
    <div id="slider">
      <div id="chart_holder">
        <div id="pie_chart">
          <ul>
            <li id="c1_r"><p><span class="pie_left"></span></p></li>  
            <li id="c1_l"><p><span class="pie_right"></span></p></li>
            <li id="c2_r"><p><span class="pie_left"></span></p></li>  
            <li id="c2_l"><p><span class="pie_right"></span></p></li>
            <li id="c3_r"><p><span class="pie_left"></span></p></li>  
            <li id="c3_l"><p><span class="pie_right"></span></p></li>
            <li id="c4_r"><p><span class="pie_left"></span></p></li>  
            <li id="c4_l"><p><span class="pie_right"></span></p></li>
            <li id="c5_r"><p><span class="pie_left"></span></p></li>  
            <li id="c5_l"><p><span class="pie_right"></span></p></li>
          </ul>
        </div>
        <div id="pyr_chart">
          <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
          </ul>
        </div>
      </div>
    </div>
    <div id="btn_panel">
      <ul>
        <li><a href="#q1_2005"><span>Q1</span><span>2010</span></a></li>
        <li><a href="#q2_2009"><span>Q2</span><span>2011</span></a></li>
        <li><a href="#q3_2009"><span>Q3</span><span>2012</span></a></li>
        <li><a href="#q4_2009"><span>Q4</span><span>2013</span></a></li>
        <li><a href="#q1_2010"><span>Q1</span><span>2014</span></a></li>
        <li><a href="#q2_2010"><span>Q2</span><span>2015</span></a></li>
      </ul>
    </div>
  </div> <!--q1_2005-->
  </div> <!--q2_2009-->
  </div> <!--q3_2009-->
  </div> <!--q4_2009-->
  </div> <!--q1_2010-->
  </div> <!--q2_2010-->
</div>

  </div>
				<c:out value="${trip.destination.name}" />
			</li>
		</c:forEach>
	</ul>
</t:root>
