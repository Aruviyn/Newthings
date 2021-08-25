# Github
- Creating repository
- inviting collaborator
- Editing Markdown / md. File

## Commands

Here are some git commands and their application

---

### Clone a repository

| Command | Description |
|---|---|
| `git clone <url>` | clone a repository into local |

Git is a distributed version control system. When having a git repository, you are actually carry the whole version starting from the initiation of the repository and not just partial of what it may have been like other version control like cvs, svn, clearcase.

---

### Remotes

Being a distributed version control system, one may host the repository at many places while each of them are synchronized to each other. Each of the remote may be hosted in gitlab, github, bitbucket, gogs or any other domain supporting git protocol. These exercise promote the nature of open source working culture. A project may mature in a way and being developed while at the same time it is taken into another repository to grow into another direction. We can see projects like libreoffice and openoffice being developed in their own direction. Similarly we had Jenkins and Hudson which took their own different path of life while still being able to support patches on one another.

#### Managing remotes

| Command | Description |
|---|---|
| `git remote add <new-remote>` | add a new remote called new-remote |
| `git remote -v` | shows if there are more than one remote defined for the repository |
| `git fetch <remote>` | fetches changes coming from remotes |

---

### git workflow

Checking status is important especially when we had spent time working on another stuff and we want to return to previous work in progress. Below is the git workflow if I had changed some file and how do I proceed with that

```bash
~/checkouts/Newthings >>> git status                                                                                                                                                                              
On branch issue-3
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   git/README.md

no changes added to commit (use "git add" and/or "git commit -a")
```
git status tells us which branch we are on and what are the status of the files being on the said branch.

In the sample output above it says that I have modified file git/README.md

I am going to add git/README.md file to be part of my next commit

```bash
~/checkouts/Newthings >>> git add git/README.md                                                              
```
With that I am ready to introduce the next commit. Therefore I issue git commit command with putting my git commit message in-line using -m switch

```bash                                                                                                    
~/checkouts/Newthings >>> git commit -m "issue-3 descriptive git commands and samples"                                                                                                                            
[issue-3 976b4ff] issue-3 descriptive git commands and samples
 1 file changed, 201 insertions(+), 25 deletions(-)
 rewrite git/README.md (64%)
```
Upon committing, the insertion and deletion has been recorded as part of the git log.

```bash
~/checkouts/Newthings >>> git status                                                                                                                                                                              
On branch issue-3
nothing to commit, working tree clean
```
With that, there are no more pending changes. The branch is clean from any modifications

---

### Branching

In any version control, branching is a very basic idea in introducing changes. Branching avoid multiple commits try to change the same line, which will cause a lot of conflicts if they are not being managed properly. Branches are the different evolution of the same source code but kept on their own timeline. Source code maintainer are able to switch into different branches to check what's up in their respective branches.

| Command | Description |
|---|---|
| `git branch -la` | This command will show the list of branches available, the current branch is marked by an asterisks (*). Some of the branch are marked as remotes, these branches are not tracked locally but it is available for tracking

```bash
~/checkouts/Newthings >>> git branch -la

Aruviyn-patch-2
issue-1
* issue-3
main
reorganize
remotes/origin/Aruviyn-patch-1
remotes/origin/Aruviyn-patch-2
remotes/origin/Aruviyn-patch-3
remotes/origin/HEAD -> origin/main
remotes/origin/issue-1
remotes/origin/main
remotes/origin/reorganize
```
---

### git Logging

Keeping track with commits are crucial when we are trying to getting ahead on what's going on with the work being done on a branch. It is useful to see what commits have been committed, what changes it carries and also from which branch it came from. All these information can be seen in git log.

| Command | Description |
|---|---|
| `git log --oneline --graph` | list down commits being introduced within the repository |

This is an example of git log:

```bash
~/checkouts/Newthings >>> git log --oneline --graph

* 97084ee (HEAD -> issue-3, origin/Aruviyn-patch-2, Aruviyn-patch-2) Readme.md v1
*   aef10c6 (main) Merge pull request #7 from Aruviyn/Aruviyn-patch-3
|\  
| * d6e9567 (origin/Aruviyn-patch-3) Update README.md
|/  
*   04fff32 Merge pull request #4 from Aruviyn/issue-1
|\  
| * c7ff0ee (origin/issue-1, issue-1) issue-1 add some git commands
* | edf91fe Merge pull request #1 from Aruviyn/reorganize
|\|
| * b688ef9 (origin/reorganize, reorganize) reorganize into specific directories
|/  
* e129f38 Update README.md
* 6dc64a5 Update README.md
* 02c40ff Update README.md
* 7dc7109 Initial commit
```

The git log above has been decorated with --graph and --oneline to simplify the look and the information being conveyed.

The first 7 hex characters are the hashes. A condensed form or a rather unique identifier of a commit (can be revealed with `git show` below). The commit hash is the one that describe what changes are being introduced in each commit. The next information in bracket are the list of branch the commit appear. This way you can tell in which branch the commit were introduced. Lastly there is the commit message.

---

### git show

We can reveal what commit has been introduced by `git show`

The information being revealed here include when the commit was introduced, who was committing the changes and also diff of the file being changed.

