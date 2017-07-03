<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="begin-html.jsp" %>

<form class="form-horizontal" action="${pageContext.request.contextPath}/form" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Заполните нижепреведенную форму</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="CarModel">Модель</label>
  <div class="col-md-4">
  <input id="CarModel" name="CarModel" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Введите модель автомобиля</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="YearOfIssue">Год выпуска</label>
  <div class="col-md-4">
  <input id="YearOfIssue" name="YearOfIssue" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Введите год выпуска</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="MileAge">Пробег</label>
  <div class="col-md-4">
  <input id="MileAge" name="MileAge" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Пробег автомобиля</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="DescriptionOfBreakage">Описание поломки</label>
  <div class="col-md-4">
  <input id="DescriptionOfBreakage" name="DescriptionOfBreakage" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Введите описание поломки</span>
  </div>
</div>
  <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Отправить форму</button>
            </div>
        </div>

</fieldset>
</form>


<%@ include file="end-html.jsp" %>
