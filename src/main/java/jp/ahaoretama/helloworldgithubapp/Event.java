package jp.ahaoretama.helloworldgithubapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * @author aha-oretama
 */

// PullRequestReviewCommentEvent is sent in following format.
// {
//  "action": "created",
//  "comment": {
//    "url": "https://api.github.com/repos/aha-oretama/test/pulls/comments/175508368",
//    "pull_request_review_id": 105048929,
//    "id": 175508368,
//    "diff_hunk": "@@ -0,0 +1,16 @@\n+package test;\n+\n+/**\n+ * @author aha-oretama\n+ * @Date 2017/07/15\n+ */\n+public class Test {",
//    "path": "Test",
//    "position": 7,
//    "original_position": 7,
//    "commit_id": "3886463bce7ba891376f69beac82ad61e1f23b80",
//    "original_commit_id": "3886463bce7ba891376f69beac82ad61e1f23b80",
//    "user": {
//      "login": "aha-oretama",
//      "id": 7259161,
//      "avatar_url": "https://avatars0.githubusercontent.com/u/7259161?v=4",
//      "gravatar_id": "",
//      "url": "https://api.github.com/users/aha-oretama",
//      "html_url": "https://github.com/aha-oretama",
//      "followers_url": "https://api.github.com/users/aha-oretama/followers",
//      "following_url": "https://api.github.com/users/aha-oretama/following{/other_user}",
//      "gists_url": "https://api.github.com/users/aha-oretama/gists{/gist_id}",
//      "starred_url": "https://api.github.com/users/aha-oretama/starred{/owner}{/repo}",
//      "subscriptions_url": "https://api.github.com/users/aha-oretama/subscriptions",
//      "organizations_url": "https://api.github.com/users/aha-oretama/orgs",
//      "repos_url": "https://api.github.com/users/aha-oretama/repos",
//      "events_url": "https://api.github.com/users/aha-oretama/events{/privacy}",
//      "received_events_url": "https://api.github.com/users/aha-oretama/received_events",
//      "type": "User",
//      "site_admin": false
//    },
//    "body": "hello",
//    "created_at": "2018-03-19T16:55:33Z",
//    "updated_at": "2018-03-19T16:55:39Z",
//    "html_url": "https://github.com/aha-oretama/test/pull/1#discussion_r175508368",
//    "pull_request_url": "https://api.github.com/repos/aha-oretama/test/pulls/1",
//    "author_association": "OWNER",
//    "_links": {
//      "self": {
//        "href": "https://api.github.com/repos/aha-oretama/test/pulls/comments/175508368"
//      },
//      "html": {
//        "href": "https://github.com/aha-oretama/test/pull/1#discussion_r175508368"
//      },
//      "pull_request": {
//        "href": "https://api.github.com/repos/aha-oretama/test/pulls/1"
//      }
//    }
//  },
//  "pull_request": {
//    "url": "https://api.github.com/repos/aha-oretama/test/pulls/1",
//    "id": 130735011,
//    "html_url": "https://github.com/aha-oretama/test/pull/1",
//    "diff_url": "https://github.com/aha-oretama/test/pull/1.diff",
//    "patch_url": "https://github.com/aha-oretama/test/pull/1.patch",
//    "issue_url": "https://api.github.com/repos/aha-oretama/test/issues/1",
//    "number": 1,
//    "state": "open",
//    "locked": false,
//    "title": "create TestFile",
//    "user": {
//      "login": "aha-oretama",
//      "id": 7259161,
//      "avatar_url": "https://avatars0.githubusercontent.com/u/7259161?v=4",
//      "gravatar_id": "",
//      "url": "https://api.github.com/users/aha-oretama",
//      "html_url": "https://github.com/aha-oretama",
//      "followers_url": "https://api.github.com/users/aha-oretama/followers",
//      "following_url": "https://api.github.com/users/aha-oretama/following{/other_user}",
//      "gists_url": "https://api.github.com/users/aha-oretama/gists{/gist_id}",
//      "starred_url": "https://api.github.com/users/aha-oretama/starred{/owner}{/repo}",
//      "subscriptions_url": "https://api.github.com/users/aha-oretama/subscriptions",
//      "organizations_url": "https://api.github.com/users/aha-oretama/orgs",
//      "repos_url": "https://api.github.com/users/aha-oretama/repos",
//      "events_url": "https://api.github.com/users/aha-oretama/events{/privacy}",
//      "received_events_url": "https://api.github.com/users/aha-oretama/received_events",
//      "type": "User",
//      "site_admin": false
//    },
//    "body": "",
//    "created_at": "2017-07-16T01:02:05Z",
//    "updated_at": "2018-03-19T16:55:39Z",
//    "closed_at": null,
//    "merged_at": null,
//    "merge_commit_sha": "a3d566e1f0516759b79b0e86c80ba718636b86c5",
//    "assignee": null,
//    "assignees": [
//
//    ],
//    "requested_reviewers": [
//
//    ],
//    "requested_teams": [
//
//    ],
//    "labels": [
//
//    ],
//    "milestone": null,
//    "commits_url": "https://api.github.com/repos/aha-oretama/test/pulls/1/commits",
//    "review_comments_url": "https://api.github.com/repos/aha-oretama/test/pulls/1/comments",
//    "review_comment_url": "https://api.github.com/repos/aha-oretama/test/pulls/comments{/number}",
//    "comments_url": "https://api.github.com/repos/aha-oretama/test/issues/1/comments",
//    "statuses_url": "https://api.github.com/repos/aha-oretama/test/statuses/3886463bce7ba891376f69beac82ad61e1f23b80",
//    "head": {
//      "label": "aha-oretama:test",
//      "ref": "test",
//      "sha": "3886463bce7ba891376f69beac82ad61e1f23b80",
//      "user": {
//        "login": "aha-oretama",
//        "id": 7259161,
//        "avatar_url": "https://avatars0.githubusercontent.com/u/7259161?v=4",
//        "gravatar_id": "",
//        "url": "https://api.github.com/users/aha-oretama",
//        "html_url": "https://github.com/aha-oretama",
//        "followers_url": "https://api.github.com/users/aha-oretama/followers",
//        "following_url": "https://api.github.com/users/aha-oretama/following{/other_user}",
//        "gists_url": "https://api.github.com/users/aha-oretama/gists{/gist_id}",
//        "starred_url": "https://api.github.com/users/aha-oretama/starred{/owner}{/repo}",
//        "subscriptions_url": "https://api.github.com/users/aha-oretama/subscriptions",
//        "organizations_url": "https://api.github.com/users/aha-oretama/orgs",
//        "repos_url": "https://api.github.com/users/aha-oretama/repos",
//        "events_url": "https://api.github.com/users/aha-oretama/events{/privacy}",
//        "received_events_url": "https://api.github.com/users/aha-oretama/received_events",
//        "type": "User",
//        "site_admin": false
//      },
//      "repo": {
//        "id": 97314451,
//        "name": "test",
//        "full_name": "aha-oretama/test",
//        "owner": {
//          "login": "aha-oretama",
//          "id": 7259161,
//          "avatar_url": "https://avatars0.githubusercontent.com/u/7259161?v=4",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/aha-oretama",
//          "html_url": "https://github.com/aha-oretama",
//          "followers_url": "https://api.github.com/users/aha-oretama/followers",
//          "following_url": "https://api.github.com/users/aha-oretama/following{/other_user}",
//          "gists_url": "https://api.github.com/users/aha-oretama/gists{/gist_id}",
//          "starred_url": "https://api.github.com/users/aha-oretama/starred{/owner}{/repo}",
//          "subscriptions_url": "https://api.github.com/users/aha-oretama/subscriptions",
//          "organizations_url": "https://api.github.com/users/aha-oretama/orgs",
//          "repos_url": "https://api.github.com/users/aha-oretama/repos",
//          "events_url": "https://api.github.com/users/aha-oretama/events{/privacy}",
//          "received_events_url": "https://api.github.com/users/aha-oretama/received_events",
//          "type": "User",
//          "site_admin": false
//        },
//        "private": false,
//        "html_url": "https://github.com/aha-oretama/test",
//        "description": null,
//        "fork": false,
//        "url": "https://api.github.com/repos/aha-oretama/test",
//        "forks_url": "https://api.github.com/repos/aha-oretama/test/forks",
//        "keys_url": "https://api.github.com/repos/aha-oretama/test/keys{/key_id}",
//        "collaborators_url": "https://api.github.com/repos/aha-oretama/test/collaborators{/collaborator}",
//        "teams_url": "https://api.github.com/repos/aha-oretama/test/teams",
//        "hooks_url": "https://api.github.com/repos/aha-oretama/test/hooks",
//        "issue_events_url": "https://api.github.com/repos/aha-oretama/test/issues/events{/number}",
//        "events_url": "https://api.github.com/repos/aha-oretama/test/events",
//        "assignees_url": "https://api.github.com/repos/aha-oretama/test/assignees{/user}",
//        "branches_url": "https://api.github.com/repos/aha-oretama/test/branches{/branch}",
//        "tags_url": "https://api.github.com/repos/aha-oretama/test/tags",
//        "blobs_url": "https://api.github.com/repos/aha-oretama/test/git/blobs{/sha}",
//        "git_tags_url": "https://api.github.com/repos/aha-oretama/test/git/tags{/sha}",
//        "git_refs_url": "https://api.github.com/repos/aha-oretama/test/git/refs{/sha}",
//        "trees_url": "https://api.github.com/repos/aha-oretama/test/git/trees{/sha}",
//        "statuses_url": "https://api.github.com/repos/aha-oretama/test/statuses/{sha}",
//        "languages_url": "https://api.github.com/repos/aha-oretama/test/languages",
//        "stargazers_url": "https://api.github.com/repos/aha-oretama/test/stargazers",
//        "contributors_url": "https://api.github.com/repos/aha-oretama/test/contributors",
//        "subscribers_url": "https://api.github.com/repos/aha-oretama/test/subscribers",
//        "subscription_url": "https://api.github.com/repos/aha-oretama/test/subscription",
//        "commits_url": "https://api.github.com/repos/aha-oretama/test/commits{/sha}",
//        "git_commits_url": "https://api.github.com/repos/aha-oretama/test/git/commits{/sha}",
//        "comments_url": "https://api.github.com/repos/aha-oretama/test/comments{/number}",
//        "issue_comment_url": "https://api.github.com/repos/aha-oretama/test/issues/comments{/number}",
//        "contents_url": "https://api.github.com/repos/aha-oretama/test/contents/{+path}",
//        "compare_url": "https://api.github.com/repos/aha-oretama/test/compare/{base}...{head}",
//        "merges_url": "https://api.github.com/repos/aha-oretama/test/merges",
//        "archive_url": "https://api.github.com/repos/aha-oretama/test/{archive_format}{/ref}",
//        "downloads_url": "https://api.github.com/repos/aha-oretama/test/downloads",
//        "issues_url": "https://api.github.com/repos/aha-oretama/test/issues{/number}",
//        "pulls_url": "https://api.github.com/repos/aha-oretama/test/pulls{/number}",
//        "milestones_url": "https://api.github.com/repos/aha-oretama/test/milestones{/number}",
//        "notifications_url": "https://api.github.com/repos/aha-oretama/test/notifications{?since,all,participating}",
//        "labels_url": "https://api.github.com/repos/aha-oretama/test/labels{/name}",
//        "releases_url": "https://api.github.com/repos/aha-oretama/test/releases{/id}",
//        "deployments_url": "https://api.github.com/repos/aha-oretama/test/deployments",
//        "created_at": "2017-07-15T12:27:04Z",
//        "updated_at": "2017-07-15T12:27:04Z",
//        "pushed_at": "2017-07-16T01:02:05Z",
//        "git_url": "git://github.com/aha-oretama/test.git",
//        "ssh_url": "git@github.com:aha-oretama/test.git",
//        "clone_url": "https://github.com/aha-oretama/test.git",
//        "svn_url": "https://github.com/aha-oretama/test",
//        "homepage": null,
//        "size": 0,
//        "stargazers_count": 0,
//        "watchers_count": 0,
//        "language": null,
//        "has_issues": true,
//        "has_projects": true,
//        "has_downloads": true,
//        "has_wiki": true,
//        "has_pages": false,
//        "forks_count": 0,
//        "mirror_url": null,
//        "archived": false,
//        "open_issues_count": 1,
//        "license": null,
//        "forks": 0,
//        "open_issues": 1,
//        "watchers": 0,
//        "default_branch": "master"
//      }
//    },
//    "base": {
//      "label": "aha-oretama:master",
//      "ref": "master",
//      "sha": "4787439ebaf005188b8cd8f8a98d3f0ac4549ae7",
//      "user": {
//        "login": "aha-oretama",
//        "id": 7259161,
//        "avatar_url": "https://avatars0.githubusercontent.com/u/7259161?v=4",
//        "gravatar_id": "",
//        "url": "https://api.github.com/users/aha-oretama",
//        "html_url": "https://github.com/aha-oretama",
//        "followers_url": "https://api.github.com/users/aha-oretama/followers",
//        "following_url": "https://api.github.com/users/aha-oretama/following{/other_user}",
//        "gists_url": "https://api.github.com/users/aha-oretama/gists{/gist_id}",
//        "starred_url": "https://api.github.com/users/aha-oretama/starred{/owner}{/repo}",
//        "subscriptions_url": "https://api.github.com/users/aha-oretama/subscriptions",
//        "organizations_url": "https://api.github.com/users/aha-oretama/orgs",
//        "repos_url": "https://api.github.com/users/aha-oretama/repos",
//        "events_url": "https://api.github.com/users/aha-oretama/events{/privacy}",
//        "received_events_url": "https://api.github.com/users/aha-oretama/received_events",
//        "type": "User",
//        "site_admin": false
//      },
//      "repo": {
//        "id": 97314451,
//        "name": "test",
//        "full_name": "aha-oretama/test",
//        "owner": {
//          "login": "aha-oretama",
//          "id": 7259161,
//          "avatar_url": "https://avatars0.githubusercontent.com/u/7259161?v=4",
//          "gravatar_id": "",
//          "url": "https://api.github.com/users/aha-oretama",
//          "html_url": "https://github.com/aha-oretama",
//          "followers_url": "https://api.github.com/users/aha-oretama/followers",
//          "following_url": "https://api.github.com/users/aha-oretama/following{/other_user}",
//          "gists_url": "https://api.github.com/users/aha-oretama/gists{/gist_id}",
//          "starred_url": "https://api.github.com/users/aha-oretama/starred{/owner}{/repo}",
//          "subscriptions_url": "https://api.github.com/users/aha-oretama/subscriptions",
//          "organizations_url": "https://api.github.com/users/aha-oretama/orgs",
//          "repos_url": "https://api.github.com/users/aha-oretama/repos",
//          "events_url": "https://api.github.com/users/aha-oretama/events{/privacy}",
//          "received_events_url": "https://api.github.com/users/aha-oretama/received_events",
//          "type": "User",
//          "site_admin": false
//        },
//        "private": false,
//        "html_url": "https://github.com/aha-oretama/test",
//        "description": null,
//        "fork": false,
//        "url": "https://api.github.com/repos/aha-oretama/test",
//        "forks_url": "https://api.github.com/repos/aha-oretama/test/forks",
//        "keys_url": "https://api.github.com/repos/aha-oretama/test/keys{/key_id}",
//        "collaborators_url": "https://api.github.com/repos/aha-oretama/test/collaborators{/collaborator}",
//        "teams_url": "https://api.github.com/repos/aha-oretama/test/teams",
//        "hooks_url": "https://api.github.com/repos/aha-oretama/test/hooks",
//        "issue_events_url": "https://api.github.com/repos/aha-oretama/test/issues/events{/number}",
//        "events_url": "https://api.github.com/repos/aha-oretama/test/events",
//        "assignees_url": "https://api.github.com/repos/aha-oretama/test/assignees{/user}",
//        "branches_url": "https://api.github.com/repos/aha-oretama/test/branches{/branch}",
//        "tags_url": "https://api.github.com/repos/aha-oretama/test/tags",
//        "blobs_url": "https://api.github.com/repos/aha-oretama/test/git/blobs{/sha}",
//        "git_tags_url": "https://api.github.com/repos/aha-oretama/test/git/tags{/sha}",
//        "git_refs_url": "https://api.github.com/repos/aha-oretama/test/git/refs{/sha}",
//        "trees_url": "https://api.github.com/repos/aha-oretama/test/git/trees{/sha}",
//        "statuses_url": "https://api.github.com/repos/aha-oretama/test/statuses/{sha}",
//        "languages_url": "https://api.github.com/repos/aha-oretama/test/languages",
//        "stargazers_url": "https://api.github.com/repos/aha-oretama/test/stargazers",
//        "contributors_url": "https://api.github.com/repos/aha-oretama/test/contributors",
//        "subscribers_url": "https://api.github.com/repos/aha-oretama/test/subscribers",
//        "subscription_url": "https://api.github.com/repos/aha-oretama/test/subscription",
//        "commits_url": "https://api.github.com/repos/aha-oretama/test/commits{/sha}",
//        "git_commits_url": "https://api.github.com/repos/aha-oretama/test/git/commits{/sha}",
//        "comments_url": "https://api.github.com/repos/aha-oretama/test/comments{/number}",
//        "issue_comment_url": "https://api.github.com/repos/aha-oretama/test/issues/comments{/number}",
//        "contents_url": "https://api.github.com/repos/aha-oretama/test/contents/{+path}",
//        "compare_url": "https://api.github.com/repos/aha-oretama/test/compare/{base}...{head}",
//        "merges_url": "https://api.github.com/repos/aha-oretama/test/merges",
//        "archive_url": "https://api.github.com/repos/aha-oretama/test/{archive_format}{/ref}",
//        "downloads_url": "https://api.github.com/repos/aha-oretama/test/downloads",
//        "issues_url": "https://api.github.com/repos/aha-oretama/test/issues{/number}",
//        "pulls_url": "https://api.github.com/repos/aha-oretama/test/pulls{/number}",
//        "milestones_url": "https://api.github.com/repos/aha-oretama/test/milestones{/number}",
//        "notifications_url": "https://api.github.com/repos/aha-oretama/test/notifications{?since,all,participating}",
//        "labels_url": "https://api.github.com/repos/aha-oretama/test/labels{/name}",
//        "releases_url": "https://api.github.com/repos/aha-oretama/test/releases{/id}",
//        "deployments_url": "https://api.github.com/repos/aha-oretama/test/deployments",
//        "created_at": "2017-07-15T12:27:04Z",
//        "updated_at": "2017-07-15T12:27:04Z",
//        "pushed_at": "2017-07-16T01:02:05Z",
//        "git_url": "git://github.com/aha-oretama/test.git",
//        "ssh_url": "git@github.com:aha-oretama/test.git",
//        "clone_url": "https://github.com/aha-oretama/test.git",
//        "svn_url": "https://github.com/aha-oretama/test",
//        "homepage": null,
//        "size": 0,
//        "stargazers_count": 0,
//        "watchers_count": 0,
//        "language": null,
//        "has_issues": true,
//        "has_projects": true,
//        "has_downloads": true,
//        "has_wiki": true,
//        "has_pages": false,
//        "forks_count": 0,
//        "mirror_url": null,
//        "archived": false,
//        "open_issues_count": 1,
//        "license": null,
//        "forks": 0,
//        "open_issues": 1,
//        "watchers": 0,
//        "default_branch": "master"
//      }
//    },
//    "_links": {
//      "self": {
//        "href": "https://api.github.com/repos/aha-oretama/test/pulls/1"
//      },
//      "html": {
//        "href": "https://github.com/aha-oretama/test/pull/1"
//      },
//      "issue": {
//        "href": "https://api.github.com/repos/aha-oretama/test/issues/1"
//      },
//      "comments": {
//        "href": "https://api.github.com/repos/aha-oretama/test/issues/1/comments"
//      },
//      "review_comments": {
//        "href": "https://api.github.com/repos/aha-oretama/test/pulls/1/comments"
//      },
//      "review_comment": {
//        "href": "https://api.github.com/repos/aha-oretama/test/pulls/comments{/number}"
//      },
//      "commits": {
//        "href": "https://api.github.com/repos/aha-oretama/test/pulls/1/commits"
//      },
//      "statuses": {
//        "href": "https://api.github.com/repos/aha-oretama/test/statuses/3886463bce7ba891376f69beac82ad61e1f23b80"
//      }
//    },
//    "author_association": "OWNER"
//  },
//  "repository": {
//    "id": 97314451,
//    "name": "test",
//    "full_name": "aha-oretama/test",
//    "owner": {
//      "login": "aha-oretama",
//      "id": 7259161,
//      "avatar_url": "https://avatars0.githubusercontent.com/u/7259161?v=4",
//      "gravatar_id": "",
//      "url": "https://api.github.com/users/aha-oretama",
//      "html_url": "https://github.com/aha-oretama",
//      "followers_url": "https://api.github.com/users/aha-oretama/followers",
//      "following_url": "https://api.github.com/users/aha-oretama/following{/other_user}",
//      "gists_url": "https://api.github.com/users/aha-oretama/gists{/gist_id}",
//      "starred_url": "https://api.github.com/users/aha-oretama/starred{/owner}{/repo}",
//      "subscriptions_url": "https://api.github.com/users/aha-oretama/subscriptions",
//      "organizations_url": "https://api.github.com/users/aha-oretama/orgs",
//      "repos_url": "https://api.github.com/users/aha-oretama/repos",
//      "events_url": "https://api.github.com/users/aha-oretama/events{/privacy}",
//      "received_events_url": "https://api.github.com/users/aha-oretama/received_events",
//      "type": "User",
//      "site_admin": false
//    },
//    "private": false,
//    "html_url": "https://github.com/aha-oretama/test",
//    "description": null,
//    "fork": false,
//    "url": "https://api.github.com/repos/aha-oretama/test",
//    "forks_url": "https://api.github.com/repos/aha-oretama/test/forks",
//    "keys_url": "https://api.github.com/repos/aha-oretama/test/keys{/key_id}",
//    "collaborators_url": "https://api.github.com/repos/aha-oretama/test/collaborators{/collaborator}",
//    "teams_url": "https://api.github.com/repos/aha-oretama/test/teams",
//    "hooks_url": "https://api.github.com/repos/aha-oretama/test/hooks",
//    "issue_events_url": "https://api.github.com/repos/aha-oretama/test/issues/events{/number}",
//    "events_url": "https://api.github.com/repos/aha-oretama/test/events",
//    "assignees_url": "https://api.github.com/repos/aha-oretama/test/assignees{/user}",
//    "branches_url": "https://api.github.com/repos/aha-oretama/test/branches{/branch}",
//    "tags_url": "https://api.github.com/repos/aha-oretama/test/tags",
//    "blobs_url": "https://api.github.com/repos/aha-oretama/test/git/blobs{/sha}",
//    "git_tags_url": "https://api.github.com/repos/aha-oretama/test/git/tags{/sha}",
//    "git_refs_url": "https://api.github.com/repos/aha-oretama/test/git/refs{/sha}",
//    "trees_url": "https://api.github.com/repos/aha-oretama/test/git/trees{/sha}",
//    "statuses_url": "https://api.github.com/repos/aha-oretama/test/statuses/{sha}",
//    "languages_url": "https://api.github.com/repos/aha-oretama/test/languages",
//    "stargazers_url": "https://api.github.com/repos/aha-oretama/test/stargazers",
//    "contributors_url": "https://api.github.com/repos/aha-oretama/test/contributors",
//    "subscribers_url": "https://api.github.com/repos/aha-oretama/test/subscribers",
//    "subscription_url": "https://api.github.com/repos/aha-oretama/test/subscription",
//    "commits_url": "https://api.github.com/repos/aha-oretama/test/commits{/sha}",
//    "git_commits_url": "https://api.github.com/repos/aha-oretama/test/git/commits{/sha}",
//    "comments_url": "https://api.github.com/repos/aha-oretama/test/comments{/number}",
//    "issue_comment_url": "https://api.github.com/repos/aha-oretama/test/issues/comments{/number}",
//    "contents_url": "https://api.github.com/repos/aha-oretama/test/contents/{+path}",
//    "compare_url": "https://api.github.com/repos/aha-oretama/test/compare/{base}...{head}",
//    "merges_url": "https://api.github.com/repos/aha-oretama/test/merges",
//    "archive_url": "https://api.github.com/repos/aha-oretama/test/{archive_format}{/ref}",
//    "downloads_url": "https://api.github.com/repos/aha-oretama/test/downloads",
//    "issues_url": "https://api.github.com/repos/aha-oretama/test/issues{/number}",
//    "pulls_url": "https://api.github.com/repos/aha-oretama/test/pulls{/number}",
//    "milestones_url": "https://api.github.com/repos/aha-oretama/test/milestones{/number}",
//    "notifications_url": "https://api.github.com/repos/aha-oretama/test/notifications{?since,all,participating}",
//    "labels_url": "https://api.github.com/repos/aha-oretama/test/labels{/name}",
//    "releases_url": "https://api.github.com/repos/aha-oretama/test/releases{/id}",
//    "deployments_url": "https://api.github.com/repos/aha-oretama/test/deployments",
//    "created_at": "2017-07-15T12:27:04Z",
//    "updated_at": "2017-07-15T12:27:04Z",
//    "pushed_at": "2017-07-16T01:02:05Z",
//    "git_url": "git://github.com/aha-oretama/test.git",
//    "ssh_url": "git@github.com:aha-oretama/test.git",
//    "clone_url": "https://github.com/aha-oretama/test.git",
//    "svn_url": "https://github.com/aha-oretama/test",
//    "homepage": null,
//    "size": 0,
//    "stargazers_count": 0,
//    "watchers_count": 0,
//    "language": null,
//    "has_issues": true,
//    "has_projects": true,
//    "has_downloads": true,
//    "has_wiki": true,
//    "has_pages": false,
//    "forks_count": 0,
//    "mirror_url": null,
//    "archived": false,
//    "open_issues_count": 1,
//    "license": null,
//    "forks": 0,
//    "open_issues": 1,
//    "watchers": 0,
//    "default_branch": "master"
//  },
//  "sender": {
//    "login": "aha-oretama",
//    "id": 7259161,
//    "avatar_url": "https://avatars0.githubusercontent.com/u/7259161?v=4",
//    "gravatar_id": "",
//    "url": "https://api.github.com/users/aha-oretama",
//    "html_url": "https://github.com/aha-oretama",
//    "followers_url": "https://api.github.com/users/aha-oretama/followers",
//    "following_url": "https://api.github.com/users/aha-oretama/following{/other_user}",
//    "gists_url": "https://api.github.com/users/aha-oretama/gists{/gist_id}",
//    "starred_url": "https://api.github.com/users/aha-oretama/starred{/owner}{/repo}",
//    "subscriptions_url": "https://api.github.com/users/aha-oretama/subscriptions",
//    "organizations_url": "https://api.github.com/users/aha-oretama/orgs",
//    "repos_url": "https://api.github.com/users/aha-oretama/repos",
//    "events_url": "https://api.github.com/users/aha-oretama/events{/privacy}",
//    "received_events_url": "https://api.github.com/users/aha-oretama/received_events",
//    "type": "User",
//    "site_admin": false
//  },
//  "installation": {
//    "id": 99470
//  }
//}
@Data
public class Event {
    private String action;
    private Comment comment;
    @JsonProperty("pull_request")
    private PullRequest pullRequest;
    private Installation installation;

    @Data
    public static class Comment {
        private String id;
        private String body;
    }

    @Data
    public static class PullRequest {
        private String number;
        @JsonProperty("review_comments_url")
        private String reviewCommentsUrl;
    }

    @Data
    public static class Installation {
        private String id;
    }
}
