package com.mentormate.devcamp;

import com.mentormate.devcamp.controller.Greeting;
import com.mentormate.devcamp.controller.GreetingController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreetingControllerTest {
    private GreetingController greetingController;

    @BeforeEach
    public void init() {
        greetingController = new GreetingController();
    }

    @Test
    void controllerGreetingTest() {
        Greeting greeting = this.greetingController.greeting("Borislav Arangelov");
        String content = greeting.getContent();
        String expected = "Hello, Borislav Arangelov!";
        Assertions.assertEquals(expected, content);
    }

}
