/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backing.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cobrakik
 */
@ManagedBean(name = "mbTheme")
@SessionScoped
public class ThemeManagedBean {

    private String template = "default";

    /**
     * Creates a new instance of ThemeManagedBean
     */
    public ThemeManagedBean() {
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

}
