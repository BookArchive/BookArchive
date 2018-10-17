This file will explain how to set up the env for the build process.

to run there are two main things that you need:
1. jdk 1.8 (version of java)
2. maven 3.5.4

java can be installed easily by following this url:
https://www.java.com/en/download/

maven can be a little more tricky.

 ###### MAC USERS ONLY######
## installing homebrew first can make this simple.
## (homebrew is just a package manager where you can easily download packages like maven or other project dependencies)

## https://brew.sh/

## once homebrew is installed:

1. open a terminal window from launchpad -> utilities
2. check that it is installed with terminal command:  'brew -v', you should see something like this appear:
        
    Homebrew 1.7.7
    Homebrew/homebrew-core (git revision ca5b3; last commit 2018-10-17)

3. enter the command 'brew install maven'
4. once it is done check your maven version with the command 'mvn -v' you should see something like:

    Apache Maven 3.5.4 (1edr2rg2938998etgf8bf061f1ceb3cfdefqo4tqrjf2; 2018-06-17T13:33:14-05:00)
    Maven home: /usr/local/Cellar/maven/3.5.4/libexec
    Java version: 1.8.0_171, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre
    Default locale: en_US, platform encoding: UTF-8
    OS name: "mac os x", version: "10.13.6", arch: "x86_64", family: "mac"

5. if you dont already have git installed install here:

    https://git-scm.com/downloads

6. Check git install with command 'git --version' you should see:

    git version 2.15.2 (Apple Git-101.1)

7. now clone (download) the code from github
8. after you unzip and store the folder where you want it open intellij IDE.

## NOTE DO NOT TRY TO OPEN THE .JAVA FILE DIRECTLY

9. when intellij is open, click import project.
10. open the pom.xml file
11. in the next settings window, in addition to the already checked boxes, check boxes 

    search for projects recursively
    import maven projects automatically
    create module groups for multi-module maven projects 

12. keep clicking next until you can click finish.
13. the project should load into intellij. 
14. right click on the application.java file in src folder and click run.
15. this should configure the build and run automatically.
16. you should see a drawing of the word 'SPRING" in the terminal window followed by a bunch of lines of text.
17. your server is now running and now you can go in your browser and go to url 'localhost:8080'
18. you will get a weird error but this is ok because its just saying its not doing anything.
19. youre server is running properly! now you can stop it by pressing the stop button in intellij








