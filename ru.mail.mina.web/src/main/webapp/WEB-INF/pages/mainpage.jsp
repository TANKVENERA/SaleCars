<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <!-- Основное содержимое -->
      <div class="page-header">
        <h2>Автосервис</h2>
        <p class="lead">Очередь всех заявок</p>
      </div>

      <div class="row">
        <div class="col-md-1">№</div>
        <div class="col-md-1">Модель</div>
        <div class="col-md-1">Год выпуска</div>
        <div class="col-md-1">Пробег </div>
         <div class="col-md-7">Описание поломки </div>
         </div>

     <% Integer i=0; %>
               <c:forEach items="${forms}" var="form">
                  <br />
                  <div class="row">

                    <div class="col-md-1"><% out.print(++i); %></div>
                    <div class="col-md-1">${form.carModel} </div>
                    <div class="col-md-1">${form.yearOfIssue}</div>
                    <div class="col-md-1">${form.mileage}</div>
                    <div class="col-md-7">${form.descriptionOfBreakage}</div>

                  </div>
               </c:forEach>

<%@ include file="end-html.jsp" %>