```bash
~/checkouts/Newthings >>> git show d6e9567

commit d6e9567bf35043f9ee74bbb0e9bd8e731d9281a5 (origin/Aruviyn-patch-3)
Author: Aruviyn <72690607+Aruviyn@users.noreply.github.com>
Date:   Mon Aug 16 13:22:39 2021 +0800

    Update README.md

diff --git a/atom-ide/README.md b/atom-ide/README.md
index 24aa4f6..8e909ad 100644
--- a/atom-ide/README.md
+++ b/atom-ide/README.md
@@ -1,2 +1,15 @@
 ## Atom ide.
 - Atom ide is free open source and source code editor that can be used on different operating system. It is also supported for plug-ins that is written in JavaScript, embedded Git Control developed by GitHub. It is a desktop application built using web technologies.
+
+Here are some commands / shortcuts for Atom:
+| *commands | *Description* | *Remark* |
+| --- | --- | --- |
+| `CTRL + Shift + P` | Opens command pallet in atom to search packages. Key in Install packages and themes preview the markdown written | |
+| `CTRL + Shift + t` | Create a new terminal instance | |
+| `CTRL + ,` | Opens setting panel | |
+| `CTRL + o` | Opening a file | |
+| `CTRL + s` | Editing and saving a file | |
+| `CTRL + Shift + s` | Save current content under a different file name | |
+| `CTRL + Shift + a` | Adds a project folder | |
+| `CTRL + \` | Hide or Show *tree-view:toogle* | |
+| `CTRL + p / t` | To open Fuzzy finder which allows quick search for any file in project | |
```

---

### Merging

When working on a branch, the work is considered as work in progress. Just as the work is completed, the branch is merged with its upstream so that the work stays with the completed work. Just as practised, a merged is not being done by oneself, rather one will raise pull request to allow their work to be reviewed before it gets merged into the stable branch. This allow the process of review.

Most people manage their pull requests using platforms like github, gitlab, bitbucket where these platform provide the facility of reviewing pull requests. In more traditional way, Pull Requests are just an identifier for people to ask for review and in the end merge their code.

In some cases, developers make branch to test out experimental work without damaging the existing code in stable branch. When They find out their experimental work actually works out, they merge their branches together to allow the experimental work to reside with the current work ready for review.

---

### git diff

Checking what has been changed is crucial. `git diff` gets the job done. Git diff format is similar to any patch format. An output of a git diff can be generated into patches portable to patch any version. Think of it as porting over cherry picks without the hashes but with patch files.

Here is a sample of git diff:

```bash
~/checkouts/Newthings >>> git diff

diff --git a/git/README.md b/git/README.md
index f95df6e..627faae 100644
--- a/git/README.md
+++ b/git/README.md
@@ -9,17 +9,144 @@ Here are some lovely git commands:

 | commands | description | remark |
 | --- | --- | --- |
-| `git clone <url>` | clone a repository into local | make an exact copy of a git repository to appear locally with all reference in-tact |
-| `git remote add origin` | this allows to tell Git which remote repository in GitLab. Remote tells Git where to push and pull from. | |
-| `git remote -v` | To view remote repositories. `-v` flag stands for **Verbose**  which shows you the URLs that Git has stored for the shortname to be used when reading and writing to that remote | tell us the concept of remotes other than origin |
-| `git fetch <remote>` | This command goes out to that remote project and pulls down all the data from that remote project that you don’t have yet. After you do this, you should have references to all the branches from that remote, which you can merge in or inspect at any time  | with the knowledge of remotes, how do you manage multiple remotes |
 | `git merge <branch>` | This command merges the specified branch’s history into the current branch. When you are ready to add your changes to the default branch, you merge the feature branch into it | tell us in what scenario do you merge branches |
 | `git cherry-pick <hash>` | This command is to choose a commit from one branch and apply it onto another. This way you can still keep track of the origin of the commit and may avoid merge conflicts in the future. | tell us what cherry pick does and why dont we just copy paste contents |
-| `git log --graph` | This command enables you to view your git log as a graph | you may want to illustrate how do you decorate the git log with graph, use --oneline switch to make it prettier |
 | `git diff` | This command displays the differences between files in two commits or between a commit and your current repository. It is used when you want to compare two different commits with each other or two files. | when does these diffs get handy, maybe you want to look into generating patches |
-| `git show <hash>` | This command shows one or more objects such as trees, tags, commits, date, author, and merge pull requests. | describe what you see in a git show output |
-| `git branch` | Branch is like the directory of your project which contains all the files in it. Git repository always creates the default branch which is called master branch. | |
 | `git checkout` | This command is used to switch the branches. Even after creating new branch, you are still in the master branch. | |


 ---
+
+### Clone a repository
+
+| Command | Description |
+|---|---|
+| `git clone <url>` | clone a repository into local |
+
+Git is a distributed version control system. When having a git repository, you are actually carry the whole version starting from the initiation of the repository and not just partial of what it may have been like other version control like cvs, svn, clearcase.
+
+---
+
+### Remotes
+
+Being a distributed version control system, one may host the repository at many places while each of them are synchronized to each other. Each of the remote may be hosted in gitlab, github, bitbucket, gogs or any other domain supporting git protocol. These exercise promote the nature of open source working culture. A project may mature in a way and being developed while at the same time it is taken into another repository to grow into another direction. We can see projects like libreoffice and openoffice being developed in their own direction. Similarly we had Jenkins and Hudson which took their own different path of life while still being able to support patches on one another.
+
+#### Managing remotes
+
+| Command | Description |
```
