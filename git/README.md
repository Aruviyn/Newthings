# Github
- Creating repository
- inviting collaborator
- Editing Markdown / md. File

## Commands

Here are some lovely git commands:

| commands | description | remark |
| --- | --- | --- |
| `git clone <url>` | clone a repository into local | make an exact copy of a git repository to appear locally with all reference in-tact |
| `git remote add origin` | this allows to tell Git which remote repository in GitLab. Remote tells Git where to push and pull from. | |
| `git remote -v` | To view remote repositories. `-v` flag stands for **Verbose**  which shows you the URLs that Git has stored for the shortname to be used when reading and writing to that remote | tell us the concept of remotes other than origin |
| `git fetch <remote>` | This command goes out to that remote project and pulls down all the data from that remote project that you don’t have yet. After you do this, you should have references to all the branches from that remote, which you can merge in or inspect at any time  | with the knowledge of remotes, how do you manage multiple remotes |
| `git merge <branch>` | This command merges the specified branch’s history into the current branch. When you are ready to add your changes to the default branch, you merge the feature branch into it | tell us in what scenario do you merge branches |
| `git cherry-pick <hash>` | This command is to choose a commit from one branch and apply it onto another. This way you can still keep track of the origin of the commit and may avoid merge conflicts in the future. | tell us what cherry pick does and why dont we just copy paste contents |
| `git log --graph` | This command enables you to view your git log as a graph | you may want to illustrate how do you decorate the git log with graph, use --oneline switch to make it prettier |
| `git diff` | This command displays the differences between files in two commits or between a commit and your current repository. It is used when you want to compare two different commits with each other or two files. | when does these diffs get handy, maybe you want to look into generating patches |
| `git show <hash>` | This command shows one or more objects such as trees, tags, commits, date, author, and merge pull requests. | describe what you see in a git show output |
| `git branch` | Branch is like the directory of your project which contains all the files in it. Git repository always creates the default branch which is called master branch. | |
| `git checkout` | This command is used to switch the branches. Even after creating new branch, you are still in the master branch. | |


---
