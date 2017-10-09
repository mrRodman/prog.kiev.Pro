<!DOCTYPE HTML>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <%String mes = (String)session.getAttribute("message");
    if (mes == null)
        mes = "";%>
    <form action="/login" method="get">
        <p align="center"><font color="#dc143c"> <%=mes%></font></p>
        <p align="center">login:         <input type="text" name="login"></p>
        <p align="center">password:      <input type="text" name="password"></p>
        <p align="center">First Name:    <input type="text" name="firstName"></p>
        <p align="center">Last Name:     <input type="text" name="lastName" align="center"></p>
        <p align="center"><input type="submit" value="register"></p>
    </form>
</body>
</html>
