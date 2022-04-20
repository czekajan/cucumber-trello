package pl.akademiaqa.cucumber.steps.board;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.trello.board.CreateBoardRequest;
import pl.akademiaqa.handlers.api.RequestHandler;
import pl.akademiaqa.url.TrelloUrl;

@RequiredArgsConstructor
public class CreateBoardSteps {

    private final CreateBoardRequest createBoardRequest;
    private final RequestHandler requestHandler;

    @When("I create new board")
    public void i_create_new_board() {

        requestHandler.setEndpoint(TrelloUrl.BOARDS);
        requestHandler.addQueryParam("name", "This is a new board");
        // request POST do API
        Response response = createBoardRequest.createBoard(requestHandler);
        // response - status code 201
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }

    @Then("I can see created board on the list")
    public void i_can_see_created_board_on_the_list() {

        // request GET na /boards
        // sprawdzenie czy board zostal dodany do listy

    }

}
