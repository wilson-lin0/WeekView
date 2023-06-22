package cs3500.pa05.controller;

import cs3500.pa05.model.WeekView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class QuoteController extends AbstractController {
  @FXML
  private TextField enterQuote;
  @FXML
  private TextArea quote;
  @FXML
  private Button exitButton;
  protected Popup eventCreationPopup;
  /**
   * Creates a Controller.
   *
   * @param weekView the WeekView
   * @param stage    the stage
   */
  public QuoteController(WeekView weekView, Stage stage) {
    super(weekView, stage);
  }

  @Override
  public void run() {
    try {
      this.eventCreationPopup = new Popup();
      FXMLLoader eventLoader = new FXMLLoader(getClass().getClassLoader().getResource(
          "Quote.fxml"));
      eventLoader.setController(this);
      Scene createEventScene = eventLoader.load();
      eventCreationPopup.getContent().add(createEventScene.getRoot());
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.eventCreationPopup.show(this.stage);

    this.quote.setVisible(false);

    this.exitButton.setOnAction(event -> {
      this.weekView.changeQuote(enterQuote.getText());
      this.eventCreationPopup.hide();
    });
  }
}
