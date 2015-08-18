import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Task {

  // Creating a membere variable mDescription if clas Task
  private String mDescription;

  // Creating the constructor
  public Task(String description) {
    
    mDescription = description;
  }

  public String getDescription() {
    return mDescription;
  }
}
