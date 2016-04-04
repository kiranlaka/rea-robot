# Solution explanation

## Design decisions

- No tests for Library wrappers (stdio & file read)
- No tests for data objects (e.g. classes in configuration package)
- Errors are only logged, but no exceptions are thrown.
  The Java Stream API does not provide a fault handling.
  Program execution always continues as good as possible.
- Integration test as JUnit test in same lifecycle stage
