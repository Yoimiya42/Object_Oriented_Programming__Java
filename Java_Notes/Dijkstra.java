
import java.util.Scanner;
import java.util.Stack;

public class Dijkstra {
    public static void main(String[] args)
    {
        //( 1 + ( ( ( 2 + 3 ) * ( 4 + 5 ) ) + 10 ) )
        Dijkstra di = new Dijkstra();
        di.DijkstraTwoStack();
    }

    public void DijkstraTwoStack(){
        Stack<String> ops = new Stack<>();
        Stack<Double> num = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext())
        {
            var s = sc.next();
            if(s.equals("("));
            else if (s.equals("+")|s.equals("-")|s.equals("*")|s.equals("/"))
                ops.push(s);
            else if (s.equals(")"))
            {
                String op = ops.pop();
                double res = num.pop();
                if(op.equals("+"))        res = num.pop() + res;
                else if (op.equals("-"))  res = num.pop() - res;
                else if (op.equals("*"))  res = num.pop() * res;
                else if (op.equals("/"))  res = num.pop() / res;
                num.push(res);
            }
            else
                num.push(Double.valueOf(s));
        }
        System.out.println(num.pop());
    }
}
