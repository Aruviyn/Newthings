# Linux Knowledge
## installing packages in Manjaro/
### screenFetch installation
- ScreenFetch is used to auto-detect and display system information on Linux distribution.
- First open the terminal and install the package by typing: sudo pacman -S screenfetch
- Proceed by inserting `sudo` password and screenFetch will be installed.
- Lastly, to display system information, type:
```
~/checkouts/Newthings >>> screenfetch                                          
 ██████████████████  ████████     aruviyn@fazreil-lapbook156
 ██████████████████  ████████     OS: Manjaro 21.1.0 Pahvo
 ██████████████████  ████████     Kernel: x86_64 Linux 5.10.53-1-MANJARO
 ██████████████████  ████████     Uptime: 2h 40m
 ████████            ████████     Packages: 1116
 ████████  ████████  ████████     Shell: bash 5.1.8
 ████████  ████████  ████████     Resolution: 1920x1080
 ████████  ████████  ████████     DE: Xfce4
 ████████  ████████  ████████     WM: Xfwm4
 ████████  ████████  ████████     WM Theme: Matcha-sea
 ████████  ████████  ████████     GTK Theme: Matcha-sea [GTK2]
 ████████  ████████  ████████     Icon Theme: Papirus-Maia
 ████████  ████████  ████████     Font: Noto Sans 10
 ████████  ████████  ████████     Disk: 13G / 51G (26%)
                                  CPU: Intel Atom x5-Z8350 @ 4x 1.92GHz
                                  GPU: Mesa DRI Intel(R) HD Graphics (CHV)
                                  RAM: 2052MiB / 3843MiB
```
### screenFetch Customization 
- To automatically have screenfetch when open terminal, head to .bashrc file and key in screenfetch at the most bottom and save the file. 
- Screenfetch can be customized differently, type in `screenfetch -h` to view the supported distributions and command options
- Customized screenfetch may vary on the choice of distribution used.
- Here is an example of `screenfetch -A 'CentOS`: 
```
                   ..                    aruviyn@fazreil-lapbook156
                 .PLTJ.                  OS: Manjaro 21.1.0 Pahvo
                <><><><>                 Kernel: x86_64 Linux 5.10.53-1-MANJARO
       KKSSV' 4KKK LJ KKKL.'VSSKK        Uptime: 11h 49m
       KKV' 4KKKKK LJ KKKKAL 'VKK        Packages: 1116
       V' ' 'VKKKK LJ KKKKV' ' 'V        Shell: bash 5.1.8
       .4MA.' 'VKK LJ KKV' '.4Mb.        Resolution: 1920x1080
     . KKKKKA.' 'V LJ V' '.4KKKKK .      DE: Xfce4
   .4D KKKKKKKA.'' LJ ''.4KKKKKKK FA.    WM: Xfwm4
  <QDD ++++++++++++  ++++++++++++ GFD>   WM Theme: Matcha-sea
   'VD KKKKKKKK'.. LJ ..'KKKKKKKK FV     GTK Theme: Matcha-sea [GTK2]
     ' VKKKKK'. .4 LJ K. .'KKKKKV '      Icon Theme: Papirus-Maia
        'VK'. .4KK LJ KKA. .'KV'         Font: Noto Sans 10
       A. . .4KKKK LJ KKKKA. . .4        Disk: 13G / 51G (26%)
       KKA. 'KKKKK LJ KKKKK' .4KK        CPU: Intel Atom x5-Z8350 @ 4x 1.92GHz
       KKSSA. VKKK LJ KKKV .4SSKK        GPU: Mesa DRI Intel(R) HD Graphics (CHV)
                <><><><>                 RAM: 2582MiB / 3843MiB
                 'MKKM'                 
                   ''                   
```
---
## File Permissions
- Linux is divides authorization into 2 levels:
 - Ownership
 - Permission
- The concept of Linux File permission and ownership is crucial in Linux. 
- Here, we will explain Linux permissions and ownership and will discuss both of them. 
- Let us start with the **Ownership**:

| User type | Description |
|---|---|
| **User** | A user is the owner of the file. By default, the person who created a file becomes its owner. Hence, a user is also sometimes called an owner |
| **Group** | Contains multiple users, same users that belongs to this group will have same Linux group permissions to access files |
| **Other** | Any other user who has access to a file. This person has neither created the file, nor he belongs to a usergroup who could own the file. Practically, it means everybody else. Hence, when you set the permission for others, it is also referred as set permissions for the world. |

---

**Understanding Permissions:** 

| **Read** | This permission give you the authority to open and read a file. Read permission on a directory gives you the ability to lists its content. |
|---|---|
| **Write** | Write permission gives you the authority to modify the contents of a file. The write permission on a directory gives you the authority to add, remove and rename files stored in the directory.  |
| **Execute** | In Unix/Linux, you cannot run a program unless the execute permission is set. If the execute permission is not set, you might still be able to see/modify the program code(provided read & write permissions are set), but not run it. |

