import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;

public class guiMain extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Instructions
        Label namelable = new Label(main.nomemisura[2][3]+main.unitadimisura[1]+":");
        GridPane.setConstraints(namelable,0,0);

        //Randomize initial mis and setting it
        Random r = new Random();
        double randomValue =100 * r.nextDouble();
        String randmis = String.valueOf(main.twodigs.format(randomValue));
        TextField mesure = new TextField(/*randmis*/);
        mesure.setPromptText(main.unitadimisura[1]);
        GridPane.setConstraints(mesure,0,1);

        //Setting calculate button
        Button calculatebutton = new Button(main.nomemisura[2][5]);
        GridPane.setConstraints(calculatebutton,1,1);

        //Creating output label
        Label output = new Label();
        GridPane.setConstraints(output,0,10);

        //Setting language button
        Button langbutton = new Button(main.nomemisura[2][7]);
        GridPane.setConstraints(langbutton,2,1);

        //Setting feet or metres button
        Button feetormetresbutton = new Button(main.unitadimisura[0]);
        GridPane.setConstraints(feetormetresbutton,3,1);

        //Adding all elements
        grid.getChildren().addAll(namelable,mesure,calculatebutton,output,langbutton,feetormetresbutton);

        //Setting what happens when feetormetresbutton is pressed
        feetormetresbutton.setOnAction(event -> {misura.metres = !misura.metres;
        if(misura.metres) {
            main.unitadimisura[0] = main.listaunitadimisura[0][0];
            main.unitadimisura[1] = main.nomemisura[2][4];
        } else {
            main.unitadimisura[0] = main.listaunitadimisura[0][1];
            main.unitadimisura[1] = main.nomemisura[2][8];
        }
        feetormetresbutton.setText(main.unitadimisura[0]);
            if(output.getText() != "" && mesure.getText() != "") {
                try {
                    main.programstart(Double.parseDouble(mesure.getText().replace(",", ".")));
                    String out = "";
                    int c = 0;
                    for (String i : main.nomemisura[1]) {
                        //Cycling trough all statements previously printed on console (Check main.java for more info)
                        out = out + main.nomemisura[1][c] + "\n";
                        c += 1;
                    }
                    output.setText(out);
                } catch (NumberFormatException e) {
                    //TODO: AlertBOX
                    output.setText(main.nomemisura[2][6]);
                }
            }
            //changing all metres/metri in feet/piedi or viceversa
            namelable.setText(main.nomemisura[2][3]+main.unitadimisura[1]+":");
            mesure.setPromptText(main.unitadimisura[1]);
        });

        //Setting what happens when langbutton is pressed
        langbutton.setOnAction(event -> {
            int counter = 0;
            if(main.nomemisura[2][7]== "English"){
                for(String i : main.nomemisura[0] ){
                    main.nomemisura[0][counter] = main.englishvoc[0][counter];
                    counter +=1;
                }
                counter = 0;
                for(String i: main.nomemisura[2]){
                    main.nomemisura[2][counter] = main.englishvoc[1][counter];
                    counter +=1;
                }
            } else {
                for(String i : main.nomemisura[0] ){
                    main.nomemisura[0][counter] = main.italianvoc[0][counter];
                    counter +=1;
                }
                counter = 0;
                for(String i: main.nomemisura[2]){
                    main.nomemisura[2][counter] = main.italianvoc[1][counter];
                    counter +=1;
                }
            }
            langbutton.setText(main.nomemisura[2][7]);
            calculatebutton.setText(main.nomemisura[2][5]);
            namelable.setText(main.nomemisura[2][3]+main.unitadimisura[1]+":");
            mesure.setPromptText(main.nomemisura[2][4]);
            if(output.getText() != "" && mesure.getText() != "") {
                try {
                    main.programstart(Double.parseDouble(mesure.getText().replace(",", ".")));
                    String out = "";
                    int c = 0;
                    for (String i : main.nomemisura[1]) {
                        //Cycling trough all statements previously printed on console (Check main.java for more info
                        out = out + main.nomemisura[1][c] + "\n";
                        c += 1;
                    }
                    output.setText(out);
                } catch (NumberFormatException e) {
                    //TODO: AlertBOX
                    output.setText(main.nomemisura[2][6]);
                }
            }
        });
        //Setting what happens when calculatebutton is pressed
        calculatebutton.setOnAction(event -> {
            //Checking if input is a number
            try {
                main.programstart(Double.parseDouble(mesure.getText().replace(",", ".")));
                String out= "";
                int c = 0;
                for(String i: main.nomemisura[1]){
                    //Cycling trough all statements previously printed on console (Check main.java for more info)
                    out = out + main.nomemisura[1][c]+"\n";
                    c+=1;
                }
                output.setText(out);
            } catch (NumberFormatException e){
                //TODO: AlertBOX
                output.setText(main.nomemisura[2][6]);
            }

        });
        //Setting scene
        Scene scene = new Scene(grid,900,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
