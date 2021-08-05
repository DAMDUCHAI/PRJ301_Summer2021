package Controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Sharp Team
 */
public class Calculate {

    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private final JTextField text;
    private boolean reset;
    private boolean isMR = false;
    private boolean process;
   
    public boolean check=false;
    private int operator = -1;
    private DecimalFormat format = new DecimalFormat("#.##################");
    private BigDecimal memory = new BigDecimal("0");

    public Calculate(JTextField text) {
        this.text = text;
        operator = -1;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }


    public void pressNumber(JButton btn) {
        BigDecimal temp;
        String value = btn.getText();
        if (process || reset) {
            text.setText("0");
            process = false;
            reset = false;
        }
        isMR = false;
        if (text.getText().contains("0.") && (text.getText().endsWith("0")
                || text.getText().endsWith("."))) {
            String ne = text.getText() + value;
            text.setText(ne);
        } else {

            temp = new BigDecimal(text.getText() + value);
            text.setText(temp.toPlainString() + "");
        }
      
        check=false;
    }

    public void pressDot() {
        if (process || reset) {
            text.setText("0");
            process = false;
            reset = false;
        }
        if (!text.getText().contains(".")) {
            text.setText(text.getText() + ".");
        }
    }

    public void pressClear() {
        firstNumber = new BigDecimal("0");
        secondNumber = new BigDecimal("0");
        //memory = new BigDecimal("0");
        operator = -1;
    }

    public BigDecimal getValue() {
        if (isMR) {
            return memory;
        }
        String value = text.getText();

        BigDecimal temp;
        try {
            temp = new BigDecimal(value);

        } catch (Exception e) {
            return firstNumber;
            
        }
        return temp;
    }

    public void calculate() {
        if (!process) {
            if (operator == -1) {
                firstNumber = getValue();
            } else {
                secondNumber = getValue();
                switch (operator) {
                    case 1:
                        // to add value
                        firstNumber = firstNumber.add(secondNumber);

                        break;
                    case 2:
                        // to sub value
                        firstNumber = firstNumber.subtract(secondNumber);
                        break;
                    case 3:
                        // to multi value
                        firstNumber = firstNumber.multiply(secondNumber);
                        break;
                    case 4:
                        // to divide value
                        if (secondNumber.toString().equals("0")) {
                            text.setText("ERROR");
                            process = false;
                            return;
                        } else {
                            MathContext mc = new MathContext(9);
                            firstNumber = firstNumber.divide(secondNumber, mc);
                            break;
                        }
                }
            }
            
                text.setText((firstNumber.toPlainString()) + "");
            
           

            process = true;
        }

    }

   

    public void pressResult() {
        if (!text.getText().equals("ERROR")) {
            calculate();
            operator = -1;
        } else {
            text.setText(firstNumber + "");
        }
       
    }

    public void pressNegate() {

        if ((text.getText().contains("0.")
                && text.getText().charAt(text.getText().length() - 1) == '0')
                || text.getText().equals("0.") || text.getText().equals("-0.")) {
            if (text.getText().charAt(0) == '-') {
                text.setText(text.getText().substring(1, text.getText().length()));

            } else {
                text.setText("-" + text.getText());

            }
        } else {
            pressResult();
            text.setText(getValue().negate().toPlainString());

        }
       
        if(check){
            process = true;
            reset = false;
        }else{
             process = false;
             reset = false;
        }

    }

    public void pressSqrt() {
        pressResult();
        BigDecimal result = getValue();
        if (result.doubleValue() >= 0) {
            Double display = Math.sqrt(result.doubleValue());

            text.setText(format.format(display));
            process = false;
        } else {
            text.setText("ERROR");
        }
        reset = true;
    
    }

    public void pressPercent() {
        pressResult();

        BigDecimal c = getValue().divide(new BigDecimal("100"));
        text.setText(c.toPlainString());
        process = false;
        reset = true;
       
    }

    public void pressInvert() {
        pressResult();
        double result = getValue().doubleValue();
        if (result != 0) {
            double x = 1 / result;

            if (x == (int) x) {
                text.setText((int) x + "");

            } else {
                BigDecimal temp = new BigDecimal(Double.toString(x));
                text.setText(temp.toPlainString());
            }
            process = false;
        } else {
            text.setText("ERROR");
        }
        reset = true;
       
    }

    public JTextField pressMR() {
        text.setText(memory + "");
        isMR = true;
        return text;
    }

    //MC : xóa bỏ trong bộ nhớ xét memory =0
    public void pressMC() {
        memory = new BigDecimal("0");
    }

    //ấn số: => M+ : lưu giá trị đó vào memory
    public void pressMAdd() {
        memory = memory.add(getValue());
        process = false;
        reset = true;
        //text.setText("ERROR");
    }

    //ấn số: => M- : lưu giá trị đối của nó vào memory
    public void pressMSub() {
        memory = memory.add(getValue().negate());
        process = false;
        reset = true;
    }

}
