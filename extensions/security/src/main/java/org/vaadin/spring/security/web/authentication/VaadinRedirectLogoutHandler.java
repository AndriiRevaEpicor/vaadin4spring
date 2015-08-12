/*
 * Copyright 2015 The original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.spring.security.web.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.vaadin.spring.security.web.VaadinRedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO Document me!
 *
 * @author Petter Holmström (petter@vaadin.com)
 */
public class VaadinRedirectLogoutHandler implements LogoutHandler {

    private final VaadinRedirectStrategy redirectStrategy;
    private String logoutUrl = "/logout";

    public VaadinRedirectLogoutHandler(VaadinRedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    public VaadinRedirectLogoutHandler(VaadinRedirectStrategy redirectStrategy, String logoutUrl) {
        this.redirectStrategy = redirectStrategy;
        this.logoutUrl = logoutUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        redirectStrategy.sendRedirect(logoutUrl);
    }
}
