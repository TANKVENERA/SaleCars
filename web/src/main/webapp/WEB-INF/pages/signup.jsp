<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="begin-html.jsp" %>

<form class="form-horizontal"  method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Регистрация нового пользователя</legend>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Логин</label>
            <div class="col-md-4">
                <input id="login" name="Login" type="text"  placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <input id="password" name="Password" type="password"  placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите пароль не менее 8 символов</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">E-mail</label>
            <div class="col-md-4">
                <input id="email" name="Email" type="text"  placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите E-mail</span>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Роль пользователя (не требуется)</label>
            <div class="col-md-4">
                <select id="role" name="FK_Role" class="form-control">
                    <option value="1">User</option>
                    <option value="2">Administrator</option>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрировать</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="end-html.jsp" %>
