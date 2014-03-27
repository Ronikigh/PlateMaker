/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.hs.platemaker;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author hirokisato
 */
public class PlateMakerPortalController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private AnchorPane platePortal;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void handleEasyPrintButtonAction(ActionEvent event) throws IOException {
        URL url = getClass().getResource("plate/PlateTemporaryImage.fxml");
        System.out.println(getClass().getResource("plate/PlateTemporaryImage.fxml"));
        AnchorPane secondaryLayout = FXMLLoader.load(getClass().getResource("plate/PlateTemporaryImage.fxml"));

        Scene secondScene = new Scene(secondaryLayout, 500, 170);

        Stage secondStage = new Stage();
        secondStage.setTitle("Second Stage");
        secondStage.setScene(secondScene);

        //Set position of second window, related to primary window.
//        secondStage.setX(platePortal.getParent()..getX() + 250);
//        secondStage.setY(platePortal.getScene().getY() + 100);
        secondStage.show();

        // 任意のノードを画像に保存する
        final WritableImage image = secondaryLayout.snapshot(new SnapshotParameters(), null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File("/Users/hirokisato/Downloads/fximage" + new SimpleDateFormat("yyMMddHHmmss").format(new Date()) + ".png"));
        } catch (IOException e) {

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
