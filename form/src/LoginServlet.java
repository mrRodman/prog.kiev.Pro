import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private static Map<String, String> logPass = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        for (Map.Entry<String, String> map : logPass.entrySet()) {

            if (login.equals(map.getKey()) && password.equals(map.getValue())) {
                HttpSession session = req.getSession(true);
                session.setAttribute("usLogin", login);
                FormServlet.setCurrentLogin(login);

                session.setAttribute("question", FormServlet.getQuestions().get(0));
                session.setAttribute("answers", FormServlet.getAnswers().get(0));
            }
        }
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        HttpSession session = req.getSession(true);

        String[] pars = new String[] {login, password, firstName, lastName};

        for (String temp : pars) {
            if (temp == null || temp.equals("")) {
                session.setAttribute("message", "some fields are empty");
                resp.sendRedirect("registration.jsp");
                return;
            }
        }

        if (logPass.containsKey(login)) {
            session.setAttribute("message", "login is taken. Try smth else");
            resp.sendRedirect("registration.jsp");
            return;
        }

        session.setAttribute("message","");
        logPass.put(login, password);
        FormServlet.addUser(new User(firstName, lastName, login));
        resp.sendRedirect("index.jsp");
    }
}