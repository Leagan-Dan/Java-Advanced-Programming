package commands;
import items.*;
import freemarker.template.*;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import catalog.Catalog;
import java.util.List;

public class ReportCommand extends Command{
    /**
     * Creates a html report based on the template given
     * @param catalog object of type Catalog
     * @throws IOException exception for input/output
     * @throws TemplateException exception related to the template
     */
    public void report(Catalog catalog) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        try {
            configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\Dan\\javaLab5\\"));
        }catch (TemplateNotFoundException exception){
            System.out.println("Couldn't set directory for template loading");
        }

        Map<String,Object> mapReport=new HashMap<>();
        List<Item> catalogList=catalog.getCatalog();
        mapReport.put("items",catalogList.toString());


        Writer writer=new FileWriter("C:\\Users\\Dan\\javaLab5\\Report.html");
        Template template=configuration.getTemplate("Template.html");
        template.process(mapReport,writer);
        writer.close();

    }
}
