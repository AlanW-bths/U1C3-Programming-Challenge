# Programming Challenge: Problems

Write each method below in `src/main/java/Solution.java`. Every method
**returns** its answer - do not print anything and do not read input with a
`Scanner`. The official tests call your methods directly and check what they
return.

Do not change any method's name or parameters, or the tests won't be able to
call it. Do not use `if` statements or the `Math` class - none of these
problems need them.

## The Calculator Class

`Solution` represents a calculator. Every calculator object has two instance
variables:

| Instance variable | Type | Holds |
|---|---|---|
| `calcModel` | `String` | the model name of the calculator, such as `"TI-84"` |
| `idNumber` | `int` | the calculator's id number, such as `1001` |

The tests create calculator objects in two ways:

```java
Solution calc = new Solution("Casio fx-300", 1001);   // model and id
Solution calc2 = new Solution(1002);                   // id only, model is "TI-84"
```

Each object has its own `calcModel` and `idNumber`. Changing one calculator
must not change any other calculator.

## Problem 1: Constructors

```java
public Solution(String model, int id)
```

Create a new calculator object. Store `model` in the `calcModel` instance
variable and `id` in the `idNumber` instance variable.

```java
public Solution(int id)
```

Create a new calculator object whose model is `"TI-84"`. Store `"TI-84"` in
`calcModel` and `id` in `idNumber`.

```java
Solution calc = new Solution(1001);
calc.getCalcModel();   // returns "TI-84"
calc.getIdNumber();    // returns 1001
```

## Problem 2: Getters

```java
public String getCalcModel()
public int getIdNumber()
```

Return the value stored in `calcModel` and `idNumber`.

```java
Solution calc = new Solution("TI-84", 1001);
calc.getCalcModel();   // returns "TI-84"
calc.getIdNumber();    // returns 1001
```

## Problem 3: Setters

```java
public void setCalcModel(String newModel)
public void setIdNumber(int newId)
```

Replace the value stored in `calcModel` with `newModel`, and the value stored
in `idNumber` with `newId`. These methods do not return anything.

```java
Solution calc = new Solution("TI-84", 1001);
calc.setCalcModel("Casio fx-300");
calc.setIdNumber(2002);
calc.getCalcModel();   // returns "Casio fx-300"
calc.getIdNumber();    // returns 2002
```

## Problem 4: Increment ID

```java
public void incrementId()
```

Add 1 to the value stored in `idNumber`. This method does not return
anything.

```java
Solution calc = new Solution("TI-84", 1001);
calc.incrementId();
calc.getIdNumber();    // returns 1002
```

## Problem 5: Add, Subtract, Multiply

```java
public double add(double num1, double num2)
public double subtract(double num1, double num2)
public double multiply(double num1, double num2)
```

Each method performs its operation on `num1` and `num2` and returns the
result. `subtract` returns `num1 - num2`.

```java
calc.add(2.5, 1.25);         // returns 3.75
calc.subtract(5.5, 8.25);    // returns -2.75
calc.multiply(1.5, 4.0);     // returns 6.0
```

## Problem 6: Quotient

```java
public int quotient(int num1, int num2)
```

Return the whole number part of `num1` divided by `num2`. Drop the decimal
part - do not round.
Both `num1` and `num2` will always be positive.

```java
calc.quotient(10, 3);   // returns 3
calc.quotient(17, 5);   // returns 3
```

## Problem 7: Remainder

```java
public int remainder(int num1, int num2)
```

Return the remainder left over when `num1` is divided by `num2`.
Both `num1` and `num2` will always be positive.

```java
calc.remainder(10, 3);   // returns 1
calc.remainder(17, 5);   // returns 2
calc.remainder(10, 5);   // returns 0
```

## Problem 8: Division Result

```java
public String divisionResult(int num1, int num2)
```

Build and return a String showing the answer to `num1` divided by `num2` in
long-division form: the quotient, then `" R "`, then the remainder. Both
`num1` and `num2` will always be positive.

Hint: you already wrote `quotient` and `remainder`. You can call them from
inside this method.

```java
calc.divisionResult(10, 3);   // returns "3 R 1"
calc.divisionResult(17, 5);   // returns "3 R 2"
```

## Problem 9: Coordinate Pair

```java
public String coordinatePair(int x, int y)
```

Build and return a String showing the coordinate pair in the format
`"(x, y)"`. Note the space after the comma.

```java
calc.coordinatePair(3, 4);   // returns "(3, 4)"
```

## Problem 10: Average

```java
public int average(int num1, int num2)
```

Return the average of `num1` and `num2`, rounded to the nearest whole number.
An average ending in `.5` rounds up. Both `num1` and `num2` will never be
negative.

```java
calc.average(4, 6);   // returns 5
calc.average(3, 4);   // returns 4  (3.5 rounds up)
```

## Problem 11: Info

```java
public String info()
```

Build and return a String in the format
`"This calculator is a model ____ with id ____"`, where the first `____` is
the value stored in `calcModel` and the second is the value stored in
`idNumber`.

```java
Solution calc = new Solution("TI-84", 1001);
calc.info();   // returns "This calculator is a model TI-84 with id 1001"
```
