package inlyit.mardeev.plugin.myPlugin.servlet;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import inlyit.mardeev.plugin.myPlugin.service.MyPluginService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MyPluginServlet extends HttpServlet {

    private final MyPluginService service;

    public MyPluginServlet(MyPluginService service) {
        this.service = service;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        IssueManager issueManager = ComponentAccessor.getIssueManager();
        List<Issue> issues= issueManager.getIssueObjects(null);
        List<Issue> freeIssues = service.getFreeIssues(issues);

    }
}

