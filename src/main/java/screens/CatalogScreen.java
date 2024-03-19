package screens;

import action.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CatalogScreen extends Tabbar {


    @AndroidFindBy(id = "block_search_widget")
    MobileElement searchWidget;

    @AndroidFindBy(id = "search_src_text")
    MobileElement searchText;

    @AndroidFindBy(uiAutomator = "resourceIdMatches(\".*id/title\").textContains(\"товаров\")")
    MobileElement foundTitle;

    @AndroidFindBy(id = "filter_label")
    MobileElement filterLabel;



    @AndroidFindBy(id = "specify_category_pager")
    MobileElement specifyCategoryPager;


    public CatalogScreen(AndroidDriver<?> driver) {
        super(driver);
    }

    public void search(String text){
        searchWidget.click();
        searchText.sendKeys(text);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public String getFoundTitle(){
        return foundTitle.getText();
    }

    public void clickFilters(){
        filterLabel.click();
    }

    public String getSearchText(){
        return searchText.getText();
    }

    public void swipeSpecifyCategory(){
        swipeHelper.swipe(Direction.LEFT, specifyCategoryPager);
        }
    }

