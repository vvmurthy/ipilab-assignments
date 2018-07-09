## Assignment 1: Java Syntax, Loops, Conditionals, Unit Tests, Documentation

### Step 0: Java Syntax

Read the following sections, and answer the practice questions at the end of the section. When you have answers to the practice questions, let me know so I can check your answers. 

#### How Java Actually Runs your Code

Section adapted from [This link](http://www.cs.cmu.edu/~jcarroll/15-100-s05/supps/basics/history.html).

Java programs on their own are not able to be run by a computer. They must first be compiled into a language the computer can understand directly, but that would be very difficult for humans to understand. This process is called *compilation*.

First, when you click `Run Program` in IntelliJ, Java compiles your functions (from various `.java` files in the assignment folders into something called Java bytecode. Bytecode files have the extension `.class`, and these `.class` files can be run by Java as needed.  

Because of this, two sorts of errors can occur in Java code. Compilation Errors occur if your code cannot compile (and thus cannot be run), and Runtime Errors occur if your code can run, but an error occurs while your program is running. Below, we will learn about why compilation errors occur. 

#### Syntax in Java

A java function consists of several lines of code which form the function. Each of these lines must adhere strictly to a set of rules determining what is and what isn't valid java code. These rules, on how Java programs should be structured, are called syntax rules. 

There are a lot of syntax rules in the Java programming language. The main ones you will encounter in this assignment are as follows:

1) Most statements must end in a semicolon. The only exception to this is if statements, loops, function declarations, and brackets.

Consider the function
```
public static void printTenEvenNumbers(){ // function declaration, no semicolon
	for(int i = 0 ; i < 20 ; i++){ // loop, no semicolon
		if( i % 2 == 0){ // if statement, no semicolon
			System.out.println(i); // statement + semicolon
		} // bracket, no semicolon
	} // bracket, no semicolon
} // bracket, no semicolon
```

Here, the only line we needed a semicolon for was our one `print` statement. Typically, if you use a variable, or make a call to another function, you will need a semicolon at the end of the line.

2) Every opening parenthesis must have a closing parenthesis. Every opening bracket must have a closing bracket.
For example
```
// Invalid code, no closing bracket
if(x == 2){
	System.out.println(x);
``` 

```
// invalid code, parenthesis in if statement are unbalanced
if((y == 2) && (x == 3){
	System.out.println("Y: " + y);
}
```

3) Every function which returns a value (called a `non-void` function in the Java language), must return a variable of that type

In order to tell if a function is non-void, we look at the function declaration at the start of each function. For example, consider the function
```
public static int main(){
	return 0;
}
```

Here, we can tell from the third keyword, `int`, that this function `main`, returns a value of type integer. If the function was something like:
```
public void doSomething(){
}
```

Then, based on the keyword, we would know the function `doSomething()` does not return any values. 

Previously, we mentioned how Java first must compile your code. We defined compilation as converting your code into a set of instructions readable by the computer. However, when Java compiles your code, it is also checking your code and whether it follows the syntax rules of the Java Programming Language. Any errors in
syntax of a Java function are called "Compilation Errors".



#### Common Errors in Your Programs

* `) expected` -> Typically, this means you have unbalanced parenthesis somewhere in your function. Look at which file the error occurs in, then look for opening parenthesis that may not be matched with a closing parenthesis.
* `; expected` -> You forgot a semicolon on the specified line
* `missing return statement` -> a `non-void` function does not return a value at the end of the function. If the function does not have a `void` keyword in its declaration, you must return a value of the type specified in the function declaration. Sometimes, this will occur if you have a function structured as follows:
```
public static void isEven(int n){
	if(n % 2 == 0){
		return true;
	}
	if(n % 2 == 1){
		return false;
	}
}
```
Here, we know mathematically, that `n` must be either even (first if statement) or odd (second if statement). However, the computer does not know that. So, we would need to add a line `return false;` or `return true;` at the end of the function 
so that our code follows Java syntax, even if that extra `return` statement will never be reached. 
* `noClassDefFound` -> This *most likely* means that your code is suffering from compilation errors, and thus Java cannot find the compiled code relating to your function. This also usually occurs when you are trying to run a test function, to test a function that you have written. To check if this is happening in your code, go to `build->rebuild code` in IntelliJ. Look at the bottom tile, under where you write your code within IntelliJ. If this panel has many red x marks, followed by filenames and line numbers, your code is suffering from compilation issues. 

This issue occurs because the compiling of the test function, and of the main function you want to test occurs separately. So if the test code compiles, but the main code doesn't, then this error can occur. 

