import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class NumberAndDateFormatExercises {
    public static void main(String[] args){
        double salario = 1246.678;
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(nf.format(salario));

        nf = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        System.out.println(nf.format(salario));


        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println(df.format(new Date()));

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));

        LocalDateTime ld = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(dtf.format(ld));


        long num1 = 10;
        long num2 = 5;
        double minDouble = Math.min(num1,num2);
        int minInt = (int)Math.min(num1,num2); // debe hacer un cast obligatorio
        float minFloat = Math.min(num1,num2);
        System.out.println(minDouble);
        System.out.println(minFloat);

        long myNumber = 100 <= Math.max(50,100) ? false ? 5 : 2*3 : true ? 7+1: 4+6;
        if (++myNumber <= 6)
            myNumber+=1;
        else if (myNumber >6)
            myNumber -=3;
        System.out.println(myNumber);


        long a,b,c;
        a=b=c=2;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

}
