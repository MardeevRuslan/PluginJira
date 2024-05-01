package inlyit.mardeev.plugin.myPlugin.service;

import com.atlassian.jira.issue.Issue;

import java.util.ArrayList;
import java.util.List;


public class MyPluginService {
    public List<Issue> getFreeIssues(List<Issue> issues) {
        List<Issue> freeIssues = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.getAssigneeUser() == null) {
                freeIssues.add(issue);
            }
        }
        return freeIssues;
    }
}