**Super important Note**: If a function you do not want to test at the moment is causing compilation errors, it is best to comment out the function. You can do this as follows
```
public static int functionIDontWantToRun(){
	/** add this symbol above code you want to comment out

	*/ //add this symbol below code you want to  comment out
	
	return 0; // Add some return at end of function to
			  // pass compilation	
}
```

#### Practice

1) What is wrong with this function (there are multiple errors in the function)
```
public static void main doSomething(){
	int x = 2;
	int y = 3;
	if((x == 2) && (y == 3){
		System.out.println(x);
	}
	return 0; 
}
```

2) What is wrong with this function (there are multiple errors in the function)
```
public static int doSomething(int x, int y){
	if((x == 2) && (y == 3)){
		System.out.println(x);
		return 0; 
	}
```

3)**challenge** What is wrong with this function (there is a lot wrong with this function)
```
public static boolean doSomething(){
	if(something){
		boolean anotherBoolean = Function.doSomethingElse(something)
	}else if(){
		boolean anotherBoolean = true;
	}
	return -1; 
}
```

### Step 1

Complete the interactive exercises of the first two modules on 
CodeCademy. This should prepare you for the basic conditional
statements + explain variables. 

### For Loops

Read [this](http://www.learnjavaonline.org/en/Loops) page on for
and while loops. You need not read the part on for-each.

### Review exercises (before starting assignment)

1) What does this code print out?

```java

for(int i = 5 ; i <= 0 ; i--){
    System.out.println(i);
}
```

2) What is wrong with this code?

```java

for(int i = 0 ; i < 10 ; i--){
    System.out.println(i);
}
```

3) What does this code print out?
```java
int i = 17;
while(i > 0){
    System.out.println(i);
    i = i / 2;
}
```

4) What is wrong with this code?

```java
int i = 1;
while(i > 0){
    System.out.println(i);
}
```

### Step 2: Rounding

While CodeCademy does spend some time on operators, it does
not spend nearly the amount of time I would want to on the subject
matter.

Open up the file in the `src/main/java/assignment1` folder `Rounding.java`.
You should see the function `BadRound`. This function is *supposed* to
round a decimal value to the nearest integer. Go to `src/test/java/assignment1`
and open the file `TestRounding.java`, and fill and example for which
`BadRound` fails in `TestBadRound`.

`TestBadRound` should fail as a unit test- your `n` value and its corresponding
`expectedOutput` should be correct mathematically though.
For example, if you set `n` (the input to `BadRound`) as 4.3, then set the 
`expectedOutput` to 5, this would be an incorrect solution to this problem, 
because mathematically we know that `expectedOutput` should be 4.

You need not fix `BadRound` once you identify an input / output for which
it fails as later on you will be writing your own rounding function (which
will work). You also need not change the inputs for any other function
besides `TestBadRound`- those inputs you will need later on when you
write your own rounding function.

*Hints*: Try my function with different inputs. As you try different inputs,
you want to make sure to think about the cases that rounding can fall into.

First, we can have positive values (1, 2.6, 6.2 as examples), or negative
values (-1.0, -3.2, -6.7 as examples), and zero. Next, within each category
of positive and negative values, we will have numbers which round up
(2.6 will round up to 3) and numbers which will round down (0.1 will round
down to 0). If you are getting stuck, make sure the numbers you try are
not all in the same category. For example, do not try 0.1, 0.2, so on
in a row, because they are all positive values which round down. Instead,
maybe try combinations such as 0.1, 0.8, etc, where each number falls into
a different category.

**ON COMPLETION:** Once you have found a number for which my `BadRound`
function fails to generate the correct output, show me.

### Step 3: Grayscale + Basic Image Storage

In step 2, we were exposed to how casting between different data types
stores the same information differently.

We store information differently due to the underlying hardware of the
computer. Computers can only store a finite amount of information. The location
where computers store temporary values (like variables in a Java program)
is called memory. Storing just a value as an `int` variable uses less of
a computer's memory than storing the same value as a `double` would. This
means we can store significantly more `int` variables on any given computer
than we can `double` variables. 

This process is exploited to a much larger extent in image processing. Images
take up a lot of memory on a computer. In my project, each image has
over 1 million pixels. As you will see later on in this section, this
can very easily take up most of the computer's memory to store just
a few images if we were to store each pixel as a `double`. So we must
only use the absolute minimum amount of space necessary for our image data.

