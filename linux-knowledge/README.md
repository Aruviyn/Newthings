## installing packages in Manjaro/
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
