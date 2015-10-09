package ua.com.lits.automation.java.framework.informationaboutactorpage;

import org.testng.annotations.Test;

import junit.framework.Assert;
import ua.com.lits.automation.java.framework.testcase.TestBase;

public class InformationAboutActorTestSuite extends TestBase {
	
  @Test
  public void checkActorNameTest() {
	  homePage = homePage.sendKeysInInputSearch();	  
	  searchResultFilmPage = homePage.clickOnButtonSearch();
	  informationAboutFilmsPage = searchResultFilmPage.clicOnLinkDetailedInformationForFoundElement();
	  informationAboutActorPage = informationAboutFilmsPage.clickOnImageActor();
	  Assert.assertEquals("Matthew McConaughey", informationAboutActorPage.getNameActor());	  
  }
}
