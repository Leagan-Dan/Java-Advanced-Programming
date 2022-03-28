package commands;

import items.*;
import catalog.Catalog;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.EmptyParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class InfoCommand extends Command{
    /**
     * Creates metadata for the saved file of the item given
     * @param item object of type Item
     * @throws IOException exception for input/output
     * @throws TikaException exception for Apache Tika methods
     * @throws SAXException exception related to the parser
     */
    public void info(Item item) throws IOException, TikaException, SAXException {

        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser=new AutoDetectParser();
        Metadata metadata= new Metadata();
        ParseContext context = new ParseContext();
        FileInputStream inputStream= new FileInputStream(item.getLocation());

        parser.parse(inputStream, handler,metadata,context);

        String[] metadataArray= metadata.names();

        System.out.println("Metadata " + item.getName() + ":" );
        for(String data: metadataArray){
            System.out.println(metadata.get(data));
        }

    }
}
