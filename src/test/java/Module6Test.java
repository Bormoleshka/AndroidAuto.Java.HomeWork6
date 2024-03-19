import action.Direction;
import action.SwipeHelper;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import screens.CatalogScreen;
import screens.FilterScreen;
import screens.Tabbar;

import java.time.Duration;

public class Module6Test {

        private final DriverFactory driverFactory = new DriverFactory();
        private AndroidDriver<?> driver;



        @Before

        public void setDriver() {

        driver = driverFactory.setUp();

    }




        @org.junit.Test
        @Test
        public void homeTest() {
        Tabbar tabbar = new Tabbar(driver);
        SwipeHelper swipeHelper = new SwipeHelper(driver);
        Assert.assertFalse(tabbar.isCatalogSelected());
        tabbar.clickCatalog();
        swipeHelper.swipe(Direction.UP);
        swipeHelper.swipe(Direction.DOWN);
        CatalogScreen catalogScreen = new CatalogScreen(driver);
        String television = "Телевизор";
        catalogScreen.search(television);
        String foundTitleText = catalogScreen.getFoundTitle();
        catalogScreen.clickFilters();
        FilterScreen filterScreen = new FilterScreen(driver);
        filterScreen.turnOnDiscountGoods();
        filterScreen.applyFilters();
        String foundSaleTitleText = catalogScreen.getFoundTitle();
        Assert.assertNotEquals(foundTitleText, foundSaleTitleText);
        driver.lockDevice(Duration.ofSeconds(3));
        Assert.assertEquals(television, catalogScreen.getSearchText());
        catalogScreen.swipeSpecifyCategory();


    }

        @After
        public void tearDown() {
        driver.quit();
    }

    }

