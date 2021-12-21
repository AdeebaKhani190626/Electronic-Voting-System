package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class Controller {

	@FXML
    private Button AdminBtn; // page 1

    @FXML
    private Button VoterBtn; // page 1

    @FXML
    private Button AdminSubmitBtn; // page 2
    
    @FXML
    private TextField EAUsername; // page 2

    @FXML
    private PasswordField EAPassword; // page 2

    @FXML
    private Button AdminBackBtn; // page 2

    @FXML
    private Button AdminMMBackBtn; // page 3

    @FXML
    private Button AdminMMStartBtn; // page 3

    @FXML
    private Button AaapBtn; // page 3

    @FXML
    private Button AaacBtn; // page 3

    @FXML
    private Button ApovBtn; // page 3

    @FXML
    private Button AdrBtn; // page 3

    @FXML
    private TextField PartyName; // page 4

    @FXML
    private TextField PartyPName; // page 4

    @FXML
    private TextField PartyMembers; // page 4
    
    @FXML
    private Button AdminMMenuBtn; // page 4
    
    @FXML
    private Button DoneBtn; // page 4
    
    @FXML
    private TextField C_Name; // page 5

    @FXML
    private TextField C_Edu; // page 5

    @FXML
    private TextField C_Age; // page 5

    @FXML
    private TextField C_FName; // page 5

    @FXML
    private TextField C_Nationality; // page 5

    @FXML
    private TextField C_PID; // page 5
    
    @FXML
    private Button AAC_Done; // page 5

    @FXML
    private Button HTWBtn; // page 6

    @FXML
    private Button CAVBtn; // page 6
    
    @FXML
    private Button CAV_Vote; // page 7

    @FXML
    private TextField V_Name; // page 7

    @FXML
    private TextField V_Age; // page 7

    @FXML
    private TextField V_CNIC; // page 7

    @FXML
    private TextField V_Party; // page 7

    @FXML
    private TextField V_Nationality; // page 7
    
    @FXML
    void CAV_Voted(ActionEvent event) throws SQLException {

    	@SuppressWarnings("unused")
		Window Candidate = CAV_Vote.getScene().getWindow();

		if (V_Name.getText().isEmpty() && V_Age.getText().isEmpty() && V_CNIC.getText().isEmpty() && V_Party.getText().isEmpty() && V_Nationality.getText().isEmpty())
		{
			String title = "Incomplete Information";
			String content = "Enter Information !!!";
        	AlertMessage(title,content);	
		}
		else if (V_Name.getText().isEmpty() || V_Age.getText().isEmpty() || V_CNIC.getText().isEmpty() || V_Party.getText().isEmpty() || V_Nationality.getText().isEmpty())
		{
			String title = "Incomplete Information";
			String content = "Fill all Information !!! ";
        	AlertMessage(title,content);
        }
		else if (!V_Name.getText().isEmpty() && !V_Age.getText().isEmpty() && !V_CNIC.getText().isEmpty() && !V_Party.getText().isEmpty() && !V_Nationality.getText().isEmpty())
		{
			DataBase DB = new DataBase();
			DB.CreateConnection();
			if (DB.InsertVoter(V_Name.getText(), V_Age.getText(), V_CNIC.getText(), V_Party.getText(),V_Nationality.getText()))
			{
				String title = "Success";
				String content = "The Vote has been Casted Sucessfully !!!";
	        	AlertMessage2(title,content);
			}
			else
			{
				String title = "Failure";
				String content = "Unable to add Voter !!! ";
	        	AlertMessage(title,content);
			}
		}
    }
    
    @FXML
    void CAVClicked(ActionEvent event) throws IOException {

    	Main next_11 = new Main();
    	next_11.NextScene("CAV.fxml");
    }

    @FXML
    void HTWClicked(ActionEvent event) throws IOException {

    	Main next_10 = new Main();
    	next_10.NextScene("HTV.fxml");
    }
    
    @FXML
    void AAC_DoneClicked(ActionEvent event) throws SQLException {

    	@SuppressWarnings("unused")
		Window Candidate = AAC_Done.getScene().getWindow();

		if (C_Name.getText().isEmpty() && C_Edu.getText().isEmpty() && C_Age.getText().isEmpty() && C_FName.getText().isEmpty() && C_Nationality.getText().isEmpty() && C_PID.getText().isEmpty())
		{
			String title = "Incomplete Information";
			String content = "Enter Information !!!";
        	AlertMessage(title,content);	
		}
		else if (C_Name.getText().isEmpty() || C_Edu.getText().isEmpty() || C_Age.getText().isEmpty() || C_FName.getText().isEmpty() || C_Nationality.getText().isEmpty() || C_PID.getText().isEmpty())
		{
			String title = "Incomplete Information";
			String content = "Fill all Information !!! ";
        	AlertMessage(title,content);
        }
		else if (!C_Name.getText().isEmpty() && !C_Edu.getText().isEmpty() && !C_Age.getText().isEmpty() && !C_FName.getText().isEmpty() && !C_Nationality.getText().isEmpty() && !C_PID.getText().isEmpty())
		{
			DataBase DB = new DataBase();
			DB.CreateConnection();
			if (DB.InsertCandidate(C_Name.getText(), C_Edu.getText(), C_Age.getText(), C_FName.getText(),C_Nationality.getText(), C_PID.getText()))
			{
				String title = "Success";
				String content = "The Candidate has been Added Sucessfully !!!";
	        	AlertMessage(title,content);
			}
			else
			{
				String title = "Failure";
				String content = "Unable to add Candidate !!! ";
	        	AlertMessage(title,content);
			}
		}
    }
    
    @FXML
    void DoneClicked(ActionEvent event) throws SQLException {

    	@SuppressWarnings("unused")
		Window Party = DoneBtn.getScene().getWindow();

		if (PartyName.getText().isEmpty() && PartyPName.getText().isEmpty() && PartyMembers.getText().isEmpty())
		{
			String title = "Incomplete Information";
			String content = "Enter Information !!!";
        	AlertMessage(title,content);	
		}
		else if (PartyName.getText().isEmpty())
		{
			String title = "Incomplete Information";
			String content = "Enter Party Name !!! ";
        	AlertMessage(title,content);
        }
		else if (PartyPName.getText().isEmpty()) 
        {
			String title = "Incomplete Information";
			String content = "Enter Party President !!!";
        	AlertMessage(title,content);
        }
		else if (PartyMembers.getText().isEmpty())
		{
			String title = "Incomplete Information";
			String content = "Enter Party Members !!!";
        	AlertMessage(title,content);
		}
		else if (!PartyName.getText().isEmpty() && !PartyPName.getText().isEmpty() && !PartyMembers.getText().isEmpty())
		{
			DataBase DB = new DataBase();
			DB.CreateConnection();
			if (DB.InsertParty(0, PartyName.getText(), PartyPName.getText(), PartyMembers.getText(), 0))
			{
				String title = "Success";
				String content = "The Party has been Added Sucessfully !!!";
	        	AlertMessage(title,content);
			}
			else
			{
				String title = "Failure";
				String content = "Unable to add Party !!! ";
	        	AlertMessage(title,content);
			}
		}
    }
    
    @FXML
    void AaacClicked(ActionEvent event) throws IOException {

    	Main next_08 = new Main();
    	next_08.NextScene("AddCandidate.fxml");
    }

    @FXML
    void AaapClicked(ActionEvent event) throws IOException {

    	Main next_06 = new Main();
    	next_06.NextScene("AddParty.fxml");
    }

    @FXML
    void AdminMMBackClicked(ActionEvent event) throws IOException {

    	Main next_04 = new Main();
    	next_04.NextScene("AdminLogin.fxml");
    }

    @FXML
    void AdminMMStartClicked(ActionEvent event) throws IOException {

    	Main next_05 = new Main();
    	next_05.NextScene("StartPage.fxml");
    }
    
    @FXML
    void AdminMMenuClicked(ActionEvent event) throws IOException {

    	Main next_07 = new Main();
    	next_07.NextScene("AdminMainMenu.fxml");
    }

    @FXML
    void AdrClicked(ActionEvent event) {

    }

    @FXML
    void ApovClicked(ActionEvent event) {

    }
    
    @FXML
    void AdminBackClicked(ActionEvent event) throws IOException {

    	Main next_03 = new Main();
    	next_03.NextScene("StartPage.fxml");	
    }
    
    @FXML
    void AdminSubmitClicked(ActionEvent event) throws SQLException, IOException {

    	@SuppressWarnings("unused")
		Window Admin = AdminSubmitBtn.getScene().getWindow();

		if (EAUsername.getText().isEmpty() && EAPassword.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Enter Username And Password !!!";
        	AlertMessage(title,content);	
		}
		else if (EAUsername.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Enter your Username !!! ";
        	AlertMessage(title,content);
        }
		else if (EAPassword.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Enter your Password !!! ";
        	AlertMessage(title,content);
        }
		else if (!EAUsername.getText().isEmpty() && !EAPassword.getText().isEmpty())
		{
			Admin adminobj = new Admin();
			DataBase DB = new DataBase();
			DB.CreateConnection();
			if (DB.RetreiveAdminCredentials(adminobj,EAUsername.getText(),EAPassword.getText()))
			{
				Main next_02 = new Main();
		    	next_02.NextScene("AdminMainMenu.fxml");
			}
			else
			{
				String title = "Wrong Credentials";
				String content = "Enter correct Username and Password !!! ";
	        	AlertMessage(title,content);
			}
		}
		}

    private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void AlertMessage2 (String title, String content)
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
    
	@FXML
    void AdminClicked(ActionEvent event) throws IOException {

    	Main next_01 = new Main();
    	next_01.NextScene("AdminLogin.fxml");	
    }

    @FXML
    void VoterClicked(ActionEvent event) throws IOException {

    	Main next_09 = new Main();
    	next_09.NextScene("VoterMainMenu.fxml");
    }
}
