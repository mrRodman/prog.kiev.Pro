import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FormServlet extends javax.servlet.http.HttpServlet {
    private AtomicInteger count = new AtomicInteger();
    private static ArrayList<String> questions = new ArrayList<>();
    private static ArrayList<String[]> answers = new ArrayList<>();
    private static Map<String, Map<String, Integer>> personalResults = new HashMap<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static String currentLogin;

    static {
        questions.add("Question 1");
        questions.add("Question 2");
        questions.add("Question 3");

        answers.add(new String[] {"answ1.1", "answ1.2", "answ1.3",});
        answers.add(new String[] {"answ2.1", "answ2.2", "answ2.3",});
        answers.add(new String[] {"answ3.1", "answ3.2", "answ3.3",});
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Integer temp = (Integer) session.getAttribute("count");

        String answ = req.getParameter("question");
        for (int i = 0; i < questions.size(); i++) {
            if (count.get() == i) {
                personalResults.put(questions.get(i), this.personalStatistics(answ));
            }
        }

        count.set(temp);
        temp = count.incrementAndGet();
        for (int i = 0; i < questions.size(); i++) {
            if (count.get() == i) {
                session.setAttribute("question", questions.get(i));
                session.setAttribute("answers", answers.get(i));
            }
        }
        session.setAttribute("count", temp);
        resp.sendRedirect("index.jsp");
    }

    private Map<String, Integer> personalStatistics(String answ) {
        Map<String, Integer> answStatistics = new HashMap<>();
        if (!answStatistics.containsKey(answ))
            answStatistics.put(answ, 1);
        return answStatistics;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder result = new StringBuilder();
        
        result.append(pickUser());
        result.append(fillResultLine());

        HttpSession session = req.getSession(true);
        session.setAttribute("stat", result.toString());
        resp.sendRedirect("statistics.jsp");
    }

    private String pickUser() {
        StringBuilder result = new StringBuilder();
        for (User user : users) {
            if (user.getLogin().equals(currentLogin)) {
                result.append(currentLogin);
                result.append(":");
                result.append("<br>");
                break;
            }
        }
        return result.toString();
    }

    private String fillResultLine() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Map<String, Integer>> outMap : personalResults.entrySet()) {
            result.append(outMap.getKey());
            result.append(": ");
            for (Map.Entry<String, Integer> inMap : outMap.getValue().entrySet()) {
                result.append(inMap.getKey() + " - " + inMap.getValue() + "<br>");
            }
            result.append("<br>");
            result.append("<br>");
        }
        return result.toString();
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static ArrayList getQuestions() {
        return questions;
    }

    public static ArrayList<String[]> getAnswers() {
        return answers;
    }

    public static void setCurrentLogin(String currentLogin) {
        FormServlet.currentLogin = currentLogin;
    }
}
