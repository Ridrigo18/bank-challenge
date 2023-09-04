package com.bankchallenge.view.controller;

import com.bankchallenge.business.dto.LoginUserDto;
import com.bankchallenge.business.service.LoginUserService;
import com.bankchallenge.util.JsfUtil;
import com.bankchallenge.util.MessageUtil;
import com.bankchallenge.view.filter.ValidatorEncrypt;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.ocpsoft.rewrite.faces.navigate.Navigate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

@Slf4j
@Named
@SessionScoped
public class LoginController implements Serializable {

    @Getter
    @Setter
    private LoginUserDto loginUserDto;

    @Autowired
    private LoginUserService service;

    @Value("${base.path.name}")
    private String basePathName;

    @PostConstruct()
    public void init() {
        loginUserDto = new LoginUserDto();
    }

    public String login() {
        final LoginUserDto userDb = service.getUserByEmail(this.loginUserDto.getEmail());
        if (userDb == null) {
            MessageUtil.addMessageError("El usuario no existe!");
        } else {
            final boolean isCheck = ValidatorEncrypt.checkPass(this.loginUserDto.getPassword(), userDb.getPassword());
            if (isCheck) {
                JsfUtil.setLoginSession("user", userDb);
                return redirect("/pages/readers");
            } else {
                MessageUtil.addMessageError("La contraseña no coincide");
            }

        }
        return StringUtils.EMPTY;

    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return redirect("/login");
    }


    public String redirect(final String navigate) {
        return Navigate.to(this.basePathName.concat(navigate)).build();
    }

}
