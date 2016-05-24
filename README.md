# wh
**Technical Test for WH**

Uses JDK 8

The project consists of several parts:

**Test runner** - RunCukesTest class.

**Packages in java folder:**

- **steps** - package with steps definitions that are used by Betting.feature. 
    Locators, pages and steps have almost no comments in the code, 
    because I believe they are self descriptive.
    
- **actions** - consists of PageActions class with actions that can be conducted on elements, 
                such us find (with fluent wait), click, type text, etc. 
                See comments in the code for further details.

- **pages** - classes created according to PageObjectPattern. 
    All classes there extends PageActions and uses corresponding locator object.
    
- **locators** - locators for every used page. 
    The locators might look like they are inconsistent, 
    but they are written us such because of the website structure and to work both in desktop and mobile mode. 
    
- **util** - package with helper classes. 
    Functionality as follows:
        BetCounter - counting estimated returns
        DriverFactory - manage driver creation
        PropertyReader - reads properties (browser and timeout) from the config.properties file
        See comments in the code for further details.


**Resources:**
- **driver** - chrome driver executable
- **Betting.feature** - feature with the test



