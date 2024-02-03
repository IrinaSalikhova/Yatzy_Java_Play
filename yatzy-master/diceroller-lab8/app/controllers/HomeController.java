package controllers;

import play.mvc.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }
    public Result version(){
        return ok("{\"appname\":\"diceroller\",\"version\":\"v0.1.0\"}");
    }
    public Result roll(){
        int value = ThreadLocalRandom.current().nextInt(1, 7);
        String res = "{\"value\":" + value  +"}";
        return ok(res);
    }
    public Result rollMany(int n) {
        int[] arr = new int[5];
        for ( int i = 0; i < arr.length; i++){
            arr[i]= ThreadLocalRandom.current().nextInt(1,7);
        }
        String res1 = "{\"values\":" + Arrays.toString(arr) +"}";
        return ok(res1);
    }

}
