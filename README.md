# REA Group Toy Robot Simulator Challenge

A simple simulator representing a toy robot moving on a tabletop.

For further explanation to design an approach see `SOLUTION.md`.

## Example usage

Invoke the toy robot simulator as follows:

```sh
java -jar rea-robot-<version>.jar [commands.txt]
```

The simulator can be invoked with an optional
plain text file containing commands, one command per line.
If no command file is given, commands are read form `sdtin`.

For a specification of the commands and on how the robot reacts to them, see `PROBLEM.md`.

## Getting Started

### Build

To build the project, just run `mvn clean package`.
The built JAR along with sample inputs can be found in the `./target/` directory.

### Test

Building with `mvn clean package` already runs unit tests.

`mvn clean verify` also runs integration tests, but none are present as of yet.

## Author

David Christ <david.christ@genitopia.org>

## Acknowledgments

- The people of REA Group Ltd for the opportunity
- Recruiter Ryan Lynch of Greythorn Pty Ltd for the referral