**Now lets view an example:**
Key in `ls -l` on your terminal. an example output woult be as such: 
```
[aruviyn@fazreil-lapbook156 ~]$ ls -l
total 48
drwxr-xr-x 3 aruviyn aruviyn 4096 Ogos 11 12:48 Desktop
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos  9 15:39 docker-compose-sample
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos  9 14:55 Documents
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos 11 12:49 Downloads
drwxr-xr-x 4 aruviyn aruviyn 4096 Ogos 16 11:29 github
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos  9 14:55 Music
drwxr-xr-x 9 aruviyn aruviyn 4096 Ogos 25 17:38 Newthings
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos  9 14:55 Pictures
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos  9 14:55 Public
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos  9 14:55 Templates
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos  9 15:52 test-another-dir
drwxr-xr-x 2 aruviyn aruviyn 4096 Ogos  9 14:55 Videos
```

The characters above such as `drwxr-xr-x` indicates: 

| **d** | Directory | 
|---|---|
| **r** | Read permission | 
| **w** | Write permission |
| **x** | Execute permission | 
| **-** | no permission | 

**Changing File/Directory Permissions With `chmod` Command:**
- This command is to prevent other users to view your file 
- It is done by changing the file permission using `chmod` which stands for change mode.
- With this command, permissions can be set on a file/directory for the owner, group, and other. 
- Key in `chmod --help` in terminal for more guides: 

