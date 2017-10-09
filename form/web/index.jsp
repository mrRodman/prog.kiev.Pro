<!DOCTYPE HTML>
<html>
  <head>
    <title>Some test</title>
  </head>
  <body>
    <% String login = (String)session.getAttribute("usLogin");
    Integer count = (Integer)session.getAttribute("count");
    if (count == null)
        session.setAttribute("count", new Integer(0));
    String question = (String)session.getAttribute("question");
    String[] answers = (String[])session.getAttribute("answers");


    if (login == null || login.equals("")) { %>
    <form action="/login" method="post">
      Login:<br>
      <input type="text" name="login"><br>
      Password:<br>
      <input type="text" name="password"><br>
      <input type="submit" value="enter">
    </form>
    <a href="/registration.jsp"><input type="button" value="registration"></a>
    <% } else {
      if (count > 2) {%>
        <h1 align="center">Test has finished</h1>
        <a href="/accept"><input type="button" value="view results"></a>

      <%} else {%>
          <form action="/accept" method="post">
            <p><strong><%=question%>:</strong></p>

            <% for (String temp : answers) { %>
                <p><input name="question" type="radio" value='<%=temp%>'><%= temp%></p>
            <% } %>
            <p><input type="submit" value="accept"></p>
          </form>
    <%}
    } %>
  </body>
</html>
