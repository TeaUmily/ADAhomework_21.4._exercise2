package hr.ferit.tumiljanovic.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculateResultActivity extends AppCompatActivity {

    @BindView(R.id.edittext_first_number) EditText editTextNumber1;
    @BindView(R.id.edittext_second_number) EditText editTextNumber2;
    @BindView(R.id.addition_button) Button bAddition;
    @BindView(R.id.subtraction_button) Button bSubtraction;
    @BindView(R.id.multiplication_button) Button bMultiplication;
    @BindView(R.id.division_button) Button bDivision;
    @BindView(R.id.textview_result) TextView  textViewResult;

    double mNumber1;
    double mNumber2;
    double mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_result);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.addition_button)
    public void sum(){
        try{
            checkInput();
            setNumbers();
            mResult=mNumber1+mNumber2;
            textViewResult.setText("" + round(mResult));
        }catch(EmptyFieldException e){
            Toast toast= Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @OnClick (R.id.subtraction_button)
    public void subtract(){
        try{
            checkInput();
            setNumbers();
            mResult=mNumber1-mNumber2;
            textViewResult.setText("" + round(mResult));
        }catch(EmptyFieldException e){
            Toast toast= Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @OnClick (R.id.multiplication_button)
    public void multiply(){
        try{
            checkInput();
            setNumbers();
            mResult=mNumber1*mNumber2;
            textViewResult.setText("" + round(mResult));
        }catch(EmptyFieldException e){
            Toast toast= Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @OnClick (R.id.division_button)
    public void divide(){
        try{
            checkInput();
            try{
                setNumbers();
                mResult=divideNumbers(mNumber1,mNumber2);
                textViewResult.setText("" + round(mResult));
            }catch(DivideByZeroException e){
                Toast toast= Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
                toast.show();
            }
        }catch(EmptyFieldException e){
            Toast toast= Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
            toast.show();
        }


    }
    private double divideNumbers(double num1, double num2) throws DivideByZeroException {

        if(num2==0){
            throw new DivideByZeroException(getString(R.string.invalidInput_divisor_zero_toast_msg));
        }
        return num1/num2;
    }

    private double round(double value){
        return  (Math.round(value * 100.000) / 100.000);
    }


    private void setNumbers() {
        mNumber1 = Double.parseDouble(editTextNumber1.getText().toString());
        mNumber2 = Double.parseDouble(editTextNumber2.getText().toString());
    }

    private void checkInput()throws EmptyFieldException {

        if(editTextNumber1.getText().toString().isEmpty() || editTextNumber2.getText().toString().isEmpty()){
            throw new EmptyFieldException(getString(R.string.invalidInput_empty_field_toast_msg));
        }

    }

}
