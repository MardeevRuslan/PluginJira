package inlyit.mardeev.plugin.myPlugin.servlet;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import inlyit.mardeev.plugin.myPlugin.service.MyPluginService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyPluginServlet extends HttpServlet {

    private final MyPluginService service;

    public MyPluginServlet(MyPluginService service) {
        this.service = service;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        IssueManager issueManager = ComponentAccessor.getIssueManager();
        List<Issue> issues= issueManager.getIssueObjects(null);
        List<Issue> freeIssues = service.getFreeIssues(issues);
        // Выводим список задач
        out.println("<html>");
        out.println("<head><title>Open Tasks</title></head>");
        out.println("<body>");
        out.println("<h1>Open Tasks</h1>");
        out.println("<ul>");
        for (Issue issue : freeIssues) {
            out.println("<li>" + issue.getKey() + " - " + issue.getSummary() + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}

