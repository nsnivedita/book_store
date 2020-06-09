package com.yannitech.api.bookstore.util;

import com.yannitech.api.bookstore.dao.entity.Author;
import com.yannitech.api.bookstore.dao.entity.Book;
import com.yannitech.api.bookstore.service.BookService;
import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;



public class FileReader {

    @Autowired
    BookService bookService;

    public FileReader(BookService bookService)
    {
        this.bookService = bookService;
    }

    public void xmlReader()
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the input XML document
            Document document = builder.parse(new File("src/main/resources/bookstore.xml"));
            document.getDocumentElement ().normalize ();
            System.out.println ("Root element of the doc is " + document.getDocumentElement().getNodeName());

            //NodeList nodeList = document.getDocumentElement().getChildNodes();
            NodeList bookNodeList = document.getElementsByTagName("book");
            int totalBook = bookNodeList.getLength();
            System.out.println("Total no of people : " + totalBook);

            for (int i = 0; i < bookNodeList.getLength(); i++)
            {
                Node node = bookNodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element elem = (Element) node;

                    Book book = new Book();
                    book.setCategory(node.getAttributes().getNamedItem("category").getNodeValue());
                    book.setTitle(elem.getElementsByTagName("title")
                            .item(0).getChildNodes().item(0).getNodeValue());
                    String language = ((Element)elem.getElementsByTagName("title").item(0)).getAttribute("lang");
                    book.setLanguage(language);
                    book.setYear(elem.getElementsByTagName("year")
                            .item(0).getChildNodes().item(0).getNodeValue());
                    book.setPrice(Float.parseFloat(elem.getElementsByTagName("price")
                            .item(0).getChildNodes().item(0).getNodeValue()));
                    Long bookId = (bookService.addBook(book)).getId();

                    NodeList authorNodeList = elem.getElementsByTagName("author");
                    for (int j = 0; j < authorNodeList.getLength(); j++)
                    {
                        Author auth = new Author();
                        String name = authorNodeList.item(i).getChildNodes().item(0).getNodeValue();
                        auth.setAuthorName(name);
                        auth.setBookId(bookId);
                        bookService.addAuthor(auth);
                    }
                }
            }
        }catch (SAXParseException err) {
            System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
            System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
            Exception x = e.getException ();
            ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
            t.printStackTrace ();
        }
    }
}

