package com.alphasense.petshop.tests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        tags = {"@category-all"},
        features = "src/test/resources/features/",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = "com.alphasense.petshop"
)
public class TestsRunner {
}