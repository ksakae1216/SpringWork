<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html >
<head>
  <meta charset="UTF-8">
  <title>Simple Form with Icons</title>
  <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
  <div style="padding-top: 100px;">
	  <fieldset>
	    <h1>Login</h1>
	    <form id="login_form" method="post" th:action="@{'/doLogin'}">
	      <div class="iconUser"></div>
	        <input type="text" placeholder="ユーザー名" name="login_id" required>
	        <br><br>
	      <div class="iconPassword"></div>
	    	<input type="password" placeholder="パスワード" name="login_password" required>
	    	<input type="submit" value="ログイン">
	    </form>
	  </fieldset>
  </div>
</body>
</html>