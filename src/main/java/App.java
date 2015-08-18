import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tasks", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();

          //save the Task description into a string
          String description = request.queryParams("description");

          //create a new Task object
          Task newTask = new Task(description);

          //put that Task object into the session
          request.session().attribute("task", newTask);

          //lets our users know when they have successfully saved a task
          model.put("template", "templates/success.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
      }
    }