This brings us to the `unsigned integer 8`, or `uint8` in image processing.
`uint8` is a data type, much like `int`, that stores significantly smaller
values than an int. `int` variables in Java can store values as large as 
2 ^ 31 - 1. `uint8` can only store values between 0 and 255. This reduces
the amount of memory each pixel takes.

However, each pixel stored as a single `uint8` variable cannot capture color.
We need multiple `uint8` variables for that. This bring us the the RGB format
of the color image. Here, each pixel of the image is stored as 3 components: `R`,
or red intensity; `G`, or green intensity; `B`, or blue intensity. Each
intensity component is stored as its own `uint8` variable. This still reduces
memory usage, while allowing us to store and view color images on our computer.

*Extra Practice* If you would like some help visualizing RGB format
for color images, go to this [link](https://www.w3schools.com/colors/colors_rgb.asp)
and play around with different RGB values to see which colors they produce.

However, for this assignment, we will still be treating `uint8` as an `int`.
This means we will store `uint8` values in `int` variables. This is
somewhat inefficient however and would not be used in practice.

*Assignment*: Open `Grayscale.java`. There are two functions to fill out.
What each function should do is
 specified in comments above each function. Complete these functions.

Once you are done, you can test them with `TestGrayscale.java` in the `test`
folder.

*Hints*: 

1) Use your rounding function for `convertToGrayscale`. It can
be called like
```
double grayValue = ...(something here);
int round = Rounding.YourGoodRound(grayValue);
```

2) Remember that while `int` can store very large numbers, we define
that a set of RGB values are valid if each of the R, G, and B values
is between `0` and `255`, inclusive. So your code should use an if statement
(or two, or three...) to check if the R value, G value and B value are within
the valid [0, 255] range.

3) Remember that java uses integer division. This is different from the 
division in your math classes:

```java
3/ 4 = 0 // Integer division
3 / 4.0 = 0.75 // floating point division
```

### Step 4: FizzBuzz

This problem is designed for you to understand `if` statements
better.

Open up `FizzBuzz.java` You will be responsible for filling
the single function in the file. The specifications of 
`FizzBuzz` are written in a comment above the file.

*Hints*:

1) Consider the order in which your statements are evaluated. As an example:
```java
// example 1;
int k = 0;
k = k + 6;
k = k / 2;
```

```java
// example 2;
int k = 0;
k = k / 2;
k = k + 6;
```

do not produce the same value `k` at the end of execution.

2) Remember the differences between integer division and modulus division.
How can we use this in our function? Most importantly, which type
of division will be used in our function?

3) You can just copy the return statements from the comment into your code.
So your code should look something like
```java

if(...//something here){
    return "Fizz";
}...//some other conditions here
else{
 return Integer.toString(assignment3);   
}

```


**Show me your function passes all test cases in `TestFizzBuzz` before
moving on to Step 5**

### Step 5: Prime Numbers

This problem is designed to walk you through the basics of
one of the most famous interview problems- the prime number problem.

The purpose of our function is to determine whether an integer is prime.
Recall from Algebra I (or the equivalent from your school), that we
consider an integer prime if it has 2, and exactly 2, factors. These 
factors are typically 1 and itself.

As we learned in `FizzBuzz`, we can determine if a number `b` is a
factor of another number, `assignment3`, by using the modulus operator `assignment3 % b`. 
We can thus use a loop + the modulus operator to determine if a 
number is prime.

Your first task is to look through `BadPrimeNumbers1()` and `BadPrimeNumbers2()`
functions in `PrimeNumbers.java`. Each of these functions fails 
with certain inputs. 

As an example, consider `BadPrimeExample()`. It is designed to say
that every number is not prime. Obviously, this is untrue- prime
numbers do exist. 

So we can easily show `BadPrimeExample()` is incorrect through the 
input of `2`, which is prime. Run `exampleBadPrime()` in `TestPrimeNumbers.java`
by right-clicking on the function name, then selecting 1. You will see
the function fails, just as expected. 

*Assignment*: Determine example inputs that cause `BadPrimeNumbers1()`
and `BadPrimeNumbers2()` to fail. Fill these in in `TestPrimeNumbers.java`
as marked in the file.

Next, you will be writing a prime number function that works. Fill in the
function `YourGoodPrimeNumbers` with your own prime number function. 
Then, run the tests in `TestPrimeNumbers` that start with `YourGood`. These
tests can be ran by right-clicking on the function name, just as you did before.
All tests should pass. Show me that they do.

(Note- do not try to cheat the system by using several if statements designed
so that it only works on my tests, but not on other numbers. I will catch
on :( )
