package com.bankchallenge.util;

import com.bankchallenge.business.dto.LoginUserDto;
import jakarta.faces.context.FacesContext;

public class JsfUtil {

    public static void setLoginSession(final String key, final LoginUserDto loginUserDto){
        final FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put(key, loginUserDto);
    }
}
