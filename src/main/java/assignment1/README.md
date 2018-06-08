## Assignment 1: Loops, Conditionals, Unit Tests, Documentation

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

*Extra Notes*: My `BadRound` function uses a technique called casting. This is
where we directly convert one type of variable to another. 

Consider the opposite of what my function does:

```java
int assignment3 = 10;
double x = (double)assignment3;
``` 

here, assignment3 has the value of `10`. `x` would have the value of `10.0`. The
difference is that we use a different type of variable to store the 
same information. Here, while `double` has the capability of storing
a decimal value, it's ok to store an integer in it as the decimal 
will just be treated as 0. 

However, my function goes the opposite direction- `double` to `int`.

*Hints*: Try my function with different inputs. How does it perform on 1.0?
1.1? 1.5?. 

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

2) Remember that while `int` can store very large numbers, we only
want valid values between `0` and `255`. So we will need an if statement
(or two, or three...) to check if the RGB components are valid.

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