```
[aruviyn@fazreil-lapbook156 ~]$ chmod --help
Usage: chmod [OPTION]... MODE[,MODE]... FILE...
  or:  chmod [OPTION]... OCTAL-MODE FILE...
  or:  chmod [OPTION]... --reference=RFILE FILE...
Change the mode of each FILE to MODE.
With --reference, change the mode of each FILE to that of RFILE.

  -c, --changes          like verbose but report only when a change is made
  -f, --silent, --quiet  suppress most error messages
  -v, --verbose          output a diagnostic for every file processed
      --no-preserve-root  do not treat '/' specially (the default)
      --preserve-root    fail to operate recursively on '/'
      --reference=RFILE  use RFILE's mode instead of MODE values
  -R, --recursive        change files and directories recursively
      --help     display this help and exit
      --version  output version information and exit

Each MODE is of the form '[ugoa]*([-+=]([rwxXst]*|[ugo]))+|[-+=][0-7]+'.

GNU coreutils online help: <https://www.gnu.org/software/coreutils/>
Full documentation <https://www.gnu.org/software/coreutils/chmod>
or available locally via: info '(coreutils) chmod invocation'
```
- To view the user manual for change mode command is by keying in `man chmod` in the terminal:
```
CHMOD(1)                         User Commands                        CHMOD(1)

NAME
       chmod - change file mode bits

SYNOPSIS
       chmod [OPTION]... MODE[,MODE]... FILE...
       chmod [OPTION]... OCTAL-MODE FILE...
       chmod [OPTION]... --reference=RFILE FILE...
DESCRIPTION
       This manual page documents the GNU version of chmod.  chmod changes the
       file mode bits of each given file according to mode, which can  be  ei‐
       ther  a  symbolic representation of changes to make, or an octal number
       representing the bit pattern for the new mode bits.

       The format of a symbolic mode is  [ugoa...][[-+=][perms...]...],  where
       perms  is  either zero or more letters from the set rwxXst, or a single
       letter from the set ugo.  Multiple symbolic modes can be  given,  sepa‐
       rated by commas.

       A  combination  of the letters ugoa controls which users' access to the
       file will be changed: the user who owns it  (u),  other  users  in  the
       file's group (g), other users not in the file's group (o), or all users
       (a).  If none of these are given, the effect is as if (a)  were  given,
       but bits that are set in the umask are not affected.

       The  operator  +  causes the selected file mode bits to be added to the
       existing file mode bits of each file; - causes them to be removed;  and
       = causes them to be added and causes unmentioned bits to be removed ex‐
       cept that a directory's unmentioned set user and group ID bits are  not
       affected.

       The  letters  rwxXst select file mode bits for the affected users: read
       (r), write (w), execute (or search for directories) (x), execute/search
       only  if  the file is a directory or already has execute permission for
       some user (X), set user or group ID on execution (s), restricted  dele‐
       tion  flag or sticky bit (t).  Instead of one or more of these letters,
       you can specify exactly one of the letters ugo: the permissions granted
       to  the  user  who  owns the file (u), the permissions granted to other
       users who are members of the file's  group  (g),  and  the  permissions
       granted  to  users  that are in neither of the two preceding categories
       (o).

       A numeric mode is from one to  four  octal  digits  (0-7),  derived  by
       adding up the bits with values 4, 2, and 1.  Omitted digits are assumed
       to be leading zeros.  The first digit selects the set user ID  (4)  and
       set group ID (2) and restricted deletion or sticky (1) attributes.  The
       second digit selects permissions for the user who owns the  file:  read
       (4),  write  (2),  and  execute  (1); the third selects permissions for
       other users in the file's group, with the same values; and  the  fourth
       for other users not in the file's group, with the same values.

       chmod never changes the permissions of symbolic links; the chmod system
       call cannot change their permissions.  This is not a problem since  the
       permissions  of  symbolic links are never used.  However, for each sym‐
       bolic link listed on the command line, chmod changes the permissions of
       the pointed-to file.  In contrast, chmod ignores symbolic links encoun‐
       tered during recursive directory traversals.

SETUID AND SETGID BITS
       chmod clears the set-group-ID bit of a regular file if the file's group
       ID  does  not  match the user's effective group ID or one of the user's
       supplementary group IDs, unless the user  has  appropriate  privileges.
       Additional restrictions may cause the set-user-ID and set-group-ID bits
       of MODE or RFILE to be ignored.  This behavior depends  on  the  policy
       and  functionality of the underlying chmod system call.  When in doubt,
       check the underlying system behavior.

       For directories chmod preserves set-user-ID and set-group-ID  bits  un‐
       less  you  explicitly specify otherwise.  You can set or clear the bits
       with symbolic modes like u+s and g-s.  To clear these bits for directo‐
       ries  with a numeric mode requires an additional leading zero, or lead‐
       ing = like 00755 , or =755

RESTRICTED DELETION FLAG OR STICKY BIT
       The restricted deletion flag or sticky bit is a single bit,  whose  in‐
       terpretation  depends  on  the file type.  For directories, it prevents
       unprivileged users from removing or renaming a file  in  the  directory
       unless  they  own  the  file  or  the directory; this is called the re‐
       stricted deletion flag for the directory,  and  is  commonly  found  on
       world-writable  directories like /tmp.  For regular files on some older
       systems, the bit saves the program's text image on the swap  device  so
       it will load more quickly when run; this is called the sticky bit.

OPTIONS
       Change  the  mode  of  each FILE to MODE.  With --reference, change the
       mode of each FILE to that of RFILE.

       -c, --changes
              like verbose but report only when a change is made

       -f, --silent, --quiet
              suppress most error messages

       -v, --verbose
              output a diagnostic for every file processed

       --no-preserve-root
              do not treat '/' specially (the default)

       --preserve-root
              fail to operate recursively on '/'

       --reference=RFILE
              use RFILE's mode instead of MODE values

       -R, --recursive
              change files and directories recursively

       --help display this help and exit

       --version
              output version information and exit

       Each          MODE          is          of           the           form
       '[ugoa]*([-+=]([rwxXst]*|[ugo]))+|[-+=][0-7]+'.

AUTHOR
       Written by David MacKenzie and Jim Meyering.

REPORTING BUGS
       GNU coreutils online help: <https://www.gnu.org/software/coreutils/>
       Report any translation bugs to <https://translationproject.org/team/>

COPYRIGHT
       Copyright  ©  2020  Free Software Foundation, Inc.  License GPLv3+: GNU
       GPL version 3 or later <https://gnu.org/licenses/gpl.html>.
       This is free software: you are free  to  change  and  redistribute  it.
       There is NO WARRANTY, to the extent permitted by law.

SEE ALSO
       chmod(2)

       Full documentation <https://www.gnu.org/software/coreutils/chmod>
       or available locally via: info '(coreutils) chmod invocation'

GNU coreutils 8.32                March 2020                          CHMOD(1)
```
---
There are two ways to use this command: 
**Absolute (Numeric) Mode**
- File permissions are not represented as characters but a three-digit octal number

| Number | Permission Type | Symbol |
|---|---|---|
| 0 | No Permission | --- | 
| 1 | Execute | --x |
| 2 | Write | -w- | 
| 3 | Exeute + Write | -wx | 
| 4 | Read | r-- | 
| 5 | Read + Execute | r-x | 
| 6 | Read + Write | rw- |
| 7 | Read + Write + Execute | rwx |

