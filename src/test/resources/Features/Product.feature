Feature: This file contains all Test Cases of ProductChrome browser is opened

Background: 
Given url is launched

Scenario: Verify Search result For Polo Men
 When user searches for polo t-shirt
 Then all results should be related to polo
 
 Scenario: verify If Search By Popularity Yeilds ProperResults
 When user hovers on men Menu
 And user clicks on men tshirt
 Then user selects popularity filter
 
 
 
