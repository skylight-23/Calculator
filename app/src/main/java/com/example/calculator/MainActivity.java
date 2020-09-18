package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_0, bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7,
            bt_8, bt_9, bt_delete, bt_div, bt_mult, bt_minus, bt_plus, bt_is, bt_dot, bt_AC, bt_left, bt_right, bt_sc, bt_help,
            bt_sin,bt_cos,bt_tan,bt_108,bt_1016,bt_102,bt_mi,bt_fang,bt_dao,bt_ou;

    private TextView showText;             //用来显示输入的符号和数字
    private String input = "";           //字符串用来保存输入的数字和符号

    double num1, num2, num3;
    double sum1, sum2, sum3;
    final double pi = 3.1415926;

    StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bt_0 = findViewById(R.id.bt_0);
        View bt_1 = findViewById(R.id.bt_1);
        View bt_2 = findViewById(R.id.bt_2);
        View bt_3 = findViewById(R.id.bt_3);
        View bt_4 = findViewById(R.id.bt_4);
        View bt_5 = findViewById(R.id.bt_5);
        View bt_6 = findViewById(R.id.bt_6);
        View bt_7 = findViewById(R.id.bt_7);
        View bt_8 = findViewById(R.id.bt_8);
        View bt_9 = findViewById(R.id.bt_9);
        View bt_delete = findViewById(R.id.bt_delete);//删除
        View bt_div = findViewById(R.id.bt_div);//除
        View bt_mult = findViewById(R.id.bt_mult);//乘
        View bt_minus = findViewById(R.id.bt_minus);//减
        View bt_plus = findViewById(R.id.bt_plus);//加
        View bt_is = findViewById(R.id.bt_is);//等于
        View bt_dot = findViewById(R.id.bt_dot);//小数点
        View bt_AC = findViewById(R.id.bt_AC);//清空
        View bt_right = findViewById(R.id.bt_right);//左括号
        View bt_left = findViewById(R.id.bt_left);//左括号
        View bt_help = findViewById(R.id.bt_help);//帮助
        View bt_sc = findViewById(R.id.bt_sc);//更多功能
        View bt_sin = findViewById(R.id.bt_sin);//sin
        View bt_cos = findViewById(R.id.bt_cos);//cos
        View bt_tan = findViewById(R.id.bt_tan);
        View bt_108 = findViewById(R.id.bt_108);//十进制转8进制
        View bt_102 = findViewById(R.id.bt_102);//十进制转2进制
        View bt_1016 = findViewById(R.id.bt_1016);//十进制转16进制
        View bt_mi = findViewById(R.id.bt_mi);
        View bt_fang = findViewById(R.id.bt_fang);
        View bt_dao = findViewById(R.id.bt_dao);
        View bt_ou = findViewById(R.id.bt_ou);
        showText = (TextView) findViewById(R.id.showText);//结果栏

        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_AC.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_left.setOnClickListener(this);
        bt_right.setOnClickListener(this);
        bt_help.setOnClickListener(this);
        bt_sc.setOnClickListener(this);
        bt_sin.setOnClickListener(this);
        bt_cos.setOnClickListener(this);


        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i("info","landscape"); // 横屏
            bt_tan.setOnClickListener(this);
            bt_102.setOnClickListener(this);
            bt_108.setOnClickListener(this);
            bt_1016.setOnClickListener(this);
            bt_mi.setOnClickListener(this);
            bt_fang.setOnClickListener(this);
            bt_dao.setOnClickListener(this);
            bt_ou.setOnClickListener(this);
        } else if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i("info","portrait"); // 竖屏
            bt_div.setOnClickListener(this);
            bt_dot.setOnClickListener(this);
            bt_is.setOnClickListener(this);
            bt_minus.setOnClickListener(this);
            bt_mult.setOnClickListener(this);
            bt_plus.setOnClickListener(this);
            bt_is.setOnClickListener(this);
            bt_minus.setOnClickListener(this);
            bt_mult.setOnClickListener(this);
            bt_plus.setOnClickListener(this);
        }

    }

    public void onClick(View view) {

        Log.v("Tag","click");

        switch (view.getId()) {
            case R.id.bt_0:
                input = addToInput("0");
                showText.setText(input);
                break;
            case R.id.bt_1:
                input = addToInput("1");
                showText.setText(input);
                break;
            case R.id.bt_2:
                input = addToInput("2");
                showText.setText(input);
                break;
            case R.id.bt_3:
                input = addToInput("3");
                showText.setText(input);
                break;
            case R.id.bt_4:
                input = addToInput("4");
                showText.setText(input);
                break;
            case R.id.bt_5:
                input = addToInput("5");
                showText.setText(input);
                break;
            case R.id.bt_6:
                input = addToInput("6");
                showText.setText(input);
                break;
            case R.id.bt_7:
                input = addToInput("7");
                showText.setText(input);
                break;
            case R.id.bt_8:
                input = addToInput("8");
                showText.setText(input);
                break;
            case R.id.bt_9:
                input = addToInput("9");
                showText.setText(input);
                break;
            case R.id.bt_dot:
                input = addToInput(".");
                showText.setText(input);
                break;
            case R.id.bt_div:
                input = addToInput("/");
                showText.setText(input);
                break;
            case R.id.bt_plus:
                input = addToInput("+");
                showText.setText(input);
                break;
            case R.id.bt_minus:
                input = addToInput("-");
                showText.setText(input);
                break;
            case R.id.bt_mult:
                input = addToInput("*");
                showText.setText(input);
                break;
            case R.id.bt_delete:
                if (input.length() >= 1)      //当至少已经输入了一个符号才执行
                {
                    input = input.substring(0, input.length() - 1);
                }
                showText.setText(input);
                break;
            case R.id.bt_AC://清除
                input = "";
                showText.setText(input);
                break;
            case R.id.bt_is://等于
                double result = calculate(input);
                String s = ""+ result;
                showText.setText(s);
                break;
            case R.id.bt_left:
                input = addToInput("(");
                showText.setText(input);
                break;
            case R.id.bt_right:
                input = addToInput(")");
                showText.setText(input);
                break;
            case R.id.bt_help:
                Toast.makeText(this,"这是帮助",Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_sin:
                double a = getSin(showText.getText().toString());
               showText.setText(""+a);

                break;
            case R.id.bt_cos:
                double c = getCos(showText.getText().toString());
                showText.setText(""+c);
                break;
            case R.id.bt_tan:
                double t =getTan(showText.getText().toString());
                showText.setText(""+t);
                break;
            case R.id.bt_102:
                int two = Integer.parseInt(showText.getText().toString());
                showText.setText(""+Integer.toBinaryString(two));
                break;
            case R.id.bt_108:
                int b = Integer.parseInt(showText.getText().toString());
                showText.setText(""+Integer.toOctalString(b));
                break;
            case R.id.bt_1016:
                int sl = Integer.parseInt(showText.getText().toString());
                showText.setText(""+Integer.toHexString(sl));
                break;
            case R.id.bt_dao:
                int dao = Integer.parseInt(showText.getText().toString());
                showText.setText(""+dao*0.148);
                break;
            case R.id.bt_ou:
                int ou = Integer.parseInt(showText.getText().toString());
                showText.setText(""+ou*0.115);
                break;
            case R.id.bt_mi:
                double mi = Double.parseDouble(showText.getText().toString());
                showText.setText(""+mi*10+"dm  "+mi*100+"cm");
                break;
            case R.id.bt_fang:
                double bian = Double.parseDouble(showText.getText().toString());
                showText.setText(""+bian*bian*bian+"立方米");
        }


    }
    public double getSin(String s){
        double x = Double.parseDouble(s);
        double y = Math.sin(pi / 180 * x);
        return y;
    }
    public double getCos(String s){
        double x = Double.parseDouble(s);
        double y = Math.cos(pi / 180 * x);
        return y;
    }
    public double getTan(String s){
        double x = Double.parseDouble(s);
        double y = Math.tan(pi / 180 * x);
        return y;
    }
    public String addToInput(String s)//添加并记录一个输入的数字或符号
    {
        input = input + String.valueOf(s);
        return input;
    }

    public double calculate(String str) {
        String s = simplify(str);
        String num = "";//记录数字
        Stack<Character> opeStack = new Stack<>();//符号站
        int l = s.length();//字符串长度 l
        List<String> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (isAllOpe(c)) {
                if (num != "") {
                    list.add(num);
                    num = "";
                }
                if (c == '(') {
                    opeStack.add(c);
                } else if (isOpe(c)) {
                    char top = opeStack.peek();
                    if (isGreater(c, top)) {// ch优先级大于top 压栈
                        opeStack.push(c);
                    } else {//否则,将栈内元素出栈,直到遇见 '(' 然后将ch压栈
                        while (true) {
                            char t = opeStack.peek();
                            if (t == '(')
                                break;
                            if (isGreater(c, t))
                                break;

                            list.add(Character.toString(t));
                            t = opeStack.pop();
                        }
                        opeStack.push(c);
                    }
                } else if (c == ')') {
                    char t = opeStack.pop();
                    while (t != '(' && !opeStack.isEmpty()) {
                        list.add(Character.toString(t));
                        t = opeStack.pop();
                    }

                }
            } else {
                num += c;
            }
        }
        //计算后缀表达式
        Stack<Double> numStack = new Stack<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String t = list.get(i);
            if (isNumeric(t)) {
                numStack.push(Double.parseDouble(t));
            } else {
                //如果t为运算符则 只有一位
                char c = t.charAt(0);
                double b = numStack.pop();
                double a = numStack.pop();
                switch (c) {
                    case '+':
                        numStack.push(a + b);
                        break;
                    case '-':
                        numStack.push(a - b);
                        break;
                    case '*':
                        numStack.push(a * b);
                        break;
                    case '/':
                        numStack.push(a / b);
                        break;
                    default:
                        break;
                }
            }
        }
        return numStack.pop();
    }

    public String simplify(String str) {
        String s = str.replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0");//处理负数，将-3改为0-3的形式
        s = "(" + s + ")";
        return s;
    }

    public static boolean isOpe(char c)//判断是否为运算符
    {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        else
            return false;
    }

    public static boolean isAllOpe(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;

        else if (c == '(' || c == ')')
            return true;
        else
            return false;
    }

    public static boolean isGreater(char a, char b)//判断符号优先级
    {
        int a1 = getLevel(a);
        int b1 = getLevel(b);
        if (a1 > b1)
            return true;
        else
            return false;
    }

    public static int getLevel(char a)//定义符号的优先级
    {

        if (a == '+'||a =='s')
            return 0;
        else if (a == '-')
            return 1;
        else if (a == '*')
            return 3;
        else if (a == '/')
            return 4;
        else
            return -1;

    }

    public static boolean isNumeric(String str) {//判断是否是数字
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}