## Hello World!

Welcome to IPILab! While this lab is a part of the Department of Biomedical 
Engineering at USC, most of our work involves programming and writing 
effective software to analyze medical images. Thus, we designed these 
assigments both to teach you how to program and to teach you the 
basics of images and how they are stored and processed on a computer.

These assigments are written for you to solve in the Java programming language. 
While at IPILab we tend to use a variety of programming languages (MATLAB, 
Python, PHP, JavaScript just to name a few), my project utilizes Java 
heavily for software development and Java is used significantly in introductory 
computer science courses, thus it was chosen for these assignments.

### Your First Assignment

Your first assignment is **Assignment 0**. It is listed below:

### Assignment 0: Setting up the Development Environment

You will need 3 major components on your computer set up by the end of this assignment.

1) An account on [GitHub](https://github.com/). In industry, GitHub is used to 
coordinate software development across large teams. However here, we are 
just going to use it to give you access to your assignments. Sign up 
for GitHub using this [link](https://github.com/signup/free) using either 
a school or a personal email account, then give me your username. If
prompted by GitHub, select the free plan option.
Once you give me your username, go to this 
[link](https://github.com/vvmurthy/ipilab-assignments), and click on 
the button that says `Clone or Download`. Download the zip file, and 
extract it to some directory. 

2) An account on [CodeCademy](https://www.codecademy.com/learn/learn-java). 
We will be using the course Learn Java as part of your work. 
Sign up for the free account option using either a personal or a school email.

3) The Java Development Kit along with an IDE, 
or an environment where you will be writing your code. 

First, download the [Java 1.8 development kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
You will most likely want to download the windows x64 version (or the MAC x64 version), 
and install as
necessary. I specify Java 1.8 because if you do complete this course
and become a member of my project team, my software uses Java 1.8.


For IDE, we use [IntelliJ IDEA](https://www.jetbrains.com/idea/) because it 
allows us to easily test code, and because it is similar to a lot 
of other IDEs such as those for Android development. Click on the 
downloads tab on the linked page 
and download IntelliJ Community Edition onto your computer.

For windows you will want to download the .exe file. Default install
location is fine, you should click the box for a 64-bit launcher,
and click on the box to create the `.java` association. 

Once downloaded, go to `File->Open`, then open the 
downloaded and extracted folder.  

You should be greeted with several subfolders, including one called `src`.
`src` has two subfolders- `main` and `test`.

`main` stores all the code you will be writing. `test` has a bunch
of functions I have written to test your assignments and make sure
you have implemented them correctly. You will be running code from
both these folders.

#### Step 1: Hello World

Your first task will be to ensure you can run code from the 
main folder. Navigate into `src/main/java` within Intellij, using the file
navigator on the left and click on the file called
`HelloWorld.java`. It should be open in IntelliJ. Follow the directions in the
file of which line to uncomment (remove the two `//` at the beginning of the line
to uncomment). Then right click on the line
`public static void main(String[] args)`. You should be given an option to
`Run HelloWorld.main()`. If you are not, let me know. This should display
`Hello World!` to the terminal prompt at the bottom of IntelliJ's screen. 

#### Step 2: Hello Linear Equation

Your next task will be to ensure that you can run code from the `tests` folder.
Open the file `HelloLinearEq.java`, and copy in this line under the comment
marked `TODO`:

```java
return 3 + 5 * X;
```

Then, navigate to the folder `src/test/java/assignment0` and open the
file `TestHelloLinearEq.java`. right click on the line 

```java
public class TestHelloLinearEq{
```
and you again should be given an option to run the functions. Three functions
should run and you should get a notification that `All 3 tests passed`
at the bottom of your screen.

#### Get your assignment checked

Please show me that you are able to run `HelloWorld.java` and 
`TestHelloLinearEq.java`.  

#### Next steps

Open `src/main/java/assignment1/README.md` and follow the directions 
contained there. Generally from now on, all of your assigment
directions will be contained in `src/main`, under the corresponding
assigment subfolder, in a file called `README`
