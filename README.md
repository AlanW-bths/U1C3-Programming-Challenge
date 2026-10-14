# Assignment: U1C3 Programming Challenge

## What to do

Implement the method(s) in `src/main/java/Solution.java`. That is the **only**
file you should edit.

Do not rename, move, or edit any other file (`SolutionTest.java`, `pom.xml`,
the package structure). Grading works by replacing those files with the
official copies before running your submission, so changes to them have no
effect on your grade - and if you rename or move `Solution.java` itself,
grading won't be able to find it and you'll receive a 0.

## Instructions

Go to PROBLEMS.md for programming challenge prompts.

## Checking your work

Running the tests yourself is the same check your instructor's grading tool
runs - if it passes for you, it'll pass for grading too (as long as you
haven't moved or renamed anything).

This requires Java 17+ and Maven installed locally. To check they're
installed, run `java -version` and `mvn -version`.

### Running the tests

From a terminal, `cd` into the project folder (the one containing `pom.xml`),
then run:

```bash
mvn clean test
```

The first time you run this it may take a little while as Maven downloads
dependencies (JUnit, etc.) - that's normal and only happens once.

### Reading the output

Scroll to the bottom of the output. You'll see one of two things:

**Success:**
```
[INFO] BUILD SUCCESS
```
with a summary line above it like:
```
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
```
All tests passed.

**Failure:**
```
[INFO] BUILD FAILURE
```
with a summary line showing how many tests failed, e.g.:
```
Tests run: 3, Failures: 1, Errors: 0, Skipped: 0
```
and one or more `[ERROR]` lines identifying exactly which test failed and why, e.g.:
```
[ERROR]   SolutionTest.testNegativeNumbers:18 expected: <-1> but was: <2>
```
This tells you: the test named `testNegativeNumbers`, on line 18 of
`SolutionTest.java`, expected your method to return `-1` but it actually
returned `2`. Use that to find the bug in `Solution.java`.

Your grade is `(tests passed / total tests) * 100` - so partial credit is
normal. Fix one failing test at a time and re-run `mvn clean test`.

### Running just one test (optional)

Once you have multiple tests and only want to focus on one:

```bash
mvn test -Dtest=SolutionTest#testNegativeNumbers
```

### Troubleshooting

| Problem | Likely cause |
|---|---|
| `mvn: command not found` | Maven isn't installed, or isn't on your PATH. Install it, then check with `mvn -version`. |
| `[ERROR] ... package does not exist` or `cannot find symbol` | Usually a syntax error in `Solution.java`, or you renamed/moved the class. Keep the class named `Solution` in `src/main/java/Solution.java`. |
| Every test fails immediately with no `[ERROR]` detail lines, just a compile error | Your code doesn't compile - fix the syntax error Maven reports before the tests can even run. |
| `Tests run: 0` | The test file isn't being found/compiled - make sure you haven't moved or renamed `SolutionTest.java` or `pom.xml`. |

If you're stuck after checking the above, ask your instructor - include the
full output of `mvn clean test` when you do, it makes debugging much faster.

## Submitting

1. Push your completed code to your own GitHub repository:

   ```bash
   git add .
   git commit -m "Complete assignment"
   git push
   ```

   Run these from inside the project folder (the one with `pom.xml` in it).
   If `git push` asks you to log in, use the same GitHub account you've
   registered with your instructor.

2. Add your repository's URL to the class submission sheet, using the exact
   GitHub account you've registered with your instructor.

Your grade is based on the percentage of official tests that pass.

**Note:** make sure your work is actually pushed before you submit the URL -
grading pulls whatever is on GitHub, not what's still only on your computer.
Running `mvn clean test` one more time right after `git push` (in a fresh
clone, if you want to be extra sure) confirms what was actually submitted.
