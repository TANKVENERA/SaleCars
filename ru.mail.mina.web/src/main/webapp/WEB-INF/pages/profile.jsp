<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Login:<b>          ${user.login}</b></p>
    <br />
    <p>Email:<b>          ${user.email}</b></p>
    <br />

 <p><b>Мои заявки </b></p>
      <div class="row">
        <div class="col-md-1">№</div>
        <div class="col-md-1">Модель</div>
        <div class="col-md-2">Год выпуска</div>
        <div class="col-md-1">Пробег</div>
        <div class="col-md-3">Описание поломки</div>
      </div>
   <% Integer i=0; %>
   <c:forEach items="${forms}" var="form">
      <br />
      <div class="row">
        <div class="col-md-1"><% out.print(++i); %></div>
        <div class="col-md-1">${form.carModel} </div>
        <div class="col-md-2">${form.yearOfIssue}</div>
        <div class="col-md-1">${form.mileage}</div>
        <div class="col-md-3">${form.descriptionOfBreakage}</div>
      </div>
   </c:forEach>
<br />

<form class="form-horizontal"  method="POST">
   <fieldset>
        <!-- Form Name -->
<br />
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Завершить сеанс</button>
            </div>
        </div>
    </fieldset>
</form>

<%@ include file="end-html.jsp" %>
