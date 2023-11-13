package fr.ylaabidi;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;
import java.util.stream.Stream;

@Slf4j
@NoArgsConstructor
public class StringCalculator {

    int add(String s) throws Exception{

        int i=0;
        if( s.length() == 0)
            return i;
        String delimiters = ",|\\n";

        if(s.length() >= 3 && Pattern.matches("^//.", s.substring(0,3))){
            delimiters += "|" + s.charAt(2);
            s = s.substring(3);
        }
        String regex = "-?\\d*(("+delimiters+")-?\\d*)*";

        // Variant 1

        if(Pattern.matches(regex, s)){
            String negatives = Stream.of(s.split(delimiters)).filter(x -> x.charAt(0) == '-' ).reduce("", (a,b) -> String.join(",", a, b));
            String error = "Les nombres négatifs ne sont pas autorisés";
            if(negatives.length() == 2)
                throw new Exception(error);
            if(negatives.length() > 2)
                throw new Exception(error + " : " + negatives.substring(1));
            i = Stream.of(s.split(delimiters)).map(Integer::parseInt).filter(x -> x <= 1000).reduce(0, Integer::sum);
        }

        // Variant 2 : broken pattern matching ?
        // TestShouldReturnSum isn't working. The rest isn't adapted for it.

//        i = switch(s){
//            case "-?\\d*((,|\n)-?\\d*)*" -> Stream.of(s.split(delimiters)).map(Integer::parseInt).filter(x -> x <= 1000).reduce(0, Integer::sum); // why doesn't it detect the 1 and returns 0
//            default -> 0;
//        };

        return i;
    }
}
