package pl.akademiaqa.cucumber.steps.board;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.trello.board.CreateBoardRequest;

@RequiredArgsConstructor
public class CreateBoardSteps {

    private final CreateBoardRequest createBoardRequest;

    @When("I create new board")
    public void i_create_new_board() {

        // request POST do API
        Response response = createBoardRequest.createBoard();
        // response - status code 201
        System.out.println(response.statusCode());
    }

    @Then("I can see created board on the list")
    public void i_can_see_created_board_on_the_list() {

        // request GET na /boards
        // sprawdzenie czy board zostal dodany do listy

    }

}
