# Selenium_Framework
#maven #screenshot #excel_reading #doc_output #testng #selenium_webdriver

This project is complete regession testing framework suit using selenium webdriver.
It is build using the maven framwork and the dependcies used can be view in "Pom.xml" file.

Descripton of the packages used.

<b>businesslogics</b> : This package contains the classes where all the logics are being wrriten .

<b>filereading </b> : This package contains the class used for reading the excel and providing the inputs in the required field 
              of the web UI, removing the dependency of manually inputting all the test values in the  required field.
              Works on the picking the values based on the provinding columns headings.
              
<b>output</b> : This package contains the classes where output of the test result is beeing generated in the ".doc" formate.
         Can be updated to produce the result in the other formate e.g PDF.
         
<b>pageobject</b> : This package contains all the classes having the "Xpath" to the web element in the application.
             
<b>testcases</b> : This package contains the classes based on the "testNg" framework.
            You can specify the test cases and there priority with the help of the "testNg" annotations.

Please the change the path of the output document according to the requriements.<br>
Ouput(Package)>Finalresult(Class File)>"Path of the ouput files". <br>

Please the change the path of the input excel according to the requriements.<br>
filereading(package)>Readingoperation(Class File)>"Path from where the excel in being read".

