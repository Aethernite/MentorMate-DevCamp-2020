### Terminal Log:
```sh
~$ mkdir Directory
~$ ls
 Directory 
~$ cd Directory
~/Directory$ touch file
~/Directory$ cd ..
~$ chmod a-w Directory
~$ chmod a+rx Directory
~$ cd Directory
~/Directory$ ls
file
~/Directory$ rm file
rm: cannot remove 'file': Permission denied
~/Directory$ touch file2
touch: cannot touch 'file2': Permission denied
~/Directory$ cd ..
~$ rmdir Directory
rmdir: failed to remove 'Directory': Directory not empty
~$ rm -r Directory
rm: descend into write-protected directory 'Directory'? y
rm: cannot remove 'Directory/file': Permission denied
~$ 
```