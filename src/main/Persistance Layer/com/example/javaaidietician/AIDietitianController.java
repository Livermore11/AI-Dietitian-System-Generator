package com.example.javaaidietician;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class AIDietitianController implements Initializable {

    @FXML
    private Button button_logout;

    @FXML
    private Button button_recommend;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_age;

    @FXML
    private TextField txt_weight;
    @FXML
    private TextField txt_height;
    @FXML
    private Label label_welcome;
    @FXML
    private Label label_result;
    @FXML
    private Label label_BMR;

    @FXML
    private RadioButton rb_male;

    @FXML
    private RadioButton rb_female;

    @FXML
    private RadioButton rb_no_exercise;

    @FXML
    private RadioButton rb_light;

    @FXML
    private RadioButton rb_moderate;

    @FXML
    private RadioButton rb_active;

    @FXML
    private RadioButton rb_heavy;
    @FXML
    private Label label_breakfast;

    @FXML
    private Label label_lunch;

    @FXML
    private Label label_dinner;

    @FXML
    private Label label_snack;

    @FXML
    private Label label_recommend;
    @FXML
    private Label label_alternative;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup toggleGroup = new ToggleGroup();
        rb_male.setToggleGroup(toggleGroup);
        rb_female.setToggleGroup(toggleGroup);

        rb_male.setSelected(true);

        ToggleGroup toggleGroup2 = new ToggleGroup();
        rb_no_exercise.setToggleGroup(toggleGroup2);
        rb_light.setToggleGroup(toggleGroup2);
        rb_moderate.setToggleGroup(toggleGroup2);
        rb_active.setToggleGroup(toggleGroup2);
        rb_heavy.setToggleGroup(toggleGroup2);

        rb_no_exercise.setSelected(true);

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"hello-view.fxml","Log In",null);
            }
        });

        button_recommend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                 if(txt_age.getText().isEmpty()) {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setContentText("Age missing");
                     alert.show();
                 }else if(txt_weight.getText().isEmpty()) {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setContentText("Weight missing");
                     alert.show();
                 }else if(txt_height.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Height missing");
                    alert.show();
                }
                 else{
                     try {
                         String name = txt_name.getText();
                         String toggleGender = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
                         String toggleExerciseLevel = ((RadioButton) toggleGroup2.getSelectedToggle()).getText();
                         int age = Integer.parseInt(txt_age.getText());
                         double weight = Double.parseDouble(txt_weight.getText());
                         double height = Double.parseDouble(txt_height.getText());

                         User users = new User(name, age, toggleGender, weight, height, toggleExerciseLevel);

                         calculateNutrientValues(users.getGender(), users.getAge(), users.getWeight(), users.getHeight(), users.getExerciseLVL());
                         recommendDiet();
                         button_logout.setVisible(true);
                         button_recommend.setText("Alternate Diet");
                         label_alternative.setVisible(true);
                     }catch (NumberFormatException e){
                         showErrorAlert("Invalid input");
                         txt_age.clear();
                         txt_weight.clear();
                         txt_height.clear();
                         txt_age.requestFocus();
                     }
                }
            }
        });
    }
    private void showErrorAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    DecimalFormat decfor = new DecimalFormat("#.00");
    public void setUserInformation(String username){
        txt_name.setText(username);
        label_welcome.setText(("Welcome " + username + "!"));
    }
    double BMR = 0;
    double AMR =0;
    String formmatedNumber;
    public void calculateNutrientValues(String gender, int age, double weight, double height, String exerciseLevel){

        switch (gender) {
            case "Male":
                BMR = 66.47 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
                formmatedNumber = decfor.format(BMR);
                label_BMR.setText("Your BMR is " + formmatedNumber + "kj per day");
                break;

            case "Female":
                BMR = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
                formmatedNumber = decfor.format(BMR);
                label_BMR.setText("Your BMR is " + formmatedNumber + "kj per day");
                break;
        }
        switch (exerciseLevel){
            case "Light exercise (1–3 days per week)":
                AMR = BMR * 1.375;
                formmatedNumber = decfor.format(AMR);
                label_result.setText("You need " + formmatedNumber + " kcal per day");
                break;
            case "Moderate exercise (3–5 days per week)":
                AMR = BMR * 1.55;
                formmatedNumber = decfor.format(AMR);
                label_result.setText("You need " + formmatedNumber + " kcal per day");
                break;
            case "Active exercise (twice per day,heavy workouts)":
                AMR = BMR * 1.725;
                formmatedNumber = decfor.format(AMR);
                label_result.setText("You need " + formmatedNumber + " kcal per day");
                break;
            case "Very Heavy exercise (6-7 days per week)":
                AMR = BMR * 1.9;
                formmatedNumber = decfor.format(AMR);
                label_result.setText("You need " + formmatedNumber + " kcal per day");
                break;
            default:
                AMR = BMR * 1.2;
                formmatedNumber = decfor.format(AMR);
                label_result.setText("You need " + formmatedNumber + " kcal per day");

        }

    }
    public void recommendDiet(){
        String[] breakFastList ={"Oatmeal with fruit and nuts",
                "Greek yogurt with berries and granola",
                "Scrambled eggs with whole grain toast",
                "Smoothie with spinach, banna and almond milk",
                "Avocado toast with smoked salmon"};

        String[] lunchList ={"Grilled chicken salad with mixed greens",
                "Whole grain wrap with turkey, avocado, and hummus",
                "Veggie stir fry with brown rice",
                "Quinoa and black bean bowl with roasted veggies",
                "Tuna salad sandwich on whole grain bread"};

        String[] dinnerList ={"Baked salmon with roasted with roasted sweet potatoes and asparagus",
                "Grilled chicken with quinoa and roasted brussels sprouts",
                "Vegetable and chickpea curry with brown rice",
                "Beef and broccoli stir-fry with brown rice",
                "Shrimp and veggie stir-fry with noddles"};

        String[] snackist ={"Apple slices with almond butter",
                "Carrot stick with hummus",
                "Veggie stir fry with brown rice",
                "Greek yogurt with honey and walnuts",
                "Hard boiled egg with avocado"};

        int breakFastIndex = (int)(Math.random() * breakFastList.length);
        int lunchIndex = (int)(Math.random() * lunchList.length);
        int dinnerIndex = (int)(Math.random() * dinnerList.length);
        int snackIndex = (int)(Math.random() * snackist.length);
        label_recommend.setText("Recommended Diet");
        label_breakfast.setText("\t\t\t\tBreakfast: \n\n" + breakFastList[breakFastIndex]);
        label_lunch.setText("\n\n\t\t\t\tLunch: \n\n" + lunchList[lunchIndex]);
        label_dinner.setText("\n\n\n\n\t\t\t\tDinner: \n\n" + dinnerList[dinnerIndex]);
        label_snack.setText("\n\n\n\n\n\n\t\t\t\tSnack: \n\n" + snackist[snackIndex]);
    }
    }

