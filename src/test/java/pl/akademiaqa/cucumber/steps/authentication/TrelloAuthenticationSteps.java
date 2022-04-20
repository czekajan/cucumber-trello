package pl.akademiaqa.cucumber.steps.authentication;

import groovy.lang.Singleton;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.handlers.trello.TrelloAuthentication;

@RequiredArgsConstructor
public class TrelloAuthenticationSteps {

    private final TrelloAuthentication trelloAuthentication;

    @Given("I am authenticated to Trello")
    public void i_am_authenticated_to_trello() {
        // dodanie klucza i tokenu
        System.out.println(trelloAuthentication.getKey());
        System.out.println(trelloAuthentication.getToken());

    }
}
