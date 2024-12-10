# Demo Web Shop Automation

This repository contains an automated testing framework for the Demo Web Shop website (https://demowebshop.tricentis.com/). The framework is built using **Selenium WebDriver**, **TestNG**, and **Java**.

## Features

- Automated tests for login, navigation, sorting, and order placement.
- Framework based on Selenium WebDriver and TestNG.
- Easily configurable for testing additional features.
- Supports structured reporting and assertions for better debugging.

## Prerequisites

Before using this repository, ensure the following:

1. **Java JDK 11 or higher** is installed.
2. **Maven** is installed and configured.
3. A web browser (e.g., Chrome) and the corresponding WebDriver (e.g., ChromeDriver) are available in your system's PATH.

## Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/Zarboni/DemoWebShopAutomation.git


## Bonus Findings

###  Detected Bugs
1. **Price Not Updating on Item Page**
   - **Description:** When selecting additional parts for a desktop item, the price on the item page does not update. The accurate price is only shown at checkout.
   - **Priority:** High

2. **Phone Number Field Accepting Text**
   - **Description:** The phone number text box in the Billing Address form accepts text input, which may result in invalid submissions.
   - **Priority:** Medium

3. **Error When Deleting an Address**
   - **Description:** Deleting an address from the user's account results in a delay and displays an error message:
     ```
     We're sorry, an internal error occurred.
     Our supporting staff has been notified of this error and will address the issue shortly.
     We apologize for the inconvenience.
     ```
     Despite this, the address is removed successfully.
   - **Priority:** Medium

4. **Missing "Add to Cart" Buttons for Desktop Items**
   - **Description:** Certain desktop items lack an "Add to Cart" button, with no clear indication of whether the item is sold out. The "Add to Wishlist" option is also missing.
   - **Priority:** High

### Negative Testing
1. **Invalid Email Address During Registration**
   - Attempted to register a user with an invalid email format (e.g., `testuser#email.com`).
   - **Result:** The system displayed an error message, "Wrong Email." This can be improved

2. **Exceeding Maximum Characters in Text Fields**
   - Entered more than the allowed characters in the "Name" and "Address" fields during checkout.
   - **Result:** There is a redirection with an error shown below. The proccess is halted but the behaviour needs improvement
     ```
     We're sorry, an internal error occurred.
     Our supporting staff has been notified of this error and will address the issue shortly.
     We apologize for the inconvenience.
     ```


3. **Entering Negative Quantities in Cart**
   - Tried adding a negative quantity for an item in the cart (e.g., `-1`).
   - **Result:** Error handling correctly shows a message,"Quantity should be positive"
