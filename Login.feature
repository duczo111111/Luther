Feature: Shopping page

Scenario Outline: Login and shopping with valid account

Given User visit page 
When User login with "<username>" and "<password>"
Then User is navigated to shoppingpage
When User pick second, third, fifth and sixth item
And User remove third and sixth item
And User sort item from high price
When User click checkout
Then User navigated to checkout page
When User enter information and click continue
And User click finish
Then User navigated to result page

Examples: 

|username								|password			|
|standard_user					|secret_sauce	|
|locked_out_user				|secrsdsdsauce|
|problem_user						|ses_sauce		|
|performance_glitch_user|sdsdsdadasd	|
