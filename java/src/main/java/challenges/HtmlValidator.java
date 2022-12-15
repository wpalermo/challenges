package challenges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HtmlValidator {

    /**
     * is html tags is valid
     *
     * <div><p><i>hello</i></p></div>
     */

    @Test
    public void test(){


        this.isValid("<div><p><i>hello</i></p></div>");
        System.out.print(this.isValid(new ArrayList<>(List.of("div", "p", "i", "/i",   "/div"))));
    }

    public boolean isValid(String html) {

        String[] tags = html.split("/<[^(><.)]+>/g");

        return false;
    }

    public String isValid(List<String> tags) {

        Stack<String> stack = new Stack<>();
        for (String tag : tags) {

            if(tag.startsWith("/")) {
                if(!stack.peek().equals(tag.substring(1))) {
                    return stack.pop();
                }
                stack.pop();
            } else {
                stack.add(tag);
            }
        }

        return "true";
    }
}
