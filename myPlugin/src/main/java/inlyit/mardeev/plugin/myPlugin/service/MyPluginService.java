package inlyit.mardeev.plugin.myPlugin.service;

import com.atlassian.jira.issue.Issue;

import java.util.List;


public class MyPluginService {
    public List<Issue> getFreeIssues(List<Issue> issues) {
        return issues;
    }
}
