package controller;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author : Daniru Punsith Ranathunga <punsithdniry@gmail.com>
 * @Since : 7/4/2024
 **/
public class customerForm implements Initializable {

    @FXML
    private TextField txt_result;
    String op = "";
    long num1;
    long num2;
    public void btnNumber(ActionEvent actionEvent) {
        String no = ((Button)actionEvent.getSource()).getText();
        txt_result.setText(txt_result.getText()+no);
    }

    public void Operation(ActionEvent actionEvent) {
        String operation = ((Button)actionEvent.getSource()).getText();
        if (!operation.equals("=")){
            if(!op.equals("")){
                return;
            }
            op = operation;
            num1 = Long.parseLong(txt_result.getText());
            txt_result.setText("");
        }else {
            if(op.equals("")){
                return;
            }
            num2 = Long.parseLong(txt_result.getText());
            calculate(num1, num2, op);
            op="";
        }
    }

    public void calculate(long n1,long n2,String op){
        switch (op){
            case"+": txt_result.setText(n1+n2+"");break;
            case"-": txt_result.setText(n1-n2+"");break;
            case"*": txt_result.setText(n1*n2+"");break;
            case"/":
                if(n2==0){
                    txt_result.setText("0");break;
                }
                txt_result.setText(n1/n2+"");break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}