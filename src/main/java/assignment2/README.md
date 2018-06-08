## Assignment 2: Built-in 2D Arrays, ArrayLists and Using Other People's Code

### Step 0: CodeCademy

Complete the remaining modules of CodeCademy on Object-oriented programming
and data structures. 

### Step 1: Learning about Built-in Arrays

#### 1D Built-in Arrays

While CodeCademy is a good resource, it does neglect to speak of built-in arrays
and their 2D variants.

The Java `ArrayList` class is implemented using something called a built-in array.
It's a set amount of locations to store a fixed number of variables
of a given type. For example, if I wanted to create a built-in array to store
10 integers, I would initialize it like:

```java
int[] myNumbers = new int[10];
```

Each of these positions would start with some value- normally that value is no value,
referred to in Java as `null`. For `int` however, the starting value of all
positions in the built-in arrray is 0.

The reason built-in arrays are used a lot in image processing is that they
do not waste memory as much as an ArrayList. See, the `ArrayList` is a class that
contains a built-in array inside it, to store variables. In order for us to not
have to manually expand the built-in array every time we exceed its capacity, the
`ArrayList` adds a fixed number, 
usually around `size() / 2` elements, then re-adds all elements from the
original arraylist to the new one, every few times we add an element to
the `ArrayList`. 

So, for a lot of the times we add in elements, 
we have unfilled elements in an `ArrayList` that
just waste memory. With a built-in array, if we know exactly how many elements
we need in our array, we can save as much memory as possible by not having
unfilled elements. Because we usually know the size of our images beforehand,
we can initialize our built-in array with the exact number of elements needed.

The question then becomes- how can we access each element of the built-in array?
It is a lot like the `get()` method of an `ArrayList`. Instead, we use the 
access operator, `[]`

For example, to access each of the elements from our built-in `int` array,
we can do:

```java
for(int i = 0 ; i < myArray.length ; i++){
    System.out.println(myArray[i]);
}
```

Here, our for loops goes through each position of the built-in array
by index (location), and we use the access operator to access the element
at that index.

#### 2D Built-in arrays

Up until now, I've shown most examples using built-in arrays as using
1D arrays. However, typically in image processing we use 2D arrays for storing images.
They vary from the typical 1D built in array, because they are 
effectively a built-in array of 1D built-in arrays as objects.

Consider their initialization:

```java
int[][] my2D = new int[10][11];
```

Here, we just initialized as 2D arrays with 10 rows, and in each of those
10 rows, we place another array of size 11. So we have 10 rows, and 11
columns in our array.

The next concern is how to access each element in the 2D array. We
access each element by two access operators. The first is the row
where the element we want to access is located. The second is the
column where the element we want to access is located.

**Super Important Note** Remember that the first element we want to
access is in index 0. So if we want to access the first element,
we actually type `myArray[0]`

So, as an example, consider a built-in array:
```java
1 | 3 | 4 | 4
2 | 6 | 7 | 8
```

We want to access element 6. This is done through `myArray[1][1]`,
because 6 is in the 1-index row (second row), and in the 1-index column
(second column).

If we wanted to access 2, this would be done through `myArray[1][0]`,
as it is in the 1-index row, and 0-index column.


### Step 2: Review Exercises

1) consider the 2D array, `myArray`
```java
1  | 2 | 3
__________
4  | 5 | 6 
```

I access an element as follows:
```java
int myElement = myArray[1][2]
```

What value is in `myElement`?

*Hints*- Remember zero-based indexing and row / column accessing

2) Consider the 1D array, `myArray`
```java
1 | 2 | 3 | 5 | 4
```

I access an element as follows:

```java
int myElement = myArray[5];
```

What happens in the code above?

### Step 3: Using Other People's Code

Programming everything on your own would be incredibly 
inefficient. Most of the complexity of programming
today is not from writing code from scratch, but rather
how to efficiently use other people's code in writing
your own software.

If you do end up working on FAST, your code will primarily
come from two sources- myself, and the Java Standard Library.
The good things is that for neither of these two sources
do you have to understand what is going on in the code 
in-depth. All you have to know is the input, output, and what
errors can occur in the program. 

This knowledge- of just the input, output and what errors
can occur in a program is known as the **interface** of a class.
These can be defined in a special kind of file known as 
the interface file. The only difference between an interface file
and a normal Java class file is that interface files just provide
input, output specifications for a function- the actual implementation
of the function's code must occur in a different file.

Open up `PremadeImage.java`. This is an example of an interface
file. It defines the functions, and has documentation to show
what should happen in each function. It is implemented using
a different file- `ImplementedImage.java`. You needn't open up this file,
as all you need to know on how to use these functions is included in `PremadeImage.java`.

