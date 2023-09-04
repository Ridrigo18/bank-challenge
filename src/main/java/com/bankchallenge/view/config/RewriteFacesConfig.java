package com.bankchallenge.view.config;

import jakarta.servlet.ServletContext;
import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;
import org.springframework.beans.factory.annotation.Value;

@RewriteConfiguration
public class RewriteFacesConfig extends HttpConfigurationProvider {

    @Value("${base.path.name}")
    private String basePathName;

    @Value("${base.path.home}")
    private String basePatHome;

    @Override
    public int priority() {
        return 10;
    }

    @Override
    public Configuration getConfiguration(final ServletContext context) {
        return ConfigurationBuilder
                .begin()
                .addRule(Join.path(this.basePathName.concat("/login")).to("/login.xhtml").withInboundCorrection())
                .addRule(Join.path(this.basePathName.concat(this.basePatHome).concat("/readers")).to("/pages/readers.xhtml"))
                .addRule(Join.path(this.basePathName.concat(this.basePatHome).concat("/blogs")).to("/pages/blogs.xhtml"))
                .addRule(Join.path(this.basePathName.concat(this.basePatHome).concat("/readersByBlogs")).to("/pages/readerByBlogs.xhtml"));
    }

}
