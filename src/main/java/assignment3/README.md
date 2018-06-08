### Assignment 3: The Try-Catch block, GUI Integration and Using Other People's Code

#### Step 1: The Try-Catch block

In programming, there are a lot of errors our program can encounter that are
not caught at compilation. These are called runtime errors.

Take, for example, this code:

```java
int index = 10;
int[] myArray = new int[5];
int k = myArray[index];
```

We can tell from the code that it will attempt to access a position larger
than the size of the array, and will thus give an `ArrayOutOfBoundsException`.
However, at compilation, this is not known by the program. 

In some cases, however, we may want to handle a specific error in a specific 
way. For example, if we try to access a position out of bounds, perhaps
we want to log this in a error file. In this way, we could change our
code to

```java
ErrorFile errorFile = new ErrorFile();
int index = 10;
int[] myArray = new int[5];
try{
    int k = myArray[index];
}catch(ArrayOutOfBoundsException e){
    errorFile.log(e);
}
```

The difference in our code is that we integrate a `try-catch` block around
the function call we believe may fail. 
Here, `try{}` contains the code we think will produce an error. `catch{}` 
is basically an `if` statement that will run if a specific error type is encountered.
For this example, the code in the `catch` statement will run if an 
`ArrayOutOfBoundsException` is encountered. Note that this code will
still fail if we get some other error that is not an `ArrayOutOfBoundsException`. If
we get an error that is not an `ArrayOutOfBoundsException`, then the error will
still return as normal.

The question many new programmers have 
after learning about `try-catch` blocks is immediately-
why don't we use `try-catch` very often in writing code? It is because
more than anything we want it to
produce the correct output if our program is able to compile and run without errors.

Take, for example, this code:

```java

public int sumOfArray(int[] myArray){
    int sum = 0;
    for(int i = myArray.length ; i >= 0 ; i--){
        try{
            sum += myArray[i];
        }catch(ArrayOutOfBoundsException e){
            break; // stop processing
        }
    }
    return sum;
}
```

While this code may look correct at first glance, it will always output an
answer of 0. This is because, we try to access `MyArray[myArray.length]` on
the first run of the `for` loop. This fails, producing an `ArrayOutOfBoundsException`.
This error is caught by the `catch` statement, and the for loop is broken, returning
an answer of 0.

Here, if we had try to run it without the `try-catch`
block, we may have been able to discover the error earlier without
needing to manually inspect the code. Thus, **Try-Catch blocks should
be used with caution**.

In practice, `try-catch` blocks are best for functions where, due to hardware
or other factors, we think there is a good chance the function will encounter
an error despite being implemented correctly.

Consider an app like `Lyft`. When a user orders a Lyft car, the app
must connect to a central server, determine a close, available car, 
and download the location and details of the car to the user's phone.
What if the user does not have connection, however? In this case, we may
just want to output a message saying that connection failed
 rather than having the whole app failing if connection to the server failed.

So, a simplified version of the `Lyft` app's connection feature would look
like:

```java

/**
* Assigns a user to a close, available car
*/
public Car getMatchedCar(){
    try{
        Car car = Server.getCar(); // Throws ServerConnectionError if connection poor
        GUI.displayToScreen(car.details());
    }catch(ServerConnectionError c){
        GUI.displayToScreen("Cannot Connect to the Server Now");
    }
}

```

Scenarios like this are perfect for `try-catch`, because the errors
they catch are not errors with our function, but with supporting
factors that affect our function that are not in our control.

#### Exceptions

`try-catch` blocks are sometimes mandated by specific functions in the
Java language. Consider how we read images in Java:

```java
try{
    Image image = ImageIO.read(new FIle("file.jpg"));
}catch(IOException e){
    System.out.println("cannot read image!");
}
```

We must surround `ImageIO.read()` in a `try-catch` block, because
of how `ImageIO.read()` is defined. A simplified version of how
the source code of `ImageIO.read()` looks is as follows:

```java
public static Image read(File file) throws IOException{
    
    Image image = FileSystem.Read(file);
    if(image == null){
        throw new IOException();
    }else if(image.isCorrupted()){
        throw new IOException();
    }
    return image;
}
```

Here, we must note a few key things- 

1) The Java version of an error is called an exception. That's why
some of the most common Java errors have names like `ArrayOutOfBoundsException`,
or `NullPointerException`, so on.
2) We define which exceptions can be produced by a function in its declaration.
3) We can check for certain conditions that mean our function has failed, and 
create exception that way. Otherwise we terminate normally.

Using this format, we can actually define our own exceptions, and our
own functions that throw exceptions. This way, if other programmers 
expand on our code, they are required to take steps to account for the
possibility of certain common errors. In this way, we have more
of a guarantee our code will be used effectively by others.

#### Step 2: Review

1) What happens when this code runs?
```java

public void doSomething(Image image) throws ArrayException{
    if(image == null){
        throw new ArrayException();
    }
    image.something();
}

public static void main(String[] args){
    try{
        doSomething(null);
    }catch(ArrayException e){
        System.out.println("code failed");
    }
}
```