The first, and most important thing to know how to do in programming is 
to be able to **READ DOCUMENTAION**. Read the comments above each
of the functions thoroughly. In an actual program, these
comments would be automatically extracted by a document generator
and converted to a software's online documentation. 
One famous example of generated documentation is the 
[Java Official Documentation](https://docs.oracle.com/javase/8/docs/api/). 

#### Review:

1) Consider the interface as follows:
```java
public interface Dog{
    
    /**
    * Returns a string denoting the sound of
    * the dog's bark in response to the stimulus
    * @param stimulus event / action to which the dog
    * is responding with a bark
    */
    public String bark(Stimulus stimulus);
    
    /**
    * Makes the dog take a 1 hour nap;
    */
    public void nap();
    
}
```
Which is implemented in a file called `Daschund.java`. Which
of these code snippets is incorrect (multiple may be incorrect,
and why?)

1)
```java
Dog dog = new Daschund();
dog.bark();
```

2) 
```java
Dog dog = new Daschund();
dog.nap();
```

3)
```java
Dog dog = new Daschund();
String naptime = dog.nap();
```

4) *Challenge*
```java
Daschund dog = new Dog();
dog.nap();
```


### Step 3: Finding the Optic Disk in a Fundus Image

Your first task will be to implement a function to find
the optic disk in an image. 

A fundus image is a type of medical image that photographs
the retina of the eye. The project I work on,
 Fundus Annotation SofTware (FAST), is a project about analyzing 
fundus images, hence exposure to the subject early is 
critical. Each fundus image is a very zoomed-in version
of looking at the retina of the eye (the retina is at the 
back of your eyeball).

The optic disk is one of several parts of the retina,
noted for its very visually distinct appearance.

Consider the image

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Fundus_photograph_of_normal_left_eye.jpg/200px-Fundus_photograph_of_normal_left_eye.jpg)

Do you see the big, bright, yellow spot on the left side of the image?
That is the optic disk. It can also be found specially by finding
a pixel with the greatest green channel value in the image. That is
because the green channel in research has been found to be the 
most clear for fundus image analysis, and the optic disk
tends to be the brightest spot in the green channel of the image.

This means a pixel with the greatest green channel value is
most likely one in the optic disk. This is the algorithm your
code must implement.

Open up `OpticDisk.java` and implement your code there. Your
code will be tested in `test/TestOpticDisk.java`, to ensure
it aligns with the expected result.

*Hints*

1) If you would like to see the output of your code 
(where it plotted the optic disk), go to `test/resources/assigment2/`
and look for the files `GeneratedOpticDisk1.png`, `GeneratedOpticDisk2.png`
and so on.

2) If you get an out of bounds exception- think of how you are iterating
through each pixel of the image in your loop

3) Think about which methods of `PremadeImage` you want to use for this
part. Note you need not use all the methods as some are for step 4.

### Step 4: Image Thresholding

#### Pt 1: Determine if Image is in Binary

Your next assignment will be to use the same `PremadeImage` class for
a different purpose- to determine if an image is in binary.

**Definitions**: for this assignment, we define "binary" as:
```
if an image has 2 distinct colors, and only two distinct colors,
then it is in binary. 

A distinct color is, for two colors, they are distinct if red, green and
blue channels do not all align in value.
```

So, an image with only 1 color is not in binary. An image with 2 colors,
where one of those colors is black (rgb values 0,0,0) and the other is
green (rgb values 0,255,0), is in binary.

You will want to use an `ArrayList` as part of your implementation. However,
you will note that `InBinary` returns a `List` object. This is because
`List` is the interface that `ArrayList` represents. 

You can initialize your `ArrayList` as follows:

`List<Object> myList = new ArrayList<>();`

Implement your function in `isBinary` in `Threshold.java`. It should
return either the two distinct RGB values in a `List`, or `null`. 

#### Pt 2: Threshold an image

Now, you should use your `isBinary` function to threshold a binary image
if it is binary. You will implement this function in `binarizeImage`, returning
null if the image is not in binary, or the binarized `PremadeImage` otherwise.

You will recolor the binary image so that the pixels where `r+g+b` is
maximum for the image (the "lighter" color) are white, and the remaning pixels
are black.

Let's say I had an image with the following colors:
```java
color1 = (200, 1, 1)
color2 = (120, 120, 0)
```

then all pixels of `color2` should be white, and all pixels of `color1` should
be black.

You can test both of your functions in `TestThreshold.java`. 

**Hints**
1) Don't try to use the java standard `contains()` method with a built-in 
array

2) Think again about which functions you will need for both parts

3) Again, your generated output will be stored in the `resources/assigments2/`
folder with the word `Generated` in it. 

### Step 5: Next Steps

You can actually begin assignment 3 right after this one. However,
before you move on, show me that your code passes the tests in 
`TestOpticDisk.java` and in `TestThreshold.java`. 