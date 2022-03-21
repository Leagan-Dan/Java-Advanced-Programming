package Main;

import Catalog.Catalog;
import Catalog.CatalogUtil;
import Item.Article;
import Item.Book;
import Item.Item;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CatalogUtil catalogUtil = new CatalogUtil();
        Catalog catalog = new Catalog();
        Article article = new Article("Biology", 23, "Research",
                "C:\\Users\\Dan\\javaLab5\\Articol.txt");
        Book book = new Book("Ion Creanga", 1892, 24, "Amintiri din copilarie",
                "C:\\Users\\Dan\\javaLab5\\Carte.txt");
        catalog.add(article);
        catalog.add(book);
        //catalog.add(book);
        System.out.println(catalog);
        catalogUtil.save(catalog, "C:\\Users\\Dan\\javaLab5\\Catalog.json");
        Catalog catalog1 = catalogUtil.load("C:\\Users\\Dan\\javaLab5\\Catalog.json");
        //Catalog catalog2 = catalogUtil.load("C:\\Users\\Dan\\javaLab5\\Catalog2.json");
        System.out.println(catalog1);
    }
}
