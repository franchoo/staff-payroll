# Java 9 - Staff Payroll
Interview coding challenge developed with [Spring Framework](https://start.spring.io) and [Mustache](https://github.com/samskivert/jmustache)

### Content
**Spring Boot** project implemented on Java 9 using _Gradle_, improved UI with Bootstrap and packaged by [feature](http://www.javapractices.com/topic/TopicAction.do?Id=205) _(this article [here](https://dzone.com/articles/package-your-classes-feature) explains better why we should package by feature instead of layers)_

### Persistence end-points _(connection details on application.yml)_
- ✓ POST /phone?empId={Integer}&type={String}&number={String} ... _Register a new phone from an employee_
- ✓ DELETE /phone?empId={Integer} ... _Delete one phone registered to an employee_

### Try out
Import the files (_build.gradle_ as a project) in an IDE (like Eclipse or IntelliJ) or with VSCode adding the [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) (also by the shell command `code <project-folder>`), execute via main method or JUnit Test files

Can also be deployed by shell command, in the project path use `$ ./gradlew bootRun`

List all the available Gradle tasks to execute with `$ ./gradlew tasks`

## Contributors
- franchoo [twitter](https://twitter.com/Franchooo42) [linkedin](https://www.linkedin.com/in/franchoo)