Lets view checking current file permissions: 
```
[aruviyn@fazreil-lapbook156 ~]$ ls -l sample 
-rw-rw-r-- 1 aruviyn aruviyn 4096 25 06:00 sample
```
Now lets view current file after chmod 764: 
```
[aruviyn@fazreil-lapbook156 ~]$ chmod 764 sample
[aruviyn@fazreil-lapbook156 ~]$ ls -l sample 
-rwxrw-r-- 1 aruviyn aruviyn 4096 25 06:00 sample
```
In the above given terminal window, I have changed the permissions of the file `sample` to `764`.
`764` Absolute code says the following: 
- Owner can read, write, and execute
- Usergroup can read and write
- Others can only read
- Setting `777`  permissions to a file or directory means that it will be readable, writable and executable by all users and may pose a huge security risk.
- In Binary, `777` actually means that it is `[111][111][111]`. 
- This means the first `[111]` is for the owner to read, write, and execute. the following `[111]` is for the group, and the last `[111]` is for others.
- It is too long to be written in binary, hence `777` permission is used instead. 

**Symbolic Mode**
- In the Absolute mode, you change permissions for all 3 owners. 
- In the symbolic mode, you can modify permissions of a specific owner. 
- It makes use of mathematical symbols to modify the Unix file permissions. 

| Operator | Description |
|---|---|
| + | Adds permission to a file/directory |
| - | Removes permission | 
| = | Sets the permission and overrides the permission set earlier |

| Owner Denotation | Description | 
|---|---|
| u | owner |
| g | group | 
| o | other | 
| a | all |

In Symbolic mode, we will not use numbers like 764 but characters like rwx alone with the operators. 
**Heres an example:**
*Current file permissoin:*
```
[aruviyn@fazreil-lapbook156 ~]$ ls -l sample 
-rw-rw-r-- 1 aruviyn aruviyn 4096 25 06:00 sample
```
*Setting permission to 'other' users:*
```
[aruviyn@fazreil-lapbook156 ~]$ chmod o=rwx sample
[aruviyn@fazreil-lapbook156 ~]$ ls -l sample 
-rw-rw-rwx 1 aruviyn aruviyn 4096 25 06:00 sample
```
*Adding 'execute' permission to the usergroup:*
```
[aruviyn@fazreil-lapbook156 ~]$ chmod g+x sample
[aruviyn@fazreil-lapbook156 ~]$ ls -l sample 
-rw-rwxrwx 1 aruviyn aruviyn 4096 25 06:00 sample
```
*Removeing 'read' permission for 'user':*
```
[aruviyn@fazreil-lapbook156 ~]$ chmod u-r sample
[aruviyn@fazreil-lapbook156 ~]$ ls -l sample 
--w-rwxrwx 1 aruviyn aruviyn 4096 25 06:00 sample
```
**Changing Ownership and Group**
-For changing ownership of a file / directory, The following command is used: 
- `chown user filename`
- In case you want to change the user as well as group for a file or directory use the command 
- `chown user:group filename`
- There is also a guide on this command by keying in `chown --help`:
```
[aruviyn@fazreil-lapbook156 ~]$ chown --help
Usage: chown [OPTION]... [OWNER][:[GROUP]] FILE...
  or:  chown [OPTION]... --reference=RFILE FILE...
Change the owner and/or group of each FILE to OWNER and/or GROUP.
With --reference, change the owner and group of each FILE to those of RFILE.

  -c, --changes          like verbose but report only when a change is made
  -f, --silent, --quiet  suppress most error messages
  -v, --verbose          output a diagnostic for every file processed
      --dereference      affect the referent of each symbolic link (this is
                         the default), rather than the symbolic link itself
  -h, --no-dereference   affect symbolic links instead of any referenced file
                         (useful only on systems that can change the
                         ownership of a symlink)
      --from=CURRENT_OWNER:CURRENT_GROUP
                         change the owner and/or group of each file only if
                         its current owner and/or group match those specified
                         here.  Either may be omitted, in which case a match
                         is not required for the omitted attribute
      --no-preserve-root  do not treat '/' specially (the default)
      --preserve-root    fail to operate recursively on '/'
      --reference=RFILE  use RFILE's owner and group rather than
                         specifying OWNER:GROUP values
  -R, --recursive        operate on files and directories recursively

The following options modify how a hierarchy is traversed when the -R
option is also specified.  If more than one is specified, only the final
one takes effect.

  -H                     if a command line argument is a symbolic link
                         to a directory, traverse it
  -L                     traverse every symbolic link to a directory
                         encountered
  -P                     do not traverse any symbolic links (default)

      --help     display this help and exit
      --version  output version information and exit

Owner is unchanged if missing.  Group is unchanged if missing, but changed
to login group if implied by a ':' following a symbolic OWNER.
OWNER and GROUP may be numeric as well as symbolic.

Examples:
  chown root /u        Change the owner of /u to "root".
  chown root:staff /u  Likewise, but also change its group to "staff".
  chown -hR root /u    Change the owner of /u and subfiles to "root".

GNU coreutils online help: <https://www.gnu.org/software/coreutils/>
Full documentation <https://www.gnu.org/software/coreutils/chown>
or available locally via: info '(coreutils) chown invocation'
```




