package com.htc.qa.app_test.steps;

import com.htc.qa.app_test.pages.home_page.HomePage;
import com.htc.qa.app_test.pages.QAPage;
import com.thoughtworks.gauge.Step;

public class QASteps {

    private QAPage qa = new QAPage();
    private HomePage home = new HomePage();

    @Step("Register <name> <email> <pass>")
    public void register(String name, String email, String pass){
        qa.registerTab().registerUser(name, email, pass);
    }

    @Step("Login <email> <pass>")
    public void login(String email, String pass){
        qa.loginTab().loginUser(email, pass);
    }

    @Step("Logout Page")
    public void logoutPage(){
        home.logout();
    }

    @Step("Browse all tabs")
    public void browseAllTabs(){
        home.displaySeconds().tutorialsManualsTab().displaySeconds().bioTab().displaySeconds();
    }

}