#### Step 3: Remaking Grayscale with Exceptions

In `assignment1`, we implemented a program to convert integer
values to grayscale. However, back then, we did not know about
exceptions, so whenever we encountered bad RGB values (values outside
of the [0, 255] range), we just returned -1.

Now, with the power of exceptions, we can just throw an exception
when we encounter bad RGB values.

In addition, we can make our GrayScale function use an actual image class,
and convert a full image to GrayScale at one time. 

Open up `GrayScaleImage.java`. You will now
need to add a function to the `GrayImage` class that throws a 
`InvalidRGB` exception if it encounters bad values, or otherwise
simply converts all values to grayscale.

You can check your functions using `TestGrayScale` in the `tests` folder.
As with assignment 2, your output will be stored in `test/resources/assignment3`
with the word `Generated` somewhere in the filename.

#### Step 4: GUI Programming

In the past, most of our programs have involved writing the
program, then testing and running it through unit tests. While
a good chunk of programming is like this, we should also touch
upon the sort of programs one may encounter in everyday life.

Most programs you encounter in everyday life feature something 
called a GUI, or graphical user interface. The GUI makes it so 
that the user does not need to interact with your program
through writing lines of code or typing in commands. Instead,
the user might click on a button, or swipe in some direction,
and the program will translate that into the applicable
programmatic command. 

In this exercise, you will not be responsible for writing a GUI
of your own. Instead, I have pre-written some GUI code for you
in the `Displayer` file. Your job will be to integrate the
`convertToGrayscale` function you wrote in this assignment, 
and the `findOpticDisk` function you wrote previously into the
GUI. 

The end result will be that your GUI can load an image, then display
the image to the screen, along with an indication of whether it is 
a left or a right eye.

You should go through the `Displayer` constructor, and its
two private classes to see an example of a GUI construction. Try
to modify or disable specific lines to see how the GUI changes as 
a result.

You should run the GUI through the main function in `RunDisplay`.
Before you begin to program, you should see a blank GUI start when
you run `RunDisplay`.

All of your code should go in the `AnalyzeImage` function in `Displayer`. 
Your code should not be that long- do not overthink this. 

#### Step 5: On your Own

Now that you have successfully integrated your code with my existing
GUI code, your next task is to improve my GUI code.

It's no doubt that my GUI is ugly. Your goal will be to make some
modification to my code to make it less ugly- either by changing 
the fonts, giving it an icon (currently the icon in the top left 
is the default java icon), or doing some other change I have
not thought about. 

So, you are free to modify my code in any way you please, as long
as you retain the original functionality of the GUI (load an image,
and display some notification of which eye the image belongs to,
along with the grayscale image itself).

Some pointers depending if you want to use one of my ideas
1) Fonts:

Go online and look into how to use `UIManager.setFont()`. It is 
part of the java interface, and controls the fonts on some of the
menus and panels on the screen. You will add the calls to 
`UIManager.setFont()` in the constructor of `Displayer()`,
after `setTitle()` but before any of the other functions. 

2) Icons:

You will first want to go online, and find some image to set
as this software's icon. It is generally best to go for an 
image that is not copyrighted.

Then, the best place to store the image will be in 
`src/main/resources/`. Then, to load the image, look into
how to use `setIconImage()` and the `IconImage` class in general.
You will need to load the image into one of Java's standard `Image`
class objects (NOT the `PremadeImage` objects we've generally used
thus far, and you will need to load the `Image` object into another
object of type `ImageIcon`)

This is probably the hardest assignment you will receive from me,
but it is also most representative of the content you will receive
from me if you become a Quality Assurance programmer- I don't have
time to specify everything and write half the code like I do in these
assignments. So much of your work will be figuring out how to 
search up info you need, and integrate it into existing source code. 

#### Step 6: Review

*Just* to make sure you looked carefully through the GUI code, here
are a few quick review questions:

1) What does this line of code  in `Displayer` do? Try disabling it and
see how your program changes
```java
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
```

2) My project structure is as follows:

`a.java`
```java
package aPackage;

public class Dog extends Animal{
    
    Dog();
    
    public run();
    public static String barkNoise();
    
}
```

```java
package bPackage;

public class mainClass{
    public static void main(String[] args){
        new Dog().run(); // Line 1
        System.out.println(barkNoise()); // Line 2
        System.out.println(Dog.barkNoise()); // Line 3
    }
}
```

Which of these lines works, and why? Consult your own GUI code for
reference- how were you able to access code in `assignment2`?

#### Next steps

Your final assignment awaits :). Note that assignment will be significantly
more math heavy than the other assignments. I expect that all of you
have taken at least precalculus, and are most likely concurrently taking
single variable calculus (AP Calc AB or BC). If you are more advanced
than this, great! If not, do talk to me because I may want you to review
some math before beginning assignment 4.