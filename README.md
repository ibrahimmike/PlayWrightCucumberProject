<h1>PlayWright with reusable Gherkin for both desktop and  mobile view <img src="react-2.svg" height="30"> .</h1>

<h3>Hello and welcome to My project. :wave: </h3> 

<h4>This is an example project of PlayWright and Cucumber it offers a solution for reusing gherkin syntax with different
views Mobile and Desktop and in different scenarios</h4>
<h6>This was achieved via leveraging object-oriented programing principals, if there were components that was reused across,
different application parts which is usually used with React apps it should have its own step definition part</h6>
<h6>Leveraging the Pico container all the objects will be set for use</h6>

The libs used to create this framework are:
- Web driver Manager
- Selenium
- Extent report.
- Page factory

Main challenges of automating a React app, and how to fix them

1. Web elements are usually built and destroyed each time the pages are loading, or a new component is showing so relocating them returns errors.
2. With each update the frontend developers do, the already created xpaths for the framework are obsolete and the elements can’t be located whether the elements are located via absolute or relative xpaths or other locators as many components of the react app are reusing the same css classes and the same name of the component over and over.

Those challenges make the creation of automation tests for the React applications hectic even with no coding tools like Katalon studio, whether the web elements on the same page got destroyed and rebuilt,  or the locators have changed completely.

How to fix:
1. Use page factory in locating the web element assures a refreshed call for every locator.
2. Applying OOP principals updates the locators for  the page as the return of a new instance of the page returns fresh elements every time it is called.
3. When assigning a locator to a web element on the page create a relative xpath, it should be relative  to the component, scroll to view to the component when the Object of the component is called can also make it easier to locate the elements.
4. Remember that React is all about reusing components, so it is totally normal that the same class and data in the html appear multiple times in different components, so use Parent child and ancestor xpaths to locate the desired component.


How to run the code and run in the terminal
``` java 
mvn test
 ```

<h3>Important notice : that is a work in progress still, so it should be continued<h3>
