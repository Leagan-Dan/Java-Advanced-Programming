package main;

import catalog.Catalog;
import commands.*;
import items.Article;
import items.Book;
import items.Item;
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.Parser;
import org.xml.sax.SAXException;

import javax.swing.text.View;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, TemplateException, TikaException, SAXException {

        AddCommand addCommand = new AddCommand();
        SaveCommand saveCommand = new SaveCommand();
        Catalog catalog = new Catalog();
        LoadCommand loadCommand = new LoadCommand();
        ListCommand listCommand = new ListCommand();
        ViewCommand viewCommand = new ViewCommand();
        ReportCommand reportCommand = new ReportCommand();
        InfoCommand infoCommand = new InfoCommand();


        Article article = new Article("Biology", 23, "Research-Article",
                "C:\\Users\\Dan\\javaLab5\\Article.txt");
        Book book = new Book("Ion Creanga", 1892, 24, "Amintiri din copilarie",
                "C:\\Users\\Dan\\javaLab5\\Book.txt");


        addCommand.add(catalog,article);
        addCommand.add(catalog,book);
        saveCommand.save(catalog, "C:\\Users\\Dan\\javaLab5\\Catalog.json");
        saveCommand.saveItems(catalog);
        loadCommand.load("C:\\Users\\Dan\\javaLab5\\Catalog.json");
        listCommand.list(catalog);
        viewCommand.view(catalog,article);
        reportCommand.report(catalog);
        infoCommand.info(article);
    }
}
