package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

public class UserClass extends TestBase{
    public String registeredName = RandomStringGenerator("name",4,8)+"@mail.com";
    public String password = RandomStringGenerator("password",5,16);


    private String RandomStringGenerator(String expression,int minStringLength,int maxStringLength){
        String SALTCHAR = "";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random(); //random number generate kore
        int randomLen = ThreadLocalRandom.current().nextInt(minStringLength, maxStringLength);
        //System.out.println("string lemgth = " + randomLen);
        switch(expression) {
            case "name":
                SALTCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
                break;
            case "password":
                SALTCHAR = "!@#$%&ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
                break;

        }
        while (salt.length() != randomLen) {
            int index = (int) (rnd.nextFloat() * SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));

        }
        //System.out.println(salt.toString());
        return salt.toString();
    }



    public void Registration() throws InterruptedException {
        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        System.out.println("Sign In page opened");

        WebElement give_email = driver.findElement(By.xpath("//input[@id='email_create']"));
        give_email.sendKeys(registeredName);
        System.out.println(registeredName);
        WebElement createAnAccount = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span"));
        createAnAccount.click();
        Thread.sleep(3000);


        System.out.println("create an account page opened");
        //Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement gender = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        gender.click();
        System.out.println("gender clicked");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstName.sendKeys("Amir");
        System.out.println("firstName given");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastName.sendKeys("Hamza");
        System.out.println("lastname given");


        WebElement password1stone = driver.findElement(By.xpath("//input[@id='passwd']"));
        password1stone.sendKeys(password);

        String typedValue = password1stone.getAttribute("value");
        int size = typedValue.length();
        if (size >= 5) {
            System.out.println("password minimum value functionality is working fine.");
        }

        else {
            System.out.println("password must be minimum five characters");
        }

        //WebElement testDropDown = driver.findElement(By.id("testingDropdown"));
        //Select dropdown = new Select(testDropDown);
        Select day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        day.selectByValue("3");
        Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        month.selectByValue("9");
        Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        year.selectByValue("1997");
        System.out.println("birth date selected");


        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='newsletter']"));
        checkbox1.click();
        System.out.println("checkbox1 clicked");
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='optin']"));
        checkbox2.click();
        System.out.println("checkbox2 clicked");


        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("MSPPL");
        System.out.println("company name given");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys("road-9, ibrahimpur, mirpur-14, Dhaka");
        System.out.println("address 1 given");

        WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys("flat -2B, house-17");
        System.out.println("address 2 given");

        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("Valdez");
        System.out.println("city name given");


        Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        state.selectByValue("2");
        System.out.println("state name selected");


        WebElement postCode = driver.findElement(By.xpath("//input[@id='postcode']"));
        postCode.sendKeys("99686");
        System.out.println("post code given");
        //textarea[@id='other']

        WebElement addInfo = driver.findElement(By.xpath("//textarea[@id='other']"));
        addInfo.sendKeys("automation testing");
        System.out.println("additional info given");

        WebElement homePhone = driver.findElement(By.xpath("//input[@id='phone']"));
        homePhone.sendKeys("01000000");
        System.out.println("home phone given");


        WebElement mobilePhone = driver.findElement(By.xpath("//input[@id='phone_mobile']"));
        mobilePhone.sendKeys("020000020");
        System.out.println("mobile phone given");


        WebElement addiAddress = driver.findElement(By.xpath("//input[@id='alias']"));
        addiAddress.clear();
        addiAddress.sendKeys("valdez, Alaska");
        System.out.println("additional address given");


        WebElement registerButton = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
        registerButton.click();
        System.out.println("register button clicked");
        Thread.sleep(1000);


        //now compare
        String Exp_Title = "Login - My Store";
        String Act_Title = driver.getTitle();


        if(!Exp_Title.equals(Act_Title)) {
            System.out.println("registration test Passed !! for valid test data !!");

            WebElement signOutButton = driver.findElement(By.xpath("//a[@class='logout']"));
            signOutButton.click();
            System.out.println("signout button clicked and sign out done");
        }


        else {
            System.out.println("registration test failed !! for valid test data !!") ;
        }



    }

    public void LoginAndOrder(String RegisteredName,String password) throws InterruptedException {
        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        System.out.println("Sign In page opened");
        //driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);


        WebElement email1 = driver.findElement(By.xpath("//input[@id='email']"));

        email1.sendKeys(RegisteredName);

        WebElement password1 = driver.findElement(By.xpath("//input[@id='passwd']"));
        password1.sendKeys(password);

        WebElement signInButton = driver.findElement(By.xpath("//body[@id='authentication']/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[@class='row']/div[@class='col-xs-12 col-sm-6']/form[@id='login_form']/div[@class='form_content clearfix']/p[@class='submit']/button[@id='SubmitLogin']/span[1]\n"));
        signInButton.click();

        System.out.println("Login done by "+RegisteredName);
        //driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);


        ///////////////////////////////



        Actions actions = new Actions(driver);
        WebElement dressesMenu = driver.findElement(By.xpath("//body[@id='my-account']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]"));

        actions.moveToElement(dressesMenu);
        System.out.println("Done Mouse hover on 'dresses' from Menu");

        WebElement casualDressesMenu = driver.findElement(By.xpath("//body[@id='my-account']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/ul[1]/li[1]/a[1]"));
        System.out.println("check");
        actions.moveToElement(casualDressesMenu);
        System.out.println("check check");
        actions.click().build().perform();
        System.out.println("Casual Dresses page loaded");


        WebElement printedDress = driver.findElement(By.xpath("//a[@class='product_img_link']//img[@class='replace-2x img-responsive']"));
        actions.moveToElement(printedDress);
        System.out.println("Done Mouse hover on Printed Dress");

        WebElement addToCart = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        System.out.println("check2");
        actions.moveToElement(addToCart);
        System.out.println("check2 check2");
        actions.click().build().perform();
        System.out.println("added to cart");

        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement continueShoppingButton = driver.findElement(By.xpath("//body[@id='category']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='layer_cart']/div[@class='clearfix']/div[@class='layer_cart_cart col-xs-12 col-md-6']/div[@class='button-container']/span[@class='continue btn btn-default button exclusive-medium']/span[1]"));
        continueShoppingButton.click();
        System.out.println("again casual dresses page loaded");


        WebElement tShirtButton = driver.findElement(By.xpath("//body[@id='category']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]"));
        tShirtButton.click();
        System.out.println("T-shirts page loaded");



        ////////////////////////////////////


        //Actions actions = new Actions(driver);
        WebElement shortTshirt = driver.findElement(By.xpath("//a[@class='product_img_link']//img[@class='replace-2x img-responsive']"));
        actions.moveToElement(shortTshirt);
        System.out.println("Done Mouse hover on short t-shirt");

        WebElement blueColor = driver.findElement(By.xpath("//a[@id='color_2']"));
        System.out.println("check3");
        actions.moveToElement(blueColor);
        System.out.println("check3 check3");
        actions.click().build().perform();
        System.out.println("blue t-shirt page loaded");

        WebElement addToCart22 = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        addToCart22.click();
        System.out.println("blue t-shirt added to cart");
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(2000);
        WebElement proceedCheckout = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        proceedCheckout.click();
        System.out.println("Cart summary page loaded");


        WebElement finalCheckout = driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]"));
        finalCheckout.click();
        System.out.println("Checkout address page loaded");


        WebElement finalCheckout2 = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Proceed to checkout')]"));
        finalCheckout2.click();
        System.out.println("Shipping checkout page loaded");


        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='cgv']"));
        checkBox2.click();
        System.out.println("Terms of Service agreed done");

        WebElement finalCheckout3 = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Proceed to checkout')]"));
        finalCheckout3.click();
        System.out.println("Payment page loaded");

        WebElement paymentByCheckButton = driver.findElement(By.xpath("//a[@class='cheque']//span[contains(text(),'(order processing will be longer)')]"));
        paymentByCheckButton.click();
        System.out.println("final confirmation page loaded");


        WebElement confirmOrderButton = driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"));
        confirmOrderButton.click();
        System.out.println("Order comfirmation page loaded");


    }

    public void logOut(){

        WebElement signOutButton = driver.findElement(By.xpath("//a[@class='logout']"));
        signOutButton.click();
        System.out.println("Order comfirmation page loaded");
    }

}
