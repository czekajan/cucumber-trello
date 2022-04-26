package pl.akademiaqa.cucumber.steps.board;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.trello.board.ReadBoardRequest;
import pl.akademiaqa.common.CommonValues;
import pl.akademiaqa.handlers.api.RequestHandler;
import pl.akademiaqa.handlers.api.ResponseHandler;
import pl.akademiaqa.handlers.shared.Context;
import pl.akademiaqa.url.TrelloUrl;

@RequiredArgsConstructor
public class ReadBoardSteps {

    private final ReadBoardRequest readBoardRequest;
    private final RequestHandler requestHandler;
    private final Context context;

    @Then("I can read created board details")
    public void i_can_read_created_board_details() {

        Response response = readBoard();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        Assertions.assertThat(response.getBody().jsonPath().getString("name")).isEqualTo(CommonValues.BOARD_NAME);
    }

    @Then("I should not see this board any more")
    public void i_should_not_see_this_board_any_more() {

        Response response = readBoard();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
    }

    private Response readBoard() {
        String boardId = context.getBoards().get(CommonValues.BOARD_NAME);

        requestHandler.setEndpoint(TrelloUrl.BOARDS);
        requestHandler.addPathParam("id", boardId);

        Response response = readBoardRequest.readBoard(requestHandler);
        return response;
    }


}
