# seng438-assignment-4

# Guidline

- read [assignment guideline](seng438-a4.md)
- commit and push output on **Github** ([assignment report template](./seng438-a4-team_number.md))

Running the Mutation test:

1. Open Eclipse in to the repository directory. Open the folder JFreeChart_Lab4 in the Eclipse package explorer.
2. If needed, right click the JFreeChart_Lab4 and go to Build Path -> Configure Build Path -> Libraries -> Add External Jars.
  - Add all .jar files in the Lab4 -> JFreeChart v3.0 -> Assignment3-artifacts -> jfreechart-1.0.19 -> jfreechart-1.0.19 ->lib folder.
  - Apply and close.
3. Right click on JFreeChart_Lab4 -> Run As -> PIT Mutation Test, and wair for report to finish.

Selenium Tests Note:
  The ideal order for running the tests is:
    1. Invalid account name
    2. Sign in (Note: the Ebay CAPTCHA might interfere with the successful execution of this test, leading to necessary manual login and logout before running the test)
    3. Add to cart 
    4. Remove from cart
    5. Add to watchlist (Note: must be signed in)
    6. Save seller (Note: must be signed in)
    7. Normal search 
    8. Advanced search


