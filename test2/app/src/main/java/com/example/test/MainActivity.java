package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[] buttons = new Button[18];
    private int[] ids = new int[]{R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,
                                 R.id.b7,R.id.b8,R.id.b9,R.id.b10,R.id.b11,R.id.b12,
                                 R.id.b13,R.id.b14,R.id.b15,R.id.b16,R.id.b17,R.id.b18};
    private TextView textView;
    private StringBuilder sb = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i =0;i<ids.length;i++){
            buttons[i] = (Button) findViewById(ids[i]);
            buttons[i].setOnClickListener(this);
        }
        textView = (TextView) findViewById(R.id.text);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.b1:
                sb = sb.delete(0,sb.length());
                textView.setText(sb);
                break;
            case R.id.b2:
                if(sb.length()!=0){
                    sb=sb.deleteCharAt(sb.length()-1);
                }
                textView.setText(sb);
                break;
            case R.id.b3:
                sb=sb.append("1");
                textView.setText(sb);
                break;
            case R.id.b4:
                sb=sb.append("2");
                textView.setText(sb);
                break;
            case R.id.b5:
                sb=sb.append("3");
                textView.setText(sb);
                break;
            case R.id.b6:
                sb=sb.append("+");
                textView.setText(sb);
                break;
            case R.id.b7:
                sb=sb.append("4");
                textView.setText(sb);
                break;
            case R.id.b8:
                sb=sb.append("5");
                textView.setText(sb);
                break;
            case R.id.b9:
                sb=sb.append("6");
                textView.setText(sb);
                break;
            case R.id.b10:
                sb=sb.append("-");
                textView.setText(sb);
                break;
            case R.id.b11:
                sb=sb.append("7");
                textView.setText(sb);
                break;
            case R.id.b12:
                sb=sb.append("8");
                textView.setText(sb);
                break;
            case R.id.b13:
                sb=sb.append("9");
                textView.setText(sb);
                break;
            case R.id.b14:
                sb=sb.append("*");
                textView.setText(sb);
                break;
            case R.id.b15:
                sb=sb.append(".");
                textView.setText(sb);
                break;
            case R.id.b16:
                sb=sb.append("0");
                textView.setText(sb);
                break;
            case R.id.b17:
                if(sb.length()>1){
                    Count c = new Count();
                    String result;
                    try{
                        String a = c.change(sb);
                        result = c.calculate(a);
                    }catch(Exception ex){
                        result = "error";
                    }
                    textView.setText(sb + "=" + result);
                    sb=sb.delete(0,sb.length());
                    if(Character.isDigit(result.charAt(0))) {
                        sb = sb.append(result);
                    }
                }
                break;
            case R.id.b18:
                sb=sb.append("/");
                textView.setText(sb);
                break;
        }
    }
}

class Count{
    private static  final Map<Character,Integer> map = new HashMap<Character, Integer>();
        static {
            map.put('-', 1);
            map.put('+', 1);
            map.put('*', 2);
            map.put('/', 2);
        }
    public String change(StringBuilder p) {
        List<String> queue = new ArrayList<String>(); //存储数字以及最后的后缀表达式
        List<Character> stack = new ArrayList<Character>();//存储运算符

        char[] charArr = p.substring(0, p.length()).trim().toCharArray(); //去空格
        String standard = "*/+-()";
        char ch = '&';
        int len = 0;
        for (int i = 0; i < charArr.length; i++) {
            ch = charArr[i];
            if (Character.isDigit(ch)) {
                len++;
            } else if (ch == '.') {
                len++;
            } else if (standard.indexOf(ch) != -1) { //是standard中的一个
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i )));
                    len = 0;
                }
                if (ch == '(') {
                    stack.add(ch);
                    continue;
                }
                if (!stack.isEmpty()) {
                    int size = stack.size() - 1;
                    boolean flag = false;
                    while (size >= 0 && ch == ')' && stack.get(size) != '(') { //一直取括号里的元素
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                        flag = true;
                    }
                    if (ch == ')' && stack.get(size) == '(') {
                        flag = true;
                    }
                    while (size >= 0 && !flag && map.get(stack.get(size)) >= map.get(ch)) { //若不是括号里的元素，并且当前栈顶元素的优先级》=对比元素，出栈插入队列
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                    }
                }
                if (ch != ')') {
                    stack.add(ch);
                } else {
                    stack.remove(stack.size() - 1);
                }
            }
            if (i == charArr.length - 1) {
                if (len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len + 1, i + 1)));
                }
                int size = stack.size() - 1;
                while (size >= 0) {
                    queue.add(String.valueOf(stack.remove(size)));
                    size--;
                }
            }
        }
        String a = queue.toString();
        return a.substring(1, a.length() - 1);
    }

    public String calculate (String aa){
        String[] arr = aa.split(", ");
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < arr.length; i++) {
            int size = list.size();
            switch (arr[i]) {
                case "+":
                    double a = Double.parseDouble(list.remove(size - 2)) + Double.parseDouble(list.remove(size - 2));
                    list.add(String.valueOf(a));
                    break;
                case "-":
                    double b = Double.parseDouble(list.remove(size - 2)) - Double.parseDouble(list.remove(size - 2));
                    list.add(String.valueOf(b));
                    break;
                case "*":
                    double c = Double.parseDouble(list.remove(size - 2)) * Double.parseDouble(list.remove(size - 2));
                    list.add(String.valueOf(c));
                    break;
                case "/":
                    double d = Double.parseDouble(list.remove(size - 2)) / Double.parseDouble(list.remove(size - 2));
                    list.add(String.valueOf(d));
                    break;
                default:
                    list.add(arr[i]);
                    break;
            }
        }
        return list.size() == 1 ? list.get(0) : "运算失败";

    }
}

