Selenium POM + PageFactory + TestNG + Maven - Full Project
--------------------------------------------------------
What I added:
- Multiple pages (LoginPage, HomePage)
- Utilities: WaitUtils, ScreenshotUtil, ExcelUtil (CSV fallback)
- Listener: TestListener with ExtentReports and screenshots on failure
- Data-driven test reading test-data/login.xlsx (or CSV fallback)
- testng.xml configured to run tests

How to run:
1. Unzip the project.
2. From project root run: mvn clean test
3. Reports/screenshots will be under test-output/

Notes:
- This is a starting template. Update locators and URLs to match your AUT.
- If using headless CI, adjust DriverFactory to add headless Chrome options.
