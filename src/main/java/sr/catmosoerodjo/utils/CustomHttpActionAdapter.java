package sr.catmosoerodjo.utils;

import org.pac4j.core.context.HttpConstants;
import org.pac4j.core.context.WebContext;
import org.pac4j.sparkjava.DefaultHttpActionAdapter;
import spark.ModelAndView;
import spark.TemplateEngine;

import java.util.HashMap;

import static spark.Spark.halt;

public class CustomHttpActionAdapter extends DefaultHttpActionAdapter {

    private final TemplateEngine templateEngine;

    public CustomHttpActionAdapter(final TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public Object adapt(int code, WebContext context) {
        if (code == HttpConstants.UNAUTHORIZED) {
            halt(401, templateEngine.render(new ModelAndView(new HashMap<>(), "error401.mustache")));
        } else if (code == HttpConstants.FORBIDDEN) {
            halt(403, templateEngine.render(new ModelAndView(new HashMap<>(), "error403.mustache")));
        } else {
            return super.adapt(code, context);
        }
        return null;
    }
}