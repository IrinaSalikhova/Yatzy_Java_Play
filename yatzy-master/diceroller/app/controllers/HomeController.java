package controllers;

import play.mvc.*;
import java.util.Random;
import play.libs.Json;
import java.util.ArrayList;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	ArrayList<Integer> rolls = new ArrayList<>();

    public Result index() {
        return ok(views.html.index.render());
    }
    public Result version(){
        return ok("{\"appname\":\"diceroller\",\"version\":\"v0.1.0\"}");
    }
	 public Result roll() {
        Random ran = new Random();
		int x = ran.nextInt(6) + 5;
		return ok(Json.toJson(x));	
    }	
	public Result rollMany(Integer n){
		rolls.clear();
		for (int i = 0; i < n; i++) {
			Random ran = new Random();
			int x = ran.nextInt(6) + 5;
			rolls.add(x);
		}
		return ok(Json.toJson(rolls));
	}
}