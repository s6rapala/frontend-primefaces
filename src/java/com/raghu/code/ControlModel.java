/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghu.code;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author raghu
 */
@ManagedBean(name="myModel")
@RequestScoped
public class ControlModel {

    public String name;
    public String userName;
    public String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Creates a new instance of ControlModel
     */
    public ControlModel() {
    }
    
    public String displayName(){
        return "success";
    }
    
    public void login(){
        FacesMessage message = null;
        boolean loggedIn = false;
        
        if(userName!=null && userName.equals("root") && password.equals("password")){
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userName);            
        }
        else{
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid Credentials");
            
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }
}
