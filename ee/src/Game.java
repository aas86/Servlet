import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class Game extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/users?useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User currentUser = new User(login, password);
        SystemLogin.checkDataBAse(URL, LOGIN, PASSWORD);

        currentUser = SystemLogin.signingIn(currentUser, URL, LOGIN, PASSWORD);
        if (currentUser != null) {
            System.out.println("Залогинились");
            resp.getWriter().write(new Page().mainPage(currentUser.getName(), currentUser.getHealth(),
                    currentUser.getRating()));//
        } else {
            resp.getWriter().write(new Page().wrongPassword());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ss = req.getQueryString();
        if (req.getQueryString() == null || req.getQueryString().equals("")) {
            resp.getWriter().write(new Page().loginPage());
        } else if (req.getParameter("num").equals("Fight")) {
            String userName = req.getParameter("userName");
            String userHealth = req.getParameter("userHealth");
            String userRating = req.getParameter("userRating");
            resp.getWriter().write(new Page().fightPage(userName, userRating));
        } else if (req.getParameter("num").equals("Begin")){
            resp.getWriter().write("");
        }
    }

}
