<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="begin-html.jsp" %>

<form class="form-horizontal" action="${pageContext.request.contextPath}/login" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Авторизация пользователя</legend>

        <!-- Login input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Логин</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text"  placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Password">Пароль</label>
            <div class="col-md-4">
                <input id="Password" name="Password" type="password"  placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите пароль</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="end-html.jsp" %>
